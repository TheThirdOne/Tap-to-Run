package com.benjaminlanders.taptorun;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.benjaminlanders.taptorun.controller.Controller;
import com.benjaminlanders.taptorun.model.World;
import com.benjaminlanders.taptorun.renderer.GameRenderer;
import com.benjaminlanders.taptorun.renderer.Renderer;

public class TapToRunMain implements ApplicationListener
{
	private SpriteBatch batch;
	private Texture texture;
	public static float h,w;
	private Renderer main;
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
		
		main = new GameRenderer(this, batch, world);
		
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
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		//batch.begin();
		//batch.draw(texture, 0, 0, w, h);
		//batch.end();
		main.render(Gdx.graphics.getDeltaTime());
		
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
