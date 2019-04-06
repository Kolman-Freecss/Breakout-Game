package com.ragnarok.model;

import com.badlogic.gdx.math.Rectangle;

public class Tile
{
	private Rectangle geometricForm;
	
	public Tile() {}

	public Tile(int x, int y, int width, int height)
	{
		this.geometricForm = new Rectangle(x, y, width, height);
	}

	public Rectangle getGeometricForm()
	{
		return geometricForm;
	}

	public void setGeometricForm(Rectangle geometricForm)
	{
		this.geometricForm = geometricForm;
	}
	
}
