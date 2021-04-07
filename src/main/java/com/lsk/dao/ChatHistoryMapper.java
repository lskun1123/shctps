package com.lsk.dao;

import com.lsk.entity.ChatHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LSKun
 */
@Repository
public interface ChatHistoryMapper {
    int deleteByPrimaryKey(Long cid);

    int insert(ChatHistory record);

    int insertSelective(ChatHistory record);

    ChatHistory selectByPrimaryKey(Long cid);

    int updateByPrimaryKeySelective(ChatHistory record);

    int updateByPrimaryKey(ChatHistory record);
}