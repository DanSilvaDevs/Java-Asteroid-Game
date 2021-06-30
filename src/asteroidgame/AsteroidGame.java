/*
 * University of Central Florida
 * COP - 3330 Spring 2016
 * Author: Daniel Silva
 */
package asteroidgame;

import blobzx.BlobGUI;
import blobzx.SandBox;
import blobzx.SandBoxMode;
import java.util.Random;


public class AsteroidGame implements BlobGUI{

    
    public static void main(String[] args) {
        new AsteroidGame();
        
    }
    
    SandBox sandbox = new SandBox();
    
    public AsteroidGame() {
        sandbox.setSandBoxMode(SandBoxMode.FLOW);
        sandbox.setFrameRate(15);
        sandbox.init(this);
    }
    
    public void generate() {
        Rocket rocket = new Rocket(300, 300, sandbox);
        sandbox.addBlob(rocket);
        Random r2 = new Random();
        int i;
        for(i = 0; i < 10; i++) {
            int x = -3 + r2.nextInt(6);
            int y = -3 + r2.nextInt(6);
            while(y == 0 || x == 0){
                y = -3 + r2.nextInt(6);
                x = -3 + r2.nextInt(6);
            }
            double rot = r2.nextBoolean() ? -0.1 : 0.1;
            Asteroid asteroid = new Asteroid(x, y, rot);
            sandbox.addBlob(asteroid);
        }
    }
    
}
