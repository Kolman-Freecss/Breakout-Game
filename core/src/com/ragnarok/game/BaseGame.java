package com.ragnarok.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ragnarok.controller.MapController;
import com.ragnarok.model.Bullet;
import com.ragnarok.model.Ship;
import com.ragnarok.model.Tile;

public class BaseGame extends ApplicationAdapter
{
	public static final int GAME_WINDOW_WIDTH = 800;
	public static final int GAME_WINDOW_HEIGHT = 600;

	// Used to draw sprites
	private SpriteBatch batch;
	private Texture shipImg;
	private Texture tileImg;
	private Texture bulletImg;
	private Ship ship;
	private List<Tile> tileSheet;
	private List<Bullet> bulletList;
	

	private MapController mapController;

	// The place that we'll instantiate LibGDX objects, this is because LibGDX uses
	// a native library, which needs to be loaded into memory before we can start
	// working with it.
	@Override
	public void create()
	{
		batch = new SpriteBatch();
		// Load the images.
		shipImg = new Texture("ship.png");
		tileSheet = new ArrayList<Tile>();
		tileImg = new Texture("red_tile.png");

		bulletList = new ArrayList<Bullet>();
		bulletImg = new Texture("green_shot.png");

		// Call to default constructor.
		ship = new Ship();

		// Singleton
		mapController = MapController.getMapController();
		tileSheet = mapController.getParserMap().parseMap(1);

	}

	@Override
	public void render()
	{
		update();
		// Color background
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		draw();
	}

	/*
	 * Draw all the physics in canvas.
	 */
	public void draw()
	{
		batch.begin();
		for (Tile tile : tileSheet)
		{
			batch.draw(tileImg, tile.getGeometricForm().getX(), tile.getGeometricForm().getY());
		}
		for (Bullet bullet : bulletList)
		{
			batch.draw(bulletImg, bullet.getGeometricForm().getX(), bullet.getGeometricForm().getY());
		}

		batch.draw(shipImg, ship.getGeometricForm().getX(), ship.getGeometricForm().getY());
		batch.end();
	}

	/*
	 * Update the data of physics before draw it.
	 */
	public void update()
	{
		handlingKeyboard();
		shipOutScreen();
		collide();
	}

	/*
	 * One thing that isn't provided in this sample code (that really should be), is
	 * an additional method called dispose. LibGDX has its own way of cleaning up
	 * after itself. This is because when writing a game in Java, keeping tabs on
	 * when the garbage collector runs is very important. Letting the garbage
	 * collector decide when to clean things up in a game is a bad idea. It could
	 * cause lag and memory leaks that could severely impact the performance of your
	 * game.
	 */
	@Override
	public void dispose()
	{
		tileImg.dispose();
		batch.dispose();
		shipImg.dispose();
		bulletImg.dispose();
	}
	
	public void collide()
	{
		boolean collide = false;
		List<Tile> foundTile = new ArrayList<Tile>();
		for (Bullet bullet : bulletList)
		{
			collide = false;
			for(Tile tile : tileSheet) 
			{
				if(bullet.isCollide(tile.getGeometricForm()))
				{
					foundTile.add(tile);
					collide = true;
				}
			}
			if(collide) continue;
			bullet.getGeometricForm().y += bullet.getSpeed() * Gdx.graphics.getDeltaTime();
		}
		
		tileSheet.removeAll(foundTile);
	}

	public void handlingKeyboard()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			/*
			 * Delta time: the time span between the current frame and the last frame in
			 */
			ship.getGeometricForm().x -= ship.getSpeed() * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			ship.getGeometricForm().x += ship.getSpeed() * Gdx.graphics.getDeltaTime();
		} else if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
		{
			this.bulletList.add(new Bullet(ship.getX() - 4 + ship.getWidth() / 2, ship.getY() - 20 + ship.getHeigth()));
		}
	}

	public void shipOutScreen()
	{
		if (ship.getGeometricForm().x < 0)
			ship.getGeometricForm().x = 0;
		if (ship.getGeometricForm().x + ship.getGeometricForm().getWidth() > GAME_WINDOW_WIDTH)
			ship.getGeometricForm().x = GAME_WINDOW_WIDTH - ship.getGeometricForm().getWidth();
	}
}
