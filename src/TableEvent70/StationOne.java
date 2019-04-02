package TableEvent70;

public class StationOne extends Thread       // push in and push out
{  
	private ThreadUI70 myOutput=new ThreadUI70("Arm Event");
//	private Event64 evBegin,evEnd;
		private Event64 evOne,evTwo;

	private int num;
	Elem data;

	public StationOne(int no,Event64 evo) 	 // constructor
	{
		this.evOne=evo;
//		this.evBegin = evBegin;
//		this.evEnd   = evEnd;
		num   = no;
		start();
	}

	public void run () 
	{   
		myOutput.println("Station One Event starts");
		evTwo = new Event64();   //todo stationTwo waiting for events
		new StationTwo(num, evTwo);   //todo firstStation sleeping

		do
		{
			data=(Elem)evOne.waitEvent();  //sendEvent of main wakes him up

//			if(data.getX()>0 && data.getX()<=num) {  //only relevant if not the last 3
				if (data.type[0] == 0)
					myOutput.println("Station One Builds Chair Frame from Erez Halevanon " + (data.getX() ));
				if (data.type[0] == 1)
					myOutput.println("Station One Builds Chair Frame from Ets Hashita " + (data.getX() ));
				if (data.type[0] == 2)
					myOutput.println("Station One Builds Chair Frame from Olive Wood " + (data.getX() ));
//			if(data.getX()>3)
//				myOutput.println("Arm push out the worked piece "+(data.getX()-3));
//			if(data.getX()>0 && data.getX()<=num)
//				myOutput.println ("Arm Push in the piece "+data.getX());
//TODO how does one know that two is available to give him event so that he's available to accept from main?
				evTwo.sendEvent(data);   //tries to send event. if not able to because inUse=true yields but either way this thread wont move to next line to free and wait for next thread before finsihed
//				evOne.waitEvent();  //todo inUse =false. can get next
//			}
		} while(data.getX()!=0);

		myOutput.println("Station One Event finish");
	}
}

