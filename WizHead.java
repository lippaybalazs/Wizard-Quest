import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class WizHead extends Actor
{
    public static double knX = 0;
    public static double knY = 0;
    public void act() 
    {
        if(getX() + knX > Wizard.posX)
        {
            setLocation(getX() - 1 - (int)((getX() + knX - Wizard.posX) / 2), getY() - (int)((getY() + knY- Wizard.posY) / 3));
        }
        if(getX() + knX < Wizard.posX)
        {
            setLocation(getX() + 1 - (int)((getX() + knX - Wizard.posX) / 2), getY() - (int)((getY() + knY- Wizard.posY) / 3));
        }
        if(getY() + knY > Wizard.posY)
        {
            setLocation(getX() - (int)((getX() + knX - Wizard.posX) / 2), getY() - 1 - (int)((getY() + knY- Wizard.posY) / 3));
        }
        if(getY() + knY < Wizard.posY)
        {
            setLocation(getX() - (int)((getX() + knX - Wizard.posX) / 2), getY() + 1 - (int)((getY() + knY- Wizard.posY) / 5));
        }
        if (knX != 0)
        {
            knX /= 2;
            if (knX * knX < 1)
            {
                knX = 0;
            }
        }
        if (knY != 0)
        {
            knY /= 2;
            if (knY * knY < 1)
            {
                knY = 0;
            }
        }
    }    
}
