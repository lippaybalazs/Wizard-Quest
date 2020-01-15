import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * determines if there are any monsters on the screen
 */
public class CheckMonsters extends Actor
{
    public static int MonsterCount;
    public void act() 
    {
        MonsterCount = getIntersectingObjects(Monster.class).size();
    }   
}
