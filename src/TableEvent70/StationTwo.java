package TableEvent70;

public class StationTwo extends Thread	       // small hole
{  
	private ThreadUI70 myOutput=new ThreadUI70("StationTwo Event");
	private Event64 evTwo,evThree;
	private int num;
	Elem data;

	public StationTwo(int no,Event64 evBegin) 	 // constructor
	{  
		this.evTwo = evBegin;
//		this.evEnd   = evEnd;
		num   = no;
		start();
	}

	public void run () 
	{ 
		myOutput.println("Station Two Event starts");
		evThree = new Event64();   //todo stationThree waiting for events
		new StationThree(num, evThree);
		do
		{
			data=(Elem)evTwo.waitEvent();  //sendEvent of main wakes him up
			if (data.type[1] == -1)
				myOutput.println("Station Two Closes station");
			if(data.type[1]==0)
				myOutput.println("Station Two paints Chair Frame tchelet "+(data.getX()));
			if(data.type[1]==1)
				myOutput.println("Station Two paints Chair Frame argaman "+(data.getX()));
			if(data.type[1]==2)
				myOutput.println("Station Two paints Chair Frame tolaat shani "+(data.getX()));

			evThree.sendEvent(data);
		} while(data.getX()!=0);
		myOutput.println("Station Two Event finish");
	}
}

