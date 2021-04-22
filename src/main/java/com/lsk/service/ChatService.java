package com.lsk.service;/*
 * @Author LSKun1123
 * @Date 2021/4/17 16:38
 * @Return
 * @Desc
 */

import com.lsk.entity.ChatHistory;

public interface ChatService {
    boolean insertMessage(ChatHistory chatHistory);
}
