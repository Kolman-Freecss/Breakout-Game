package com.ragnarok.model;

import com.badlogic.gdx.math.Rectangle;
import com.ragnarok.game.BaseGame;

public class Ship
{

	private Rectangle geometricForm;
	private int speed;
	
	/*
	 * Default constructor
	 * */
	public Ship()
	{
		this(BaseGame.GAME_WINDOW_WIDTH / 2, 20, 128, 128);
	}
	
	public Ship(int x, int y, int width, int height)
	{
		this.geometricForm = new Rectangle(x, y, width, height);
		this.speed = 280;
	}

	public Rectangle getGeometricForm()
	{
		return geometricForm;
	}

	public void setGeometricForm(Rectangle geometricForm)
	{
		this.geometricForm = geometricForm;
	}
	
	public float getX()
	{
		return this.geometricForm.getX();
	}
	
	public float getY()
	{
		return this.geometricForm.getY();
	}
	
	public float getWidth()
	{
		return this.geometricForm.getWidth();
	}
	
	public float getHeigth()
	{
		return this.geometricForm.getHeight();
	}

	public int getSpeed()
	{
		return speed;
	}

	public void setSpeed(int speed)
	{
		this.speed = speed;
	}
	
}
