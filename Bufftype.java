import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Abbilities that mostly follow the character
 */
public class Bufftype extends Actor
{
    public int type;
    int i = 0;
    GreenfootImage img;
    GreenfootSound sound;
    public Bufftype(int x)
    {
        type = x;
        switch (type)
        {
            case 0 :
                img = new GreenfootImage("Firetornado.png");
                sound = new GreenfootSound("FireTornado.wav");
                sound.setVolume(70);
                sound.play();
                WizHead.knX = Greenfoot.getRandomNumber(10);
                WizHead.knY = Greenfoot.getRandomNumber(10);
                WizRight.Cast(10, 25, -20, -45);
                WizLeft.Cast(10, -15, -20, 0);
                i = 0;
                break;
            case 1 :
                img = new GreenfootImage("Regen.png");
                sound = new GreenfootSound("LesserHeal.wav");
                sound.setVolume(70);
                sound.play();
                WizRight.Cast(10, 25, -20, -45);
                WizLeft.Cast(10, -15, -20, 0);
                i = 0;
                break;
            case 2 :
                img = new GreenfootImage("Earthshield.png");
                sound = new GreenfootSound("EarthShield.wav");
                sound.setVolume(70);
                sound.play();
                WizHead.knX = Greenfoot.getRandomNumber(10);
                WizHead.knY = Greenfoot.getRandomNumber(10);
                WizRight.Cast(50, 25, -20, -45);
                WizLeft.Cast(50, -15, -20, 0);
                i = 0;
                break;
            case 3 :
                img = new GreenfootImage("Recover.png");
                sound = new GreenfootSound("GreaterHeal.wav");
                sound.setVolume(70);
                sound.play();
                WizHead.knX = Greenfoot.getRandomNumber(10);
                WizHead.knY = Greenfoot.getRandomNumber(10);
                WizRight.Cast(50, 25, -20, -45);
                WizLeft.Cast(50, -15, -20, 0);
                i = 0;
                break;
            case 4 :
                img = new GreenfootImage("Blank.png");
                sound = new GreenfootSound("FlameThrower.wav");
                sound.setVolume(70);
                sound.play();
                WizHead.knX = Greenfoot.getRandomNumber(10);
                WizHead.knY = Greenfoot.getRandomNumber(10);
                WizRight.Cast(100, 25, -30, -45);
                WizLeft.Cast(100, -15, -20, 0);
                i = 0;
                break;
        }
    }
    public void act() 
    {
        switch(type)
        {
            case 0 :
                Firetornado();
                break;
            case 1 :
                Lifespring();
                break;
            case 2 :
                Earthshield();
                break;
            case 3 :
                Lifebloom();
                break;
            case 4 :
                Flamethorwer();
                break;
        }
    }
    void Flamethorwer()
    {
        setLocation(Wizard.posX + 50, Wizard.posY);
        setImage(img);
        if (Counter.i % 15 == 0)
        {
            if (Greenfoot.getRandomNumber(10) % 2 == 0)
            {
                sound = new GreenfootSound("FlameThrower.wav");
            }
            else
            {
                sound = new GreenfootSound("FireBall.wav");
            }
            sound.setVolume(70);
            sound.play();
        }
        if ( Counter.i % 4 == 0)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
        }
        getWorld().addObject(new ProjSpell(7), 0, 0);
        i += 5;
        if (i >= 500)
        {
            getWorld().removeObject(this);
        }
    }
    void Lifebloom()
    {
        setLocation(Wizard.posX, Wizard.posY);
        setImage(img);
        if (Counter.i % 2 == 0)
        {
            setRotation(Counter.i % 120 * 3);
        }
        if (i % 50 == 0)
        {
            Wizard.Damage(-1);
            Wizard.Shield += 1;
            if (Wizard.Shield > 100)
            {
                Wizard.Shield = 100;
            }
        }
        if (i >= 250)
        {
            img.setTransparency(249 - i % 250);
        }
        else
        {
            img.setTransparency(i % 250 + 1);
        }
        i += 5;
        if (i >= 490)
        {
            getWorld().removeObject(this);
        }
    }
    void Earthshield()
    {
        setLocation(Wizard.posX, Wizard.posY);
        setImage(img);
        if (Counter.i % 2 == 0)
        {
            setRotation(Counter.i % 120 * 3);
        }
        if (i % 50 == 0)
        {
            Wizard.Shield += 10;
            if (Wizard.Shield > 100)
            {
                Wizard.Shield = 100;
            }
        }
        if (i >= 490)
        {
            getWorld().removeObject(this);
        }
        i += 5;
        if (i >= 250)
        {
            img.setTransparency(249 - i % 250);
        }
        else
        {
            img.setTransparency(i % 250 + 1);
        }
    }
    void Lifespring()
    {
        setLocation(Wizard.posX, Wizard.posY);
        img.setTransparency(i % 250 + 1);
        setImage(img);
        sound.play();
        if (Counter.i % 2 == 0)
        {
            setRotation(-Counter.i % 60 * 6);
        }
        if (i % 100 == 0)
        {
            Wizard.Damage(-1);
        }
        i += 5;
        List<Bufftype> hit2 = getIntersectingObjects(Bufftype.class);
        if(hit2 != null)
        {    
            for (int k = 0; k < hit2.size(); k++)
            {
                if (hit2.get(k).type == type)
                {
                    getWorld().removeObject(hit2.get(k));
                }
            }
        }
        if (i % 250 >= 125)
        {
            img.setTransparency(249 - i % 125 * 2);
        }
        else
        {
            img.setTransparency(i % 125 * 2 + 1);
        }
        if (i >= 2500)
        {
            getWorld().removeObject(this);
        }
    }
    void Firetornado()
    {
        if (Counter.i % 2 == 0)
        {
            sound.play();
        }
        setLocation(Wizard.posX, Wizard.posY);
        setImage(img);
        Wizard.immune = true;
        if (Counter.i % 2 == 0)
        {
            setRotation(-Counter.i % 30 * 12);
        }
        List<Monster> hit2 = getIntersectingObjects(Monster.class);
        if(hit2 != null)
        {
            for (int k = 0; k < hit2.size(); k++)
            {
                if (!hit2.get(k).burn)
                {
                    hit2.get(k).Damage(5,0,0,0);
                    hit2.get(k).Burning(5);
                }
            }
        }
        if (i <= 250)
        {
            img.setTransparency(i);
        }
        if (i >= 2250)
        {
            img.setTransparency(249 - i % 250);
        }
        i += 5;
        if (i >= 2490)
        {
            Wizard.immune = false;
            getWorld().removeObject(this);
        }
    }
}
