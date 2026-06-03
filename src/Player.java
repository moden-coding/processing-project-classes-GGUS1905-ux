import processing.core.PApplet;

public class Player {
    private int x;
    private int y;
    private int height;
    private int width;
    private PApplet screen;
   

    public Player(PApplet c){
        this.x = 370;
        this.y = 550;
        this.height = 25;
        this.width = 60;
        int speed = 10;
        screen = c;


    }
    public void display(){
       screen.fill(255);
       screen.rect(x, y , width, height);
    }
    public void moveLeft(){
        x = x - speed;
    }
    public void moveRight(){
        x = x + speed;
    }
}
