import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author SaF
 * @version 1.0
 */
public class Space extends World
{
public int shot = 1;
    /**
     * 
     */
    public Space()
    {    
        super(100, 100, 5); 
        addObject(new Player(), 50, 90);
        populate();
    }
    public void populate()
    {
        /** Erstellt 5 Reihen an Gegnern */
        Enemy1[] enemies1 = new Enemy1[10];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new Enemy1();
            addObject(enemies1[i], (i*5)+5, 20);
        }
        
        Enemy1[] enemies2 = new Enemy1[20];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new Enemy1();
            addObject(enemies1[i], (i*5)+5, 15);
        }
        Enemy2[] enemies4 = new Enemy2[20];
        for ( int i = 0; i <10; i++ ) {
            enemies1[i] = new Enemy2();
            addObject(enemies1[i], (i*5)+5, 10);
        }
    }
    
        public boolean CanShoot()
    {
        if (shot == 1) {
            return true;
        } else {
            return false;
        }
    }
        public void ShootSet(int arg)
    {
        shot = arg;
    }
    
}
