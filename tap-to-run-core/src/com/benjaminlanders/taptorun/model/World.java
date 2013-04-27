package com.benjaminlanders.taptorun.model;

import java.util.ArrayList;
import java.util.List;

public class World 
{
	public List<Box> boxes;
	public World()
	{
		boxes = new ArrayList<Box>();
		boxes.add(new Box(Box.BLOCK,.1f,.1f,.2f,.05f));
	}
}
