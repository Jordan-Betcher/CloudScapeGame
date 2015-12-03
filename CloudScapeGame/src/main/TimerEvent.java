package main;

import game.events.Event;

public class TimerEvent extends Event<Double>
{
	
	private double startTime;
	
	//This variable represents how many seconds or second parts will be done b4 all the listeners are activated
	private double increments;
	
	public TimerEvent(double increments)
	{
		this(0.0, increments);
	}
	
	public TimerEvent(double startTime, double increments)
	{
		this.startTime = startTime;
		this.increments = increments;
		startTimer();
	}
	
	private void startTimer()
	{
		double timePassed = startTime;
		//TODO create timer using the increments variable
		
		
		
		//This activates all the event listeners and passes to them the time that has elapsed
		this.activate(timePassed);
	}
	
	public double getStartTime()
	{
		return startTime;
	}
	
	
}
