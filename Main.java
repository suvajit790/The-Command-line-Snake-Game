import java.lang.Thread;
import java.util.Scanner;

public class Main extends MainData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HomeScreen home = new HomeScreen();
        UserData ud = new UserData();
        home.display();
        ud.level = sc.nextInt();
        ud.GameScreenHeight = sc.nextInt();
        ud.GameScreenWidth = sc.nextInt();
        Display obj = new Display(ud);
        Input obj1 = new Input();
        try {
            obj.t.join();
            obj1.t.join();
            sc.close();
        } catch (Exception e) {
            System.out.println("Main Thread Interrupted");
        }
    }
}