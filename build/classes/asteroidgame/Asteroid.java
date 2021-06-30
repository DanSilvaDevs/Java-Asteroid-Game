/*
 * University of Central Florida
 * COP - 3330 Spring 2016
 * Author: Daniel Silva
 */
package asteroidgame;

import blobzx.BlobUtils;
import blobzx.PolyBlob;
import java.awt.Point;
import java.util.Random;

public class Asteroid extends PolyBlob {
   
   private static Random r = new Random();
   
   public Asteroid(int x, int y, double rot) {
       super(-100, -100, rot);
       setDelta(x, y);
       int sides, distance, i;
       sides = r.nextInt(10-5) + 5;
       int[] a = new int[sides];
       int[] b = new int[sides];
       double[] angle = new double[sides];
       Point point;
       for(i = 0; i < sides; i++) {
           double region = (2*Math.PI) / sides;
           angle[i] = (i * region) + (Math.random() * region);
           distance = r.nextInt(16-5) + 5;
           point = BlobUtils.rotatePoint(distance, angle[i]);
           a[i] = (int) point.getX();
           b[i] = (int) point.getY();
       }
       setPolygon(a, b);
   } 
}
