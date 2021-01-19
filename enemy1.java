import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*; //list, iterator classes
/**
 * Basis der Enemy Klasse, hat Bewegungen, schiessen und weiters Drinnen
 * Base of the Enemy Class, includes but isn't limited to Movement and shooting
 * @author Sandro Filisetti
 * @version V4.0
 */
public class Enemy1  extends Actor
{
    public int dir = 1; //1 = links 2 = Rechts
    public int movetimer = 0; 
    public int shouldMove = 0; 
    public int shouldCar = 0;   
    public GreenfootImage img1;    
    public GreenfootImage img2;     
    public int shoot; 
    public int chance = 1; 
    
    public Enemy1()
    {
        img1 = getImage();
        img2 = new GreenfootImage("enemy1-2.gif"); 
    }
    
    public void act() 
    {
       List bullets = getNeighbours(3, false, Playerbullet.class); 
       if (!bullets.isEmpty()) {
       Actor b = (Actor) bullets.get(0); 
       if (b instanceof Playerbullet) { 
           ((Space) getWorld()).ShootSet(1); 
           getWorld().removeObject(b); 
           destroy(); 
       }
       } else {
           shoot();
           move();
       }
    }
    
    public void destroy() 
    {
        Greenfoot.playSound("invaderkilled.wav"); 
        ((Space) getWorld()).addPoints(10); 
        ((Space) getWorld()).invaders--;
        if (((Space)getWorld()).invaders <= 0) {
            ((Space) getWorld()).populate();
            ((Space)getWorld()).invaders = 50;
        }
        getWorld().removeObject(this); 
    }
    
    public void shoot()
    {
        if (shouldMove == 1) {
            shoot = Greenfoot.getRandomNumber(100);
            if (shoot <= chance) {
                getWorld().addObject(new Enemybullet(), getX(), getY()+5);
            }
        }
    }
        
        
    
    public void move() 
    {
        if (dir == 1 && shouldCar == 1) {
            if (getX() + 5 >= getWorld().getWidth()) { 
                carridgeRight(); 
                carridgeAlliesRight(); 
                movetimer = 0; 
                shouldMove = 0;
            }
        } else if (dir == 2 && shouldCar == 1) {
            if (getX() - 5 <= 0) {
                carridgeLeft();
                carridgeAlliesLeft();
                movetimer = 0;
                shouldMove = 0;
            }
        }
        if (dir == 1 && shouldMove == 1) { 
            if (getImage() == img1) { 
                setImage(img2); 
            } else {
                setImage(img1);
            }
            setLocation(getX()+5, getY()); 
            shouldMove = 0; 
        } else if (dir == 2 && shouldMove == 1) {
            if (getImage() == img1) {
                setImage(img2);
            } else {
                setImage(img1);
            }
            setLocation(getX()-5, getY()); 
            shouldMove = 0;
        } else if (shouldMove == 0) { 
            movetimer++; 
            if (movetimer == 24) {
                shouldCar = 1; 
            } else if (movetimer == 25) {
                shouldMove = 1; 
                shouldCar = 0;
                movetimer = 0;
            }
        }
    }
    
    private void carridgeRight() 
    {
        setLocation(getX(), getY() + 5); 
        dir = 2;
        chance = chance+1;
        if (getY() > 60) {
            ((Space) getWorld()).gameOver();
        }
    }
    
    private void carridgeLeft()
    {
        setLocation(getX(), getY() + 5);
        dir = 1;
        chance = chance+1;
    }
    
    private void carridgeAlliesRight()
    {
        List allies = getWorld().getObjects(Enemy1.class);
        Iterator i = allies.iterator();
        while(i.hasNext()) {
            Enemy1 a = (Enemy1) i.next();
            if ( a != this) {
                a.carridgeRight();
                a.setLocation(a.getX(), a.getY());
                a.shouldMove = 0;
                a.movetimer = 0;
                if (getImage() != a.getImage()) {
                    setImage(a.getImage());
                }
            }
        }
    }
    
    private void carridgeAlliesLeft()
    {
        List allies = getWorld().getObjects(Enemy1.class);
        Iterator i = allies.iterator();
        while(i.hasNext()) {
            Enemy1 a = (Enemy1) i.next();
            if ( a != this) {
                a.carridgeLeft();
                a.setLocation(a.getX(), a.getY());
                a.shouldMove = 0;
                a.movetimer = 0;
                if (getImage() != a.getImage()) {
                    setImage(a.getImage());
                }
            }
        }
    }
}
