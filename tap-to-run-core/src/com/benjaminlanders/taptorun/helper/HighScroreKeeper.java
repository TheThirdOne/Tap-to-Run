package com.benjaminlanders.taptorun.helper;

import com.benjaminlanders.taptorun.TapToRunMain;

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
		TapToRunMain.prefs.putString("scores",out);
		TapToRunMain.prefs.flush();
	}
	
	public static String[] readScoresFromFile()
	{
		String temp = TapToRunMain.prefs.getString("scores");
		return temp.split(",");
	}
	
	public static void createFile()
	{
		if(TapToRunMain.prefs.getString("scores").equals(""));
		{
		TapToRunMain.prefs.putString("scores","5,4,3,2,1");
		TapToRunMain.prefs.flush();
		}
	}

}
