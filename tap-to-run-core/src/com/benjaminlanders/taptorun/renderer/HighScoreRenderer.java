package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;
import com.benjaminlanders.taptorun.helper.HighScroreKeeper;

public class HighScoreRenderer extends Renderer 
{
	SpriteBatch batch;
	String[] scores;
	String[] ranking = {"First","Second","Third","Fourth","Fifth"};
	
 	public HighScoreRenderer(TapToRunMain ref, SpriteBatch batch) 
	{
		super(ref);
		this.batch = batch;
	}

	@Override
	public void render(float delta) 
	{
		batch.begin();
		drawBackground();
		drawTitle();
		drawScores();
		checkToReturn();
		batch.end();
	}
	
	public void drawTitle()
	{
		Assets.font.setScale(TapToRunMain.w/240,TapToRunMain.h/180);
		Assets.font.draw(batch, "High Scores", TapToRunMain.w/2-Assets.font.getBounds("High Scores").width/2, 70*TapToRunMain.h/71);
	}
	
	public void drawScores()
	{
		Assets.font.setScale(TapToRunMain.w/480,TapToRunMain.h/360);
		String[] scores = HighScroreKeeper.readScoresFromFile();
		for(int i = 0; i < scores.length;i++)
		{
			Assets.font.draw(batch,ranking[i]+ ": " + scores[i], TapToRunMain.w/96, TapToRunMain.h/6*(5-i));
		}
	}
	
	public void checkToReturn()
	{
		if(Gdx.input.justTouched())
		{
			reference.setState(TapToRunMain.MENU);
		}
	}
	
	public void drawBackground()
	{
		batch.draw(Assets.getImage(Assets.menu), 0, 0, TapToRunMain.w, TapToRunMain.h);
	}

}
