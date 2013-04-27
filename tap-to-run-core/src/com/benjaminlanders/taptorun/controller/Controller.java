package com.benjaminlanders.taptorun.controller;

import java.util.List;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.benjaminlanders.taptorun.model.Box;
import com.benjaminlanders.taptorun.model.Player;
import com.benjaminlanders.taptorun.model.World;

public class Controller
{
	World world;
	public Controller(World world)
	{
		this.world = world;
	}
	public void update(float delta)
	{
		List<Box> collided = new ArrayList<Box>();
		for(Box block: world.boxes)
		{
			if(block.collides(world.player.x, world.player.y - world.player.h/2))
				collided.add(block);
		}
		if(!collided.isEmpty())
		{
			for(Box collides: collided)
			{
				if(world.player.y - world.player.h/2 <= collides.y+collides.h)
				{
					world.player.y = collides.y+collides.h+world.player.h/2-.01f;
					world.player.vY = 0;
					if(Gdx.input.justTouched())
					{
						world.player.vY = .1f;
					}
				}
			}
		}else
		{
			world.player.vY-=.02f;
		}
		collided.clear();
		/*if(world.player.y - world.player.h/2 <= .2f)
		{
			world.player.y = .19f+world.player.h/2;
			world.player.vY = 0;
			if(Gdx.input.justTouched())
			{
				world.player.vY = .1f;
			}
		}else
		{
			world.player.vY-=.02f;
		}*/
		world.player.y += world.player.vY;
		
	}
}
