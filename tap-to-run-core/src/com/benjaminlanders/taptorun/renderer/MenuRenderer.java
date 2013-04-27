package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;

public class MenuRenderer extends Renderer
{
	SpriteBatch batch;
	int w,h,h2,w2;
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
		batch.end();
	}
	public void drawOptions()
	{
		Assets.font.setScale(1f);
		Assets.font.draw(batch,"Play Game", TapToRunMain.w/2 - Assets.font.getBounds("Play Game").width/2  , TapToRunMain.h/2);
		Assets.font.draw(batch,"Highscore", TapToRunMain.w/2 - Assets.font.getBounds("Highscore").width/2  , TapToRunMain.h/2- Assets.font.getBounds("Play Game").height*2);

	}
	public void drawTitle()
	{
		Assets.font.setColor(Color.BLACK);
		Assets.font.setScale(2f);
		Assets.font.draw(batch,"Tap to Run", TapToRunMain.w/2 - Assets.font.getBounds("Tap to Run").width/2  , TapToRunMain.h);
	}


}
