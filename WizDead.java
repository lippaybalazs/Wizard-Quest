import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hard coded game over scene
 */
public class WizDead extends Actor
{
    int type;
    int i = 0;
    GreenfootImage img;
    public WizDead()
    {
        
    }
    public void act() 
    {
        WizHead.knX += (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10);
        WizHead.knY += (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10);
        if (i <= 750 && i % 10 == 0)
        {
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), Wizard.posX + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50), Wizard.posY + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50));
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), Wizard.posX + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50), Wizard.posY + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50));
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), Wizard.posX + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50), Wizard.posY + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(50));
        }
        if (i == 501)
        {
            setLocation(640,360);
            setImage(new GreenfootImage("Menu/GameOver.png"));
        }
        if (i >= 750)
        {
            Wizard.HP = 100;
            Wizard.Shield = 100;
            Greenfoot.setWorld(new Menu());
        }
        i++;
    }    
}
