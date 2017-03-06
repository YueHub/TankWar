package com.naruto.tankwar.img;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Img {
	
	/**
	 * ����ͼƬ
	 */
	public static Image background = new ImageIcon("skin/background/background0"+".png").getImage();
	
	/**
	 * ǽ��ͼƬ
	 */
	public static Image[] WALL ; 
	static{
		WALL = new Image[12];
		for(int i = 0;i<WALL.length;i++ ){
		WALL[i] = new ImageIcon("skin/walls/wall0/"+i+".png").getImage();
		}
	}
	
	/**
	 * ̹��ͼƬ
	 */
	public static Image[][] TANK;
	static {
		TANK = new Image[3][4];
		for(int i = 0;i<3;i++){
			for(int j =0;j<4;j++){
				TANK[i][j] = new ImageIcon("skin/tank01/tank"+i+"/"+j+".png").getImage();
			}
		}
	}
	
	/**
	 * �ڵ���ͼƬ
	 */
	public static Image[] BULLET;
	static {
		BULLET = new Image[4];
		for(int i = 0;i<BULLET.length;i++){
			BULLET[i] =new ImageIcon("skin/bullet/"+i+".png").getImage();
		}
	}
	
	/**
	 *��ը��ͼƬ 
	 */
	public static Image[][] BOOM;
	static {
			BOOM = new Image[4][18];
			for(int i=0;i<4;i++){
				for(int j =0 ;j<17;j++){
					BOOM[i][j] = new ImageIcon("skin/booms/boom"+i+"/"+j+".png").getImage();
				}
			}
	}
	
	/**
	 * ���׵�ͼƬ
	 */
	public static Image landmine = new ImageIcon("skin/landmine/landmine.png").getImage();
	
	/**
	 * boss��ͼƬ
	 */
	public static Image boss = new ImageIcon("skin/boss/boss.png").getImage();
	
	
	/**
	 * Ѫ�ۿ�ͼƬ	
	 */
	public static Image rectframe = new ImageIcon("skin/tank/rectframe.png").getImage();
	
	/**
	 * Ѫ�۵�ͼƬ
	 */
	public static Image rect = new ImageIcon("skin/tank/rect.png").getImage();
	
	/**
	 * ��ͣͼƬ
	 */
	public static Image pause = new ImageIcon("skin/other/pause.png").getImage();
	
	/**
	 * ��ȴͼƬ
	 */
	public static Image cooltime = new ImageIcon("skin/other/cooltime.png").getImage();
	
	
}
