package com.naruto.tankwar.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class Bullet {
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
		
	/**
	 * �ڵ��Ƿ�ݻ�
	 */
	private boolean bulletDestroy = false;
	
	/**
	 * �ڵ���X����
	 */
	private int bulletX;
	
	/**
	 * �ڵ���Y����
	 */
	private int bulletY;
	
	/**
	 * ����ö��
	 */
	Tank.Direction dir;
	
	/**
	 * ����ҵĻ��ǻ����˵�bullet
	 */
	private boolean playerb;
	
	/**
	 * �ǲ���boss��bullet
	 */
	private boolean bossb;
	
	/**
	 * ����ʽ��ID
	 */
	private int fireID;
	
	/**
	 * �ڵ��Ŀ��
	 */
	public static int BULLET_W ;
	
	/**
	 * �ڵ��ĸ߶�
	 */
	public static int BULLET_H ;
	
	/**
	 * �ڵ�X�����ƶ����ٶ�
	 */
	private static final int XSPEED = 30;
	
	/**
	 * �ڵ�Y�����ƶ����ٶ�
	 */
	private static final int YSPEED = 30;
	
	/**
	 * ���췽�� 
	 */
	public Bullet(int bulletX,int bulletY,GameDto dto,Tank.Direction dir,boolean playerb,boolean bossb){
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.dto = dto;
		this.dir = dir;
		this.playerb = playerb;
		this.bossb = bossb;
		this.initBullet();
	}
	
	/**
	 * ��ʼ���ڵ�
	 */
	public void initBullet(){
		//�õ��ڵ���ID
		fireID = this.dto.getFireID();
		//�õ���ʱ�ڵ��ĳ��Ϳ�
		BULLET_W = Img.BULLET[fireID].getWidth(null);
		BULLET_H = Img.BULLET[fireID].getHeight(null);
	}
	
	/**
	 * �����ڵ��Ƿ�Ϊ��ҵ��ڵ�
	 */
	public void setPlayerb(boolean playerb){
		this.playerb = playerb;
	}
	
	/**
	 * �����ڵ���X����
	 */
	public int getBulletX() {
		return bulletX;
	}

	/**
	 * �����ڵ���X����
	 */
	public void setBulletX(int bulletX) {
		this.bulletX = bulletX;
	}
	
	/**
	 * �����ڵ���Y����
	 */
	public int getBulletY() {
		return bulletY;
	}

	/**
	 * �����ڵ���Y����
	 */
	public void setBulletY(int bulletY) {
		this.bulletY = bulletY;
	}
	
	/**
	 * �õ��ڵ��Ƿ񻹴���
	 */
	public boolean isbulletDestroy(){
		return bulletDestroy;
	}
	
	/**
	 * �õ����ڵ��ľ��Σ�������ײ��⣩ 
	 */
	public Rectangle getRect(){
		return new Rectangle(bulletX,bulletY,BULLET_W,BULLET_H);
	}
	
	/**
	 * �ӵ�����̹����
	 */
	public boolean hitTank(Tank tank){
		if(this.getRect().intersects(tank.getRect())&&!this.isbulletDestroy()&&tank.isPlayer()!=this.playerb){
			//���뱬ը���X����
			this.dto.getBoom().setBoomX(tank.getTankX());
			//���뱬ը���Y����
			this.dto.getBoom().setBoomY(tank.getTankY());
			//�����ڵ�Ϊ�ݻ�״̬
			this.bulletDestroy = true;
			//���ñ�ըΪ��Ҫ
			this.dto.getBoom().setLive(true);
			//̹�˵�Ѫ
			tank.reduceExp();
			//���̹��Ѫ��С��0  ̹�˵���������һ  
			if(tank.getExp()<=0){
				tank.setLife(tank.getLife()-1);
				tank.setTankX(400);
				tank.setTankY(600);
				tank.setExp(100);
			}
			if(tank.getLife()==0){	
				tank.setTankDestroy(true);
				this.dto.getTanks().remove(tank);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * �ڵ�����̹�˼�����
	 */
	public boolean hitTanks(ArrayList<Tank> tanks){
		for(int i = 0;i<tanks.size();i++){
			if(this.hitTank(tanks.get(i))){
				return true ;
			}
		}
		return false;
	}
	
	/**
	 * �ڵ���һ��ǽ���ϣ���������ĵ��ã�
	 */
	public boolean hitWall(Wall wall){
		if(this.getRect().intersects(wall.getRect())){
			//ǽ�ڵ�Ѫ
			wall.reduceExp();
			this.bulletDestroy = true;
			return true;
		}
		return false;
	}
	
	/**
	 * �ڵ�����ǽ����
	 */
	public boolean hitWalls(ArrayList<Wall> walls){
		for(int i = 0;i<walls.size();i++){
			if(this.hitWall(walls.get(i))){
				return true;
			}
		}	
		return false;
	}
	
	/**
	 * �ƶ��ڵ��ķ������ο�����ʿ����
	 */
	public void moveBullet() {
		if(this.dto.isPause()){
			return;
		}
		switch(dir) {
		case L:
			bulletX -= XSPEED;
			break;
		case U:
			bulletY -= YSPEED;
			break;
		case R:
			bulletX += XSPEED;
			break;
		case D:
			bulletY += YSPEED;
			break;
		case STOP:
			break;
		}
		//����100 ������ڵ��ڱ߽��޷�����
		if(bulletX < -100 || bulletY < -100 || bulletX > 1300 || bulletY > 800) {
			bulletDestroy = true;
		}
		
}
	
	/**
	 *�����ڵ� 
	 */
	public void drawBullet(Graphics g){
		//����ڵ��Ѿ��ݻ��ǾͲ�����
		if(bulletDestroy){
			this.dto.getBullet().remove(this);
			return;
		}
		//���������ڵ���ô�Ϳ����и����ڵ�
		if(this.playerb){
			g.drawImage(Img.BULLET[fireID],bulletX,bulletY,null);
		}
		//�����boss���ڵ�  �������һ���ڻ�
		if(this.bossb){
			g.drawImage(Img.BULLET[3],bulletX,bulletY,null);
		}
		//�������ͨ�����˵��ڵ�   ��ֻ���е�һ���ڵ�
		if(!this.playerb&&!this.bossb)
		{
			g.drawImage(Img.BULLET[0],bulletX,bulletY,null);
		}
		
		moveBullet();
	}
	
	
}
