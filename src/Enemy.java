import processing.core.PApplet;

public class Enemy {
    private int x;
    private int y;
    private PApplet screen;
    private int speed;
    private int size;

    public Enemy(PApplet b , int x , int y){
        screen = b;
        this.x = x;
        this.y = y;
        this.size = 30;
        this.speed = 1;
    }

     public void display(){
       screen.fill(255);
       screen.ellipse(x, y , size, size);
    }
        public void move(int direction) {
        x += speed;
        if (x + size / 2 > screen.width || x - size / 2 < 0) {
            speed = -speed;
            x += direction;

        }
    }
    public void createEnemy(){
        screen.fill(255);
        screen.ellipse(x, y , size, size);
        
    }
    public int getX(){
        return x;
    }

}
