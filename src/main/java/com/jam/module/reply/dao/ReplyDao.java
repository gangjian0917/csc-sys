package com.jam.module.reply.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jam.module.reply.entity.Reply;
import com.jam.module.topic.entity.Topic;
import com.jam.module.user.entity.User;

import java.util.List;

/**
 * Created by eclipse.
 * Copyright (c) 2016, All Rights Reserved.
 */
@Repository
public interface ReplyDao extends JpaRepository<Reply, Integer> {

    List<Reply> findByTopicOrderByInTimeDesc(Topic topic);

    void deleteByTopicId(int topicId);

    void deleteByUser(User user);

    Page<Reply> findByUser(User user, Pageable pageable);
}
