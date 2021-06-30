/*
 * University of Central Florida
 * COP - 3330 Spring 2016
 * Author: Daniel Silva
 */
package asteroidgame;

import blobzx.BlobAction;
import blobzx.BlobProximity;
import blobzx.BlobUtils;
import static blobzx.BlobUtils.playSound;
import blobzx.PolyBlob;
import java.awt.Point;
import java.awt.event.KeyEvent;
import blobzx.SandBox;


public class Rocket extends PolyBlob implements BlobAction, BlobProximity{

    private final int[] a = {10, -10, -5, -10};
    private final int[] b = {0, -7, 0, 7};
    private final int[] ab = {10, -10, -5, -10};
    private final int[] bc = {0, -7, 0, 7};
    private double angle = 0.0;
    private final double delta = 0.15;
    private final double speed = 5.0;
    SandBox box;
    
    public Rocket(int x, int y, SandBox sandbox) {
        super(0, 0, 0);
        setLoc(x, y);
        setRate(0);
        setDelta(0, 0);
        setPolygon(ab, bc);
        box = sandbox;
    }
    
    public void keyAction(KeyEvent e) {
        int xloc, yloc, i;
        Point d;
        
        switch (e.getKeyCode()) {
            case 32:
                //Space Bar
                launch(box);
                playSound();
                break;
            case 37:
                //Left arrow
                angle = angle - delta;
                if(angle < 0)
                    angle = angle + 2*Math.PI;
                turn();
                break;
            case 38:
                //Up arrow 
                for(i = 0; i<a.length; i++) {
                    d = getLoc();
                    xloc = d.x;
                    yloc = d.y;
                    xloc = xloc + (int) Math.round(speed * Math.cos(angle));
                    yloc = yloc + (int) Math.round(speed * Math.sin(angle));
                    setLoc(xloc, yloc);
                }
                break;
            case 39:
                //Right Arrow   
                angle = angle + delta;
                if(angle > 2*Math.PI)
                    angle = angle - 2*Math.PI;
                turn();
                break;
        }
    }
    public void turn() {
        int i;
        Point p;
        for(i = 0; i < a.length; i++){
            p = BlobUtils.rotatePoint(a[i], b[i], angle);
            ab[i] = p.x;
            bc[i] = p.y;
            }
        }
    
    public void launch(SandBox box) {
       int a, b;
       double radius;
       Point d, c;
       radius = getSize() * 0.5;
       d = getLoc();
       c = BlobUtils.rotatePoint(d.x, angle);
       a = c.x;
       b = c.y;
       Missile missile;
       missile = new Missile(d.x , d.y, angle);
       box.addBlob(missile);
    }
}
