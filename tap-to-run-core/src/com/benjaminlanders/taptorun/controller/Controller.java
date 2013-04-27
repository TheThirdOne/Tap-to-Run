package com.benjaminlanders.taptorun.controller;

import com.badlogic.gdx.Gdx;
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
		if(world.player.y <= 0)
		{
			world.player.y = 0;
			world.player.vY = 0;
			if(Gdx.input.justTouched())
			{
				world.player.vY = .1f;
			}
		}else
		{
			world.player.vY-=.02f;
		}
		world.player.y += world.player.vY;
		
	}
}
