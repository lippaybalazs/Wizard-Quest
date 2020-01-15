import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class Shrapnel extends Actor
{
    double x;
    double y;
    int type;
    int i = 250;
    GreenfootImage img;
    public Shrapnel(double a, double b, int c)
    {
        x = a;
        type = c;
        y = b + 10;
    }
    public void act() 
    {
        if (i == 250)
        {
            switch(type)
            {
                case 0 :
                    img = new GreenfootImage("shrapnel.png");
                    break;
                case 1 :
                    img = new GreenfootImage("watershrap.png");
                    break;
                case 2 :
                    img = new GreenfootImage("rockshrap.png");
                    break;
                case 3 :
                    img = new GreenfootImage("fireshrap.png");
                    break;
                case 4 :
                    img = new GreenfootImage("windshrap.png");
                    break;
            }
            setImage(img);
        }
        setLocation((int)(getX() + x), (int)(getY() - y / 2));
        img.setTransparency(i);
        if (i > 10)
        {
            i -= 7;
        }
        x /= 1.5;
        y --;
        if (getY() > 750)
        {
            getWorld().removeObject(this);
        }
    }    
}
