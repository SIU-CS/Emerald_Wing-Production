package com.engine;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.noise.OpenSimplexNoise;
import com.test.GridRendering;

public class GridThread extends Thread {
	
	private int gridMinZ = -25;
	private int gridMaxZ = -25;
	private int gridMinX = 25;
	private int gridMaxX = 25;
	
	private float scale = 1;	// These should have defaults in case something goes wrong
	
	private Color color;
	
	private GridRendering gridTest;
	
	public GridThread(int gridMinZ, int gridMaxZ, int gridMinX, int gridMaxX, float scale, GridRendering gridTest, Color color){
		this.gridMaxZ = gridMaxZ;
		this.gridMinZ = gridMinZ;
		this.gridMaxX = gridMaxX;
		this.gridMinX = gridMinX;
		
		this.scale = scale;
		this.gridTest = gridTest;
		this.color = color;
	}
	
	@Override
	public void run() {
		
	}
	
	public void render(MeshPartBuilder builder, OpenSimplexNoise noise, float offIncr, float size, float acceleration, int zS, int xS){

		builder.setColor(color);
		
		float zoff = acceleration;
		for(int z = gridMinZ; z < gridMaxZ; z += scale){
			float xoff = 0;
			for(int x = gridMinX; x < gridMaxX; x += scale){
				zS = z;
				xS = x;
				
				gridTest.buildRect(xS, zS, scale, xoff, zoff);
				
				xoff += offIncr;
			}
			zoff += offIncr;
		}
	}
}