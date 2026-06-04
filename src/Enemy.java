import processing.core.PApplet;

public class Enemy {
    private int x;
    private int y;
    private PApplet screen;
    private int speed;
    private int size;

    public Enemy(PApplet b){
        screen = b;
        this.x = (int) screen.random(15,785);
        this.y = 30;
        this.size = 30;
        this.speed = 20;
    }

     public void display(){
       screen.fill(255);
       screen.ellipse(x, y , size, size);
    }
        public void move() {
        x += speed;
        if (x + size / 2 > screen.width || x - size / 2 < 0) {
            speed = -speed;

        }
    }
    public void createEnemy(){
        screen.fill(255);
        screen.ellipse(x, y , size, size);
    }

}
