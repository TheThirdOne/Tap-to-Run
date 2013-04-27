package com.benjaminlanders.taptorun.helper;

import com.badlogic.gdx.Gdx;

public class HighScroreKeeper 
{
	public static void writeScoreToFile()
	{
		
	}
	public static String[] readScoresFromFile()
	{
		String temp = Gdx.files.internal("saves/scores.txt").readString();
		return temp.split(",");
	}

}
