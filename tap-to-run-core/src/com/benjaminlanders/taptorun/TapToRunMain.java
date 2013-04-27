package com.benjaminlanders.taptorun;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.controller.Controller;
import com.benjaminlanders.taptorun.helper.Assets;
import com.benjaminlanders.taptorun.model.World;
import com.benjaminlanders.taptorun.renderer.GameRenderer;
import com.benjaminlanders.taptorun.renderer.MenuRenderer;
import com.benjaminlanders.taptorun.renderer.Renderer;

public class TapToRunMain implements ApplicationListener
{
	private SpriteBatch batch;
	private Texture texture;
	public static float h,w;
	public static final int MAIN = 0;
	public static final int MENU = 1;
	public static final int SCORE = 2;
	public static int state= MENU;
	private Renderer main, menu;
	Controller controller;
	World world;
	@Override
	public void create()
	{		
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		world = new World();
		controller = new Controller(world);
		
		batch = new SpriteBatch();
		
		Assets.font = new BitmapFont(Gdx.files.internal("test.fnt"), false);
		
		main = new GameRenderer(this, batch, world);
		menu = new MenuRenderer(this, batch);
			
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	@Override
	public void dispose()
	{
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render()
	{		
		float delta = Gdx.graphics.getDeltaTime();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		switch(state)
		{
			case MAIN:
				controller.update(delta);
				main.render(delta);
				break;
			case MENU:
				menu.render(delta);
				break;
			case SCORE:
				
				break;
		}
		
		
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}
	@Override
	public void resume()
	{
	}
	public void setState(int state)
	{
		TapToRunMain.state = state;
		if(state == MAIN)
		{
			resetWorld();
		}
	}
	public void resetWorld()
	{
		
	}
	
}
