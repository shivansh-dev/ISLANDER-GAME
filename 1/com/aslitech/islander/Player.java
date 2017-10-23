package com.aslitech.islander;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Sprite implements PlayerState{
	
	BufferedImage spriteSheet;
	int State;
	//int walkIndex;
	//int standIndex;
	int gravity;
	int force;
	//int standDelayer = 0;
	private final int FLOOR=GAME_HEIGHT-180;
	BufferedImage standImageArray[];
	
	public Player() {
		loadSpriteSheet();
		standImageArray=defaultImage();
		x=100;
		y=408;
		width=60;
		height=90;
		State = STAND;
		//standIndex=walkIndex=0;
		//standImageArray=defaultImage();
	}
	
	public void loadSpriteSheet() {
		try {
			spriteSheet=ImageIO.read(Player.class.getResource("sprite sheet player.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage[] defaultImage() {
		BufferedImage array[]=new BufferedImage[7];
		array[0]=spriteSheet.getSubimage(108, 19,24,45);
		array[1]=spriteSheet.getSubimage(145, 20,27,46);
		array[2]=spriteSheet.getSubimage(185, 19, 27, 47);
		array[3]=spriteSheet.getSubimage(221,19, 31, 47);
		array[4]=spriteSheet.getSubimage(266,19, 26, 47);
		array[5]=spriteSheet.getSubimage(302, 19,42, 47);
		array[6]=spriteSheet.getSubimage(351, 19, 29,47);
		return array;		
	}
	public BufferedImage[] walkImage() {
		BufferedImage array[]=new BufferedImage[4];
		array[0]=spriteSheet.getSubimage(185, 75,19,48);
		array[2]=spriteSheet.getSubimage(223, 75,19,48);
		array[1]=spriteSheet.getSubimage(260, 75, 30, 48);
		array[3]=spriteSheet.getSubimage(302,75, 24, 45);
		return  array;
	}
	
	
	
	
	public void drawPlayer(Graphics g) {
		
		if(State==STAND) {
			standEffect(g);
		}
		else if(State==WALK) {
			walkEffect(g);
		}
	}
	
	
	
	

	public void walkEffect(Graphics g) {
		// TODO Auto-generated method stub
		BufferedImage array[]=walkImage();
		if(walkIndex==array.length-1) {
			g.drawImage(array[array.length-1], x, y-height	,width,height, null);
		}
		else {
			g.drawImage(array[standIndex], x, y-height	,width,height, null);
			//int walkDelayer = 0;
			//walkDelayer++;
			//if(walkDelayer==4) {
				standIndex++;
				//walkDelayer=0;
			//}
			
		}
		
	}
	int standDelayer=0;
	int standIndex=0;
	public void standEffect(Graphics g) {
		// TODO Auto-generated method stub
		
		if(standIndex>=standImageArray.length-1) {
			g.drawImage(standImageArray[standImageArray.length-1], x, FLOOR-height	,width,height, null);
		}
		else {
			g.drawImage(standImageArray[standIndex], x, FLOOR-height,width,height, null);

			//standDelayer++;
			//if(standDelayer==4) {
				standIndex++;
			//	standDelayer=0;
			//}
			
		//for(int s)
		
		
		}

	}

	
/*	public void standEffect(Graphics g) {
		if(standIndex>=standImageArray.length-1){
		walkIndex = 0;
	}
	else
	{
		g.drawImage(standImageArray[walkIndex], x, y, w, h, null);
		walkPass++;
		if(walkPass==4){
		
		walkIndex++;
		walkPass=0;
		}
			
		}

	}
	
	*/
	
	
	
}
