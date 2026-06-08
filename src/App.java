import java.util.ArrayList;
import processing.core.*;

public class App extends PApplet {
    int scene = 0;
    int direction = 1;
    Player guy;
    Enemy enemy;
    Bullet bad;
    ArrayList<Enemy> firstRow;
    ArrayList<Bullet> bullets;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        guy = new Player(this);
        firstRow = new ArrayList<>();
        bullets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enemy = new Enemy(this, 50 + i * 70, 50);
            firstRow.add(enemy);
        }
    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0);
        guy.display();
        if (frameCount % 60 == 0) {
            int randomEnemy = (int) random(firstRow.size());
            Enemy chosenEnemy = firstRow.get(randomEnemy);
            Bullet shot = new Bullet(chosenEnemy.getX(), chosenEnemy.getY(), this);
            bullets.add(shot);
        }
        for (Bullet b : bullets) {
            b.display();
            b.movement();
        }

        for (Enemy i : firstRow) {
            i.display();
            i.move(direction);
            if (i.getX() > 785) {
                direction = -1;
            }
            if (i.getX() < 15) {
                direction = 1;
            }

        }
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
