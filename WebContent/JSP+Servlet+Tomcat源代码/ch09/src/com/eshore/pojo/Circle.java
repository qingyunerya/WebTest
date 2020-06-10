package com.eshore.pojo;

import java.io.Serializable;

public class Circle implements Serializable{

	private static final long serialVersionUID = 1L;
	private double radius =1.0d;	//�뾶
	private double circleArea = 0.0d;	//Բ���
	private double circumference=0.0d;	//Բ�ܳ�
	public Circle() {	//�޲����Ĺ��췽��
		super();
		// TODO Auto-generated constructor stub
	}
	//���Ե�get��set����
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getCircleArea() {
		circleArea = Math.PI*radius*radius;//����Բ���
		return circleArea;
	}
	public void setCircleArea(double circleArea) {
		this.circleArea = circleArea;
	}
	public double getCircumference() {
		circumference = 2*Math.PI*radius;//����Բ�ܳ�
		return circumference;
	}
	public void setCircumference(double circumference) {
		this.circumference = circumference;
	}
}
