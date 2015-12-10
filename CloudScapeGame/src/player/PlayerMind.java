package player;

import java.awt.Graphics2D;
import java.util.ArrayList;

import game.events.EventListenerType;
import game.worldmap.Drawable;
import game.worldmap.Position3D;

public class PlayerMind extends
		EventListenerType<ArrayList<Character>> implements Drawable
{
	private ArrayList<Character> chars;
	private Player player;

	public PlayerMind(Player player)
	{
		this.chars = new ArrayList<Character>();
		this.player = player;
	}
	
	@Override
	public void activate(ArrayList<Character> chars)
	{
		this.chars = chars;
	}
	
	public void update()
	{
		printButtons();
		if(chars.contains('w'))
		{
			player.position = new Position3D(player.position.getX(), player.position.getY(), player.position.getZ() - 10);
		}
	}

	public void draw(Graphics2D graphics2D)
	{
		player.draw(graphics2D);
	}
	
	public void printButtons()
	{
		for(char c : chars)
		{
			System.out.print(c + ", ");
		}

		System.out.println();
	}
	
}
