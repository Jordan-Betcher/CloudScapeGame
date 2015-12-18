package player;

import java.awt.Color;
import java.awt.Graphics2D;

import main.Map;
import game.worldmap.Drawable;
import game.worldmap.Moveable;
import game.worldmap.XYZ;

public class PlayerData implements Drawable, Moveable
{
	private Map map;
	private XYZ position;
	
	public PlayerData(Map map)
	{
		this.map = map;
		this.position = new XYZ(0, 0, 0);
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
	public XYZ getPosition()
	{
		return position;
	}

	@Override
	public void setPosition(XYZ xyzCoords)
	{
		this.position = xyzCoords;		
	}

	public Map getMap()
	{
		return map;
	}
	
}
