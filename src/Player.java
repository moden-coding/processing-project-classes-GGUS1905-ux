import processing.core.PApplet;

public class Player { 
    private int x;
    private int y;
    private int height;
    private int width;
    private PApplet screen;
    private int speed;
   

    public Player(PApplet c){ //my constructre
        this.x = 370;
        this.y = 550;
        this.height = 25;
        this.width = 60;
        this.speed = 5;
        screen = c;


    }

    public int getCenter(){ //that is getting the center of the player
       return x + width / 2;
    }
    public void display(){ //displaying the player
       screen.fill(255);
       screen.rect(x, y , width, height);
    }
    public void moveLeft(){ //make the player move left by the speed 
        x -= speed;
    }
    public void moveRight(){ //make the player move right by the speed 
        x += speed; 
    }
    public int getX(){ //geting the x position of the player
        return x;
    }
     public int getY(){ //geting the y position of the player
        return y;
    }

}
