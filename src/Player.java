import processing.core.PApplet;

public class Player {
    private int x;
    private int y;
    private int height;
    private int width;
    private PApplet screen;
    private int speed;
   

    public Player(PApplet c){
        this.x = 370;
        this.y = 550;
        this.height = 25;
        this.width = 60;
        this.speed = 20;
        screen = c;


    }
    public void display(){
       screen.fill(255);
       screen.rect(x, y , width, height);
    }
    public void moveLeft(){
        x -= speed;
    }
    public void moveRight(){
        x += speed; 
    }
    public void shoot(){
    
    }
}
