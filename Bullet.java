import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author SaF
 * @version 1.0
 */
public class Bullet extends Actor
{
    /**
     * 
     */
    public void act() 
    {
       int y = getY();
       y = y-2;
       setLocation(getX(), y);
       
       if (getY() == 0) {
           destroy();
        }
    }    
    
    private void destroy() {
        ((Space) getWorld()).ShootSet(1);
        getWorld().removeObject(this);
    }
}
