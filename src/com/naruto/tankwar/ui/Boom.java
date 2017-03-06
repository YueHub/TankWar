package com.naruto.tankwar.ui;

import java.awt.Graphics;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class Boom {
	
	/**
	 * ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 * ��ը��X����
	 */
	private int boomX;

	/**
	 * ��ը��Y����
	 */
	private int boomY;
	
	/**
	 * ���ñ�ըΪ��Ҫ
	 */
	private boolean live = true;
	
	/**
	 * ��ը��id
	 */
	private int id ;
	
	/**
	 * ���췽��
	 */
	public Boom(int boomX,int boomY,GameDto dto){
		this.boomX = boomX;
		this.boomY = boomY;
		this.dto = dto;
	}
	
	/**
	 * �õ���ը���X����
	 */
	public int getBoomX() {
		return boomX;
	}

	/**
	 * ���ñ�ը���Y����
	 */
	public void setBoomX(int boomX) {
		this.boomX = boomX;
	}

	/**
	 * �õ���ը���Y����
	 */
	public int getBoomY() {
		return boomY;
	}
	
	/**
	 * ���ñ�ը���Y����
	 */
	public void setBoomY(int boomY) {
		this.boomY = boomY;
	}
	
	/**
	 * ���ñ�ը�Ƿ���Ҫ
	 */
	public void setLive(boolean live){
		this.live = live;
	}
	
	public void drawBoom(Graphics g){	
		//�������Ҫ��ը�Ͳ��滭
		if(!live){
			return;
		}
		if(id == Img.BOOM[0].length){
			live = false;
			id = 0;
			return;
		}
		g.drawImage(Img.BOOM[this.dto.getFireID()][id], boomX, boomY,null);
		id++;	
	}
	
}
