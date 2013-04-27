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
		boxes.add(new Box(Box.BLOCK,.1f,.2f,.7f,.2f));
		boxes.add(new Box(Box.BLOCK,.7f,.3f,.7f,.2f));
		boxes.add(new Box(Box.BLOCK,1.3f,.4f,.7f,.2f));
		boxes.add(new Box(Box.BLOCK,2.4f,.2f,.7f,.2f));
		boxes.add(new Box(Box.BLOCK,3f,.1f,5f,.2f));
		player = new Player(.3f,.6f, .20f,.2f);
	}
}
