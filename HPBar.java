import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * visuals
 */
public class HPBar extends Actor
{
    int type;
    public HPBar(int x)
    {
        type = x;
        switch(x)
        {
            case 0 :
                setImage(new GreenfootImage("HP-.png"));
                break;
            case 1 :
                setImage(new GreenfootImage("Shield-.png"));
                break;
            case 2 :
                setImage(new GreenfootImage("resourcebar.png"));
                break;
            case 3 :
                setImage(new GreenfootImage("ultbar.png"));
                break;
            case 4 :
                setImage(new GreenfootImage("BossHPBar.png"));
                break;
            case 5 :
                setImage(new GreenfootImage("impossiblebar.png"));
                break;
        }
    }
    public void act() 
    {
        if (Level.BossHP <= 0 && type == 4)
        {
            getWorld().removeObject(this);
        }
    }    
}
