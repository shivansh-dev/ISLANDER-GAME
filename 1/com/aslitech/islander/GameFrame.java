package com.aslitech.islander;

import java.awt.Toolkit;

import javax.swing.JFrame;

import com.aslitech.islander.constants.GameConstants;

public class GameFrame  extends JFrame implements GameConstants {
	
	public GameFrame(){
		setSize(GAME_WIDTH,GAME_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Board board = new Board();
		add(board);
		setVisible(true);
		Toolkit.getDefaultToolkit().sync();
		setFocusable(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameFrame gameFrame = new GameFrame();
	}

}
