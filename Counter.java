import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Global counter to ease on performance
 */
public class Counter extends Actor
{
    public static int i = 0;
    public Counter()
    {
        i = 0;
    }
    public void act() 
    {
        i++;
        if (i == 999999999)
        {
            i = 0;
        }
    }    
}
