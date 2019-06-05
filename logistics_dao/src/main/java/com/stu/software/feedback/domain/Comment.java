package com.stu.software.feedback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stu.software.domain.BaseEntity;


@Entity
@Table(name = "T_COMMENT")
public class Comment extends BaseEntity {

	private static final long serialVersionUID = 1L;

	public String getCommentID() {
		return CommentID;
	}

	public void setCommentID(String commentID) {
		CommentID = commentID;
	}

	@Column(name="COMMENT_ID")
	String CommentID;

	public String getCommentTime() {
		return CommentTime;
	}

	public void setCommentTime(String commentTime) {
		CommentTime = commentTime;
	}

	@Column(name="COMMENT_TIME")
	String CommentTime;


	public String getCommentContent() {
		return CommentContent;
	}

	public void setCommentContent(String commentContent) {
		CommentContent = commentContent;
	}

	@Column(name="COMMENT_CONTENT")
	String CommentContent;


	@ManyToOne
	@JoinColumn(name="CTYPE_ID")
	Ctype ctype;

}