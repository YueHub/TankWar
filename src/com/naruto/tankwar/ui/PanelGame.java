package com.naruto.tankwar.ui;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import com.naruto.tankwar.control.PlayerControl;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class PanelGame extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 * ���췽��
	 */
	public PanelGame(GameDto dto){
		this.dto = dto;
	}
	
	/**
	 *��װ��Ϸ������ 
	 */
	public void setPlayerControl(PlayerControl playercontrol){
		this.addKeyListener(playercontrol);
	}
	
	/**
	 * �õ���Ϸ���ݴ����
	 */
	public GameDto getGameDto(){
		return dto;
	}


	public void paintComponent(Graphics g){
		//���ݵȼ���������ͼƬ
		Img.background = new ImageIcon("skin/background/background"+this.dto.getLevel()+".png").getImage();
		//���Ʊ���ͼƬ
		g.drawImage(Img.background,0,0,1200,660,null);
		//������Ҫ
		this.dto.getTank().paint(g);
		
		//�������ȴʱ����ô�ͻ�����ȴͼƬ
		if(this.dto.isCoolTime()){
			g.drawImage(Img.cooltime, 0, 0,1200,660,null);
		}
		
		//�������ͣ״̬��ô�ͻ�����ͣͼƬ
		if(this.dto.isPause()){
			g.drawImage(Img.pause,450,280,null);
		}
		//��ý���
		this.requestFocus();
	}
	
}
