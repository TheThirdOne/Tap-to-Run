package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;

public class GameRenderer extends Renderer
{
	private SpriteBatch batch;
	float stateTime;
	private Cloud[] clouds;
	public static final int NUMBER_OF_CLOUDS = 4;

	public GameRenderer(TapToRunMain ref, SpriteBatch batch) 
	{
		super(ref);
		this.batch = batch;
		clouds = new Cloud[NUMBER_OF_CLOUDS];
		for(int i = 0; i < NUMBER_OF_CLOUDS; i++ )
		{
			clouds[i] = new Cloud();
		}
	}

	public void render(float delta)
	{
		stateTime += delta;
		batch.begin();
		drawBackground(stateTime);
		drawCharacter();
		drawClouds(delta);
		batch.end();
	}
	public void drawClouds(float delta)
	{
		for(int i = 0; i < NUMBER_OF_CLOUDS; i++ )
		{
			batch.draw(Assets.getImage(Assets.cloud),clouds[i].getX()*TapToRunMain.w,clouds[i].getY()*TapToRunMain.h,64,32);
			clouds[i].update(delta);
		}
	}
	public void drawBackground(float stateTime)
	{
		batch.draw(Assets.getImage(Assets.background), -((stateTime*50)%TapToRunMain.w), 0, TapToRunMain.w, TapToRunMain.h);
		batch.draw(Assets.getImage(Assets.background), -((stateTime*50)%TapToRunMain.w)+TapToRunMain.w, 0, TapToRunMain.w, TapToRunMain.h);
	}
	public void drawCharacter()
	{
		batch.draw(Assets.getImage(Assets.character),0,0,50,50);
	}

}
