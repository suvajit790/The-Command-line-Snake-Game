import java.lang.Thread;
import java.util.Scanner;

public class Input extends MainData implements Runnable {

    Thread t;
    Scanner scan = new Scanner(System.in);
    Input(){
        t = new Thread(this, "Input");
        t.start();
    }
    public void run(){
        try {
            while (displayIsAlive) {
                try {
                    int data = scan.nextInt();
                    if (data>=4&&data<=8&&data!=7) {
                        inputdata = data;
                    }
                } catch (Exception e) {
                    
                }
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("Input Thread Interrupted"+e);
        }
    }
}