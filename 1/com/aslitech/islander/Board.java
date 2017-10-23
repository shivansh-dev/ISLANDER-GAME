package com.aslitech.islander;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.aslitech.islander.constants.GameConstants;

public class Board extends JPanel implements GameConstants{
	
	
	Image backgroundImage;
	Camera camera=new Camera();
	Player player;	
	Timer timer;
	
	
	public Board() {
		gameLoop();
		player=new Player();
			
	}
	
	public void drawBackground(Graphics g) {
		camera.drawBackground(g);
		
	}
	
	
	public void gameLoop() {
		timer=new Timer(GAME_SPEED	, (e)->{
			repaint();
			
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		player.drawPlayer(g);
		
		
	}
}
