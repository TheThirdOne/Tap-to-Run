package com.benjaminlanders.taptorun.renderer;

import com.benjaminlanders.taptorun.TapToRunMain;

public abstract class Renderer 
{
	protected TapToRunMain reference;
	protected Renderer(TapToRunMain ref)
	{
		reference = ref;
	}
	public abstract void render(float delta);
}
