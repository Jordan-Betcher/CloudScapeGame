package main;

import screen.Render;
import game.events.EventListenerType;

public class TimerListener extends EventListenerType<Integer>
{
	private Render render;
	private Map map;
	
	
	//Change it so that it gets map from renderCamara?
	public TimerListener(Render render, Map map)
	{
		this.render = render;
		this.map = map;
	}
	
	@Override
	public void activate(Integer object)
	{
		// TODO make this render the screen
		//	TODO make this update the Map
		render.repaint();
		map.update();
	}
	
}
