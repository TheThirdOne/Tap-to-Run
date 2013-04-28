package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.Gdx;
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
		drawClouds(delta);
		drawBlocks();
		drawCharacter();
		drawScore();
		drawGameOver();
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
		batch.draw(Assets.getImage(Assets.character),(world.player.x-world.player.w/2)*TapToRunMain.w,
				(world.player.y-world.player.h/2)*TapToRunMain.h,world.player.w*TapToRunMain.w,world.player.h*TapToRunMain.h);
	}
	public void drawBlocks()
	{
		for(Box box: world.boxes)
		{
			batch.draw(Assets.getImage(Assets.block), box.x*TapToRunMain.w, box.y*TapToRunMain.h, box.w*TapToRunMain.w, box.h*TapToRunMain.h);
		}
	}
	public void drawScore()
	{
		if(world.player.alive)
		{
		Assets.font.setScale(TapToRunMain.w/240, TapToRunMain.h/160);
		Assets.font.draw(batch, "" + ((int)world.score), 5, TapToRunMain.h-5);
		}
	}
	public void drawGameOver() 
	{
		if(!world.player.alive)
		{
		Assets.font.draw(batch, "Game over",(int) (TapToRunMain.w/2-Assets.font.getBounds("Game Over").width/2),
				TapToRunMain.h/2+Assets.font.getBounds("Game Over").height+5);
		Assets.font.draw(batch, "Points:" + ((int)world.score),
				(int) (TapToRunMain.w/2-Assets.font.getBounds("Points:" + ((int)world.score)).width/2), TapToRunMain.h/2);
		checkToReturn();
		}
	}
	public void checkToReturn()
	{
		if(Gdx.input.justTouched())
		{
			reference.setState(TapToRunMain.MENU);
		}
	}

}
