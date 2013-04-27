package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;
import com.benjaminlanders.taptorun.model.Box;
import com.benjaminlanders.taptorun.model.World;

public class GameRenderer extends Renderer
{
	private SpriteBatch batch;
	float stateTime;
	World world;
	private Cloud[] clouds;
	public static final int NUMBER_OF_CLOUDS = 4;

	public GameRenderer(TapToRunMain ref, SpriteBatch batch, World world) 
	{
		super(ref);
		this.batch = batch;
		this.world = world;
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
		drawBlocks();
		drawCharacter();
		drawClouds(delta);
		batch.end();
	}
	public void drawClouds(float delta)
	{
		for(int i = 0; i < NUMBER_OF_CLOUDS; i++ )
		{
			batch.draw(Assets.getImage(Assets.cloud),clouds[i].getX()*TapToRunMain.w,clouds[i].getY()*TapToRunMain.h,.1f*TapToRunMain.w,.05f*TapToRunMain.h);
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
	public void drawBlocks()
	{
		for(Box box: world.boxes)
		{
			batch.draw(Assets.getImage(Assets.block), box.x*TapToRunMain.w, box.y*TapToRunMain.h, box.w*TapToRunMain.w, box.h*TapToRunMain.h);
		}
	}

}
