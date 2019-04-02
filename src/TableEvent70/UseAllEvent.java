/*
package TableEvent70;

import TableEvent70.ThreadUI70;

public class ArmEvent extends Thread       // push in and push out
{  
	private ThreadUI70 myOutput=new ThreadUI70("Arm Event");
	private Event64 evBegin,evEnd;
	private int num;
	Elem data;

	public ArmEvent(int no,Event64 evBegin,Event64 evEnd) 	 // constructor
	{  
		this.evBegin = evBegin;	  
		this.evEnd   = evEnd;
		num   = no;
		start();
	}

	public void run () 
	{   
		myOutput.println("Arm Event starts");
		do 
		{
			data=(Elem)evBegin.waitEvent();

			if(data.getX()>3)
				myOutput.println("Arm push out the worked piece "+(data.getX()-3));
			if(data.getX()>0 && data.getX()<=num)
				myOutput.println ("Arm Push in the piece "+data.getX());	   

			evEnd.sendEvent();
		} while(data.getX()!=0);  

		myOutput.println("Arm Event finish");
	}
}

public class BigDrillEvent extends Thread	       // big hole
{ 
	private ThreadUI70 myOutput=new ThreadUI70("Big Drill Event");
	private Event64 evBegin,evEnd;
	private int num;
	Elem data;

	public BigDrillEvent(int no,Event64 evBegin,Event64 evEnd) 	 // constructor
	{  
		this.evBegin = evBegin;	  
		this.evEnd   = evEnd;
		num   = no;
		start();
	} 

	public void run() 
	{ 
		myOutput.println("BigDrill Event Start");
		do 
		{
			data=(Elem)(evBegin.waitEvent());

			if(data.getX()>1 && data.getX()<num+2)
				myOutput.println("BigDrill makes a big hole in piece "+(data.getX()-1));

			evEnd.sendEvent();
		} while(data.getX()!=0);   
		myOutput.println("BigDrill finish");
	}
}

public class SmallDrillEvent extends Thread	       // small hole
{  
	private ThreadUI70 myOutput=new ThreadUI70("SmallDrill Event");
	private Event64 evBegin,evEnd;
	private int num;
	Elem data;

	public SmallDrillEvent(int no,Event64 evBegin,Event64 evEnd) 	 // constructor
	{  
		this.evBegin = evBegin;	  
		this.evEnd   = evEnd;
		num   = no;
		start();
	}

	public void run () 
	{ 
		myOutput.println("SmallDrill Event starts");
		do 
		{                                                    
			data=(Elem)(evBegin.waitEvent());

			if(data.getX()>2 && data.getX()!=(num+3))
				myOutput.println ("SmallDrill makes a small hole piece "+(data.getX()-2));

			evEnd.sendEvent();
		} while(data.getX()!=0);  
		myOutput.println("SmallDrill Event finish");
	}
}

public class UseTableEventWin 
{ 
	private ThreadUI70 myOutput=new ThreadUI70("Table Event");
	private int n=4;      // no of pieces.
	private int k;        // nb turn
	private Elem data;
	void rotable()
	{
		Event64 evBeginB=new Event64(),evBndB=new Event64();
		Event64 evBeginC=new Event64(),evBndC=new Event64();
		Event64 evBeginA=new Event64(),evBndA=new Event64();

		myOutput.println("Table starts"); 

        new BigDrillEvent(n,evBeginA,evBndA); 
		new SmallDrillEvent(n,evBeginB,evBndB);
		new ArmEvent(n,evBeginC,evBndC);

		for(k=1 ; k<=(n+3); k++)
		{
			data=new Elem(k,"");
			evBeginA.sendEvent(data);
			evBeginB.sendEvent(data);
			evBeginC.sendEvent(data);

			evBndA.waitEvent();
			evBndB.waitEvent();
			evBndC.waitEvent();

			myOutput.println ("turn the table");
			if (k>3)
				myOutput.println ("finish elem no. "+(k-3));
		}

		data=new Elem(0,"");
		evBeginA.sendEvent(data);
		evBeginB.sendEvent(data);
		evBeginC.sendEvent(data);

		evBndA.waitEvent();
		evBndB.waitEvent();
		evBndC.waitEvent();
		myOutput.println("Table finish"); 
	}

	public static void main (String args[]) 
	{		
		new UseTableEventWin().rotable();
	}
}

*/
