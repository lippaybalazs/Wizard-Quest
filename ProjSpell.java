import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Mainly spells that are thrown towards the enemy
 * the behaviour is mostly hard coded, but all self explanatory
 */
public class ProjSpell extends Actor
{
    int type;
    double accel;
    GreenfootImage img0;
    GreenfootSound sound;
    public ProjSpell(int x)
    {
        type = x;
        switch(type)
        {
            case 0 :
            img0 = new GreenfootImage("Fireball.png");
            sound = new GreenfootSound("FireBall.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(50, 25, -30, -45);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = 0.1;
            break;
            case 1 :
            img0 = new GreenfootImage("Firegrenade.png");
            sound = new GreenfootSound("FireBall.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(50, 25, -30, -45);
            WizLeft.Cast(50, -15, -20, 0);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = 10;
            break;
            case 2 :
            img0 = new GreenfootImage("pyroblast.png");
            sound = new GreenfootSound("Pyroblast.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(50, 25, -30, -45);
            WizLeft.Cast(50, -15, -20, 0);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = 0.1;
            break;
            case 3 :
            img0 = new GreenfootImage("Rockblast.png");
            sound = new GreenfootSound("FireBall.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(10, 15, -50, 0);
            WizLeft.Cast(10, 30, -50, 0);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = -30;
            break;
            case 4 :
            img0 = new GreenfootImage("watergun.png");
            sound = new GreenfootSound("Boss2Attack.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(50, 25, -30, -45);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = -10;
            break;
            case 5 :
            sound = new GreenfootSound("Tornado.wav");
            sound.setVolume(70);
            sound.play();
            WizRight.Cast(50, 25, -30, -45);
            WizLeft.Cast(50, -15, -20, 0);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = -15;
            break;
            case 6 :
            img0 = new GreenfootImage("rockthrow.png");
            WizRight.Cast(50, 25, -30, -45);
            WizHead.knX = Greenfoot.getRandomNumber(10);
            WizHead.knY = Greenfoot.getRandomNumber(10);
            accel = -41;
            break;
            case 7 :
            img0 = new GreenfootImage("Fireball.png");
            accel = -10;
            break;
        } 
    }
    public void act() 
    {
        switch(type)
        {
            case 0 :
            Fireball();
            break;
            case 1 :
            Firegrenade();
            break;
            case 2 :
            Pyroblast();
            break;
            case 3 :
            Rockblast();
            break;
            case 4 :
            Watergun();
            break;
            case 5 :
            Tornado();
            break;
            case 6 :
            Rockthrow();
            break;
            case 7 :
            Flamethrow();
            break;
        }
    }
    void Flamethrow()
    {
        if (accel == -10)
        {
            setLocation(Wizard.posX + 50, Wizard.posY + (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(20));
            setImage(img0);
        }
        if (accel < 60)
        {
            accel += (double)(Greenfoot.getRandomNumber(20))/10;
        }
        if (Counter.i % 4 == 0)
        {
            getWorld().addObject(new spellshadow(1), getX(), getY());
        }
        setLocation(getX() + 12, (int)(getY() + accel / 5));
        List<Monster> hit2 = getIntersectingObjects(Monster.class);
        if (hit2 != null)
        {
            for (int k = 0; k < hit2.size(); k++)
            {
                if (!hit2.get(k).burn)
                {
                    hit2.get(k).Damage(2,0,0,0);
                    hit2.get(k).Burning(1);
                }
            }
        }
        if (getX() > 1500 || getY() > 900 || Greenfoot.getRandomNumber(25) == 1)
        {
            getWorld().removeObject(this);
        }
    }
    void Rockthrow()
    {
        if (accel == -41)
        {
            setLocation(-100,650);
            setImage(img0);
            accel++;
        }
        if (Counter.i % 10 == 0)
        {
            setRotation(Counter.i % 120 * 3);
        }
        if (getX() <  Wizard.posX + 100)
        {   
            setLocation(getX() + 25, (int)(getY() - (getY() - Wizard.posY) / 50));
        }
        else
        {
            if (accel < 60)
            {
                accel++;
            }
            setLocation(getX() + 20, (int)(getY() + accel / 3));
        }
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1500 || getY() > 900)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),2), getX() + 25, getY());
            }
            hit.Stunned(200);
            if (hit.i == 0)
            {
                hit.knockbackx = 10;
                hit.Damage(0,0,0,1);
                if(hit.getY() < getY())
                {
                    hit.knockbacky = -10;
                }
                    else
                {
                    hit.knockbacky = 10;
                }
                hit.i = 50;
            }
            hit.Damage(0,0,2,1);
            sound = new GreenfootSound("StoneHit.wav");
            sound.setVolume(70);
            sound.play();
            getWorld().removeObject(this);
        }
    }
    void Tornado()
    {
        if (Counter.i % 20 / 5 == 0)
        {
            setImage(new GreenfootImage("Tornado3.png"));
        }
        if (Counter.i % 20 / 5 == 1)
        {
            setImage(new GreenfootImage("Tornado2.png"));
        }
        if (Counter.i % 20 / 5 == 2)
        {
            setImage(new GreenfootImage("Tornado1.png"));
        }
        if (Counter.i % 20 / 5 == 3)
        {
            setImage(new GreenfootImage("Tornado0.png"));
        }
        if (accel == -15)
        {
            setLocation(Wizard.posX - 100, Wizard.posY);
        }
        if (accel < 0)
        {
            accel += 0.45;
            setLocation(getX(), getY() + 5);
        }
        if (accel < 10 && accel >= 0)
        {
            accel *= 2;
            setLocation(getX(), getY() + 5);
        }
        setLocation((int)(getX() + accel), getY());
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if(hit != null)
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
                        getWorld().addObject(new explosion(6), hit2.get(k).getX(), hit2.get(k).getY());
                        hit2.get(k).knockbackx = 10;
                        hit2.get(k).Damage(0,0,0,1);
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
        if (getX() > 1700)
        {
            getWorld().removeObject(this);
        }
    }
    void Watergun()
    {
        if (accel == -10)
        {
            setLocation(Wizard.posX + 50, Wizard.posY);
            setImage(img0);
        }
        if (accel < 60)
        {
            accel++;
        }
        if (Counter.i % 2 == 0)
        {
            getWorld().addObject(new spellshadow(3), getX(), getY());
        }
        setLocation(getX() + 12, (int)(getY() + accel / 5));
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1500 || getY() > 900)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            if(hit.burn && hit.type != 99)
            {
                hit.Damage(0,6,0,0);
                for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
                {
                    getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),1), getX() + 25, getY());
                }
                hit.burn = false;
            }
            else
            {
                hit.Damage(0,3,0,0);
            }
            getWorld().addObject(new explosion(4), getX(), getY());
            getWorld().removeObject(this);
        }
    }
    void Rockblast()
    {
        if (accel == -30)
        {
            setLocation(Wizard.posX + 50, Wizard.posY - 50);
            setImage(img0);
        }
        if (Counter.i % 4 ==0)
        {
            getWorld().addObject(new spellshadow(1), getX(), getY());
        }
        if (Counter.i % 10 == 0)
        {
            setRotation(Counter.i % 120 * 3);
        }
        if (accel < 60)
        {
            accel++;
        }
        setLocation(getX() + 10, (int)(getY() + accel / 3));
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1500 || getY() > 900)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX() + 25, getY());
            }
            getWorld().addObject(new explosion(1), getX(), getY());
            hit.Stunned(100);
            hit.Burning(1);
            hit.Damage(1,0,2,0);
            sound = new GreenfootSound("StoneHit.wav");
            sound.setVolume(70);
            sound.play();
            getWorld().removeObject(this);
        }
    }
    void Pyroblast()
    {
        if (accel == 0.1)
        {
            setLocation(Wizard.posX + 50, Wizard.posY);
            setImage(img0);
        }
        if (accel < 10)
        {
            accel *= 2;
        }
        if (Counter.i % 4 ==0)
        {
            getWorld().addObject(new spellshadow(1), getX(), getY());
        }
        setLocation((int)(getX() + accel), getY());
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1700)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            if(hit2 != null)
            {   
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k) != null)
                    {
                        if (!hit2.get(k).burn)
                        {
                            hit2.get(k).Burning(5);
                        }
                        if (hit2.get(k).i == 0)
                        {
                            hit2.get(k).knockbackx = 10;
                            hit2.get(k).Damage(0,0,0,1);
                            getWorld().addObject(new explosion(3), hit2.get(k).getX(), hit2.get(k).getY());
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
        }
    }
    void Fireball()
    {
        if (accel == 0.1)
        {
            setLocation(Wizard.posX + 50, Wizard.posY);
            setImage(img0);
        }
        if (accel < 10)
        {
            accel *= 2;
        }
        if (Counter.i % 4 ==0)
        {
            getWorld().addObject(new spellshadow(1), getX(), getY());
        }
        setLocation((int)(getX() + accel), getY());
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1500)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            getWorld().addObject(new explosion(1), getX(), getY());
            hit.Burning(3);
            hit.Damage(3,0,0,0);
            getWorld().removeObject(this);
        }
    }
    void Firegrenade()
    {
        if (accel == 10)
        {
            setLocation(Wizard.posX + 50, Wizard.posY);
            setImage(img0);
            accel = 9;
        }
        if (Counter.i % 10 ==0)
        {
            getWorld().addObject(new spellshadow(1), getX(), getY());
        }
        setLocation((int)(getX() + accel), getY());
        Monster hit = (Monster) getOneIntersectingObject(Monster.class);
        if (getX() > 1500)
        {
            getWorld().removeObject(this);
        }
        if(hit != null)
        {
            List<Monster> hit2 = getIntersectingObjects(Monster.class);
            getWorld().addObject(new explosion(2), getX(), getY());
            if(hit2 != null)
            {   
                for (int k = 0; k < hit2.size(); k++)
                {
                    if (hit2.get(k) != null)
                    {
                        hit2.get(k).Damage(2,0,1,0);
                        hit2.get(k).Burning(2);
                        hit2.get(k).Stunned(50);
                    }
                }
                getWorld().removeObject(this);
            }
        }
    }
}
