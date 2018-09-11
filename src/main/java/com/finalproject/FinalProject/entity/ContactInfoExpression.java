package com.finalproject.FinalProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="contactinfoexpression")
public class ContactInfoExpression {
	
	@Id
	@Column(name = "expression_type")
	private String type;
	private String pattern;
	public ContactInfoExpression() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ContactInfoExpression(String type, String pattern) {
		super();
		this.type = type;
		this.pattern = pattern;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	@Override
	public String toString() {
		return "ContactInfoExpression [type=" + type + ", pattern=" + pattern + "]";
	}
	
	

}
