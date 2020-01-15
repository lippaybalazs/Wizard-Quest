import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class explosion extends Actor
{
    int i = 250;
    int type = 0;
    GreenfootImage img;
    GreenfootSound sound;
    public explosion(int x)
    {
        switch (x)
        {
            case 0 :
                img = new GreenfootImage("projectileboom.png");
                sound = new GreenfootSound("Explosion.wav");
                sound.setVolume(50);
                sound.play();
                break;
            case 1 :
                img = new GreenfootImage("fireboom.png");
                sound = new GreenfootSound("Explosion.wav");
                sound.setVolume(60);
                sound.play();
                break;
            case 2 :
                img = new GreenfootImage("explosion.png");
                sound = new GreenfootSound("Explosion.wav");
                sound.setVolume(70);
                sound.play();
                break;
            case 3 :
                img = new GreenfootImage("burn.png");
                break;
            case 4 :
                img = new GreenfootImage("waterboom.png");
                break;
            case 5 :
                img = new GreenfootImage("SteamExplosion.png");
                sound = new GreenfootSound("SteamExplosion.wav");
                sound.setVolume(70);
                sound.play();
                type = 1;
                break;
            case 6 :
                img = new GreenfootImage("windexplo.png");
                break;
        }
    }
    public void act() 
    {
        img.setTransparency(i);
        setImage(img);
        if (i == 0)
        {
            getWorld().removeObject(this);
        }
        if (type == 0)
        {
            i -= 25;
        }
        if (type == 1)
        {
            i -=5;
        }
    }    
}
