package com.naruto.tankwar.ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import com.naruto.tankwar.dto.GameDto;
import com.naruto.tankwar.img.Img;

public class Tank{	
	
	/**
	 * �������ڲ������
	 */
	private Tank thistank = this;
	
	/**
	 * �ڲ��ࣨ����������Ϸ����Ҫ���֣�
	 */
	private paintMain paintMian;
	
	/**
	 * ��Ϸ����
	 */
	private GameDto dto;
		
	/**
	 * ̹�˵�X����
	 */
	private int tankX;
	
	/**
	 * ̹�˵�Y���� 
	 */
	private int tankY;
	
	/**
	 * ̹�˵��ƶ��ٶ�
	 */
	private static final int SPEED = 15;
	
	/**
	 * ��̹ͨ�˵Ŀ��
	 */
	private static final int TANK_W = 60;
	
	/**
	 * ��̹ͨ�˵ĸ߶�
	 */
	private static final int TANK_H = 60;

	/**
	 * ̹��boss�Ŀ��
	 */
	private static final int BOSS_W = 180;
	
	/**
	 * ̹��boss�ĸ߶�
	 */
	private static final int BOSS_H = 180;
	
	/**
	 * ̹�˵�X�ƶ�����
	 */
	private int xMove;
	
	/**
	 * ̹�˵�Y�ƶ�����
	 */
	private int yMove;
	
	/**
	 * ̹��ǰһ����X����
	 */
	private int oldX;
	
	/**
	 * ̹��ǰһ����Y����
	 */
	private int oldY;

	/**
	 * ̹�˵�Ѫ��
	 */
	private double exp;
	
	/**
	 * ̹������ҿ��ƻ��Ǽ��������
	 */
	private boolean player;
	
	/**
	 * �Ƿ���boss
	 */
	private boolean boss; 

	/**
	 * ̹���Ƿ񱻴ݻ�
	 */
	private boolean tankDestroy;
	
	/**
	 * �ĸ�����
	 */
	private boolean bL=false, bU=false, bR=false, bD = false;
	
	/**
	 *ö�ٰ˸�����
	 */
	public static enum Direction {L, U, R, D, STOP};
	
	/**
	 * ��ʼ������
	 */
	private Direction dir = Direction.STOP;
	
	/**
	 * ��ʼ������
	 */
	private Direction pdDir = Direction.U;
	
	/**
	 * �õ�һ�������������
	 */
	private static Random random = new Random();
	
	/**
	 * ��ÿһ������������̹�˻���3��15֮��ĽŲ�
	 */
	private int step = random.nextInt(12) + 3;
	
	/**
	 * ̹�˵�ID��
	 */
	private int tankID;
	
	/**
	 * ̹�˵�����
	 */
	private int tankKind;
	
	
	/**
	 * ̹�˵�������
	 */
	private int life;
	
	/**
	 * ���췽��
	 */
	public Tank(GameDto dto,boolean player,boolean boss,int tankX,int tankY,Direction dir){
		this.dto = dto;
		//��ʼ��̹�˵�Ѫ��
		this.exp = 100;
		//��ʼ��̹����˭���Ƶ�
		this.player = player;
		//��ʼ��̹���Ƿ���boss
		this.boss = boss;
		this.tankX = tankX;
		this.tankY = tankY;
		//��ʼ��������̹�˵ķ���
		this.dir = dir;
		initTank();
	}
	
	/**
	 * ��ʼ��̹�˵������ʶ ��������
	 */
	public void initTank(){
		if(this.isPlayer()){
			this.tankKind = 0;
			this.life = 2;
		}
		if(!this.isPlayer()&&!this.isBoss()){
			this.tankKind = 1;
			this.life = 1;
		}
		if(this.isBoss()){
			this.tankKind = 2;
			this.life = 2;
		}	
		paintMian = new paintMain();
	}
	
	/**
	 * �õ�̹�˵�X����
	 */
	public int getTankX() {
		return tankX;
	}
	
	/**
	 * ����̹�˵�X���� 
	 */
	public void setTankX(int tankX) {
		this.tankX = tankX;
	}
	
