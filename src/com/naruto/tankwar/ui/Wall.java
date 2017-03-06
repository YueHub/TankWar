package com.naruto.tankwar.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class Wall {
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 * ǽ��ͼƬ
	 */
	private Image img;
	
	/**
	 * ǽ�ڵ�X����
	 */
	private int wallX;
	
	/**
	 * ǽ�ڵ�Y����
	 */
	private int wallY;
	
	/**
	 * ��ʶǽ�ڵ�ID��
	 */
	private int wallID;
	
	/**
	 * ǽ�ڵ�Ѫ��
	 */
	private int exp;
	
	/**
	 * ǽ��ͼƬ�Ŀ��
	 */
	private int WALL_W ;
	
	/**
	 * ǽ��ͼƬ�ĸ߶�
	 */
	private  int WALL_H ;
	
	/**
	 * ���췽��
	 */
	public Wall(Image img,int wallID,int wallX,int wallY,GameDto dto){
		this.img = img;
		this.wallID = wallID;
		this.wallX = wallX;
		this.wallY = wallY;
		this.dto = dto;
		this.initWall();
	}
	
	/**
	 * ǽ�ڳ�ʼ��
	 */
	public void initWall(){
		if(this.wallID == 0){
			WALL_W = 0 ;
			WALL_H = 0 ;
		}
		else{
			WALL_W = Img.WALL[wallID].getWidth(null);
			WALL_H = Img.WALL[wallID].getHeight(null);
			this.exp = 100;
		}
	}
	
	/**
	 * ǽ�ڵ�Ѫ
	 */
	public void reduceExp(){
		if(this.getWallID()!=5&&this.getWallID()!=0){
			this.exp -= (10+this.dto.getFireID()*30);
		}
	}
	
	/**
	 * �õ�����ǽ�ڵ�Ѫ��
	 */
	public int getExp() {
		return exp;
	}
	
	/**
	 * ����ǽ�����ڵ�Ѫ��
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	/**
	 * �õ�ǽ�ڵ�ID
	 */
	public int getWallID() {
		return wallID;
	}
	
	/**
	 * ����ǽ�ڵ�ID
	 */
	public void setWallID(int wallID) {
		this.wallID = wallID;
	}

	/**
	 * ��ײ���
	 */
	public Rectangle getRect(){
		return new Rectangle(wallX,wallY,WALL_W,WALL_H);
	}
	
	/**
	 * ����ǽ��
	 */
	public void drawWall(Graphics g){
		if(this.exp<=0){
			this.dto.getWalls().remove(this);
			return ;
		}
		g.drawImage(img, wallX, wallY,null);
	}
}
