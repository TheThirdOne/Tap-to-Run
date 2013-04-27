package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;

public class GameRenderer extends Renderer
{
	private SpriteBatch batch;

	protected GameRenderer(TapToRunMain ref, SpriteBatch batch) 
	{
		super(ref);
		this.batch = batch;
	}

	@Override
	public void render() 
	{
		
	}

}
