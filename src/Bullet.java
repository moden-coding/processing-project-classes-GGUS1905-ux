import processing.core.PApplet;

public class Bullet {
    private int x;
    private int y;
    private int speed;
    private PApplet screen;
    private int direction;

    public Bullet(int chosenEnemyX, int chosenEnemyY, int direction, PApplet c) { //my constructer
        this.x = chosenEnemyX;
        this.y = chosenEnemyY;
        this.screen = c;
        this.speed = 4;
        this.direction = direction;
    }

    public void display() { //displaying the bullets
        if (direction == -1) { //if the bullet direction is going up his color will be bright green
            screen.fill(0, 255, 0); 
        } else {//if the bullet direction is going down his color will be red
            screen.fill(255, 0, 0); 
        }

        screen.ellipse(x, y, 10, 10);
    }


    public void movement() { //this will move the bllet by the speed times the direction
        y += speed * direction;
    }

    public int getX() { //getting the x position of the bullet
        return x;
    }

    public int getY() { //getting the y position of the bullet
        return y;
    }

    public int getDirection() { //getting the direction of the bullet
        return direction;
    }

}
