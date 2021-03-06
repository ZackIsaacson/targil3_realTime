package TableEvent70;

public class UseTableEventWin extends Thread{
    private static ThreadUI70 myOutput = new ThreadUI70("Table Event");
    private static boolean fin=false;
    private int n = 7;      // no of pieces.
    private int k;        // nb turn
    private Elem data;
    static Elem dataEnd;

    void rotable() {
        Event64 evBegin = new Event64(), evEnd = new Event64();

//        Event64 evBeginB=new Event64();
//        ,evBndB=new Event64();
//        Event64 evBeginC=new Event64(),evBndC=new Event64();
//        Event64 evBeginA=new Event64(),evBndA=new Event64();

        myOutput.println("Table starts");
        new StationOne(n, evBegin);   //todo firstStation sleeping
//        new BigDrillEvent(n,evBeginA,evBndA);
//        new SmallDrillEvent(n,evBeginB,evBndB);
//        new ArmEvent(n,evBeginC,evBndC);

        for (k = 1; k <= n; k++) {
            data = new Elem(k, "");   //new chair
            evBegin.sendEvent(data);  //todo send event to wake up firstStation
//            evBeginA.sendEvent(data);
//            evBeginB.sendEvent(data);
//            evBeginC.sendEvent(data);

//            evBndA.waitEvent();
//            evBndB.waitEvent();
//            evBndC.waitEvent();

            myOutput.println("Sent chair order from main to chair " + k);
//            if (k > 3)
//                myOutput.println("finish elem no. " + (k - 3));
        }
//todo closing all stations
        data = new Elem(0, "");
        evBegin.sendEvent(data);  //todo send event to wake up firstStation

//        evBeginA.sendEvent(data);
//        evBeginB.sendEvent(data);
//        evBeginC.sendEvent(data);
//
//        evBndA.waitEvent();
//        evBndB.waitEvent();
//        evBndC.waitEvent();
        myOutput.println("Table finish");
    }

    public static void finito(Event64 evEnd) {
        do {
//                        myOutput.println("finish elem no. " + );
            dataEnd = (Elem) (evEnd.waitEvent());
            myOutput.println("finish elem no. " + dataEnd.getX());

//        evEnd.waitEvent();
//        todo print that finish
        } while (dataEnd.getX() != 0);
    }


/*
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
*/

    public static void main(String args[]) {
        new UseTableEventWin().rotable();
    }
}