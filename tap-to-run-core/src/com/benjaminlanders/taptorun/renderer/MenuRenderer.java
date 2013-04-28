package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;
import com.benjaminlanders.taptorun.helper.SoundManager;

public class MenuRenderer extends Renderer
{
	SpriteBatch batch;
	public MenuRenderer(TapToRunMain ref, SpriteBatch batch)
	{
		super(ref);
		this.batch = batch;
	}

	@Override
	public void render(float delta) 
	{
		batch.begin();
		batch.draw(Assets.getImage(Assets.menu), 0, 0, TapToRunMain.w, TapToRunMain.h);
		drawTitle();
		drawOptions();
		checkInput();
		batch.end();
	}
	public void checkInput()
	{
		if(Gdx.input.justTouched())
		{
			if(Gdx.input.getX() < TapToRunMain.w/2 + Assets.font.getBounds("Play Game").width/2 &&
			   Gdx.input.getX() > TapToRunMain.w/2 - Assets.font.getBounds("Play Game").width/2 &&
			   TapToRunMain.h-Gdx.input.getY() < TapToRunMain.h/2 &&
			   TapToRunMain.h-Gdx.input.getY() > TapToRunMain.h/2 - Assets.font.getBounds("Play Game").height)
			{
				reference.setState(TapToRunMain.MAIN);
				SoundManager.playSelect();
			}
			if(Gdx.input.getX() < TapToRunMain.w/2 + Assets.font.getBounds("Highscore").width/2 &&
				Gdx.input.getX() > TapToRunMain.w/2 - Assets.font.getBounds("Highscore").width/2 &&
				TapToRunMain.h-Gdx.input.getY() < TapToRunMain.h/2 - 2 * Assets.font.getBounds("Play Game").height &&
				TapToRunMain.h-Gdx.input.getY() > TapToRunMain.h/2 - Assets.font.getBounds("HighScore").height- 2 * Assets.font.getBounds("Play Game").height )
			{
				reference.setState(TapToRunMain.SCORE);
				SoundManager.playSelect();
			}
		}
	}

	public void drawOptions()
	{
		Assets.font.setScale(TapToRunMain.w/480,TapToRunMain.h/360);
		Assets.font.draw(batch,"Play Game", TapToRunMain.w/2 - Assets.font.getBounds("Play Game").width/2  , TapToRunMain.h/2);
		Assets.font.draw(batch,"Highscore", TapToRunMain.w/2 - Assets.font.getBounds("Highscore").width/2  , TapToRunMain.h/2- Assets.font.getBounds("Play Game").height*2);

	}
	public void drawTitle()
	{
		Assets.font.setColor(Color.BLACK);
		Assets.font.setScale(TapToRunMain.w/240,TapToRunMain.h/180);
		Assets.font.draw(batch,"Tap to Run", TapToRunMain.w/2 - Assets.font.getBounds("Tap to Run").width/2  , TapToRunMain.h-5);
	}


}
