package com.stu.software.feedback.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;
@Table(name="T_ADMIN_COMMENT")
@Entity
@NamedQueries({ @NamedQuery(name = "Comment.getRoot", query="select g from Comment g  where g.parent is null") })

public class Comment extends BaseTreeEntity<Comment>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@Column(name="COMMENT_TIME")
    String CommentTime;
	@Column(name="COMMENT_SUBSTANCE")
	String CommentSubstance;
	@Column(name="COMMENT_ATTRIBUTE")
	String CommentAttribute;
	
	public Long getId() {
		return id;
	}
	
	public String getCommentTime() {
		
		return CommentTime;
	}
	
	public void setCommentTime(String commentTime) {
		
		this.CommentTime = commentTime;
	}
	
	public String getCommentSubstance() {

		return CommentSubstance;
	
	}
	public void setCommentSubstance(String commentSubstance) {
		
		this.CommentSubstance = commentSubstance;
	}
	
	public String getCommentAttribute() {
		
		return CommentAttribute;
		
	}
    public void setCommentAttribute(String commentAttribute) {
		
		this.CommentAttribute = commentAttribute;
	}

	
	

}