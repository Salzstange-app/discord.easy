package test;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

    public static void main(String[] args) {



        int e = 10;



        int test = e != 0 ? e : 102;









        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            Boolean bool = true;
            @Override
            public void run() {
                if(bool){
                    bool = false;
                    System.out.println("no");
                }else{
                    System.out.println("t " +new Random().nextInt());
                    bool = true;
                }
            }
        }, 0,6*1000);



    }

}
