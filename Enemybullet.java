import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author Sandro Filisetti
 * @version V4.0
 */
public class Enemybullet  extends Actor
{
    private GreenfootImage img1; 
   
    
    public Enemybullet() 
    {
        img1 = getImage(); 
    }
    
    public void act() 
    {
      int y = getY();
      y = y+1;
      setLocation(getX(), y);
       
      if (getY() + 5 == getWorld().getHeight()) {
          destroy();
      }

    }    
    
    private void destroy() {
        getWorld().removeObject(this);
    }   
}
