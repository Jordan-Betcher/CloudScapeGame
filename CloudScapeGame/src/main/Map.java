package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import player.Player;
import player.PlayerMind;

public class Map
{
	private ArrayList<PlayerMind> playerMinds = new ArrayList<PlayerMind>();
	//TODO create a block list
	private Ground ground = new Ground();
	
	public void addEntity(PlayerMind entity)
	{
		playerMinds.add(entity);
	}
	
	public ArrayList<PlayerMind> getEntities()
	{
		return this.playerMinds;
	}

	public void draw(Graphics2D graphics2D, Rectangle focus)
	{
		ground.draw(graphics2D);
		drawEntities(graphics2D);
	}
	
	private void drawEntities(Graphics2D graphics2D)
	{
		//TODO create a buffer so that no entities are added while this loop is running
		for(PlayerMind mind : playerMinds)
		{
			mind.draw(graphics2D);
		}
	}

	public static boolean collide(Rectangle rect1, Rectangle rect2)
	{
		return rect1.intersects(rect2);
	}

	public void update()
	{
		for(PlayerMind mind : playerMinds)
		{
			mind.update();
		}
	}
	
}
