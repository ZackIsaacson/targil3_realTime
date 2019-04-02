package TableEvent70;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

class Elem {
    private int x;
    private String st;
    //    ArrayList<Integer> type = new ArrayList(4);
    int type[] = new int[4];

    public Elem(int x, String st) {
/*
		העמדה הראשונה יכולה לבנות שלדים  משלושה סוגים שונים של עץ: ארז הלבנון, עץ השיטה ועץ זית.
			העמדה השנייה צובעת באחד משלושה הצבעים הבאים: תכלת, ארגמן ותולעת שני.
		העמדה השלישית מרכיבה רק סוג אחד של מושב.
		העמדה הרביעית מרפדת את המושב בעורות תחשים או בעורות אילים מאדמים.
*/
        if (x == 0) {
//		type = ThreadLocalRandom.current().nextInt(0, 2);
            type[0] = -1;
            type[1] = -1;
            type[2] = -1;
            type[3] = -1;

//        type.add();  //firstStation
//        type.add(ThreadLocalRandom.current().nextInt(0, 3));  //second
//        type.add(0);  //third
//        type.add(ThreadLocalRandom.current().nextInt(0, 2));   //fourth

            this.x = x;
            this.st = st;
        } else {
            //		type = ThreadLocalRandom.current().nextInt(0, 2);
            type[0] = ThreadLocalRandom.current().nextInt(0, 3);
            type[1] = ThreadLocalRandom.current().nextInt(0, 3);
            type[2] = 0;
            type[3] = ThreadLocalRandom.current().nextInt(0, 2);

//        type.add();  //firstStation
//        type.add(ThreadLocalRandom.current().nextInt(0, 3));  //second
//        type.add(0);  //third
//        type.add(ThreadLocalRandom.current().nextInt(0, 2));   //fourth

            this.x = x;
            this.st = st;
        }
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String toString() {
        return x + "   " + st;
    }

}