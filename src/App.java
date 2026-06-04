import java.util.ArrayList;
import processing.core.*;

public class App extends PApplet {
    int scene = 0;
    Player guy;
    Enemy enemy;
    ArrayList<Enemy> firstRow;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        guy = new Player(this);
        firstRow = new ArrayList<>();
        
        }
    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0);
        guy.display();
        

    }

    public void keyPressed() {

        if (keyCode == LEFT) {
            guy.moveLeft();
        }
        if (keyCode == RIGHT) {
            guy.moveRight();
        }
    }

}
