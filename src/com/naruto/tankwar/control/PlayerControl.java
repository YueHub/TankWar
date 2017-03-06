package com.naruto.tankwar.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.naruto.tankwar.dto.GameDto;


public class PlayerControl extends KeyAdapter{
	
	/**
	 *��Ϸ������ 
	 */
	private GameControl gamecontrol;
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 *���췽�� 
	 */
	public PlayerControl(GameControl gamecontrol,GameDto dto){
		this.gamecontrol = gamecontrol;
		this.dto = dto;
	}

	/**
	 *��ҿ������������¼��� 
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_SPACE:
			this.gamecontrol.startGame();
			break;
		case KeyEvent.VK_W:
			this.gamecontrol.up();
			break;
		case KeyEvent.VK_S:
			this.gamecontrol.down();
			break;
		case KeyEvent.VK_A:
			this.gamecontrol.left();
			break;
		case KeyEvent.VK_D:
			this.gamecontrol.right();
			break;
			//����ʽһ
		case KeyEvent.VK_J:
			this.gamecontrol.fire_1();
			break;
			//����ʽ��
		case KeyEvent.VK_K:
			this.gamecontrol.fire_2();
			break;
			//����ʽ��
		case KeyEvent.VK_L:
			this.gamecontrol.fire_3();
			break;
			//����ʽ��
		case KeyEvent.VK_I:
			this.gamecontrol.buryMine();
			break;
			//��ӻ�����
		case KeyEvent.VK_F1:
			this.gamecontrol.addTank();
			break;
			//���׼�
		case KeyEvent.VK_F2:
			this.gamecontrol.cheat();
			break;
			//��ȴʱ��
		case KeyEvent.VK_F3:
			this.gamecontrol.coolTime();
			break;
			//���ؿ�(����)
		case KeyEvent.VK_F4:
			this.gamecontrol.jumpOff();
			break;
			//��ͣ
		case KeyEvent.VK_ENTER:
			this.gamecontrol.pause();
			break;
			//�ر�Ѫ��
		case KeyEvent.VK_SHIFT:
			this.gamecontrol.closeExp();
			break;
			
		default:
			break;
		}
		this.dto.getTank().locateDirection();
	} 
	
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W :
			this.dto.getTank().setbU(false);
			break;
		case KeyEvent.VK_S :
			this.dto.getTank().setbD(false);
			break;
		case KeyEvent.VK_A :
			this.dto.getTank().setbL(false);
			break;
		case KeyEvent.VK_D :
			this.dto.getTank().setbR(false);
			break;
		}
		this.dto.getTank().locateDirection();		
	}
	
	
	
	
	
}
