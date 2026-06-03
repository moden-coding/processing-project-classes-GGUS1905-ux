import processing.core.*;

public class App extends PApplet {
    int scene = 0;
    Player guy;


    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        guy = new Player(this);

    }

    public void settings() {
        size(800, 600);
    }

    public void draw() {
        background(0);
        guy.display();

    }
    public void keyPressed(){
      if(key == LEFT){
       guy.moveLeft();
      }
    }

}
