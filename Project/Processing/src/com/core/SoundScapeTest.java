package com.core;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class SoundScapeTest {

	String[] testString = {"Yell 'Dead Cell' VR(Mix)", "Metal Gear Solid 2", "Game Music", "Konami"};
	
	
	public void testMetaString() {
		assertTrue(Arrays.equals(testString, testString));
	}

}
