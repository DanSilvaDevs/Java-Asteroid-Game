/*
 * University of Central Florida
 * COP - 3330 Spring 2016
 * Author: Daniel Silva
 */
package asteroidgame;

import blobzx.Blob;
import blobzx.BlobProximity;

public class Missile extends Blob implements BlobProximity{
    
    public Missile(int x, int y, double theta) {
        super(x, y, (int) Math.round(5.0 * Math.cos(theta)), (int) Math.round(5.0 * Math.sin(theta)));
        int size = 5;
        setSize(size);
    }   
}
