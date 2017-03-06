package com.naruto.tankwar.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class Map {
	
	/**
	 * ��Ϸ���ݴ����
	 */
	private GameDto dto;

	/**
	 * ������
	 */
	FileReader fr = null;	
	
	/**
	 * �����װ��
	 */
	BufferedReader br = null;
	
	/**
	 * ������ڵĵȼ�
	 */
	public static int level;
	
	/**
	 * ���췽��
	 */
	public Map(GameDto dto){
		this.dto = dto;
	}
	
	
	
	/**
	 * ������е�ͼ��Ϣ���ļ�����άint�����飩PS�������java����������Ϸ
	 */
	public void readMap(){		
		String filepath = "maps/" + level + ".map";
		File file = new File(filepath);	
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			for (int i = 0; i < 11; i++) {
				String line = br.readLine();
				byte[] point = line.getBytes();
				for (int j = 0; j < 20; j++) {
					this.dto.getNumMap()[i][j] = point[j] - 48;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br == null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				br = null;
			}
			if (fr == null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fr = null;
			}
		}
	}
	
	/**
	 * ɾ��ԭ���ĵ�ͼ
	 */
	public void removeMap(){
		//��������ǽ��Ѫ��Ϊ0  ɾ������ǽ�ڣ���ɾ����ͼ��
		for (int i = 0; i < this.dto.getWalls().size(); i++) {
				this.dto.getWalls().get(i).setExp(0);
		}
	}
	
	/**
	 * ������ͼ
	 */
	public void creatMap(){
		//�õ���ǰ��̹�˵ȼ�
		level = this.dto.getLevel();
		//���ݵȼ�����ǽ��ͼƬ
		for(int i = 0;i<Img.WALL.length;i++ ) {
			Img.WALL[i] = new ImageIcon("skin/walls/wall"+level+"/"+i+".png").getImage();
		}
		//�����ͼ�ļ�
		this.readMap();
		//���ݵ�ͼ�ļ����ǽ�ڣ��������ͼ��
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 20; j++) {
				int wallID = this.dto.getNumMap()[i][j];
				this.dto.getWalls().add(new Wall(Img.WALL[wallID],wallID,j*60,i*60,dto));
			}
		}
	}
}
