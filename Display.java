import java.lang.Thread;

public class Display extends MainData implements Runnable {
    Thread t;
    Food fd;
    Snake s;
    UserData ud;
    Display(UserData ud){
        this.ud = ud;
        fd = new Food(ud);
        s = new Snake(fd,ud);
        t = new Thread(this, "Display");
        t.start();
    }
    public void run(){
        try{
            s.init();
            while (true) {
                System.out.print("\033[H\033[2J");
                System.out.println("Score = "+score);
                s.update(inputdata);
                if (s.ChkFrCrash()) {
                    break;
                }
                if (s.snake_x[0] == fd.food_x && s.snake_y[0] == fd.food_y) {
                    score++;
                    s.eaten();
                }
                for (int y = 0; y < ud.GameScreenHeight; y++) {
                    for (int x = 0; x < ud.GameScreenWidth; x++) {
                        boolean condition = false;
                        for (int i = 0; i < s.bdcount; i++) {
                            if (s.snake_x[i]==x && s.snake_y[i]==y) {
                                condition = true;
                                break;
                            }
                        }
                        if (x == fd.food_x && y == fd.food_y) {
                            System.out.print("O");
                        }else if (condition) {
                            System.out.print("*");
                        } else {
                            System.out.print("_");
                        }
                    }
                    System.out.println();
                }
                Thread.sleep((11-ud.level)*100);
            }
            gameOver();
            fd.putHighScore(score);
            displayIsAlive = false;
        }catch(Exception e){
            System.out.println("Display Thread Interrupted"+e);
        }
    }
    void gameOver(){
        for (int y = 0; y < ud.GameScreenHeight; y++) {
            for (int x = 0; x < ud.GameScreenWidth; x++) {
                if (x==(ud.GameScreenWidth/2)-4 && y == ud.GameScreenHeight/2) {
                    System.out.print("GAME OVER");
                }
                if(x>(ud.GameScreenWidth/2)-5 && x<(ud.GameScreenWidth/2)+5 && y == ud.GameScreenHeight/2) {
                } else if (y == (3*ud.GameScreenHeight)/4 && x == (ud.GameScreenWidth/2)-12) {
                    System.out.print("Enter any integer to exit");
                } else if (y == (3*ud.GameScreenHeight)/4 && x >= (ud.GameScreenWidth/2)-12 && x <= (ud.GameScreenWidth/2)+12) {
                    
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}