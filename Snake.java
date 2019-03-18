
public class Snake {
    int snake_x[] = new int[100];
    int snake_y[] = new int[100];
    UserData ud;
    Food fd;
    Snake(Food fd, UserData ud){
        this.fd = fd;
        this.ud = ud;
    }
    int bdcount;
    void init(){
        bdcount = 2;
        snake_x[0]=10;
        snake_y[0]=5;
        snake_x[1]=10;
        snake_y[1]=6;
        fd.foodApr();
    }
    void update(int next){
        for (int i = bdcount; i > 0; i--) {
            snake_x[i]=snake_x[i-1];
            snake_y[i]=snake_y[i-1];
        }
        if (snake_x[0]==0 && next == 4) {
            snake_x[0] = (ud.GameScreenWidth-1);
            return;
        }
        if (snake_x[0]==(ud.GameScreenWidth-1) && next == 6) {
            snake_x[0] = 0;
            return;
        }
        if(snake_y[0] == 0 && next == 8){
            snake_y[0] = (ud.GameScreenHeight-1);
            return;
        }
        if(snake_y[0]==(ud.GameScreenHeight-1) && next == 5){
            snake_y[0] = 0;
            return;
        }
        switch (next) {
            case 8:
                snake_y[0] -= 1;
                break;
            case 5:
                snake_y[0] += 1;
                break;
            case 4:
                snake_x[0] -= 1;
                break;
            case 6:
                snake_x[0] += 1;
                break;
        
            default:
                break;
        }
    }
    boolean ChkFrCrash(){
        boolean t = false;
        for (int i = 1; i < bdcount; i++) {
            if (snake_x[0] == snake_x[i] && snake_y[0] == snake_y[i]) {
                t = true;
                break;
            }
        }
        return t;
    }
    void eaten(){
        bdcount++;
        fd.foodApr();
    }
}