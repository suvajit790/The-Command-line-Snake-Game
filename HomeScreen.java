
public class HomeScreen {
    Food fd = new Food();
    void display(){
        System.out.print("\033[H\033[2J");
        for (int y = 0; y < 10+1; y++) {
            for (int x = 0; x < 60 + 1; x++) {
                if ((x == 0 || x == 60) && y!=0) {
                    System.out.print("|");
                }
                if ((y == 0 || y == 10) && x != 60) {
                    if (y == 10 && x == 1) {
                        
                    } else {
                        System.out.print("_");
                    }
                }
                if (y == 0 && x == 60) {
                    System.out.print("_");
                }
                if (y == (10/2)-3 && x == 0) {
                    System.out.print("           WELCOME TO THE JAVA CONSOLE SNAKE GAME          |");
                    break;
                }else if(y == (10/2)-2 && x == 0){
                    System.out.print("                              - Developed by Suvajit Patra |");
                    break;
                }else if(y == (10/2) && x == 0) {
                    System.out.print("                  Enter the level (1 - 10)                 |");
                    break;
                }else if(y == (10/2)+2 && x == 0){
                    System.out.print("  Enter the gamescreen height and width (Defult is 10 60)  |");
                    break;
                }else if (y == (10/2)+4 && x == 0) {
                    int t = fd.getHighScore();
                    if (t/100 > 0) {
                        System.out.print("                        HighScore = "+t+"                    |");
                    } else if (t/10 > 0){
                        System.out.print("                        HighScore = "+t+"                     |");
                    } else {
                        System.out.print("                        HighScore = "+t+"                      |");
                    }
                    break;
                }else if (x!= 0 && x!=60&&y!= 0 && y!=10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}