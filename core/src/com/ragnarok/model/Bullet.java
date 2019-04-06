package com.ragnarok.model;

import com.badlogic.gdx.math.Rectangle;

public class Bullet
{

	private Rectangle geometricForm;
	private int speed;

	public Bullet(float x, float y)
	{
		this.geometricForm = new Rectangle(x, y, 8, 20);
		this.speed = 100;
	}

	public boolean isCollide(Rectangle rect)
	{
		return this.getX() + this.getWidth() > rect.x
				&& this.getY() + getHeigth() > rect.y
				&& this.getX() < rect.x + rect.width;
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
