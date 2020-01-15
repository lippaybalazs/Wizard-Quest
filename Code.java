import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class Code extends Actor
{
    public Code(int x)
    {
        switch (x)
        {
            case 0 :
                setImage(new GreenfootImage("SelectFire.png"));
                break;
            case 1 :
                setImage(new GreenfootImage("SelectWater.png"));
                break;
            case 2 :
                setImage(new GreenfootImage("SelectEarth.png"));
                break;
            case 3 :
                setImage(new GreenfootImage("SelectWind.png"));
                break;
        }
    }
    public void act() 
    {
        
    }    
}
