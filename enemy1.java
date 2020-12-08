import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy1 extends Actor
{
    public int direction = 1; //1 = move left, 2 = move right
    public GreenfootImage img1;
    public GreenfootImage img2;
    
    
    public enemy1()
    {
        img1 = getImage();
        img2 = new GreenfootImage("enemy1-2.gif");
    }
    public void act() 
    {
        move();
       
    }
    public void move()
    {
        if (getImage() == img1) {
            setImage(img2);
        }
        else {
            setImage(img1);
        }
        
    }
}
