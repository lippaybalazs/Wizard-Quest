import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 *  The enemy character in the game, mostly self explanatory code
 *  the movements and actions are usually random
 */
public class Monster extends Actor
{
    GifImage gifImage;
    GreenfootSound sound;
    double f = 1;
    double w = 1;
    double e = 1;
    double n = 1;
    int element;
    int type;
    double HP = 5;
    int dir = 1;
    public int i = 0;
    int countBurn;
    int stunCount;
    boolean stunned = false;
    boolean action = false;
    public int knockbackx = 0;
    public boolean boss = false;
    public boolean elemchanger = false;
    public int knockbacky = 0;
    public boolean burn = false;
    public int speed = (Greenfoot.getRandomNumber(9) + 5) * 2;
    int phase = 3;
    public Monster(int x, int y)
    {
        element = y;
        switch(element)
        {
            case 1 :
                f = 0;
                w = 2;
                n = 0.5;
                break;
            case 2 :
                f = 0.5;
                w = 0;
                e = 2;
                break;
            case 3 :
                w = 0.5;
                e = 0;
                n = 2;
                break;
            case 4 :
                f = 2;
                e = 0.5;
                n = 0;
                break;
            case 5 :
                elemchanger = true;
                break;
        }
        type = x;
        switch (type)
        {
            case 0 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level0Monster.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level0Monster_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level0Monster_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level0Monster_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level0Monster_wind.gif");
                        break;
                }
                setImage(gifImage.getCurrentImage());
                HP = 7;
                break;
            case 1 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level1Monster.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level1Monster_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level1Monster_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level1Monster_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level1Monster_wind.gif");
                        break;
                }
                setImage(gifImage.getCurrentImage());
                HP = 15;
                break;
            case 2 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level2Monster.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level2Monster_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level2Monster_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level2Monster_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level2Monster_wind.gif");
                        break;
                }
                setImage(gifImage.getCurrentImage());
                HP = 25;
                speed = 1;
                break;
            case 3 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level0Boss.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level0Boss_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level0Boss_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level0Boss_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level0Boss_wind.gif");
                        break;
                }
                setImage(gifImage.getCurrentImage());
                HP = 150;
                if (elemchanger)
                {
                    HP += 50;
                }
                Level.BossMaxHP = HP;
                action = false;
                boss = true;
                break;
            case 4 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level1Boss.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level1Boss_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level1Boss_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level1Boss_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level1Boss_wind.gif");
                        break;
                }
                HP = 200;
                if (elemchanger)
                {
                    HP += 50;
                }
                Level.BossMaxHP = HP;
                action = false;
                boss = true;
                break;
            case 5 :
                switch (element)
                {
                    default :
                        gifImage = new GifImage("Level2Boss.gif");
                        break;
                    case 1 :
                        gifImage = new GifImage("Level2Boss_fire.gif");
                        break;
                    case 2 :
                        gifImage = new GifImage("Level2Boss_water.gif");
                        break;
                    case 3 :
                        gifImage = new GifImage("Level2Boss_earth.gif");
                        break;
                    case 4 :
                        gifImage = new GifImage("Level2Boss_wind.gif");
                        break;
                }
                HP = 200;
                if (elemchanger)
                {
                    HP += 50;
                }
                speed = 2000;
                Level.BossMaxHP = HP;
                action = false;
                boss = true;
                break;
            case 6 :
                gifImage = new GifImage("Level3Boss.gif");
                HP = 750;
                speed = 2000;
                Level.BossMaxHP = HP;
                phase = 3;
                action = false;
                boss = true;
                break;
            case 99:
                HP = 200;
                speed = 1;
                burn = true;
                break;
        }
    }
    public void act() 
    {
        switch (type)
        {
            case 0 :
                Level0();
                break;
            case 1 :
                Level1();
                break;
            case 2 :
                Level2();
                break;
            case 3 :
                Boss0();
                break;
            case 4 :
                Boss1();
                break;
            case 5 :
                Boss2();
                break;
            case 6 :
                Boss3();
                break;
            case 99 :
                Select();
                break;
        }
        if (elemchanger)
        {
            Shift();
        }
    }  
    void Select()
    {
        if (i != 0)
        {
            i--;
        }
        if (!burn)
        {
            switch (speed)
            {
                case 1 :
                    setImage(new GreenfootImage("SelectFire.png"));
                    break;
                case 2 :
                    setImage(new GreenfootImage("SelectWater.png"));
                    break;
                case 3 :
                    setImage(new GreenfootImage("SelectEarth.png"));
                    break;
                case 4 :
                    setImage(new GreenfootImage("SelectWind.png"));
                    break;
            }
            Wizard hit = (Wizard) getOneIntersectingObject(Wizard.class);
            if (hit != null)
            {
                if (hit.knock == 0 && !Wizard.immune)
                {         
                    hit.knockbackx = -30;
                    hit.knock = 20;
                    speed++;
                }
            }
        }
        else
        {
            setImage(new GreenfootImage("Blank.png"));
        }
        if (speed >= 5)
        {
            speed = 1;
        }
    }
    void Shift()
    {
        if (Greenfoot.getRandomNumber(500) == 1)
        {
            int el = Greenfoot.getRandomNumber(20) % 4 + 1;
            while (el == element)
            {
                el = Greenfoot.getRandomNumber(20) % 4 + 1;
            }
            element = el;
            switch(element)
            {
                case 1 :
                    f = 0;
                    w = 2;
                    n = 0.5;
                    break;
                case 2 :
                    f = 0.5;
                    w = 0;
                    e = 2;
                    break;
                case 3 :
                    w = 0.5;
                    e = 0;
                    n = 2;
                    break;
                case 4 :
                    f = 2;
                    e = 0.5;
                    n = 0;
                    break;
            }
            switch (type)
            {
                case 3 :
                    switch (element)
                    {
                        default :
                            gifImage = new GifImage("Level0Boss.gif");
                            break;
                        case 1 :
                            gifImage = new GifImage("Level0Boss_fire.gif");
                            break;
                        case 2 :
                            gifImage = new GifImage("Level0Boss_water.gif");
                            break;
                        case 3 :
                            gifImage = new GifImage("Level0Boss_earth.gif");
                            break;
                        case 4 :
                            gifImage = new GifImage("Level0Boss_wind.gif");
                            break;
                    }
                    setImage(gifImage.getCurrentImage());
                    break;
                case 4 :
                    switch (element)
                    {
                        default :
                            gifImage = new GifImage("Level1Boss.gif");
                            break;
                        case 1 :
                            gifImage = new GifImage("Level1Boss_fire.gif");
                            break;
                        case 2 :
                            gifImage = new GifImage("Level1Boss_water.gif");
                            break;
                        case 3 :
                            gifImage = new GifImage("Level1Boss_earth.gif");
                            break;
                        case 4 :
                            gifImage = new GifImage("Level1Boss_wind.gif");
                            break;
                    }
                    break;
                case 5 :
                    switch (element)
                    {
                        default :
                            gifImage = new GifImage("Level2Boss.gif");
                            break;
                        case 1 :
                            gifImage = new GifImage("Level2Boss_fire.gif");
                            break;
                        case 2 :
                            gifImage = new GifImage("Level2Boss_water.gif");
                            break;
                        case 3 :
                            gifImage = new GifImage("Level2Boss_earth.gif");
                            break;
                        case 4 :
                            gifImage = new GifImage("Level2Boss_wind.gif");
                            break;
                    }
                    break;
                case 6 :
                    gifImage = new GifImage("Level3Boss.gif");
                    break;
            }
        }
    }
    void Boss3()
    {
        if (HP >= 500 && ! action)
        {
            phase = 3;
        }
        else
        {
            if (HP >= 250 && !action)
            {
                phase = 2;
            }
            else if (!action)
            {
                phase = 1;
            }
        }
        switch (phase)
        {
            case 3 :
                Boss2();
                break;
            case 2 :
                Boss1();
                break;
            case 1 :
                Boss0();
                break;
            default :
                Boss0();
                break;
        }
    }
    void Boss2()
    {
        setImage(gifImage.getCurrentImage());
        Level.BossHP = HP;
        if (!stunned)
        {
            if(getX() >= 1150)
            {
                setLocation(getX() - 5, getY());
            }
            setLocation(getX(), getY() + 2 * dir);
            if (getY() - 149 < 80)
            {
                if (dir < 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() + 3);
            }
            else if (getY() + 169 > 720)
            {
                if (dir > 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() - 3);
            }
            if ((getY() < 0 && dir < 0) || (getY() > 720 && dir > 0))
            {
                setLocation(getX(), getY() - 10 * dir);
            }
            if(HP > 0)
            {
                if (Greenfoot.getRandomNumber((int)(HP % 250 * 2) + 10) == 1 && speed > 1500)
                {
                    action = true;
                    speed = -100;
                    knockbacky = (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(200);
                }
            }
            if (Counter.i / 2 % 200 / 10 > 10 && Counter.i % 15 == 0)
            {
                getWorld().addObject(new Projectile(-5, (((double)(getX() - 5 - Wizard.posX)) * ((double)(getY() - Wizard.posY)) + (double)(Wizard.posY) * ((double)(getX() - Wizard.posX))) / ((double)(getX() - Wizard.posX)) - getY(), getX() - 100, getY(), 5), getX() - 100, getY());
                getWorld().addObject(new Projectile(-5, (((double)(getX() - 5 - Wizard.posX)) * ((double)(getY() - Wizard.posY)) + (double)(Wizard.posY) * ((double)(getX() - Wizard.posX))) / ((double)(getX() - Wizard.posX)) - getY(), getX() - 100, getY(), 5), getX() - 100, getY());
            }
            if (Wizard.posX < getX() - 125)
            {
                if (Counter.i / 2 % 50 / 10 == 1 && Counter.i % 20 == 0)
                {
                    sound = new GreenfootSound("Boss2Attack.wav");
                    sound.setVolume(70);
                    sound.play();
                    getWorld().addObject(new Projectile(-10, (((double)(getX() - 10 - Wizard.posX)) * ((double)(getY() - Wizard.posY)) + (double)(Wizard.posY) * ((double)(getX() - Wizard.posX))) / ((double)(getX() - Wizard.posX)) - getY(), getX() - 100, getY(), 50), getX() - 100, getY());
                }
            }
            if (action)
            {
                if (speed >= 2000)
                {
                    action = false;
                }
                if (speed % 50 == 0 && speed <= 280)
                {
                    getWorld().addObject(new Projectile(-6,0,1350,720 - speed + knockbacky,15),-100,0);
                    getWorld().addObject(new Projectile(-6,0,1350,speed + knockbacky,15),-100,0);
                    getWorld().addObject(new Projectile(-6,0,1450,720 - speed + knockbacky,15),-100,0);
                    getWorld().addObject(new Projectile(-6,0,1450,speed + knockbacky,15),-100,0);
                }
                speed += 10;
            }
        }
        else
        {
            if (stunCount == 0)
            {
                stunned = false;
            }
            stunCount -= 10;
        }
        if (Wizard.posX >= getX() - 125)
        {
            if (getY() > Wizard.posY)
            {
                dir = -1; 
            }
            else
            {
                dir = 1;
            }
            setLocation(getX(), (int)(((double)(getY()) + (double)((Wizard.posY - getY())) / 50)));
        }
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        CheckColl();
    }
    void Boss1()
    {
        Level.BossHP = HP;
        if (!stunned)
        {
            if(getX() >= 1100)
            {
                setLocation(getX() - 5, getY());
            }
            if (!action)
            {
                setImage(gifImage.getCurrentImage());
                setLocation(getX(), getY() + 1 * dir);
                if (getY() - 149 < 80)
                {
                    if (dir < 0)
                    {
                        dir *= -1;
                    }
                    setLocation(getX(), getY() + 3);
                }
                else if (getY() + 169 > 720)
                {
                    if (dir > 0)
                    {
                        dir *= -1;
                    }
                    setLocation(getX(), getY() - 3);
                }
                if ((getY() < 0 && dir < 0) || (getY() > 720 && dir > 0))
                {
                    setLocation(getX(), getY() - 4 * dir);
                }
                if (Greenfoot.getRandomNumber((int)(HP % 250 * 2) + 10) == 10 && getX() <= 1100)
                {
                    action = true;
                    speed = 0;
                }
                if (Counter.i / 2 % 200 / 10 == 1 && Counter.i % 15 == 0)
                {
                    if (elemchanger)
                    {
                        getWorld().addObject(new Monster(2,element), getX() - 100, getY());
                    }
                }
                if (Counter.i / 2 % 200 / 10 > 10 && Counter.i % 15 == 0)
                {
                    if (!elemchanger)
                    {
                        getWorld().addObject(new Projectile((-1 * (double)(Greenfoot.getRandomNumber(100)) / 50 - 2), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * ((double)(Greenfoot.getRandomNumber(100)) / 50), getX() - 100, getY(), 5), getX() - 100, getY());
                        getWorld().addObject(new Projectile((-1 * (double)(Greenfoot.getRandomNumber(100)) / 50 - 2), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * ((double)(Greenfoot.getRandomNumber(100)) / 50), getX() - 100, getY(), 5), getX() - 100, getY());
                        getWorld().addObject(new Projectile((-1 * (double)(Greenfoot.getRandomNumber(100)) / 50 - 2), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * ((double)(Greenfoot.getRandomNumber(100)) / 50), getX() - 100, getY(), 5), getX() - 100, getY());
                    }
                    else
                    {
                        if (getX() - 150 > Wizard.posX)
                        {
                            getWorld().addObject(new Projectile(-5, (((double)(getX() - 5 - Wizard.posX)) * ((double)(getY() - Wizard.posY)) + (double)(Wizard.posY) * ((double)(getX() - Wizard.posX))) / ((double)(getX() - Wizard.posX)) - getY(), getX() - 100, getY(), 5), getX() - 100, getY());
                            getWorld().addObject(new Projectile(-5, (((double)(getX() - 5 - Wizard.posX)) * ((double)(getY() - Wizard.posY)) + (double)(Wizard.posY) * ((double)(getX() - Wizard.posX))) / ((double)(getX() - Wizard.posX)) - getY(), getX() - 100, getY(), 5), getX() - 100, getY());
                        }
                    }
                }
            }
            else
            {
                if (speed >= 2250)
                {
                    action = false;
                }
                if (speed < 250)
                {
                    setLocation(getX() - 2, getY());
                }
                if (speed >= 1750)
                {
                    setLocation(getX() + 1, getY());
                }
                if (speed % 50 == 0 && speed <= 1500 && speed >= 250)
                {
                    getWorld().addObject(new Projectile(-6,-5,speed,780,15),-100,0);
                    getWorld().addObject(new Projectile(-6,5,speed,-50,15),-100,0);
                    getWorld().addObject(new Projectile(-6,-5,speed - 250,780,15),-100,0);
                    getWorld().addObject(new Projectile(-6,5,speed - 250,-50,15),-100,0);
                    getWorld().addObject(new Projectile(-6,-5,speed - 500,780,15),-100,0);
                    getWorld().addObject(new Projectile(-6,5,speed - 500,-50,15),-100,0);
                }
                speed += 5;
            }
        }
        else
        {
            if (stunCount == 0)
            {
                stunned = false;
            }
            stunCount -= 10;
        }
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        CheckColl();
    }
    void Boss0()
    {
        setImage(gifImage.getCurrentImage());
        Level.BossHP = HP;
        if (!stunned)
        {
            if(getX() >= 1150)
            {
                setLocation(getX() - Greenfoot.getRandomNumber(3) % 3, getY());
            }
            setLocation(getX(), getY() + 1 * dir);
            if (getY() - 149 < 80)
            {
                if (dir < 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() + 3);
            }
            else if (getY() + 169 > 720)
            {
                if (dir > 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() - 3);
            }
            if ((getY() < 0 && dir < 0) || (getY() > 720 && dir > 0))
            {
                setLocation(getX(), getY() - 4 * dir);
            }
            if (!action)
            {
                if(HP > 0)
                {
                    if (Greenfoot.getRandomNumber((int)(HP) * 3 + 10) == 1)
                    {
                        action = true;
                        speed = 1;
                    }
                }
                if (Counter.i / 2 % 200 / 10 > 10 && Counter.i % 15 == 0)
                {
                    getWorld().addObject(new Projectile(-4, (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(20) / 10, getX() - 50, getY(), 5), getX() - 50, getY());
                    getWorld().addObject(new Projectile(-4, (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(20) / 10, getX() - 50, getY(), 5), getX() - 50, getY());
                }
                if (Counter.i / 2 % 200 / 10 == 1 && Counter.i % 15 == 0)
                {
                    if (!elemchanger)
                    {
                        getWorld().addObject(new Monster(0,element), getX() - 100, getY());
                    }
                    else
                    {
                        getWorld().addObject(new Monster(2,element), getX() - 100, getY());
                    }
                }
            }
            else
            {
                if (getX() < 1150)
                {
                    setLocation(getX() - 15 * speed, getY());
                }
                else
                {
                    action = false;
                }
                if (getX() < 150)
                {
                    speed *= -1;
                    setLocation(getX() - 5 * speed, getY());
                }
            }
        }
        else
        {
            if (stunCount == 0)
            {
                stunned = false;
            }
            stunCount -= 10;
        }
        List<Monster> hit2 = getIntersectingObjects(Monster.class);
        if(hit2 != null)
        {
            for (int k = 0; k < hit2.size(); k++)
            {
                if (hit2.get(k).i == 0)
                {
                    if(hit2.get(k).getX() < getX())
                    {
                        hit2.get(k).knockbackx = -30;
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
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        CheckColl();
    }
    void Level2()
    {
        setImage(gifImage.getCurrentImage());
        if (!stunned)
        {
            setLocation(getX() + 2 * speed, getY() + 3 * dir);
            if (getY() - 49 < 70)
            {
                if (dir < 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() + 5);
            }
            else if (getY() + 49 > 720)
            {
                if (dir > 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() - 5);
            }
            if (getX() - 49 < 600)
            {
                if (speed < 0)
                {
                    speed *= -1;
                }
                setLocation(getX() + 5, getY());
            }
            else if (getX() + 49 > 1200)
            {
                if (speed > 0)
                {
                    speed *= -1;
                }
                setLocation(getX() - 5, getY());
            }
            if (Counter.i / 2 % 150 / 10 > 10 && Counter.i % 10 == 0)
            {
                getWorld().addObject(new Projectile(-5, 0, getX() - 50, getY(), 5), getX() - 50, getY());
            }
        }
        else
        {
            gifImage.pause();
            if (stunCount == 0)
            {
                gifImage.resume();
                stunned = false;
            }
            stunCount--;
        }
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        if (knockbackx != 0)
        {
            setLocation(getX() + knockbackx, getY());
            knockbackx /= 1.1;
            if (knockbackx * knockbackx < 1)
            {
                knockbackx = 0;
            }
        }
        if (knockbacky != 0)
        {
            setLocation(getX(), getY() + knockbacky);
            knockbacky /= 1.1;
            if (knockbacky * knockbacky < 1)
            {
                knockbacky = 0;
            }
        }
        CheckColl();
    }
    void Level1()
    {
        setImage(gifImage.getCurrentImage());
        if (!stunned)
        {
            if(getX() > 1200 - speed * 5)
            {
                setLocation(getX() - Greenfoot.getRandomNumber(3) % 3, getY());
            }
            setLocation(getX(), getY() + 1 * dir);
            if (getY() - 49 < 70)
            {
                if (dir < 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() + 3);
            }
            else if (getY() + 49 > 720)
            {
                if (dir > 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() - 3);
            }
            if ((getY() < 0 && dir < 0) || (getY() > 720 && dir > 0))
            {
                setLocation(getX(), getY() - 2 * dir);
            }
            if (Counter.i % 80 == 50 + speed)
            {
                getWorld().addObject(new Projectile(-4,-0.5,getX() - 50, getY(), 5), getX() - 50, getY());
                getWorld().addObject(new Projectile(-4,0.5,getX() - 50, getY(), 5), getX() - 50, getY());
            }
        }
        else
        {
            gifImage.pause();
            if (stunCount == 0)
            {
                gifImage.resume();
                stunned = false;
            }
            stunCount--;
        }
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        if (knockbacky != 0)
        {
            setLocation(getX(), getY() + knockbacky);
            knockbacky /= 1.1;
            if (knockbacky * knockbacky < 1)
            {
                knockbacky = 0;
            }
        }
        CheckColl();
    }
    void Level0()
    {
        setImage(gifImage.getCurrentImage());
        if (!stunned)
        {
            setLocation(getX() - Greenfoot.getRandomNumber(3) % 3, getY() + 1 * dir);
            if(Greenfoot.getRandomNumber(500) < 2 || !(getY() + 50< 720 && getY() - 50> 0))
            {
                dir *= -1;
            }
            if (getY() - 49 < 70)
            {
                if (dir < 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() + 3);
            }
            else if (getY() + 49 > 720)
            {
                if (dir > 0)
                {
                    dir *= -1;
                }
                setLocation(getX(), getY() - 3);
            }
            if(getOneIntersectingObject(Monster.class)!= null)
            {
                if(Greenfoot.getRandomNumber(10) < 2)
                {
                    dir *= -1;
                }
            }
            if (Counter.i % 80 == 50 + speed)
            {
                getWorld().addObject(new Projectile(-4, (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10) / 10, getX() - 50, getY() + 25, 5), getX() - 50, getY() + 25);
            }
        }
        else
        {
            gifImage.pause();
            if (stunCount == 0)
            {
                stunned = false;
                gifImage.resume();
            }
            stunCount--;
        }
        if (i != 0)
        {
            i--;
        }
        if (burn)
        {
            if(countBurn % 50 == 0)
            {
                Damage(1,0,0,0);
                getWorld().addObject(new explosion(3), getX(), getY());
            }
            if (countBurn <= 0)
            {
                burn = false;
            }
            countBurn--;
        }
        if (knockbackx != 0)
        {
            setLocation(getX() + knockbackx, getY());
            knockbackx /= 1.1;
            if (knockbackx * knockbackx < 1)
            {
                knockbackx = 0;
            }
        }
        if (knockbacky != 0)
        {
            setLocation(getX(), getY() + knockbacky);
            knockbacky /= 1.1;
            if (knockbacky * knockbacky < 1)
            {
                knockbacky = 0;
            }
        }
        CheckColl();
    }
    public void Burning(int x)
    {
        if(type != 99)
        {
            if (f != 0)
            {
                countBurn = (int)((x * f -1) * 50) + 49;
                burn = true;
            }
        }
    }
    public void Stunned(int x)
    {
        if (e != 0 )
        {
            stunned = true;
            stunCount = (int)(x * e);
        }
    }
    boolean CheckColl()
    {
        if (!boss)
        {
            if(getX() + 50 <= 0)
            {
                getWorld().removeObject(this);
                return false;
            }
        }
        Wizard hit = (Wizard) getOneIntersectingObject(Wizard.class);
        if (hit != null)
        {
            if (hit.knock == 0 && !Wizard.immune)
            {         
                if(hit.getX() < getX())
                {
                    if (!boss)
                    {
                        hit.knockbackx = -20;
                    }
                    else
                    {
                        hit.knockbackx = -30;
                    }
                }
                else
                {
                    if (!boss)
                    {
                        hit.knockbackx = 20;
                    }
                    else
                    {
                        hit.knockbackx = 30;
                    }
                }
                if(hit.getY() < getY())
                {
                    if (!boss)
                    {
                        hit.knockbacky = -10;
                    }
                    else
                    {
                        hit.knockbacky = -20;
                    }
                }
                else
                {
                    if (!boss)
                    {
                        hit.knockbacky = 10;
                    }
                    else
                    {
                        hit.knockbacky = 20;
                    }
                }
                hit.knock = 20;
                Wizard.Damage(10 + type);
            }
            if (!boss)
            {
                getWorld().removeObject(this);
                return false;
            }
        }
        if( HP <= 0)
        {
            switch (type)
            {
                case 0 :
                    Wizard.Ult += 5;
                    Level.Points += 1;
                    break;
                case 1 :
                    Wizard.Ult += 10;
                    Level.Points += 2;
                    break;
                case 2 :
                    Wizard.Ult += 15;
                    Level.Points += 5;
                    break;
                case 3 :
                    Wizard.Ult += 20;
                    Level.BossHP = 0;
                    getWorld().addObject(new BossDead(type,getImage()), getX(), getY());
                    break;
                case 4 :
                    Wizard.Ult += 30;
                    Level.BossHP = 0;
                    getWorld().addObject(new BossDead(type,getImage()), getX(), getY());
                    break;
                case 5 :
                    Wizard.Ult += 40;
                    Level.BossHP = 0;
                    getWorld().addObject(new BossDead(type,getImage()), getX(), getY());
                    break;
                case 6 :
                    Wizard.Ult += 50;
                    Level.BossHP = 0;
                    getWorld().addObject(new BossDead(type,getImage()), getX(), getY());
                    break;
            }
            getWorld().removeObject(this);
            return false;
        }
        return true;
    }
    public void Damage(double a, double b, double c, double d)
    {
        double damage = 0;
        if (type == 99)
        {
            speed++;
            if (speed == 5)
            {
                speed = 1;
            }
        }
        damage += (a * f) / (double)(Wizard.diff);
        damage += (b * w) / (double)(Wizard.diff);
        damage += (c * e) / (double)(Wizard.diff);
        damage += (d * n) / (double)(Wizard.diff);
        if (HP - damage < 0)
        {
            HP = 0;
        }
        else
        {
            HP -= damage;
        }
    }
}
