import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class WizRight extends Actor
{
    static int i = 0;
    static int knX = 0;
    static int knY = 0;
    static int rot = 0;
    public void act() 
    {
        if (i != 0)
        {
            setLocation(Wizard.posX - knX + 23, Wizard.posY - knY + 30);
            i--;
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
            if(getX() + knX + rot / 5 > Wizard.posX + 23)
            {
                setLocation(getX() - 1 - (int)((getX() + rot / 5 + knX - Wizard.posX - 23) / 3), getY() - (int)((getY() + knY- Wizard.posY - 30) / 3));
            }
            if(getX() + knX + rot / 5 < Wizard.posX + 23)
            {
                setLocation(getX() + 1 - (int)((getX() + rot / 5 + knX - Wizard.posX -23) / 3), getY() - (int)((getY() + knY- Wizard.posY - 30) / 3));
            }
            if(getY() + knY > Wizard.posY + 30)
            {
                setLocation(getX() - (int)((getX() + rot / 5 + knX - Wizard.posX - 23) / 3), getY() - 1 - (int)((getY() + knY- Wizard.posY - 30) / 3));
            }
            if(getY() + knY < Wizard.posY + 30)
            {
                setLocation(getX() - (int)((getX() + rot / 5 + knX - Wizard.posX - 23) / 3), getY() + 1 - (int)((getY() + knY- Wizard.posY - 30) / 3));
            }
            if (rot != 0)
            {
                rot += 1;
                if (rot == 360)
                {
                    rot = 0;
                }
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
