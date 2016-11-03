package com.jam.module.collect.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.jam.common.BaseEntity;
import com.jam.module.topic.entity.Topic;
import com.jam.module.user.entity.User;

import java.util.Date;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Table(name = "cs_collect")
@Entity
@Getter
@Setter
public class Collect extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 与话题的关联关系
	@ManyToOne
	@JoinColumn(nullable = false, name = "topic_id")
	private Topic topic;

	// 与用户的关联关系
	@ManyToOne
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	@Column(name = "in_time")
	private Date inTime;

	@Override
	public String toString() {
		return "Collect [id=" + id + ", topic=" + topic + ", user=" + user + ", inTime=" + inTime + "]";
	}

}
