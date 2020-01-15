import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class HPVal extends Actor
{
    int t;
    int type;
    GreenfootImage img0;
    public HPVal(int i, int x)
    {
        t = i;
        type = x;
        switch (type)
        {
            case 0 :
                img0 = new GreenfootImage("HP+.png");
                break;
            case 1 :
                img0 = new GreenfootImage("Shield+.png");
                break;
            case 2 :
                img0 = new GreenfootImage("fireres.png");
                break;
            case 3 :
                img0 = new GreenfootImage("waterres.png");
                break;
            case 4 :
                img0 = new GreenfootImage("earthres.png");
                break;
            case 5 :
                img0 = new GreenfootImage("windres.png");
                break;
            case 6 :
            case 7 :
            case 8 :
                img0 = new GreenfootImage("ultres.png");
                break;
            case 9 :
                img0 = new GreenfootImage("BossHP.png");
                break;
        }
    }
    public void act() 
    {
        switch (type)
        {
            case 0 :
                if (t > Wizard.HP)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 1 :
                if (t > Wizard.Shield)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 2 :
                if (t > Wizard.FP)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 3 :
                if (t > Wizard.WP)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 4 :
                if (t > Wizard.EP)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 5 :
                if (t > Wizard.NP)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 6 :
                if (t > Wizard.Ult)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 7 :
                if (t + 100 > Wizard.Ult)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 8 :
                if (t + 200 > Wizard.Ult)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                break;
            case 9 :
                if (t > (double)(Level.BossHP / Level.BossMaxHP) * 500)
                {
                    setImage((GreenfootImage)null);
                }
                else
                {
                    setImage(img0);
                }
                if (Level.BossHP <= 0)
                {
                    getWorld().removeObject(this);
                }
                break;
        }
    }   
}
