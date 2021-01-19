import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * die Playerdie Klasse wird genutzt um zu zeigen was passiert wenn der Spieler getroffen wird.
 * The Playerdie Class will be used to show what happens if the Player gets hit
 * 
 * @author Sandro Filisetti 
 * @version V4.0
 */
public class Playerdie  extends Actor
{
    private int deathtimer = 0; //timer to remove object
    
    private GreenfootImage img1; //1st animation
    
    private GreenfootImage img2; //2nd animation
    
    public Playerdie() //creation code, sets two variables with the two images
    {
        img1 = getImage(); //current image
        img2 = new GreenfootImage("shipdie-2.gif"); //second image
    }

    public void act() 
    {
        deathtimer++;
        if (deathtimer > 20) {
            ((Space) getWorld()).die();
            getWorld().removeObject(this);
        } else {
            if (getImage() == img1) {
                setImage(img2);
            } else {
                setImage(img1);
            }
        }
            
    }    
}
