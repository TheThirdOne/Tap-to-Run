package com.benjaminlanders.taptorun.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class HighScroreKeeper 
{
	public static void writeScoreToFile(int points)
	{
		String[] scores = readScoresFromFile();
		int temp = scores.length;
		for(int i = 0; i < scores.length;i++)
		{
			if(points > Integer.parseInt(scores[i]))
			{
				temp = i;
				break;
			}
		}
		if(temp == scores.length)
			return;
		String out = "";
		for(int i = 0; i < temp;i++)
		{
			out += scores[i] + ",";
		}
		out+=points+",";
		for(int i = temp;i<scores.length-1;i++)
		{
			out+=scores[i]+",";
		}
		out.substring(0, out.length()-2);
		//Gdx.files.external("save/scores.txt").writeString(out, false);
		Gdx.app.getPreferences("Tap-to-Run").putString("scores",out);
	}
	public static String[] readScoresFromFile()
	{
		String temp = Gdx.app.getPreferences("Tap-to-Run").getString("scores");//Gdx.files.external("save/scores.txt").readString();
		return temp.split(",");
	}
	public static void createFile()
	{
		Gdx.app.getPreferences("Tap-to-Run").putString("scores","5,4,3,2,1");
	}

}
