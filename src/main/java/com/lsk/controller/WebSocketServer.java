package com.lsk.controller;

import com.google.gson.Gson;
import com.lsk.entity.ChatHistory;
import com.lsk.service.ChatService;
import com.lsk.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LSKun
 */
@ServerEndpoint("/ws/server/{userName}")
public class WebSocketServer {


    @Autowired
    ChatService chatService;
    /**
     * 会话，主要用于向客户端发送数据
     */
    private Session session;

    private String userName;

    public String getUserName(){
        return userName;
    }

    public Session getSession() {
        return session;
    }

    /**
     * websocket连接
     * @param session
     */
    @OnOpen
    public void onOpen(Session session,@PathParam("userName") String userName){
        this.session = session;
        add(userName,this);

    }

    /**
     * websocket断开
     */
    @OnClose
    public void onClose(){
        remove(this);
    }

    /**
     * websocket消息
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // 广播
        sendToMessage(message);
    }

    /**
     * websocket错误
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        error.printStackTrace();
    }

    /**
     * 广播消息方法
     * @param message
     * @throws IOException
     */
    public void sendToMessage(String message) throws IOException {
        sendMessage(message);
    }

    /**
     * 广播消息方法
     * @param msg
     * @throws IOException
     */
    public void backMessage(ChatHistory msg) throws IOException {
        getSession().getBasicRemote().sendText(new Gson().toJson(msg));

    }

    /**
     * 广播消息方法
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        ChatHistory chatHistory = new Gson().fromJson(message,ChatHistory.class);
        chatHistory.setIsread(0);
        chatHistory.setChattime(new Timestamp(System.currentTimeMillis()));
        System.out.println(chatHistory);
        WebSocketServer s = servers.get(chatHistory.getAccepter());
        if(s != null){
            s.getSession().getBasicRemote().sendText(message);
            boolean isSuccess = chatService.insertMessage(chatHistory);
        }
        else{
            //msg.setType(0);
            chatHistory.setTag(0);
            chatHistory.setChatcontent("对方未上线");
            backMessage(chatHistory);
        }

    }

    private static Map<String,WebSocketServer> servers = new HashMap<>();

    /**
     * 广播
     * @param msg
     */
    public static void broadCast(String msg){
        for (Map.Entry<String,WebSocketServer> entry: servers.entrySet()) {
            try {
                entry.getValue().sendMessage(msg);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 新增客户端服务器
     * @param server
     */
    public static void add(String userName,WebSocketServer server){
        // 使用时间构造登录信息
        ChatHistory chatHistory = new ChatHistory();
        chatHistory.setAccepter(Integer.parseInt(userName));
        chatHistory.setChatcontent("");
        //chatHistory.setSayer();
        chatHistory.setChattime(new Timestamp(System.currentTimeMillis()));
        chatHistory.setTag(0);

        // 广播
        try {
            server.backMessage(chatHistory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加入服务组
        servers.put(userName,server);
    }

    /**
     * 客户端服务器退出
     * @param server
     */
    public static void remove(WebSocketServer server){
        // 客户端服务器退出
        servers.remove(server.getUserName());
        // 使用时间构造登录信息
        Message msg = new Message();
        msg.setTo(server.getUserName());
        msg.setContent(server.getUserName()+"已退出");
        msg.setFrom("系统");
        msg.setType(0);
        msg.setTime(StringUtils.getCurrentTime());
        // 广播
        broadCast(new Gson().toJson(msg));
    }

}
