package com.aslitech.islander;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.aslitech.islander.constants.GameConstants;

public class Board extends JPanel implements GameConstants,PlayerState{
	
	
	Image backgroundImage;
	Camera camera=new Camera();
	Player player;	
	Timer timer;
	
	
	public Board() {
		setSize(GAME_WIDTH,GAME_HEIGHT);
		player=new Player();
		gameLoop();
		setFocusable(true);
		bindEvents();
		
			
	}
	
	public void drawBackground(Graphics g) {
		camera.drawBackground(g);
		
		
	}
	
	
	private void bindEvents(){
		this.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e){
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				System.out.println("here");
				camera.moveForward();
				player.State=WALK;
			}
			
			else if(e.getKeyCode()==KeyEvent.VK_LEFT){
				camera.moveBackward();
			}
			/*if(e.getKeyCode()==KeyEvent.VK_K){
				player.setState(Player.KICK);
			}*/
		}
		@Override
		public void keyReleased(KeyEvent e){
			
		}
		});
	}
	
	
	public void gameLoop() {
		timer=new Timer(GAME_SPEED	, (e)->{
			repaint();
			
		});
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawBackground(g);
		player.drawPlayer(g);
		
		
	}
}
