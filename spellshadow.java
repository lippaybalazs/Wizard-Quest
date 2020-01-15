import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * visuals
 */
public class spellshadow extends Actor
{
    int type = 0;
    int opacity = 200;
    GreenfootImage img;
    public spellshadow(int x)
    {
        type = x;
        switch(x)
        {
            case 0 :
                img = new GreenfootImage("Projectileshadow.png");
                break;
            case 1 :
                img = new GreenfootImage("FireShadow.png");
                break;
            case 2 :
                img = new GreenfootImage("wizardshadow.png");
                break;
            case 3 :
                img = new GreenfootImage("watershadow.png");
                break;
            case 4 :
                img = new GreenfootImage("Meteor.png");
                break;
        }
    }
    public void act() 
    {
        img.setTransparency(opacity);
        setImage(img);   
        opacity -= 15;
        if (opacity <= 0)
        {
            getWorld().removeObject(this);
        }
    }    
}
