package com.benjaminlanders.taptorun.model;

public class Box
{
	public static final int BLOCK = 0;
	public static final int SPIKE = 1;
	public float x,y,w,h;
	public int type;
	public Box(int type, float x, float y, float w, float h)
	{
		this.type = type;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	public boolean collides(float x,float y)
	{
		return (this.x < x && this.y < y) && (this.x + this.w > x && this.y + this.h > y);	
	}
}
