package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Map
{
	private ArrayList<Player> entities = new ArrayList<Player>();
	//TODO create a block list
	private Ground ground = new Ground();
	
	public void addEntity(Player entity)
	{
		entities.add(entity);
	}
	
	public ArrayList<Player> getEntities()
	{
		return this.entities;
	}

	public void draw(Graphics2D graphics2D, Rectangle focus)
	{
		ground.draw(graphics2D);
		drawEntities(graphics2D);
	}
	
	private void drawEntities(Graphics2D graphics2D)
	{
		//TODO create a buffer so that no entities are added while this loop is running
		for(Player entity : entities)
		{
			entity.draw(graphics2D);
		}
	}

	public static boolean collide(Rectangle rect1, Rectangle rect2)
	{
		return rect1.intersects(rect2);
	}

	public void update()
	{
		// TODO create update
		
	}
	
}
