package com.benjaminlanders.taptorun.model;

import java.util.ArrayList;
import java.util.List;

public class World 
{
	public List<Box> boxes;
	public Player player;
	public World()
	{
		boxes = new ArrayList<Box>();
		boxes.add(new Box(Box.BLOCK,.1f,.2f,.5f,.2f));
		player = new Player(.3f,.6f, .2f,.2f);
	}
}
