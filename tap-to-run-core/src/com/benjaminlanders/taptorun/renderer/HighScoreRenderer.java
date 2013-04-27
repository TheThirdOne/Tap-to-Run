package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;

public class HighScoreRenderer extends Renderer 
{
	SpriteBatch batch;
	String[] scores;
 	public HighScoreRenderer(TapToRunMain ref, SpriteBatch batch) 
	{
		super(ref);
		this.batch = batch;
	}

	@Override
	public void render(float delta) 
	{
		batch.begin();
		drawTitle();
		drawScores();
		checkToReturn();
		batch.end();
	}
	public void drawTitle()
	{
		Assets.font.setScale(2f);
		Assets.font.draw(batch, "High Scores", TapToRunMain.w/2-Assets.font.getBounds("High Scores").width/2, TapToRunMain.h);
	}
	public void drawScores()
	{
		Assets.font.setScale(1);
		Assets.font.draw(batch, "High Scores", TapToRunMain.w/2-Assets.font.getBounds("High Scores").width/2, TapToRunMain.h-50);
	}
	public void checkToReturn()
	{
		if(Gdx.input.justTouched())
		{
			reference.setState(TapToRunMain.MENU);
		}
	}

}
