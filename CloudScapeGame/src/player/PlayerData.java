package player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Map;
import game.worldmap.Drawable;
import game.worldmap.Moveable;
import game.worldmap.Position3D;

public class PlayerData implements Drawable, Moveable
{
	public Map map;
	public Position3D position;
	
	public PlayerData(Map map)
	{
		this.map = map;
		this.position = new Position3D(0, 0, 0);
	}
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		graphics2D.setColor(Color.red);
		//TODO create actual pic
		//TODO make off set middle? OR do in collision
		graphics2D.fillRect(this.position.getX(), this.position.getY(), 64, 64);
		
	}

	@Override
	public Position3D getPosition3D()
	{
		return position;
	}
	
}
