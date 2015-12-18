package player;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Map;
import game.worldmap.camara.Camara;

public class PlayerCamara implements Camara
{
	//TODO change this to entity later
	private PlayerData playerData;
	private Rectangle focus;
	
	public PlayerCamara(PlayerData playerData)
	{
		this.playerData = playerData;
		focus = new Rectangle(0, 0, 640, 480);
	}
	
	@Override
	public void draw(Graphics2D graphics2D)
	{
		Map map = playerData.getMap();
		map.draw(graphics2D, focus);
	}
	
}
