import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossDead extends Actor
{
    int type;
    int i = 0;
    GreenfootImage img;
    public BossDead(int x, GreenfootImage im)
    {
        type = x;
        img = im;
        if (img == null)
        {
            img = new GreenfootImage("Blank.png");
        }
        setImage(img);
    }
    public void act() 
    {
        if (i <= 750 && i % 10 == 1)
        {
            setLocation(getX() + 1, getY() - 1);
        }
        if (i <= 750 && i % 10 == 0)
        {
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), getX() + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(150), getY() + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(150));
        }
        if (i >= 500 && i <= 750)
        {
            img.setTransparency(249 - i % 250);
            setImage(img);
        }
        if (i == 750)
        {
            setLocation(640,360);
            switch ((int)(Level.diff * 10)) // displays the hidden code to the next level
            {
                case 10 :
                    getWorld().addObject(new Code(3), 256, 500);
                    getWorld().addObject(new Code(2), 512, 500);
                    getWorld().addObject(new Code(1), 768, 500);
                    getWorld().addObject(new Code(0), 1024, 500);
                    break;
                case 11 :
                    getWorld().addObject(new Code(3), 256, 500);
                    getWorld().addObject(new Code(0), 512, 500);
                    getWorld().addObject(new Code(2), 768, 500);
                    getWorld().addObject(new Code(1), 1024, 500);
                    break;
                case 12 :
                    getWorld().addObject(new Code(1), 256, 500);
                    getWorld().addObject(new Code(2), 512, 500);
                    getWorld().addObject(new Code(0), 768, 500);
                    getWorld().addObject(new Code(3), 1024, 500);
                    break;
                case 13 :
                    getWorld().addObject(new Code(2), 256, 500);
                    getWorld().addObject(new Code(2), 512, 500);
                    getWorld().addObject(new Code(0), 768, 500);
                    getWorld().addObject(new Code(1), 1024, 500);
                    break;
                case 14 :
                    getWorld().addObject(new Code(0), 256, 500);
                    getWorld().addObject(new Code(1), 512, 500);
                    getWorld().addObject(new Code(1), 768, 500);
                    getWorld().addObject(new Code(0), 1024, 500);
                    break;
                case 15 :
                    getWorld().addObject(new Code(3), 256, 500);
                    getWorld().addObject(new Code(0), 512, 500);
                    getWorld().addObject(new Code(1), 768, 500);
                    getWorld().addObject(new Code(3), 1024, 500);
                    break;
            }
            if ((int)(Level.diff * 10) == 17)
            {
                setImage(new GreenfootImage("Menu/Finish.png"));
            }
            else
            {
                setImage(new GreenfootImage("Menu/StageClear.png"));
            }
        }
        if (i >= 1500)
        {
            if ((int)(Level.diff * 10) != 17)
            {
                Greenfoot.setWorld(new Level(Level.diff + 0.1, Level.difficulty, Level.impossible));
            }
            else
            {
                Greenfoot.setWorld(new Menu());
            }
        }
        i++;
    }    
}
