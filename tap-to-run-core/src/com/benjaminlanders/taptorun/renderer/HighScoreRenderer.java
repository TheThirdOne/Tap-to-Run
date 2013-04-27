package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;

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
		
		
		batch.end();
	}

}
