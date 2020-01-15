import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The projectiles that are suposed to be avoided,
 * most of the code is for visuals
 */
public class Projectile extends Actor
{
    double X;
    double Y;
    public int damage;
    double posX;
    double posY;
    public Projectile(double x, double y, int a, int b, int dmg)
    {
        X = x;
        Y = y;
        posX = a;
        posY = b;
        damage = dmg;
        if (dmg <= 10)
        {
            setImage(new GreenfootImage("Projectile.png"));
        }
        if (dmg > 10)
        {
            setImage(new GreenfootImage("BigProjectile.png"));
        }
    }
    public void act() 
    {
        posX += X;
        posY += Y;
        if (Counter.i % 8 ==0)
        {
            getWorld().addObject(new spellshadow(0), getX(), getY());
        }
        setLocation((int)(posX), (int)(posY));
        CheckColl();
    }  
    boolean CheckColl()
    {
        if(getX() + 50 <= 0)
        {
            getWorld().removeObject(this);
            return false;
        }
        if (getOneIntersectingObject(Wizard.class) != null)
        {
            getWorld().addObject(new explosion(0), getX(), getY());
            Wizard.Damage(damage);
            getWorld().removeObject(this);
            return false;
        }
        return true;
    }
}
