package com.naruto.tankwar.service;

import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.ui.LandMine;
import com.naruto.tankwar.ui.Map;
import com.naruto.tankwar.ui.PanelGame;
import com.naruto.tankwar.ui.Tank;

public class GameService {
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto ;
	
	/**
	 * ���췽��
	 */
	public GameService(GameDto dto,PanelGame panelgame){
		this.dto = dto;
	}
	
	
	/**
	 * ��Ϸ��ʼ��
	 */
	public void startGame() {
		this.dto.setStartGame(true);
	}
	
	/**
	 * ̹�������ƶ�
	 */
	public void up() {
		this.dto.getTank().setbU(true);
	}

	/**
	 * ̹�������ƶ�
	 */
	public void down() {
		this.dto.getTank().setbD(true);
	}

	/**
	 * ̹�������ƶ�
	 */
	public void left() {
		this.dto.getTank().setbL(true);
	}

	/**
	 * ̹�������ƶ�
	 */
	public void right() {
		this.dto.getTank().setbR(true);
	}
	
	/**
	 * ���һ��������̹�˵�������̹�˼�����
	 */
	public void addTank() {
		this.dto.getTanks().add(new Tank(this.dto,false,false,200,200,Tank.Direction.D));
	}
	
	/**
	 * ��ȴʱ��
	 */
	public void coolTime() {
		this.dto.setCoolTime(!this.dto.isCoolTime());
	}
	
	/**
	 *���׼� 
	 */
	public void cheat() {
		//���̹��Ѫ������20
		this.dto.getTank().setExp(this.dto.getTank().getExp()+20);
	}

	public void pause() {
		//ÿ��һ�ξ�������ͣ����ûԭ���෴��
		this.dto.setPause(!this.dto.isPause());
	}
	
	/**
	 * ���̹�˿���ʽһ
	 */
	public void fire_1() {
		this.dto.setFireID(0);
		this.dto.getTank().fire();
	}
	
	/**
	 * ���̹�˿���ʽ��
	 */
	public void fire_2() {
		this.dto.setFireID(1);
		this.dto.getTank().fire();
	}
	
	/**
	 * ���̹�˿���ʽ��
	 */
	public void fire_3() {
		this.dto.setFireID(2);
		this.dto.getTank().fire();
	}
	
	/**
	 * ���̹�˿���ʽ��
	 */
	public void buryMine() {
		this.dto.getLandmines().add(new LandMine(this.dto.getTank().getTankX(),this.dto.getTank().getTankY(),this.dto)); 
	}
	
	/**
	 * �ر�Ѫ��
	 */
	public void closeExp() {
		this.dto.setCloseExp(!this.dto.isCloseExp());
	}

	/**
	 * ���ؿ�
	 */
	public void jumpOff() {
		//����
		this.dto.setLevel(this.dto.getLevel()+1);
		//ˢ�µ�ͼ
		this.dto.getMap().removeMap();
		this.dto.setMap(new Map(dto));
		this.dto.getMap().creatMap();
		//����򵽵��Ĺأ�Boss��
		if(dto.getLevel() == 4){
			//ɾ������С��
			for(int i = 0;i<dto.getTanks().size();i++){
				dto.getTanks().get(i).setTankDestroy(true);
			}
			//���tank Boss
			dto.getTanks().add(new Tank(dto,false,true,500,660-180,Tank.Direction.U));
		}
		//�����û�򵽵��Ĺ�
		if(dto.getLevel() != 4){
			//ɾ������С��
			for(int i = 0;i<dto.getTanks().size();i++){
				dto.getTanks().get(i).setTankDestroy(true);
			}
			//����ĸ�С��
		for(int i = 0 ;i<4;i++){
			dto.getTanks().add(new Tank(dto,false,false,500+i*60,0,Tank.Direction.D));
		}
		}
	}
}
