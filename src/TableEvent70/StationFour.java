package TableEvent70;

import static TableEvent70.UseTableEventWin.finito;

public class StationFour extends Thread	       // small hole
{
    private ThreadUI70 myOutput=new ThreadUI70("SmallDrill Event");
    private Event64 evFour,evEnd;
    private int num;
    Elem data;

    public StationFour(int no,Event64 evBegin) 	 // constructor
    {
        this.evFour = evBegin;
        this.evEnd   = evEnd;
        num   = no;
        start();
    }

    public void run ()
    {
        myOutput.println("Station Four Event starts");
        evEnd = new Event64();   //todo stationTwo waiting for events
        finito(evEnd);
//        new StationOne(num, evEnd);
//        new UseTableEventWin().finito(num,evEnd); //todo

        do
        {
            data=(Elem)(evFour.waitEvent());

            if(data.type[1]==0)
                myOutput.println("Station Four cushions orot tchashim to Chair "+(data.getX()));
            if(data.type[1]==1)
                myOutput.println("Station Four cushions orot eilim modamim to Chair "+(data.getX()));

            evEnd.sendEvent(data);
        } while(data.getX()!=0);
        myOutput.println("Station Four Event finish");
    }
}

