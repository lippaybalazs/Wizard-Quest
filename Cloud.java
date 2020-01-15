import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * visuals
 */
public class Cloud extends Actor
{
    int knX = 0;
    int knY = 0;
    public void act() 
    {
        if(getX() + knX > Wizard.posX)
        {
            setLocation(getX() - 1 - (int)((getX() + knX - Wizard.posX) / 2.5), getY() - (int)((getY() - 50 + knY- Wizard.posY) / 5));
        }
        if(getX() + knX < Wizard.posX)
        {
            setLocation(getX() + 1 - (int)((getX() + knX - Wizard.posX) / 2.5), getY() - (int)((getY() - 50 + knY- Wizard.posY) / 5));
        }
        if(getY() - 50 + knY > Wizard.posY)
        {
            setLocation(getX() - (int)((getX() + knX - Wizard.posX) / 2.5), getY() - 1 - (int)((getY() - 50 + knY- Wizard.posY) / 2));
        }
        if(getY() - 50 + knY < Wizard.posY)
        {
            setLocation(getX() - (int)((getX() + knX - Wizard.posX) / 2.5), getY() + 1 - (int)((getY() - 50 + knY- Wizard.posY) / 2));
        }
        if (Counter.i % 2 ==0)
        {
            getWorld().addObject(new spellshadow(2), getX(), getY() + 30);
        }
    }    
}
