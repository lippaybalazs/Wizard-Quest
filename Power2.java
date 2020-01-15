import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Visuals
 */
public class Power2 extends Actor
    {
        public static int type = 0;
        boolean fade = false;
        int i;
        GreenfootImage img = new GreenfootImage("Blank.png");
        GreenfootImage img0;
        GreenfootImage img1;
        GreenfootImage img2;
        GreenfootImage img3;
        GreenfootImage img01;
        GreenfootImage img11;
        GreenfootImage img21;
        GreenfootImage img31;
        public Power2()
        {
            type = 0;
            img0 = new GreenfootImage("fire0.png");
            img1 = new GreenfootImage("water0.png");
            img2 = new GreenfootImage("earth0.png");
            img3 = new GreenfootImage("wind0.png");
            img01 = new GreenfootImage("fire1.png");
            img11 = new GreenfootImage("water1.png");
            img21 = new GreenfootImage("earth1.png");
            img31 = new GreenfootImage("wind1.png");
        }
        public void act() 
        {
            switch (type)
            {
                case 1 :
                    getImage().setTransparency(255);
                    if (Counter.i % 50 < 25)
                    {
                        setImage(img0);
                    }
                    else
                    {
                        setImage(img01);
                    }
                    fade = false;
                    break;
                case 2 : 
                    getImage().setTransparency(255);
                    if (Counter.i % 50 < 25)
                    {
                        setImage(img1);
                    }
                    else
                    {
                        setImage(img11);
                    }
                    fade = false;
                    break;
                case 3 : 
                    getImage().setTransparency(255);
                    if (Counter.i % 50 < 25)
                    {
                        setImage(img2);
                    }
                    else
                    {
                        setImage(img21);
                    }
                    fade = false;
                    break;
                case 4 : 
                    getImage().setTransparency(255);
                    if (Counter.i % 50 < 25)
                    {
                        setImage(img3);
                    }
                    else
                    {
                        setImage(img31);
                    }
                    fade = false;
                    break;
                case 0 :
                    if (!fade)
                    {
                        getImage().setTransparency(255);
                        img = new GreenfootImage(getImage());
                        fade = true;
                        i = 250;
                    }
                    break;
            }
            if (fade && type == 0)
            {
                img.setTransparency(i);
                setImage(img);
                i -= 10;
                if ( i <= 0)
                {
                    fade = false;
                    getImage().setTransparency(255);
                    img = new GreenfootImage("Blank.png");
                    setImage(img);
                }
            }
            setLocation(Wizard.posX, Wizard.posY + 95);
    }    
}
