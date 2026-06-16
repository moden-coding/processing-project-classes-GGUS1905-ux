import java.util.ArrayList;
import processing.core.*;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class App extends PApplet {
    int scene = 0;
    int direction = 1;
    Player guy;
    Enemy enemy;
    Bullet bad;
    ArrayList<Enemy> firstRow;
    ArrayList<Bullet> bullets;
    int score = 0;
    int lives = 3;
    boolean left, right;
    int highScore;
    public static void main(String[] args) { // Starts the game window and runs the App class
        PApplet.main("App");
    }

    public void setup() { // Creates the player, enemies, bullets, and loads the high score
        guy = new Player(this);
        firstRow = new ArrayList<>();
        bullets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            enemy = new Enemy(this, 50 + i * 70, 50);
            firstRow.add(enemy);

        }
        highScore();
    }

    public void settings() { // Sets the size of the game screen
        size(800, 600);
    }

    public void draw() { 
        if (scene == 2) { //sets everything for scene two and print it on the screen
            background(0);
            fill(255, 0, 0);
            textSize(50);
            textAlign(CENTER);
            text("GAME OVER", width / 2, height / 2);
            textSize(25);
            text("Score: " + score, width / 2, height / 2 + 50);
            text("Press R to restart", width / 2, height / 2 + 100);
            text("High Score: " + highScore, width / 2, height / 2 + 150);
            return;
        }
        if (scene == 0) { //sets everything for scene one and print it on the screen
            background(0);
            fill(255);
            textSize(40);
            text("Space Invaders (but better)", 180, 250);
            text("Use LEFT and RIGHT arrows to move", 120, 320);
            text("Press SPACE to shoot", 200, 360);
            text("Don't get hit by enemy bullets!", 140, 400);
            text("Press Enter To Start:", 200, 500);

        }
        if (scene == 4) { //sets everything for scene one and print it on the screen
            background(0);
            fill(0, 255, 0);
            textSize(40);
            textAlign(CENTER);
            text("Good job, you are a real winner!", width / 2, height / 2 - 40);
            textSize(25);
            text("Want to try again?", width / 2, height / 2 + 20);
            text("Press R to restart", width / 2, height / 2 + 80);
        }

        if (scene == 1) { 
            background(0);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            textSize(20);
            text("Score: " + score, 10, 25);
            text("Lives: " + lives, 10, 50);
            text("High Score: " + highScore, 10, 75);

            if (left == true) { //calls on the left movment of my player
                guy.moveLeft();
            }
            if (right == true) { //calls on the right movment of my player
                guy.moveRight();
            }

            guy.display();
            if (frameCount % 60 == 0) { //thats calling every frameCount%60 on a bullet to gert shot from one random enemy
                if (firstRow.size() > 0) {
                    int randomEnemy = (int) random(firstRow.size());
                    Enemy chosenEnemy = firstRow.get(randomEnemy);
                    Bullet shot = new Bullet(chosenEnemy.getX(), chosenEnemy.getY(), 1, this);
                    bullets.add(shot);
                }

            }
            for (Bullet b : bullets) { //displaying and moving the bullets
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

            for (int i = 0; i < bullets.size(); i++) { //that is checking for collosion of the enemy and if collison is trigered it increses the score by one and removes enemy and bullet from my screen  
                Bullet b = bullets.get(i);
                for (int j = 0; j < firstRow.size(); j++) {
                    Enemy e = firstRow.get(j);
                    if (dist(b.getX(), b.getY(), e.getX(), e.getY()) < 20 && b.getDirection() == -1) {
                        firstRow.remove(j);
                        bullets.remove(i);
                        score++;
                        break;

                    }

                }
                if (b.getDirection() == 1 && dist(b.getX(), b.getY(), guy.getCenter(), guy.getY()) < 35) { //that is checking for collosion of the player and if collison is trigered it decreses the lives by one and removes the bullet from my screen
                    bullets.remove(i);
                    lives--;
                    i--;
                    break;
                }
            }
            if (lives <= 0) {
                scene = 2;
            }
            if (firstRow.size() == 0) {
                scene = 4;
            }

        }
        if (score > highScore) {
            highScore = score;
            saveHighScore();
        }

    }

    public void keyPressed() { //checking if any key is pressed and checking for the consequences
        if (scene == 0 && keyCode == ENTER) {
            scene = 1;
        }

        if (key == ' ') { //every time the space is pressed the player is gonna shot a bullet
            Bullet shot = new Bullet(guy.getCenter(), guy.getY(), -1, this);
            bullets.add(shot);
            
        }
        if ((scene == 2 || scene == 4) && (key == 'r' || key == 'R')) {
            scene = 1; 
            resetGame();
        }

        if (keyCode == LEFT) {
            left = true;
        }
        if (keyCode == RIGHT) {
            right = true;
        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            left = false;
        }
        if (keyCode == RIGHT) {
            right = false;
        }

    }

    public void resetGame() {
        score = 0;
        lives = 3;
        direction = 1;

        bullets.clear();
        firstRow.clear();

        for (int i = 0; i < 10; i++) {
            firstRow.add(new Enemy(this, 50 + i * 70, 50));
        }

        guy = new Player(this);
    }

    public void highScore() { //im reading the high score from the file compare it to my score and if score is bigger than high score i write in score insted of heigh score
        try {
            Scanner fileReader = new Scanner(new File("highscore.txt"));

            while (fileReader.hasNextLine()) {
                int number = fileReader.nextInt();
                highScore = number;

            }

            fileReader.close();
        } catch (Exception e) {
            System.out.println("File not found");
            highScore = 0;
        }
    }

    public void saveHighScore() { //if score is bigger than high score i write in score insted of heigh score
        try {
            PrintWriter writer = new PrintWriter("highscore.txt");
            writer.println(highScore);
            writer.close();
        } catch (Exception e) {
            System.out.println("Could not save high score.");
        }
    }
}
