import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*; //Für Listen --- For Lists
/**
 * Player Klasse, die Hauptfigure die der Spieler benutzt.
 * Player Class, Maincharacter that the player uses.
 * 
 * @author Sandro Filisetti
 * @version V4.0
 */
public class Player  extends Actor
{
    /**
     * Act wird ausgeführt wenn das Spiel läuft oder der Act Knopf gedrückt wird
     * Act will be used if the game is running or the Act button is pressed
     */  
    private int ShootTimer = 0;
    
    public void act() 
    {
       List bullets = getNeighbours(3, false, Enemybullet.class); //new list with all Pbullets within 2 uinits adjacent to the enemy
       if (!bullets.isEmpty()) { //Nur eine Kugel auf dem Bildschirm --- Makes sure only 1 Bullet is on Screen
       Actor b = (Actor) bullets.get(0); //Nimmt erstes Objekt in derliste --- Takes first Object in the List
       if (b instanceof Enemybullet) { //Checkt ob ws wirklich eine Spielerkugel ist --- Checks if its really a Playerbullet
           getWorld().removeObject(b); //Lässt Kugel verschwinden wenn sie das Ende der Welt erreicht --- Makes Bullet go away when it reaches edge of the World
           destroy(); //Destroy funktion wird hier benutzt --- Uses Destroy funcition
       }
       } else {
        processKeys();
       }
    }    
    
    /**
     * Hier werden die Tasteneingaben verarbeitet --- Here the Keyinputs get processed
     */
    private void processKeys() {
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
            getWorld().addObject(new Playerbullet(), getX(), getY()-5);
            ((Space) getWorld()).ShootSet(0);
            Greenfoot.playSound("shoot.wav");
        }   
    }

    private void destroy() {
        getWorld().addObject(new Playerdie(), getX(), getY());
        ((Space) getWorld()).ShootSet(0);
        Greenfoot.playSound("explosion.wav");
        getWorld().removeObject(this);
    }
}
