import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author SaF
 * @version 1.0
 */
public class Player extends Actor
{
    public void act() 
    {
        KeyPress();
        
    }    
        private void KeyPress() {
        int x = getX();
        if(Greenfoot.isKeyDown("right")) {
            x = x+1;
            setLocation(x, getY());
        }
        if(Greenfoot.isKeyDown("left")) {
            x = x-1;
            setLocation(x, getY());
        }
        if (Greenfoot.isKeyDown("up") && ((Space) getWorld()).CanShoot()) {
            getWorld().addObject(new Bullet(), getX(), getY()-5);
            ((Space) getWorld()).ShootSet(0);
 
        }   
    }
        private void destroy() {
        ((Space) getWorld()).ShootSet(0);
        getWorld().removeObject(this);
    }
}
