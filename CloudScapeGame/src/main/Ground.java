package main;

import java.awt.Color;
import java.awt.Graphics2D;

import game.worldmap.Drawable;

public class Ground implements Drawable
{
	
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		graphics2D.setColor(Color.green);
		graphics2D.fillRect(0, 0, 640, 480);
	}
	
}
