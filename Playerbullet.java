import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Playerbullet, gibt an was die Klasse macht.
 * Playerbullet, here you can see what this class does
 * 
 * @author Sandro Filisetti
 * @version V4.0
 */
public class Playerbullet  extends Actor
{
    /**
     *
     */
    private Player player;
    
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
