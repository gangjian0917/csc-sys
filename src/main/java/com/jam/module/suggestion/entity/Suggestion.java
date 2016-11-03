package com.jam.module.suggestion.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jam.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by eclipse. Copyright (c) 2016, All Rights Reserved.
 */
@Entity
@Table(name = "cs_suggestion")
@Getter
@Setter
public class Suggestion extends BaseEntity {

	@Id
	@GeneratedValue
	private int id;

	// 标题
	@Column(unique = true, nullable = false)
	private String title;

	// 内容
	@Column(columnDefinition = "text")
	private String content;

	// 发布时间
	@Column(nullable = false)
	private Date inTime;

	// 修改时间
	private Date modityTime;

	// 回复数
	@Column(name = "reply_count")
	private int replyCount;

}
