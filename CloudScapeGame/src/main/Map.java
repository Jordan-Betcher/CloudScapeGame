package main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import player.PlayerData;
import player.Player;

public class Map
{
	private ArrayList<Player> players = new ArrayList<Player>();
	//TODO create a block list
	private Ground ground = new Ground();
	
	public void addEntity(Player entity)
	{
		players.add(entity);
	}
	
	public ArrayList<Player> getEntities()
	{
		return this.players;
	}

	public void draw(Graphics2D graphics2D, Rectangle focus)
	{
		ground.draw(graphics2D);
		drawEntities(graphics2D);
	}
	
	private void drawEntities(Graphics2D graphics2D)
	{
		//TODO create a buffer so that no entities are added while this loop is running
		for(Player mind : players)
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
		for(Player mind : players)
		{
			mind.update();
		}
	}
	
}
