import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class WizLeft extends Actor
{
    static int i = 0;
    static int knX;
    static int knY;
    static int rot;
    public void act() 
    {
        if (i != 0)
        {
            setLocation(Wizard.posX - knX - 27, Wizard.posY - knY + 37);
            i--;
            if (i == 0)
            {
                rot = 0;
            }
        }
        else
        {
            if (knX != 0)
            {
                if (knX > 0)
                {
                    knX--;
                }
                else
                {
                    knX++;
                }
            }
            if (knY != 0)
            {
                if (knY > 0)
                {
                    knY--;
                }
                else
                {
                    knY++;
                }
            }
            if(getX() + knX + rot / 5 > Wizard.posX - 27)
            {
                setLocation(getX() - 1 - (int)((getX() + rot / 5 + knX - Wizard.posX + 27) / 3), getY() - (int)((getY() + knY- Wizard.posY - 37) / 3));
            }
            if(getX() + knX + rot / 5 < Wizard.posX - 27)
            {
                setLocation(getX() + 1 - (int)((getX() + rot / 5 + knX - Wizard.posX + 27) / 3), getY() - (int)((getY() + knY- Wizard.posY - 37) / 3));
            }
            if(getY() + knY > Wizard.posY + 37)
            {
                setLocation(getX() - (int)((getX() + rot / 5 + knX - Wizard.posX + 27) / 3), getY() - 1 - (int)((getY() + knY- Wizard.posY - 37) / 3));
            }
            if(getY() + knY < Wizard.posY + 37)
            {
                setLocation(getX() - (int)((getX() + rot / 5 + knX - Wizard.posX + 27) / 3), getY() + 1 - (int)((getY() + knY- Wizard.posY - 37) / 3));
            }
        }
        setRotation(rot);
    }    
    public static void Cast(int t, int x, int y, int r)
    {
        i = t;
        knX = -x;
        knY = -y;
        rot = r;
    }
}
