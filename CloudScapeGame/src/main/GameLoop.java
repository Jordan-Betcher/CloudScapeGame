package main;

import screen.render.Render;
import game.events.EventListenerType;

public class GameLoop implements EventListenerType<Integer>
{
	private Render render;
	private Map map;
	
	
	//Change it so that it gets map from renderCamara?
	public GameLoop(Render render, Map map)
	{
		this.render = render;
		this.map = map;
	}
	
	@Override
	public void activate(Integer object)
	{
		render.repaint();
		map.update();
	}
	
}