	/**
	 * �õ�̹�˵�Y����
	 */
	public int getTankY() {
		return tankY;
	}
	
	/**
	 * ����̹�˵�Y����
	 */
	public void setTankY(int tankY) {
		this.tankY = tankY;
	}
	
	
	/**
	 * �õ�̹���Ƿ񱻴ݻ�
	 */
	public boolean isTankDestroy(){
		return tankDestroy;
	}
	
	/**
	 * ����̹���Ƿ񱻴ݻ�
	 */
	public void setTankDestroy(boolean tankDestroy) {
		this.tankDestroy = tankDestroy;
	}
	
	/**
	 * ����̹�������Ƿ�Ϊtrue���������û�а��������
	 */
	public void setbL(boolean bL) {
		this.bL = bL;
	}
	
	/**
	 * ����̹���Ϸ����Ƿ�Ϊtrue���������û�а��Ϸ������
	 */
	public void setbU(boolean bU) {
		this.bU = bU;
	}
	
	/**
	 * ����̹�������Ƿ�Ϊtrue���������û�а��ҷ������
	 */
	public void setbR(boolean bR) {
		this.bR = bR;
	}
	
	/**
	 * ����̹�������Ƿ�Ϊtrue���������û�а��·������
	 */
	public void setbD(boolean bD) {
		this.bD = bD;
	}
	
	/**
	 * �õ�����̹�˵�Ѫ�� 
	 */
	public double getExp() {
		return exp;
	}
	
	/**
	 * ��������̹�˵�Ѫ��
	 */
	public void setExp(double exp) {
		this.exp = exp;
	}
		
	/**
	 * �õ�������ҵ�������
	 */
	public int getLife() {
		return life;
	}

	/**
	 * ����������ڵ�������
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * �õ�̹������ҿ��ƻ��Ǽ��������
	 */
	public boolean isPlayer() {
		return player;
	}
	
	/**
	 * ����̹������һ��Ǽ��������
	 */
	public void setPlayer(boolean player) {
		this.player = player;
	}
	
	/**
	 * �õ�̹���Ƿ���boss
	 */
	public boolean isBoss() {
		return boss;
	}
	
	/**
	 * ����̹���Ƿ���boss
	 */
	public void setBoss(boolean boss) {
		this.boss = boss;
	}
	
	/**
	 *�õ�̹�˵ľ��Σ�������ײ��⣩ 
	 */
	public Rectangle getRect(){
		if(this.boss){
			return new Rectangle(tankX,tankY,BOSS_W,BOSS_H);
		}
		else{
			return new Rectangle(tankX,tankY,TANK_W,TANK_H);
		}
		
	}
	
	/**
	 * ̹�˿���
	 */
	public void fire() {
		if(this.tankDestroy){
			return;
		}
		//��ʼ�ڵ���X�����Y����
		int x = 0;
		int y = 0;
		//��������̹�˽�̹���ڵ���ʶΪ����ڵ� ���´���һ���ڵ����ڵ�������
		if(this.isPlayer()) {
			x = this.tankX + TANK_W/2 - Bullet.BULLET_W/2;
			y = this.tankY + TANK_H/2 - Bullet.BULLET_H/2;
			Bullet bullet = new Bullet(x, y,this.dto,pdDir,true,false);
			this.dto.getBullet().add(bullet);
		}
		if(this.isBoss()){
			 x = this.tankX + BOSS_W/2 - 140/2;
			 y = this.tankY + BOSS_H/2 - 110/2; 
			Bullet bullet = new Bullet(x,y,this.dto,pdDir,false,true);
			this.dto.getBullet().add(bullet);
		}
		//����ǻ�����̹�˽�̹���ڵ���ʶΪ�������ڵ� ���´���һ���ڵ����ڵ�������
		if(!this.isPlayer()&&!this.isBoss())
		{
			x = this.tankX + TANK_W/2 - Bullet.BULLET_W/2;
			y = this.tankY + TANK_H/2 - Bullet.BULLET_H/2;
			Bullet bullet = new Bullet(x, y,this.dto,pdDir,false,false);
			this.dto.getBullet().add(bullet);
		}
	}

