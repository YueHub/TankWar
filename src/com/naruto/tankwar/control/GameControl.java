package com.naruto.tankwar.control;

import com.naruto.tankwar.service.GameService;
import com.naruto.tankwar.ui.PanelGame;

public class GameControl {
	
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameservice;
	
	/**
	 * ���췽��
	 */
	public GameControl(GameService gameservice,PanelGame panelgame){
		this.gameservice = gameservice;
	}
	
	/**
	 * ��Ϸ�����������߼������Ϸ��ʼ�ķ���
	 */
	public void startGame() {
		this.gameservice.startGame();
	}
	
	/**
	 * ��Ϸ�����������߼���������ƶ��ķ���
	 */
	public void up() {
		this.gameservice.up();
	}
	
	/**
	 * ��Ϸ�����������߼���������ƶ��ķ���
	 */
	public void down() {
		this.gameservice.down();
	}

	/**
	 * ��Ϸ�����������߼���������ƶ��ķ���
	 */
	public void left() {
		this.gameservice.left();
	}

	/**
	 * ��Ϸ�����������߼���������ƶ��ķ���
	 */
	public void right() {
		this.gameservice.right();
	}

	/**
	 * ��Ϸ�����������߼�������̹�˵ķ���
	 */
	public void addTank() {
		this.gameservice.addTank();
	}
	
	/**
	 * ��ʱ����
	 */
	public void coolTime() {
		this.gameservice.coolTime();
	}
	
	/**
	 * ��Ϸ�����������߼�������׵ķ���
	 */
	public void cheat() {
		this.gameservice.cheat();
	}

	/**
	 * ��Ϸ�����������߼������Ϸ��ͣ�ķ���
	 */
	public void pause() {
		this.gameservice.pause();
	}
	
	/**
	 * ��Ϸ�����������߼���Ŀ���ʽһ�ķ���
	 */
	public void fire_1() {
		this.gameservice.fire_1();
	}
	
	/**
	 * ��Ϸ�����������߼���Ŀ���ʽ���ķ���
	 */
	public void fire_2() {
		this.gameservice.fire_2();
	}
	
	/**
	 * ��Ϸ�����������߼���Ŀ���ʽ���ķ���
	 */
	public void fire_3() {
		this.gameservice.fire_3();
	}
	
	/**
	 * ��Ϸ�����������߼���Ŀ���ʽ�ĵķ���
	 */
	public void buryMine() {
		this.gameservice.buryMine();
	}
	
	/**
	 * ��Ϸ�����������߼���Ĺر�Ѫ�۵ķ���
	 */
	public void closeExp() {
		this.gameservice.closeExp();
	}

	/**
	 * ���ؿ�
	 */
	public void jumpOff() {
		this.gameservice.jumpOff();
	}
}
