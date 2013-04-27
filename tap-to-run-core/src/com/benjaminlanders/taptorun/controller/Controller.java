package com.benjaminlanders.taptorun.controller;

import java.util.List;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.benjaminlanders.taptorun.helper.SoundManager;
import com.benjaminlanders.taptorun.model.Box;
import com.benjaminlanders.taptorun.model.World;

public class Controller
{
	World world;
	boolean mouseReleased, mouseDown;
	public Controller(World world)
	{
		this.world = world;
	}
	public void update(float delta)
	{
		if(world.player.alive)
		{
			mouseReleased = mouseDown && !Gdx.input.isTouched();
			mouseDown = Gdx.input.isTouched();
			updateBlocks(delta);
			playerCollision(delta);
			world.player.y += world.player.vY;
			world.score += delta*5;
			if(world.player.y + world.player.h/2 < 0)
			{
				world.player.alive = false;
			}
		}else
		{
			updateBlocks(delta/10);
		}
		
	}
	private void updateBlocks(float delta)
	{
		for(Box box: world.boxes)
		{
			if(box.x + box.w < 0)
			{
				box.w = (float) Math.random()/3+.33f;
				box.x = 2.7f-box.w;
			}else
			{
				box.x -= delta*.5f;
			}
			
		}
	}
	private void playerCollision(float delta)
	{
		List<Box> collided = new ArrayList<Box>();
		for(Box block: world.boxes)
		{
			if(block.collides(world.player.x, world.player.y - world.player.h/2))
				collided.add(block);
		}
		if(!collided.isEmpty())
		{
			if(mouseDown)
			{
				world.player.x += .005f;
			}else
			{
				world.player.x -= .0001f;
			}
			for(Box collides: collided)
			{
				if(world.player.y - world.player.h/2 <= collides.y+collides.h)
				{
					world.player.y = collides.y+collides.h+world.player.h/2-.01f;
					world.player.vY = 0;
					if(mouseReleased)
					{
						world.player.vY = .02f;
						SoundManager.playJump();
					}
				}
			}
		}else
		{
			world.player.vY-=.04f*delta;
		}
		collided.clear();
		for(Box block: world.boxes)
		{
			if(block.collides(world.player.x+world.player.w/2, world.player.y))
				collided.add(block);
		}
		if(!collided.isEmpty())
		{
			for(Box collides: collided)
			{
				if(world.player.x + world.player.w/2 > collides.x)
				{
					world.player.x = collides.x - world.player.w/2;
				}
			}
		}
		collided.clear();
	}
}
