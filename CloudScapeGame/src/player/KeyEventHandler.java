package player;

import game.events.EventListenerType;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class KeyEventHandler implements EventListenerType<KeyEvent>
{
	
	
	private ArrayList<Character> keys = new ArrayList<Character>();
	
	public void activate(KeyEvent keyEvent)
	{
		char input = keyEvent.getKeyChar();
		if( ! keys.contains(input))
		{
			keys.add(input);
		}
	}
	
	public ArrayList<Character> get()
	{
		ArrayList<Character> temp = keys;
		keys = new ArrayList<Character>();
		return temp;
	}
}
