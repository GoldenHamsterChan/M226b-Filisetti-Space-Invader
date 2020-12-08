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
        
    }
}
