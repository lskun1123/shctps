package com.lsk.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.httpclient.HttpStatus;//此类需要添加maven依赖或jar包


public class HttpUtil {

    public static String doGet(String urlPath, HashMap<String, Object> params)
            throws Exception {
        StringBuilder sb = new StringBuilder(urlPath);
        // 说明有参数
        if (params != null && !params.isEmpty()) {
            sb.append("?");

            Set<Entry<String, Object>> set = params.entrySet();
            for (Entry<String, Object> entry : set) { // 遍历map里面的参数
                String key = entry.getKey();
                String value = "";
                if (null != entry.getValue()) {
                    value = entry.getValue().toString();
                    // 转码
                    value = URLEncoder.encode(value, "UTF-8");
                }
                sb.append(key).append("=").append(value).append("&");
            }
            // 删除最后一个&
            sb.deleteCharAt(sb.length() - 1);
        }
        // System.out.println(sb.toString());
        URL url = new URL(sb.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 5s超时
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        // HttpStatus.SC_OK ==
        if (conn.getResponseCode() == HttpStatus.SC_OK) {
            // 200
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            StringBuilder sbs = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sbs.append(line);
            }
            // JSONObject jsonObject = new JSONObject(sbs.toString());
            return sbs.toString();
        }

        return null;
    }
}
