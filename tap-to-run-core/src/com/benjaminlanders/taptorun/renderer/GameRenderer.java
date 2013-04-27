package com.benjaminlanders.taptorun.renderer;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.taptorun.TapToRunMain;
import com.benjaminlanders.taptorun.helper.Assets;

public class GameRenderer extends Renderer
{
	private SpriteBatch batch;
	TextureRegion test;
	float stateTime;

	public GameRenderer(TapToRunMain ref, SpriteBatch batch) 
	{
		super(ref);
		this.batch = batch;
	}

	public void render(float delta)
	{
		stateTime += delta;
		batch.begin();
		batch.draw(Assets.getImage(Assets.background), -((stateTime*50)%TapToRunMain.w), 0, TapToRunMain.w, TapToRunMain.h);
		batch.draw(Assets.getImage(Assets.background), -((stateTime*50)%TapToRunMain.w)+TapToRunMain.w, 0, TapToRunMain.w, TapToRunMain.h);
		test = Assets.getImage(Assets.background);
		batch.draw(Assets.getImage(Assets.character),0,0,50,50);
		batch.end();
	}

}
