import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;

public class Food {
    int food_x,food_y;
    Random rand = new Random();
    UserData ud;
    String highScoreOut = "HS.data";
    Food (UserData ud){
        this.ud = ud;
    }
    Food (){

    }
    int getHighScore(){
        int score;
        try (FileInputStream fin = new FileInputStream(highScoreOut)) {
            score = fin.read();
            return score;
        } catch (Exception e) {
            return 0;
        }
    }
    void putHighScore(int score){
        if (score > getHighScore()) {
            try (FileOutputStream fout = new FileOutputStream(highScoreOut)) {
                fout.write(score);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    void foodApr(){
        food_x = rand.nextInt(ud.GameScreenWidth);
        food_y = rand.nextInt(ud.GameScreenHeight);
    }
}