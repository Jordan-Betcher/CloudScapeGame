package player;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Map;
import game.worldmap.camara.Camara;

public class PlayerCamara implements Camara
{
	//TODO change this to entity later
	private Player player;
	private Rectangle focus;
	
	public PlayerCamara(Player player)
	{
		this.player = player;
		focus = new Rectangle(0, 0, 640, 480);
	}
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		Map map = player.map;
		map.draw(graphics2D, focus);
	}
	
}
