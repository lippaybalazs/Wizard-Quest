import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * The main character, most of it is selfexplanatory
*/
public class Wizard extends Actor
{
    static GreenfootSound backgroundMusic = new GreenfootSound("Instrumental Metal Music Metal Mix Vol.1 Royalty-Free.mp3");
    boolean fire = false;
    boolean water = false;
    boolean earth = false;
    boolean wind = false;
    int i = 0;
    boolean activated = false;
    public static boolean immune = false;
    int activecount;
    public static double accelX = 0;
    public static double accelY = 0;
    double acceleration = 2;
    public static double diff = 1;
    public static double FP = 100; ///spell resources
    public static double WP = 100;
    public static double EP = 100;
    public static double NP = 100;
    public static int Shield = 100;
    public static double Ult = 50;
    public static int HP = 100;
    public static int posX = 0;
    public static int posY = 0;
    public int knockbacky = 0;
    public int knockbackx = 0;
    public int knock = 0;
    public Wizard()
    {
        backgroundMusic.playLoop();
    } 
    public void act() 
    {
        if (Counter.i % (int)((50 * diff)) == 0)
        {
            Shield++;
        }
        if (HP > 0)
        {
            if (Level.impossible)
            {
                if (HP > 1)
                {
                    HP = 1;
                }
                Shield = 0;
            }
            KeyCheck();
            posX = getX();
            posY = getY();
            PowerManage();
            cast();            
            FP += 0.1;
            if (FP > 100)
            {
                FP = 100;
            }
            WP += 0.1;
            if(WP > 100)
            {
                WP = 100;
            }
            EP += 0.1;
            if (EP > 100)
            {
                EP = 100;
            }
            NP += 0.1;
            if (NP > 100)
            {
                NP = 100;
            }
            Ult += 0.01;
            if (Ult > 300)
            {
                Ult = 300;
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
            if (knock != 0)
            {
                knock--;
            }
        }
        else
        {
            if (HP != -10000)
            {
                HP = -10000;
                getWorld().addObject(new WizDead(), getX(), getY());
                setImage(new GreenfootImage("Blank.png"));
            }
        }
    }   
    
    void KeyCheck() ///Movement keys
    {
        if(Greenfoot.isKeyDown("right"))
        {
            if (accelX <= 0)
            {
                accelX = 0.3;
            }
            else if (accelX < 10 * acceleration * 0.3)
            {
                accelX *= acceleration;
            }
        }
        else if (Greenfoot.isKeyDown("left"))
        {
            if (accelX >= 0)
            {
                accelX = -0.3;
            }
            else if (accelX > -10 * acceleration * 0.3)
            {
                accelX *= acceleration;
            }
        }
        else
        {
            if (accelX * accelX > 1)
            {
                accelX /= 1.2;
            }
            else
            {
                accelX = 0;
            }
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (accelY >= 0)
            {
                accelY = -0.3;
            }
            else if (accelY > -10 * acceleration * 0.3)
            {
                accelY *= acceleration;
            }
        }
        else if (Greenfoot.isKeyDown("down"))
        {
            if (accelY <= 0)
            {
                accelY = 0.3;
            }
            else if (accelY < 10 * acceleration * 0.3)
            {
                accelY *= acceleration;
            }
        }
        else
        {
            if (accelY * accelY > 1)
            {
                accelY /= 1.2;
            }
            else
            {
                accelY = 0;
            }
        }
        if (!immune)
        {
            move(accelX, accelY);
        }
        else
        {
            move(accelX * 2, accelY * 2);
        }
    }
    
    void move(double x ,double y) ///makes you remain in the world
    {
        if (x > 0)
        {
            if (getX() + x + 50< 1280)
            {
                setLocation((int)(getX() + x), getY());
            }
        }
        else
        {
            if (getX() + x - 50 > 0)
            {
                setLocation((int)(getX() + x), getY());
            }
        }
        if (y > 0)
        {
            if (getY() + y + 50 < 720)
            {
                setLocation(getX(), (int)(getY() + y));
            }
        }
        else
        {
            if (getY() + y - 50 > 70)
            {
                setLocation(getX(), (int)(getY() + y));
            }
        }
        if (getX() + 50 > 1280)
        {
            setLocation(getX() - 10, getY());
        }
        if (getX() - 50 < 0)
        {
            setLocation(getX() + 10, getY());
        }
        if (getY() + 50 > 720)
        {
            setLocation(getX(), getY() - 10);
        }
        if (getY() - 50 < 70)
        {
            setLocation(getX(), getY() + 10);
        }
    }
    public static void Damage(int x) /// incoming damage from outside sources
    {
        if (x > 0)
        {
            WizHead.knX = Greenfoot.getRandomNumber(10) + 10 + x * 2;
            WizHead.knY = Greenfoot.getRandomNumber(10) + 10 + x;
        }
        if (HP > 0)
        {
            if (x >= 0)
            {
                x *= diff;
            }
            if (!immune || x < 0)
            {
                if (Shield > 0 && x > 0)
                {
                    Shield -=x;
                }
                else
                {
                    HP -= x;
                }
            }
            if (Shield > 100)
            {
                Shield = 100;
            }
            if (Shield < 0)
            {
                HP += Shield;
                Shield = 0;
            }
            if (HP > 100)
            {
                HP = 100;
            }
            if (HP < 0)
            {
                HP = 0;
            }
        }
    }
    void PowerManage() /// encoding the spells
    {
        if (!activated)
        {
            if(Greenfoot.isKeyDown("a"))
            {
                if (!fire && FP > 10)
                {
                    fire = true;
                    switch(i)
                    {
                        case 0 :
                        Power1.type = 1;
                        break;
                        case 1 :
                        Power2.type = 1;
                        break;
                        case 2 :
                        Power3.type = 1;
                        break;
                    }
                    FP -= 10;
                    if(i != 2)
                    {
                        i++;
                    }
                    else
                    {
                        i = 0;
                        activated = true;
                        Spell();
                    }
                }
            }
            else
            {
                fire = false;
            }
            if(Greenfoot.isKeyDown("s"))
            {
                if (!water && WP > 10)
                {
                    water = true;
                    switch(i)
                    {
                        case 0 :
                        Power1.type = 2;
                        break;
                        case 1 :
                        Power2.type = 2;
                        break;
                        case 2 :
                        Power3.type = 2;
                        break;
                    }
                    WP -= 10;
                    if(i != 2)
                    {
                        i++;
                    }
                    else
                    {
                        i = 0;
                        activated = true;
                        Spell();
                    }
                }
            }
            else
            {
                water = false;
            }
            if(Greenfoot.isKeyDown("d"))
            {
                if (!earth && EP > 10)
                {
                    earth = true;
                    switch(i)
                    {
                        case 0 :
                        Power1.type = 3;
                        break;
                        case 1 :
                        Power2.type = 3;
                        break;
                        case 2 :
                        Power3.type = 3;
                        break;
                    }
                    EP -= 10;
                    if(i != 2)
                    {
                        i++;
                    }
                    else
                    {
                        i = 0;
                        activated = true;
                        Spell();
                    }
                }
            }
            else
            {
                earth = false;
            }
            if(Greenfoot.isKeyDown("f"))
            {
                if (!wind && NP > 10)
                {
                    wind = true;
                    switch(i)
                    {
                        case 0 :
                        Power1.type = 4;
                        break;
                        case 1 :
                        Power2.type = 4;
                        break;
                        case 2 :
                        Power3.type = 4;
                        break;
                    }
                    NP -= 10;
                    if(i != 2)
                    {
                        i++;
                    }
                    else
                    {
                        i = 0;
                        activated = true;
                        Spell();
                    }
                }
            }
            else
            {
                wind = false;
            }
            if(Greenfoot.isKeyDown("space") && !activated)
            {
                switch (Power1.type)
                {
                    case 1 :
                        FP += 10;
                        break;
                    case 2 :
                        WP += 10;
                        break;
                    case 3 :
                        EP += 10;
                        break;
                    case 4 :
                        NP += 10;
                        break;
                }
                Power1.type = 0;
                switch (Power2.type)
                {
                    case 1 :
                        FP += 10;
                        break;
                    case 2 :
                        WP += 10;
                        break;
                    case 3 :
                        EP += 10;
                        break;
                    case 4 :
                        NP += 10;
                        break;
                }
                Power2.type = 0;
                Power3.type = 0;
                i = 0;
            }
        }
    }   
    void cast() /// 3 elements selected
    {
        if(activated)
        {
            if (activecount == 30)
            {
                Power1.type = 0;
                Power2.type = 0;
                Power3.type = 0;
                activecount = 0;
                activated = false;
            }
            else
            {
                activecount++;
            }
        } 
    }
    boolean Spell() ///decoding the spells
    {
            int firep = 0;
            int waterp = 0;
            int earthp = 0;
            int windp = 0;
            switch(Power1.type)
            {
                case 1 :
                    firep++;
                    break;
                case 2 :
                    waterp++;
                    break;
                case 3 :
                    earthp++;
                    break;
                case 4 :
                    windp++;
                    break;
            }
            switch(Power2.type)
            {
                case 1 :
                    firep++;
                    break;
                case 2 :
                    waterp++;
                    break;
                case 3 :
                    earthp++;
                    break;
                case 4 :
                    windp++;
                    break;
            }
            switch(Power3.type)
            {
                case 1 :
                    firep++;
                    break;
                case 2 :
                    waterp++;
                    break;
                case 3 :
                    earthp++;
                    break;
                case 4 :
                    windp++;
                    break;
            }
            switch(firep)
            {
                case 3 :
                    getWorld().addObject(new ProjSpell(0), 0, 0);
                    return true; //3f
                case 2 :
                    if (earthp != 0)
                    {
                        getWorld().addObject(new ProjSpell(1), 0, 0);
                        return true; //2f 1e
                    }
                    if (waterp != 0)
                    {
                        getWorld().addObject(new Bufftype(4), 0, 0);
                        return true; //2f 1w
                    }
                    getWorld().addObject(new ProjSpell(2), 0, 0);
                    return true; //2f 1n
                case 1 :
                    switch(waterp)
                    {
                        case 1 :
                            if (earthp != 0)
                            {
                                if (Ult >= 100)
                                {
                                    getWorld().addObject(new BeamSpell(0), 600, 300);
                                    Ult -= 100;
                                }
                                else
                                {   Fail(1,1,1,0);
                                }
                                return true; //1f 1w 1e
                            }
                            if (Ult >= 200)
                            {
                                getWorld().addObject(new Bufftype(0), 0, 0);
                                Ult -= 200;
                            }
                            else
                            {
                                Fail(1,1,0,1);
                            }
                            return true; //1f 1w 1n
                        case 2 :
                            getWorld().addObject(new BeamSpell(3), 0, 0);
                            return true; //1f 2w
                    }
                    switch(earthp)
                    {
                        case 1 :
                            if (Ult >= 300)
                            {
                                getWorld().addObject(new BeamSpell(5), 0, 0);
                                Ult -= 300;
                            }
                            else
                            {
                                Fail(1,0,1,1);
                            }
                            return true; //1f 1e 1n
                        case 2 :
                            getWorld().addObject(new ProjSpell(3), 0, 0);
                            return true; //1f 2e
                    }
                    getWorld().addObject(new BeamSpell(7), 0, 0);
                    return true; //1f 2 n
                case 0 :
                    switch (waterp)
                    {
                        case 3 :
                            getWorld().addObject(new ProjSpell(4), 0, 0);
                            return true; //3w
                        case 2 :
                            if (earthp != 0)
                            {
                                getWorld().addObject(new Bufftype(1), 0, 0);
                                return true; //2w 1e
                            }
                            getWorld().addObject(new ProjSpell(5), 0, 0);
                            return true; //2w 1n
                        case 1 :
                            if (earthp == 1)
                            {
                                if (Ult >= 100)
                                {
                                    getWorld().addObject(new Bufftype(2), 0, 0);
                                    Ult -= 100;
                                }
                                else
                                {
                                    Fail(0,1,1,1);
                                }
                                return true; //1w 1e 1n
                            }
                            if (earthp == 2)
                            {
                                getWorld().addObject(new Bufftype(3), 0, 0);
                                return true; //1w 2e
                            }
                            getWorld().addObject(new BeamSpell(1), 0, 0);
                            return true; //1w 2n
                        case 0 :
                            switch(earthp)
                            {
                                case 3 :
                                    getWorld().addObject(new BeamSpell(6), 0, 0);
                                    return true; //3e
                                case 2 :
                                    getWorld().addObject(new ProjSpell(6), 0, 0);
                                    return true; //2e 1n
                                case 1 :
                                    getWorld().addObject(new BeamSpell(2), 0, 0);
                                    return true; //1e 2n
                            }
                            getWorld().addObject(new BeamSpell(4), 0, 0);
                            return true; //3n
                    }
            }
            return true;
    }
    void Fail(int a, int b, int c, int d) ///Visuals
    {
        for (int k = 0; k < a; k++)
        {
            FP -= 20;
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),3), getX() + 25, getY());
            }
        }
        for (int k = 0; k < b; k++)
        {
            WP -= 20;
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),1), getX() + 25, getY());
            }
        }
        for (int k = 0; k < c; k++)
        {
            EP -= 20;
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),0), getX() + 25, getY());
            }
        }
        for (int k = 0; k < d; k++)
        {
            NP -= 20;
            for (int j = Greenfoot.getRandomNumber(3) + 2; j >= 0; j--)
            {
                getWorld().addObject(new Shrapnel((-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(10), (-1 + Greenfoot.getRandomNumber(10) % 2 * 2) * Greenfoot.getRandomNumber(8),4), getX() + 25, getY());
            }
        }
    }
}
