package com.aslitech.islander;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.aslitech.islander.constants.GameConstants;

public class Camera implements GameConstants{
	private int x;
	private int y;
	private int width;
	private int height;
	private int xSpeed;
	private int ySpeed;
	private BufferedImage image;
	
	public Camera() {
		x=240;
		y=240;
		width=360;
		height=240;
		try {
			image=ImageIO.read(Camera.class.getResource("map.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void move() {
		x+=xSpeed;
		y+=ySpeed;
	}
	public Image getSubImage() {
		return image.getSubimage(x, y, width, height);
	}
	public void drawBackground(Graphics g) {
		g.drawImage(getSubImage(), 0, 0,GAME_WIDTH,GAME_HEIGHT, null );
		
	}

}
