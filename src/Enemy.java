import processing.core.PApplet;

public class Enemy {
    private int x;
    private int y;
    private PApplet screen;
    private int speed;
    private int size;

    public Enemy(PApplet b , int x , int y){ //my constructre
        screen = b;
        this.x = x;
        this.y = y;
        this.size = 30;
        this.speed = 1;
    }

     public void display(){ //displaying the enemy 
       screen.fill(255);
       screen.ellipse(x, y , size, size);
    }
        public void move(int direction) {//moving enemy by the speed and if the enemy touches the end of the screen he changes direction and his y is gewtting lower
        x += speed;
        if (x + size / 2 > screen.width || x - size / 2 < 0) {
            speed = -speed;
            y += 60;
           
        }
    }
    public void createEnemy(){ //creating an enemy
        screen.fill(255);
        screen.ellipse(x, y , size, size);
        
    }
    public int getX(){//geting the x position of the enemy
        return x;
    }
     public int getY(){//geting the y position of the enemy
        return y;
    }

}
