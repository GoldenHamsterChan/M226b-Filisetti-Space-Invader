import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Space() /** Creates the Space and the other Objects */
    {    
        super(100, 100, 5); 
        addObject(new Player(), 50, 90);
        populate();
    }
    public void populate()
    {
        /** Erstellt 5 Reihen an Gegnern */
        enemy1[] enemies1 = new enemy1[10];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new enemy1();
            addObject(enemies1[i], (i*5)+5, 20);
        }
        
        enemy1[] enemies2 = new enemy1[20];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new enemy1();
            addObject(enemies1[i], (i*5)+5, 15);
        }
        enemy2[] enemies4 = new enemy2[20];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new enemy2();
            addObject(enemies1[i], (i*5)+5, 10);
        }
    }
}
