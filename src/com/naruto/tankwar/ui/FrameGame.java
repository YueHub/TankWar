package com.naruto.tankwar.ui;

import javax.swing.JFrame;
import com.naruto.tankwar.dto.GameDto;

public class FrameGame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;
	
	/**
	 * ��Ϸ����
	 */
	private PanelGame panelgame ;
		
	/**
	 *��Ϸ�߳� 
	 */
	private Thread gameThread;
	
	/**
	 * ���췽��
	 */
	public FrameGame(PanelGame panelgame,GameDto dto){
		this.dto = dto;
		this.panelgame = panelgame;
		//���ô�������
		this.setTitle("java��̹�˴�ս");
		//���ùرհ�ť
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ڲ��ɸı��С
		this.setResizable(false);
		//���ô���λ�úʹ�С
		this.setBounds(50,10,1200+6,660+28);	
		//����Ĭ��Panel������Panel��
		this.setContentPane(panelgame);	
		//���ô��ڿɼ�
		this.setVisible(true);
		//�õ�panelgame�Ŀ�Ⱥ͸߶�
		GameDto.panelGame_W = panelgame.getWidth();
		GameDto.panelGame_H = panelgame.getHeight();
		
		//���ػ�����̹��
		this.loadTankComputer();
		
		//���ص�ͼ
		this.loadMap();
		
		//����ˢ�²��ϻ�����߳�
		this.reFreshThread();
	}
	
	/**
	 * ���ػ�����̹��
	 */
	public void loadTankComputer(){
		for(int i = 0;i<4;i++){
			this.dto.getTanks().add(new Tank(this.dto,false,false,420+i*60,0,Tank.Direction.D));
			}
	}
		
	/**
	 * ������Ϸ��ͼ
	 */
	public void loadMap(){
		//������һ����Ϸ��ͼ����
		this.dto.setMap(new Map(this.dto));
		this.dto.getMap().creatMap();
	}
	
	/**
	 * ˢ���߳�
	 */
	 public void reFreshThread(){
		//�����ƶ�ˢ�»�����߳�
		this.gameThread = new Thread(){
			public void run(){
				while(true){
					try {
						Thread.sleep(100);
						panelgame.repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}	
		};
		this.gameThread.start();
	  }
	
}
