package com.benjaminlanders.taptorun.model;

public class Player
{
	public float x,y, vY,h,w;
	public boolean alive;
	
	public Player(float x, float y,float h,float w)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		alive = true;
	}
}