	/**
	 * ��Ѫ
	 */
	public void reduceExp(){
		//��������̹��ÿ�α����5��Ѫ
		if(this.isPlayer()){
			this.exp -= 5;
		}
		if(this.isBoss()){
			this.exp -= 5;
		}
		//����ǻ�����ÿ�α���۲�ͬ��Ѫ���뿪��ʽ�йأ�
		if(!this.isBoss()&&!this.isPlayer())
			switch(this.dto.getFireID()){
			case 0 :this.exp -= 15;break;
			case 1 :this.exp -= 25;break;
			case 2 :this.exp -= 40;break;
			case 3 :this.exp -= 60;break;
			}
			
	}
	
	/**
	 * ̹���Ƿ� ײ��ǽ��
	 */
	public boolean hitWall(Wall wall){
		if(this.getRect().intersects(wall.getRect())){
			return true;
		}
		return false;
	}
	
	/**
	 * ̹����ײ�Ƿ���ײǽ����
	 */
	public boolean hitWalls(){
		for(int i = 0 ;i<this.dto.getWalls().size();i++){
			if(this.hitWall(this.dto.getWalls().get(i))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �Ƿ���ײ����̹��
	 */
	public boolean hitTank(Tank tank){
		if(this.getRect().intersects(tank.getRect())&&tank!=thistank){
			return true;
		}
		return false;
	}
	
	/**
	 * �Ƿ���ײ��������������̹��
	 */
	public boolean hitTanks(){
		for(int i = 0;i<this.dto.getTanks().size();i++){
			if(this.hitTank(this.dto.getTanks().get(i))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ̹����ײ�ϵ���
	 */
	public boolean hitLandMine(LandMine landmine){
		if(this.getRect().intersects(landmine.getRect())&&!this.isPlayer()){
			//�������ϵ��׵�̹�˴ݻ�
			this.setTankDestroy(true);
			//�Ӽ������Ƴ���̹��
			this.dto.getTanks().remove(this);
			//������ըΪ��Ҫ
			this.dto.getBoom().setLive(true);
			//���õ���Ϊ�����ֿ���ʽ
//			this.dto.setFireID(4);
			//���õ��״ݻ�
			landmine.setLandMineDestroy(true);
			return true;
		}
		return false;
	}
	
	/**
	 * ̹����ײ��һȺ����
	 */
	public boolean hitLandMines(){
		for(int i =0;i<this.dto.getLandmines().size();i++){
			if(this.hitLandMine(this.dto.getLandmines().get(i))){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ƶ�
	 */
	public void stay(){
		tankX = oldX;
		tankY = oldY;
	}
	
	/**
	 * ���ֲ�ͬ�İ��������Ӧö�ٵİ˸�����
	 */
	public void locateDirection() {
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
	}
	
	/**
	 * ���ݲ�ͬ���̹������ͬ���ƶ�
	 */
	public void move() {
		if(!this.dto.isStartGame()){
			return ;
		}
		//�������̹ͣ�˾Ͳ��ƶ�
		if(this.dto.isPause()){
			return;
		}
		//�������ȴʱ�䲢���ǻ������ǾͲ��ƶ�
		if(!this.isPlayer()&&this.dto.isCoolTime()){
			return;
		}
		
		oldX = tankX;
		oldY = tankY;
		
		//����ǻ�����̹��  �͸�����������ƶ�
		if(!this.isPlayer()){
			Direction[] dirs = Direction.values();
			if(step == 0) {
				step = random.nextInt(12) + 3;
				int rn = random.nextInt(dirs.length);
				//ȡ�����һ������ 
				this.dir = dirs[rn];
				//��ĳһ��������step�� stepΪ3��15������� 
		}
			
			step -- ;
			
			if(this.isBoss()){
				if(random.nextInt(15)<3){
					fire();	
				}
			}
			if(!this.isBoss()){
				if(random.nextInt(15)<5){
					fire();	
				}
			}
			
		}
		switch(dir){
		case U:
			xMove = 0;
			yMove = -SPEED;
			if(this.isOverWindow(tankX+xMove, tankY+yMove)){
				return ;
			}
			tankX += xMove;
			tankY += yMove;
			tankID = 0;
			break;
		case D:
			xMove = 0;
			yMove = SPEED;
			if(this.isOverWindow(tankX+xMove, tankY+yMove)){
				return ;
			}
			tankX += xMove;
			tankY += yMove;
			tankID = 1;
			break;
		case STOP:
			break;
		case L:
			xMove = -SPEED;
			yMove = 0;
			if(this.isOverWindow(tankX+xMove, tankY+yMove)){
				return ;
			}
			tankX += xMove;
			tankY += yMove;
			tankID = 2;
			break;
		case R:
			xMove = SPEED;
			yMove = 0;
			if(this.isOverWindow(tankX+xMove, tankY+yMove)){
				return ;
			}
			tankX += xMove;
			tankY += yMove;
			tankID = 3;
			break;

		}
		if(this.dir != Direction.STOP) {
			this.pdDir = this.dir;
		}
	}	

	/**
	 * �Ƿ�Խ��
	 */
	public boolean isOverWindow(int TankX,int TankY){
		int game_W = GameDto.panelGame_W;
		int game_H = GameDto.panelGame_H;
		if(this.boss){
			return TankX<0||TankX>game_W-BOSS_W||TankY<0||TankY>game_H-BOSS_H; 
		}
		else{
			return TankX<0||TankX>game_W-TANK_W||TankY<0||TankY>game_H-TANK_H;
		}
		
	}
	
	/**
	 * �ڲ���  ����������Ϸ��Ҫ����
	 *
	 */
	private class paintMain{
		
		/**
		 * ����̹��
		 */
		public void drawTank(Graphics g){
			this.drawWalls(g);
			//���̹���Ѿ����ݻ���ô�Ͳ�����̹��
			if(isTankDestroy()){
				return;
			}
			else{
			//���û�б��ݻ���ô�ͻ���̹�˺�Ѫ��
			g.drawImage(Img.TANK[tankKind][tankID],tankX,tankY,null);
			this.drawExp(g);
			//̹���ƶ�  ������������ΪҪ�ƶ�Ҫ��ͣˢ��
			move();
			//���ײǽ�˻�ײ������̹��  �Ͳ������ƶ�
			if(hitWalls()||hitTanks()||hitLandMines()){
				stay();
			}
			}
		}
		
		/**
		 * ����Ѫ��
		 */
		public void drawExp(Graphics g){
			if(dto.isCloseExp()){
				return ;
			}
			//Ѫ�۵�X����
			int rect_x = 0;
			//Ѫ�۵�Y����
			int rect_y = 0;
			//Ѫ�۵Ŀ��
			int rect_W = 0;
			//Ѫ�۵ĸ߶�
			int rect_H = 0;
			//Ѫ�ۿ�ܵ�x����
			int rectframe_x = 0;
			//Ѫ�ۿ�ܵ�y����
			int rectframe_y = 0;
			//Ѫ�ۿ�ܵĳ���
			int rectframe_W = 0;
			//Ѫ�ۿ�ܵĸ߶�
			int rectframe_H = 0;
			if(isBoss()){
				Img.rectframe = new ImageIcon("skin/exp/rectframe.png").getImage();
				Img.rect = new ImageIcon("skin/exp/rect.png").getImage();
				rect_x = tankX;
				rect_y = tankY - 50;
				rect_W = 185;
				rect_H = 7;
				rectframe_x = rect_x - 70;
				rectframe_y = rect_y - 20;
				rectframe_W = 290;
				rectframe_H = 60;
			}
			if(!isBoss()){
				Img.rectframe = new ImageIcon("skin/tank/rectframe.png").getImage();
				Img.rect = new ImageIcon("skin/tank/rect.png").getImage();
				rect_x = tankX;
				rect_y = tankY - 20;
				rect_W = 74;
				rect_H = 6;
				rectframe_x = rect_x-25;
				rectframe_y = rect_y-10;
				rectframe_W = 110;
				rectframe_H = 35;		
			}
			//����̹��Ѫ��ռ�ı���
			double percent =exp/100 ;
			//����Ѫ�ۿ��
			g.drawImage(Img.rectframe,rectframe_x, rectframe_y,rectframe_W,rectframe_H,null);
			//����Ѫ����������Ѫ��
			g.drawImage(Img.rect,rect_x,rect_y,rect_x+(int)(rect_W*percent),rect_y+rect_H,0,0,rect_W,rect_H,null);	
		}
		
		/**
		 * �����ڵ�
		 */
		public void drawBullet(Graphics g){
			for(int i = 0 ;i<dto.getBullet().size();i++){
				//�ڵ��򵽻��������Ϻ�Ĵ���
				dto.getBullet().get(i).hitTanks(dto.getTanks());
				//�ڵ������̹�����Ϻ�Ĵ���
				dto.getBullet().get(i).hitTank(thistank);
				//�ڵ���ǽ���ϵĴ���
				dto.getBullet().get(i).hitWalls(dto.getWalls());
				//�����ڵ�
				dto.getBullet().get(i).drawBullet(g);
			}
		}
		
		/**
		 * ���Ƶ���
		 */
		public void drawLandMine(Graphics g){
			for(int i = 0 ;i<dto.getLandmines().size();i++){
				dto.getLandmines().get(i).drawLandMine(g);
			}
		}
		
		/**
		 * ���ƻ�����̹��
		 */
		public void drawTanks(Graphics g){
			//��������˱�����
			if(dto.getTanks().size() == 0){
				//����
				dto.setLevel(dto.getLevel()+1);
				//dto.setStart(false);
				//ˢ�µ�ͼ
				dto.getMap().removeMap();
				dto.setMap(new Map(dto));
				dto.getMap().creatMap();
				
				//ˢ�µ�ͼ��ͬʱ  ����ҵ�̹�˻ص���ԭ��
				tankX = 600;
				tankY = 600;
				
				//����򵽵��Ĺأ�Boss��
				if(dto.getLevel() == 4){
					//ɾ���ĸ�С��
					for(int i = 0;i<dto.getTanks().size();i++){
						dto.getTanks().get(i).setTankDestroy(true);
					}
					//���tank Boss
					dto.getTanks().add(new Tank(dto,false,true,500,660-180,Tank.Direction.U));
				}
				//�����û�򵽵��Ĺ�
				if(dto.getLevel() != 4){
					//����ĸ�С��
				for(int i = 0 ;i<4;i++){
					dto.getTanks().add(new Tank(dto,false,false,500+i*60,0,Tank.Direction.D));
				}
				}
				
			}
			for(int i = 0 ;i<dto.getTanks().size();i++){
				dto.getTanks().get(i).paintMian.drawTank(g);
			}
		}
		
		/**
		 * ��������ǽ��
		 */
		public void drawWalls(Graphics g){
			for(int i = 0;i<dto.getWalls().size();i++){
				dto.getWalls().get(i).drawWall(g);
			}
		}
		
		/**
		 * ���Ʊ�ը
		 */
		public void drawBoom(Graphics g){
			if(!dto.isStartGame()){
				return ;
			}
			dto.getBoom().drawBoom(g);
		}
	}
	
	/**
	 * ���ô�paint���� ��ˢ����̹���йصĶ��ͼƬ���ڵ� ��ը�ȣ�
	 */
	public void paint(Graphics g){	
		//�������̹��
		paintMian.drawTank(g);
		//���ƻ�����
		paintMian.drawTanks(g);
		//�����ڵ�
		paintMian.drawBullet(g);
		//���Ƶ���
		paintMian.drawLandMine(g);
		//���Ʊ�ը
		paintMian.drawBoom(g);
		//������Ϣ
		g.drawString("̹��������"+this.dto.getTanks().size(),0,40);
	}
}
