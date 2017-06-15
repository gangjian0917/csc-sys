package com.jam.module.reply.entity;

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
@Entity
@Table(name = "cs_reply")
@Getter
@Setter
public class Reply extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 回复的内容
	@Column(columnDefinition = "text", nullable = false)
	private String content;

	// 回复时间
	private Date inTime;

	// 点赞数量
	private int up;

	// 与话题的关联关系
	@ManyToOne
	@JoinColumn(nullable = false, name = "topic_id")
	private Topic topic;

	// 与用户的关联关系
	@ManyToOne
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	// 对回复点赞的用户id，逗号隔开(英文逗号)
	@Column(columnDefinition = "text")
	private String upIds;

	@Override
	public String toString() {
		return "Reply [id=" + id + ", content=" + content + ", inTime=" + inTime + ", up=" + up + ", topic=" + topic
				+ ", user=" + user + ", upIds=" + upIds + "]";
	}

}
