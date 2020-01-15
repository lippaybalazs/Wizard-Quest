import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Code speaks for itself here, nothing to comment on
 */
public class BeamSpell extends Actor
{
    int type;
    int i;
    GreenfootImage img;
    GreenfootSound sound;
    public BeamSpell( int x)
    {
        type = x;
        switch (type)
        {
            case 0 :
                img = new GreenfootImage("Flashbomb.png");
                sound = new GreenfootSound("Flash.wav");
                sound.setVolume(70);
                sound.play();
                WizRight.Cast(260, 0, -50, -60);
                i = 250;
                break;
            case 1 :
                img = new GreenfootImage("Kineticbeam0.png");
                sound = new GreenfootSound("KineticBeam.wav");
                sound.setVolume(70);
                sound.play();
                WizRight.Cast(50, 25, -30, -45);
                WizLeft.Cast(50, -15, -20, 0);
                i = 325;
                break;
            case 2 :
                img = new GreenfootImage("Thunderstrike1.png");
                sound = new GreenfootSound("Thunder.wav");
                sound.setVolume(80);
                sound.play();
                WizRight.Cast(50, 25, -30, -45);
                i = 750;
                break;
            case 3 :
                img = new GreenfootImage("steamexplotrack.png");
                WizRight.Cast(50, 25, -30, -45);
                WizLeft.Cast(50, -15, -20, 0);
                i = 1;
                break;
            case 4 :
                img = new GreenfootImage("Lightning.png");
                sound = new GreenfootSound("Lightning.wav");
                sound.setVolume(50);
                sound.play();
                WizRight.Cast(50, 25, -30, -45);
                WizLeft.Cast(50, -15, -20, 0);
                i = 250;
                break;
            case 5 :
                img = new GreenfootImage("Meteor.png");
                sound = new GreenfootSound("Meteor.wav");
                sound.setVolume(60);
                sound.play();
                WizRight.Cast(150, 15, -50, 0);
                WizLeft.Cast(150, 15, -50, 0);
                i = 0;
                break;
            case 6 :
                img = new GreenfootImage("Rockpillar.png");
                sound = new GreenfootSound("Rock.wav");
                sound.setVolume(70);
                sound.play();
                WizRight.Cast(100, 25, -30, -45);
                i = 0;
                break;
            case 7 :
                img = new GreenfootImage("Incinerate.png");
                sound = new GreenfootSound("Incinerate.wav");
                sound.setVolume(70);
                sound.play();
                WizRight.Cast(50, 25, -50, -45);
                WizLeft.Cast(50, -15, -50, 0);
                i = 250;
                break;
        }
    }
    public void act() 
    {
        switch (type)
        {
            case 0 :
                Flashbomb();
                break;
            case 1 :
                Kineticbeam();
                break;
            case 2 :
                Thunderstrike();
                break;
            case 3 :
                Steamexplosion();
                break;
            case 4 :
                Lightning();
                break;
            case 5 :
                Meteor();
                break;
            case 6 :
                Rockpillar();
                break;
            case 7 :
                Incinerate();
                break;
        }
    }   
    void Incinerate()
    {
        if (i == 250)
        {
            setLocation(Wizard.posX, Wizard.posY);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            setImage(img);
        }
        if (i == 244)
        {
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            if(hit2 != null)
            {
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k).i == 0)
                    {
                        getWorld().addObject(new explosion(1), hit2.get(k).getX(), hit2.get(k).getY());
                        hit2.get(k).Damage(1,0,0,2);
                        hit2.get(k).Burning(2);
                        if(hit2.get(k).getX() < getX())
                        {
                            hit2.get(k).knockbackx = -20;
                        }
                        else
                        {
                            hit2.get(k).knockbackx = 20;
                        }
                        if(hit2.get(k).getY() < getY())
                        {
                            hit2.get(k).knockbacky = -10;
                        }
                        else
                        {
                            hit2.get(k).knockbacky = 10;
                        }
                        hit2.get(k).i = 50;
                    }
                }
            }
        }
        img.setTransparency(i);
        setImage(img);
        i -= 3;
        if (i <= 0)
        {
            getWorld().removeObject(this);
        }
    }
    void Rockpillar()
    {
        if (i == 0)
        {   
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            setLocation(Wizard.posX + 100, Wizard.posY);
        }
        if (i < 75 && i % 5 == 0)
        {
            img.setTransparency(i * 3 + 25);
            setImage(img);
            getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX(), getY() + Greenfoot.getRandomNumber(100));
        }
        List<Projectile> hit1 = getIntersectingObjects(Projectile.class);
        if(hit1 != null)
        {
            for (int k = 0; k < hit1.size(); k++)
            {
                getWorld().addObject(new explosion(0), hit1.get(k).getX(), hit1.get(k).getY());
                getWorld().removeObject(hit1.get(k));
                i += 10 + hit1.get(k).damage;
                if (hit1.get(k).damage >= 50)
                {
                    i = 600;
                }
            }
        }
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (hit != null)
        {   
            if (!hit.boss)
            {
                for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
                {
                    getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), hit.getX() - 25, hit.getY());
                }
                hit.Damage(0,0,0,6);
            }
            i = 600;
        }
        if (i > 500)
        {
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX(), getY() + Greenfoot.getRandomNumber(100));
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX(), getY());
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX(), getY() - Greenfoot.getRandomNumber(100));
            }
            getWorld().removeObject(this);
        }
        i++;
    }
    void Meteor()
    {
        if (i == 0)
        {
            setLocation(-250,50);
            setImage(img);
        }
        if (Counter.i % 20 == 0)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
        }
        if (i >= 0)
        {
            setLocation(i -50, (int)((double)(i * i * 0.0008 - 350)));
            if (i % 25 == 0)
            {
                getWorld().addObject(new spellshadow(4), getX(), getY());
            }
            if (getY() >= 360)
            {
                List<Monster> hit2 = getObjectsInRange(2000, Monster.class);
                for (int k = 0; k < hit2.size(); k++)
                {
                    hit2.get(k).Damage(5,5,5,5);
                }
                img.setTransparency(0);
                setImage(img);
                getWorld().addObject(new BeamSpell(0), 600, 300);
                i = -9;
            }
            i += 5;
        }
        else
        {
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            getWorld().addObject(new explosion(Greenfoot.getRandomNumber(8) % 6), Greenfoot.getRandomNumber(1280), Greenfoot.getRandomNumber(720));
            if (i % 30 == 0)
            {
                getWorld().addObject(new explosion(5), getX(), getY());
            }
            if (i % 50 == 0)
            {
                getWorld().addObject(new BeamSpell(0), 600, 300);
            }
            if (i == -100)
            {
                getWorld().removeObject(this);
            }
            i--;
        }
    }
    void Lightning()
    {
        if (i == 250)
        {
            setImage(img);
        }
        setLocation(Wizard.posX + 172, Wizard.posY + 15);
        if (i == 240)
        {
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            if(hit2 != null)
            {
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k).i == 0)
                    {
                        getWorld().addObject(new explosion(6), hit2.get(k).getX(), hit2.get(k).getY());
                        hit2.get(k).knockbackx = 30;
                        hit2.get(k).Damage(0,0,0,3);
                        if(hit2.get(k).getY() < getY())
                        {
                            hit2.get(k).knockbacky = -15;
                        }
                        else
                        {
                            hit2.get(k).knockbacky = 15;
                        }
                        hit2.get(k).i = 50;
                    }
                }
            }
        }
        img.setTransparency(i);
        setImage(img);
        i -= 10;
        if (i == 0)
        {
            getWorld().removeObject(this);
        }
    }
    void Steamexplosion()
    {
        if (i == 1)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            setLocation(Wizard.posX + 50, Wizard.posY);
            setImage(img);
            i--;
        }
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (hit != null)
        {
            List<Monster> hit2 = getObjectsInRange(200, Monster.class);
            getWorld().addObject(new explosion(5), getX(), getY());
            for (int k = 0; k < hit2.size(); k++)
            {
                if (hit2.get(k).burn && hit2.get(k).type != 99)
                {
                    hit2.get(k).Damage(0,4,0,0);
                    for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
                    {
                        getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),1), hit2.get(k).getX() + 25, hit2.get(k).getY());
                    }
                    hit2.get(k).burn = false;
                    }
                    else
                    {
                        hit2.get(k).Damage(0,2,0,0);
                    }
                hit2.get(k).Burning(2);
            }
        }
        setLocation(getX() + 50, getY());
        if (getX() > 1500 || hit != null)
        {
            getWorld().removeObject(this);
        }
    }
    void Thunderstrike()
    {
        setLocation(Wizard.posX + 200, Wizard.posY);
        setImage(img);
        if (i == 500)
        {
            img = new GreenfootImage("Thunderstrike2.png");
            sound = new GreenfootSound("Thunder.wav");
            sound.play();
        }
        if (i == 250)
        {
            img = new GreenfootImage("Thunderstrike3.png");
            sound = new GreenfootSound("Thunder.wav");
            sound.setVolume(80);
            sound.play();
        }
        if (i % 250 == 0)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            if(hit2 != null)
            {
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k).i == 0)
                    {
                        getWorld().addObject(new explosion(6), hit2.get(k).getX(), hit2.get(k).getY());
                        hit2.get(k).knockbackx = 10;
                        hit2.get(k).Stunned(100);
                        hit2.get(k).Damage(0,0,1,2);
                        if(hit2.get(k).getY() < getY())
                        {
                            hit2.get(k).knockbacky = -5;
                        }
                        else
                        {
                            hit2.get(k).knockbacky = 5;
                        }
                        hit2.get(k).i = 20;                 
                    }
                }
            }
        }
        img.setTransparency(i % 250 + 1);
        i -= 10;
        if (i == 0)
        {
            getWorld().removeObject(this);
        }
    }
    void Kineticbeam()
    {
        if (i == 325)
        {
            setImage(img);
        }
        setLocation(Wizard.posX + 700, Wizard.posY);
        if (i > 275)
        {
            img.setTransparency((325 - i) * 2);
            setImage(img);
        }
        if (i == 275)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            setImage(new GreenfootImage("Kineticbeam1.png"));
        }
        if (i == 265)
        {
            setImage(new GreenfootImage("Kineticbeam2.png"));
        }
        if (i == 255)
        {
            img = new GreenfootImage("Kineticbeam3.png");
        }
        {
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            if(hit2 != null)
            {
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k).i == 0)
                    {
                        if (hit2.get(k).burn && hit2.get(k).type != 99)
                        {
                            hit2.get(k).Damage(0,2,0,0);
                            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
                            {
                                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),1), hit2.get(k).getX() + 25, hit2.get(k).getY());
                            }
                            hit2.get(k).burn = false;
                        }
                        else
                        {
                            hit2.get(k).Damage(0,1,0,0);
                        }
                        hit2.get(k).knockbackx = 10;
                        hit2.get(k).Damage(0,0,0,2);
                        if(hit2.get(k).getY() < getY())
                        {
                            hit2.get(k).knockbacky = -5;
                        }
                        else
                        {
                            hit2.get(k).knockbacky = 5;
                        }
                        hit2.get(k).i = 70;
                    }
                }
            }
        }
        if (i < 250)
        {
            img.setTransparency(i);
            setImage(img);
        }
        i -= 5;
        if (i == 0)
        {
            getWorld().removeObject(this);
        }
    }
    void Flashbomb()
    {
        List<Projectile> hit1 = getIntersectingObjects(Projectile.class);
        if(hit1 != null)
        {
            for (int k = 0; k < hit1.size(); k++)
            {
                getWorld().removeObject(hit1.get(k));
            }
        }
        List<Monster> hit2 = getIntersectingObjects(Monster.class);
        if(hit2 != null)
        {
            for (int k = 0; k < hit2.size(); k++)
            {
                hit2.get(k).Stunned(50);
                if (!hit2.get(k).burn && hit2.get(k).type != 99)
                {
                    hit2.get(k).Burning(1);
                }
            }
        }
        img.setTransparency(i);
        setImage(img);
        i -= 1;
        if (i == 0)
        {
            getWorld().removeObject(this);
        }
    }
}
