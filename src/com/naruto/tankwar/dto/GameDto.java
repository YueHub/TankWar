package com.naruto.tankwar.dto;

import java.util.ArrayList;
import com.naruto.tankwar.ui.Boom;
import com.naruto.tankwar.ui.Bullet;
import com.naruto.tankwar.ui.LandMine;
import com.naruto.tankwar.ui.Map;
import com.naruto.tankwar.ui.Tank;
import com.naruto.tankwar.ui.Wall;

public class GameDto {
	
	/**
	 * panelgame�Ŀ��
	 */
	public static int panelGame_W;
	
	/**
	 * panelgame�ĸ߶�
	 */
	public static int panelGame_H;

	/**
	 * ���̹��
	 */
	private Tank mytank;

	/**
	 * ����̹�˼���
	 */
	private ArrayList<Tank> tanks;

	/**
	 * �ڵ�����
	 */
	private ArrayList<Bullet> bullet;
	
	/**
	 * ���׼���
	 */
	private ArrayList<LandMine> landmines;
	
	/**
	 * ǽ��
	 */
	private ArrayList<Wall> walls;
	
	/**
	 * ��ը
	 */
	private Boom boom;
	
	/**
	 * �洢��ͼ�Ķ�ά���飨ʵ�ʴ���ǵ�ͼÿ��ͼƬ��id��
	 */
	private int[][] numMap ;
		
	/**
	 * ��Ϸ��ͼ
	 */
	private Map map ;

	/**
	 * �Ƿ�����ͣ״̬
	 */
	private boolean pause = false;

	/**
	 * �Ƿ�����ȴʱ��
	 */
	private boolean coolTime = false;
	
	/**
	 * �Ƿ�ر�Ѫ��
	 */
	private boolean closeExp = false;
	
	/**
	 * ��Ϸ�Ƿ�ʼ
	 */
	private boolean startGame = false;

	/**
	 * �����ID��
	 */
	private int fireID = 0; 
	
	/**
	 * ̹��Ŀǰ�ĵȼ�
	 */
	private int level;

	/**
	 * ���췽��
	 */
	public GameDto(){
		this.initDto();
		boom = new Boom(0,0,this);
	}
	
	/**
	 * ��ʼ��GameDto
	 */
	public void initDto(){
		//������Ż�����̹�˵ļ��϶���
		this.tanks = new ArrayList<Tank>();
		//��������ڵ��ļ��϶���
		this.bullet = new ArrayList<Bullet>();
		//������ŵ��׵ļ��϶���
		this.landmines = new ArrayList<LandMine>();
		//������ǽ�ڵļ��϶���
		this.walls = new ArrayList<Wall>();
		//�������̹�˶���
		mytank = new Tank(this,true,false,600,200,Tank.Direction.STOP);
		//�������ֵ�ͼ
		numMap = new int[11][20];
	}
	
	/**
	 * �õ���Ϸ�Ƿ�ʼ
	 */
	public boolean isStartGame() {
		return startGame;
	}

	/**
	 * ������Ϸ�Ƿ�ʼ
	 */
	public void setStartGame(boolean startGame) {
		this.startGame = startGame;
	}
	
	/**
	 *�õ����̹�� 
	 */
	public Tank getTank(){
		return mytank;
	}
	
	/**
	 * �������̹��
	 */
	public void setTank(Tank mytank){
		this.mytank = mytank;
	}
	
	/**
	 * �õ�������̹�˼���
	 */
	public ArrayList<Tank> getTanks(){
		return tanks;
	}
	
	/**
	 * �õ��ڵ�����
	 */
	public ArrayList<Bullet> getBullet(){
		return bullet;
	}
	
	/**
	 * �õ����׼���
	 */
	public ArrayList<LandMine> getLandmines() {
		return landmines;
	}
	
	/**
	 * �õ���ը
	 */
	public Boom getBoom(){
		return boom;
	}
	
	/**
	 * �õ�ǽ�ڼ���
	 */
	public ArrayList<Wall> getWalls() {
		return walls;
	}
	
	/**
	 * �õ���ͼ��ά����
	 */
	public int[][] getNumMap(){
		return numMap;
	}
	/**
	 * ������Ϸ��ͼ
	 */
	public void setMap(Map map) {
		this.map = map;
	}
	
	/**
	 * �õ���Ϸ��ͼ
	 */
	public Map getMap(){
		return map;
	}
	
	/**
	 * �õ��Ƿ���ͣ
	 */
	public boolean isPause() {
		return pause;
	}
	
	/**
	 * �����Ƿ���ͣ
	 */
	public void setPause(boolean pause) {
		this.pause = pause;
	}
	
	/**
	 * �õ��Ƿ�����ȴʱ��
	 */
	public boolean isCoolTime() {
		return coolTime;
	}
	
	/**
	 * ������ȴʱ��
	 */
	public void setCoolTime(boolean coolTime) {
		this.coolTime = coolTime;
	}
	
	/**
	 * �õ��Ƿ����Ѫ��
	 */
	public boolean isCloseExp() {
		return closeExp;
	}
	
	/**
	 * �����Ƿ����Ѫ��
	 */
	public void setCloseExp(boolean closeExp) {
		this.closeExp = closeExp;
	}
	
	/**
	 * �õ�����ʽ��ID
	 */
	public int getFireID() {
		return fireID;
	}
	
	/**
	 * ���ÿ���ʽ��ID
	 */
	public void setFireID(int fireID) {
		this.fireID = fireID;
	}
	
	/**
	 * �õ�̹��Ŀǰ�ĵȼ�
	 */
	public int getLevel() {
		return level;
	}
	
	/**
	 * ����̹��Ŀǰ�ĵȼ�
	 */
	public void setLevel(int level) {
		this.level = level;
	}
}
