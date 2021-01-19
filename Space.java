import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Space here.
 * 
 * @author saf 
 * @version 1.02
 */
public class Space extends World
{

    /**
     * Konstrukter der Weltall Klasse
     */
    public int shot = 1;
    public int invaders = 50;
    Counter score = new Counter("Score: ");
    Counter lives = new Counter("Lives: ");
    
    public Space() /** erstllt das Weltall und die objekte */
    {    
        super(100, 100, 5); 
        addObject(new Player(), 50, 90);
        addObject(score, 15, 90);
        addObject(lives, 95, 90);
        lives.add(3);
        populate();
    }
    
    public void ShootSet(int arg)
    {
        shot = arg;
    }
    
    public boolean CanShoot()
    {
        if (shot == 1) {
            return true;
        } else {
            return false;
        }
    }
    
    public void addPoints(int pts)
    {
        score.add(pts);
    }
    
    public void die()
    {
        lives.subtract(1);
        if (lives.getValue() == 0) {
            gameOver();
        }
         
        addObject(new Player(), 50, 90);
        shot = 1;
    }
    
    public void gameOver() 
    {
        addObject(new ScoreBoard(score.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    
    public void populate()
    {
        /** Erstellt 5 Reihen an Gegnern */
        Enemy1[] enemies1 = new Enemy1[10];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new Enemy1();
            addObject(enemies1[i], (i*5)+5, 10);
        }
        
       
       Enemy2[] enemies2 = new Enemy2[21];
        for ( int i = 0; i <10; i++ ) {
            enemies2[i] = new Enemy2();
            addObject(enemies2[i], (i*5)+5, 15);
        }
        
        
        for ( int i = 11; i <21; i++ ) {
            enemies2[i] = new Enemy2();
            addObject(enemies2[i], ((i*5)+5)-55, 20);
        } 
        
        Enemy3[] enemies3 = new Enemy3[21];
        for ( int i = 0; i <10; i++ ) {
            enemies3[i] = new Enemy3();
            addObject(enemies3[i], (i*5)+5, 25);
        } 
        
        for ( int i = 11; i <21; i++ ) {
            enemies3[i] = new Enemy3();
            addObject(enemies3[i], ((i*5)+5)-55, 30);
        } 
    }
}
