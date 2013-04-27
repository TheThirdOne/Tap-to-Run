package com.benjaminlanders.taptorun.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.benjaminlanders.taptorun.TapToRunMain;

public class Assets 
{
	public static TapToRunMain application;
	
	private static final String[] imageAddress = {"nullimage","background","character","cloud"};
	public static TextureRegion[] images = new TextureRegion[4];
	public static final int nullimage = 0;
	public static final int background = 1;
	public static final int character = 2;
	public static final int cloud = 3;
	
	private static final String[] stringAddress = {"test"};
	public static String[] strings = new String[1];
	public static final int test = 0;
	public static String getString(int reference)
	{
		if(strings.length <= reference)
			return null;
		if(strings[reference]==null)
		{
			
			strings[reference] = Gdx.files.internal("strings/"+stringAddress[reference]+".txt").readString();
			
		}
		return strings[reference];
	}
		
	/**
	 * gets the image if its loaded, if not it loads and then gives it
	 * @param reference the value in the array for the correct image. use the constants
	 * @return the image
	 */
	public static TextureRegion getImage(int reference)
	{
		if(images.length < reference)
			return null;
		if(images[reference]==null)
		{
			images[reference] = new TextureRegion(new Texture(Gdx.files.internal("images/"+imageAddress[reference]+".png")));
		}
		return images[reference];
	}
}
