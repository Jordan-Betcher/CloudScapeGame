package main;

import game.events.Events;

public class Main
{
	public static Events events = new Events();
	
	public static void main(String[] args)
	{
		events.add(new TimerEvent(0.1));
		//TODO pass in the stuff for the TimerListener to be able to update the map and render it
		events.add(new TimerListener(), TimerEvent.class);
	}
	
}
