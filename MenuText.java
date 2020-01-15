import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The main manu and the buttons
 */
public class MenuText extends Actor
{
    int type;
    boolean on;
    public boolean vis = true;
    static boolean ent;
    GreenfootImage img0;
    GreenfootImage img1;
    GreenfootImage nullimg = new GreenfootImage("Menu/Blank.png"); 
    public MenuText(int x)
    {
        ent = false;
        type = x;
        switch (type)
        {
            case 0 :
                img0 = new GreenfootImage("Menu/Difficulty.png");
                img1 = new GreenfootImage("Menu/Difficulty.png");
                vis = false;
                break;
            case 1 :
                img0 = new GreenfootImage("Menu/NewGame0.png");
                img1 = new GreenfootImage("Menu/NewGame1.png");
                vis = true;
                break;
            case 2 :
                img0 = new GreenfootImage("Menu/LoadLevel0.png");
                img1 = new GreenfootImage("Menu/LoadLevel1.png");
                vis = true;
                break;
            case 3 :
                img0 = new GreenfootImage("Menu/SpellBook0.png");
                img1 = new GreenfootImage("Menu/SpellBook1.png");
                vis = true;
                break;
            case 4 :
                img0 = new GreenfootImage("Menu/Guide.png");
                img1 = new GreenfootImage("Menu/Guide.png");
                vis = true;
                break;
            case 5 :
                img0 = new GreenfootImage("Menu/Quit0.png");
                img1 = new GreenfootImage("Menu/Quit1.png");
                vis = true;
                break;
            case 6 :
                img0 = new GreenfootImage("Menu/Back0.png");
                img1 = new GreenfootImage("Menu/Back1.png");
                vis = false;
                break;
            case 7 :
                img0 = new GreenfootImage("Menu/Hardish0.png");
                img1 = new GreenfootImage("Menu/Hardish1.png");
                vis = false;
                break;
            case 8 :
                img0 = new GreenfootImage("Menu/Hard0.png");
                img1 = new GreenfootImage("Menu/Hard1.png");
                vis = false;
                break;
            case 9 :
                img0 = new GreenfootImage("Menu/Extreme0.png");
                img1 = new GreenfootImage("Menu/Extreme1.png");
                vis = false;
                break;
            case 10 :
                img0 = new GreenfootImage("Menu/Impossible0.png");
                img1 = new GreenfootImage("Menu/Impossible1.png");
                vis = false;
                break;
            case 11 :
                img0 = new GreenfootImage("Menu/Load0.png");
                img1 = new GreenfootImage("Menu/Load1.png");
                vis = false;
                break;
            case 12 :
                img0 = new GreenfootImage("Menu/SpellBook.png");
                img1 = new GreenfootImage("Menu/SpellBook.png");
                vis = false;
                break;
            case 13 :
                img0 = new GreenfootImage("Menu/Code.png");
                img1 = new GreenfootImage("Menu/Code.png");
                vis = false;
                break;
        }
        if(vis)
        {
            setImage(img0);
        }
        else
        {
            setImage(nullimg);
        }
        on = false;
    }
    public void act() 
    {
        Wizard hit = (Wizard) getOneIntersectingObject(Wizard.class);
        if (hit != null && (Wizard.posY <= getY() + 50 && Wizard.posY >= getY() - 50))
        {
            if(!on)
            {
                if(vis)
                {
                    setImage(img1);
                }
                else
                {
                    setImage(nullimg);
                }
                on = true;
            }
        }
        else
        {
            if(on)
            {
                if(vis)
                {
                    setImage(img0);
                }
                else
                {
                    setImage(nullimg);
                }
                on = false;
            }
        }
        Check();
    } 
    public void UpdateVis(boolean x)
    {
        vis = x;
        if (!vis)
        {
            setImage(nullimg);
        }
        else
        {
            setImage(img0);
            on = false;
        }
    }
    void Check() ///the button presses and their functions
    {
        if (vis && on)
        {
            if (Greenfoot.isKeyDown("enter"))
            {
                if(!ent)
                {
                    ent = true;
                    switch (type)
                    {
                        case 1 :
                            Menu.WinState1();
                            Menu.diff = 1;
                            break;
                        case 2 :
                            Menu.WinState2();
                            break;
                        case 3 :
                            Menu.WinState3();
                            break;
                        case 5 :
                            System.exit(0);
                            break;
                        case 6 :
                            Menu.WinState0();
                            break;
                        case 7 :
                            Menu.difficulty = 0.5;
                            Menu.impossible = false;
                            Greenfoot.setWorld(new Level(Menu.diff,Menu.difficulty,Menu.impossible));
                            break;
                        case 8 :
                            Menu.difficulty = 1;
                            Menu.impossible = false;
                            Greenfoot.setWorld(new Level(Menu.diff,Menu.difficulty,Menu.impossible));
                            break;
                        case 9 :
                            Menu.difficulty = 2;
                            Menu.impossible = false;
                            Greenfoot.setWorld(new Level(Menu.diff,Menu.difficulty,Menu.impossible));
                            break;
                        case 10 :
                            Menu.difficulty = 2;
                            Menu.impossible = true;
                            Greenfoot.setWorld(new Level(Menu.diff,Menu.difficulty,Menu.impossible));
                            break;
                        case 11:
                            int k = Menu.Compute();
                            switch (k)
                            {
                                case 1234 :
                                    Menu.diff = 1.1;
                                    Menu.WinState1();
                                    break;
                                case 4132 :
                                    Menu.diff = 1.2;
                                    Menu.WinState1();
                                    break;
                                case 2314 :
                                    Menu.diff = 1.3;
                                    Menu.WinState1();
                                    break;
                                case 3312 :
                                    Menu.diff = 1.4;
                                    Menu.WinState1();
                                    break;
                                case 1221 :
                                    Menu.diff = 1.5;
                                    Menu.WinState1();
                                    break;
                                case 4214 :
                                    Menu.diff = 1.6;
                                    Menu.WinState1();
                                    break;
                            }
                            getWorld().addObject(new BeamSpell(0), 600, 300);
                            break;
                    }
                }
            }
            else
            {
                ent = false;
            }
        }
    }
}
