package com.naruto.tankwar.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class LandMine {
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 * ���׵Ŀ��
	 */
	private int landMine_W = Img.landmine.getWidth(null);
	
	/**
	 * ���׵ĸ߶�
	 */
	private int landMine_H = Img.landmine.getHeight(null);
	
	/**
	 * ���׵�X����
	 */
	private int landMineX;
	
	/**
	 * ���׵�Y����
	 */
	private int landMineY;
	
	/**
	 * �����Ƿ�ݻ�
	 */
	private boolean landMineDestroy =  false;

	/**
	 * ���췽��
	 */
	public LandMine(int landMineX , int landMineY,GameDto dto){
		this.landMineX = landMineX;
		this.landMineY = landMineY;
		this.dto = dto;
	}
	
	/**
	 * �õ������Ƿ��Ѿ��ݻ�
	 */
	public boolean isLandMineDestroy() {
		return landMineDestroy;
	}
	
	/**
	 * ���õ����Ƿ񱻴ݻ�
	 */
	public void setLandMineDestroy(boolean landMineDestroy) {
		this.landMineDestroy = landMineDestroy;
	}
	
	/**
	 * ��ײ���
	 */
	public Rectangle getRect(){
		return new Rectangle(landMineX,landMineY,landMine_W,landMine_H);
	}

	/**
	 * ���Ƶ���
	 */
	public void drawLandMine(Graphics g){
		if(this.landMineDestroy){
			this.dto.getLandmines().remove(this);
			return ;
		}
		g.drawImage(Img.landmine, landMineX,landMineY,null);
	}
	
}
