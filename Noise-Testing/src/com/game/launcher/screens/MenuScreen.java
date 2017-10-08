package com.game.launcher.screens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//import com.noise.OpenSimplexNoise;

public class MenuScreen extends Screen{
	
	private ScreenManager screenManager;
	private int columns = 0, rows = 0, scale=10;
	private int[] grid; private double[] noiseGrid;
//	private OpenSimplexNoise noise = new OpenSimplexNoise();
	
	private File file;
	private FileReader fileReader;
	private BufferedReader bufferedReader;
	
	public void create(ScreenManager screenManager) {
		this.screenManager = screenManager;
		columns = screenManager.game().getWidth() / scale;
		rows = screenManager.game().getHeight() / scale;
		grid = new int[columns];
		noiseGrid = new double[columns];
		
		for(int i=0; i < columns; i++){
			grid[i] = i*scale;
		}
	
		try {
			file = new File("F:/User/Documents/GitHub/Emerald_Wing-Production/Project/wav testing/src/res/output.txt");
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private int len = 0, multiply = 450;
	
	public void update() {
		if(len > 1){
			String line;
			
			try {
				for(int i=0; i < columns; i++){
					line = bufferedReader.readLine();
					
					noiseGrid[i] = ((Double.parseDouble(line)*multiply)+(screenManager.game().getHeight()/2));
					
//					System.out.println("Index: "+i+" string: "+noiseGrid[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			len=0;
		}
		len++;
	}
	
	public void draw(Graphics2D g) {
		Color greyish = new Color(25,25,25);
		g.setColor(greyish);
		g.fillRect(0, 0, screenManager.game().getWidth(), screenManager.game().getHeight());	// Sets background
		g.setColor(Color.darkGray);
		g.setStroke(new BasicStroke(0.1f));
		//g.translate(0, screenManager.game().getHeight()/2);
		//g.rotate(Math.PI/4, screenManager.game().getWidth() / 2, screenManager.game().getHeight() / 2);
		
		for(int j=0; j < rows; j++){
			for(int i=0; i < columns; i++){
				g.drawRect(i*scale, j*scale, scale, scale);
				//g.drawLine(i*scale, j*scale, j*scale, i*scale);
			}
		}
		
		g.setColor(Color.white);
		g.setStroke(new BasicStroke(1f));
		
		for(int i=0; i < columns-1; i++){
			g.drawLine(i*scale, (int)noiseGrid[i], (i*scale)+scale, (int)noiseGrid[i+1]);
		}
		
	}
}