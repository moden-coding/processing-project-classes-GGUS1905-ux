import processing.core.PApplet;

public class Bullet {
    private int x;
    private int y;
    private int speed;
    private int size;
    private PApplet screen;

    public Bullet(int chosenEnemyX, int chosenEnemyY, PApplet c) {
        this.x = chosenEnemyX;
        this.y = chosenEnemyY;
        this.screen = c;
        this.size = 20;
        this.speed = 4;
    }

    public void display(){
       screen.fill(200, 0, 0);
       screen.ellipse(x, y , size, size);
    }

    public void movement(){
        y += speed;
    }


}
