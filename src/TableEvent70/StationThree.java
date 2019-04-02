package TableEvent70;

public class StationThree extends Thread	       // small hole
{  
	private ThreadUI70 myOutput=new ThreadUI70("SmallDrill Event");
	private Event64 evThree,evFour;
	private int num;
	Elem data;

	public StationThree(int no,Event64 evBegin) 	 // constructor
	{  
		this.evThree = evBegin;
//		this.evEnd   = evEnd;
		num   = no;
		start();
	}

	public void run () 
	{ 
		myOutput.println("Station Three Event starts");
		evFour = new Event64();   //todo stationTwo waiting for events
		new StationFour(num, evFour);
		do
		{

			data=(Elem)(evThree.waitEvent());

//			if(data.getX()>2 && data.getX()!=(num+3))
				myOutput.println("Station Three adds seat to Chair "+(data.getX()));

			evFour.sendEvent(data);
		} while(data.getX()!=0);
		myOutput.println("Station Three Event finish");
	}
}

