import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Menu extends World
{
    static Monster mon0;
    static Monster mon1;
    static Monster mon2;
    static Monster mon3;
    static MenuText men0;
    static MenuText men1;
    static MenuText men2;
    static MenuText men3;
    static MenuText men4;
    static MenuText men5;
    static MenuText men6;
    static MenuText men7;
    static MenuText men8;
    static MenuText men9;
    static MenuText men10;
    static MenuText men11;
    static MenuText men12;
    static MenuText men13;
    public static int windowstate = 0;
    public static double diff;
    public static double difficulty;
    public static boolean impossible = false;
    public void stopped()
    {
        Wizard.backgroundMusic.setVolume(0);
    }
    public void started()
    {
        Wizard.backgroundMusic.setVolume(15);
    }
    public Menu()
    {    
        super(1280, 720, 1, false);  
        Wizard.HP = 100;
        Wizard.Shield = 100;
        addObject(new BeamSpell(0), 600, 300);
        windowstate = 0;
        setBackground("Levels/stage4.png");
        addObject(new Counter(),0,0);
        addObject(new Wizard(), 580, 400);
        addObject(new WizAnim(), 580, 400);
        addObject(new WizHead(), 580, 400);
        addObject(new WizLeft(), 553, 437);
        addObject(new WizRight(), 603, 430);
        addObject(new Cloud(), 580, 445);
        setPaintOrder(explosion.class,Shrapnel.class,BeamSpell.class,Power1.class, Power2.class, Power3.class,Bufftype.class,WizLeft.class,WizHead.class,Cloud.class,WizAnim.class,ProjSpell.class,WizRight.class,Wizard.class,HPVal.class,HPBar.class,Projectile.class,spellshadow.class);
        addObject(new Power1(), 0, 0);
        addObject(new Power2(), 0, 0);
        addObject(new Power3(), 0, 0);
        mon0 = new Monster(99,0);
        mon1 = new Monster(99,0);
        mon2 = new Monster(99,0);
        mon3 = new Monster(99,0);
        men0 = new MenuText(0);
        men1 = new MenuText(1);
        men2 = new MenuText(2);
        men3 = new MenuText(3);
        men4 = new MenuText(4);
        men5 = new MenuText(5);
        men6 = new MenuText(6);
        men7 = new MenuText(7);
        men8 = new MenuText(8);
        men9 = new MenuText(9);
        men10 = new MenuText(10);
        men11 = new MenuText(11);
        men12 = new MenuText(12);
        men13= new MenuText(13);
        addObject(men0, 250, 670);
        addObject(men1, 940, 275);
        addObject(men2, 940, 400);
        addObject(men3, 940, 525);
        addObject(men4, 640, 360);
        addObject(men5, 1100, 670);
        addObject(men6, 1100, 670);
        addObject(men7, 940, 150);
        addObject(men8, 940, 275);
        addObject(men9, 940, 400);
        addObject(men10, 940, 525);
        addObject(men11, 180, 670);
        addObject(men12, 640, 360);
        addObject(men13, 640, 360);
        addObject(mon0, 1200, 150);
        addObject(mon1, 1200, 275);
        addObject(mon2, 1200, 400);
        addObject(mon3, 1200, 525);
        Wizard.backgroundMusic.setVolume(15);
    }
    public void act()
    {
        Wizard.Ult = 300;
        Wizard.FP = 100;
        Wizard.WP = 100;
        Wizard.EP = 100;
        Wizard.NP = 100;
    }
    public static void WinState0()
    {
        windowstate = 0;
        men0.UpdateVis(false);
        men1.UpdateVis(true);
        men2.UpdateVis(true);
        men3.UpdateVis(true);
        men4.UpdateVis(true);
        men5.UpdateVis(true);
        men6.UpdateVis(false);
        men7.UpdateVis(false);
        men8.UpdateVis(false);
        men9.UpdateVis(false);
        men10.UpdateVis(false);
        men11.UpdateVis(false);
        men12.UpdateVis(false);
        men13.UpdateVis(false);
        mon0.burn = true;
        mon1.burn = true;
        mon2.burn = true;
        mon3.burn = true;
    }
    public static void WinState1()
    {
        windowstate = 1;
        men0.UpdateVis(true);
        men1.UpdateVis(false);
        men2.UpdateVis(false);
        men3.UpdateVis(false);
        men4.UpdateVis(false);
        men5.UpdateVis(false);
        men6.UpdateVis(true);
        men7.UpdateVis(true);
        men8.UpdateVis(true);
        men9.UpdateVis(true);
        men10.UpdateVis(true);
        men11.UpdateVis(false);
        men12.UpdateVis(false);
        men13.UpdateVis(false);
        mon0.burn = true;
        mon1.burn = true;
        mon2.burn = true;
        mon3.burn = true;
    }
    public static void WinState2()
    {
        windowstate = 2;
        men0.UpdateVis(false);
        men1.UpdateVis(false);
        men2.UpdateVis(false);
        men3.UpdateVis(false);
        men4.UpdateVis(false);
        men5.UpdateVis(false);
        men6.UpdateVis(true);
        men7.UpdateVis(false);
        men8.UpdateVis(false);
        men9.UpdateVis(false);
        men10.UpdateVis(false);
        men11.UpdateVis(true);
        men12.UpdateVis(false);
        men13.UpdateVis(true);
        mon0.burn = false;
        mon1.burn = false;
        mon2.burn = false;
        mon3.burn = false;
    }
    public static void WinState3()
    {
        windowstate = 3;
        men0.UpdateVis(false);
        men1.UpdateVis(false);
        men2.UpdateVis(false);
        men3.UpdateVis(false);
        men4.UpdateVis(false);
        men5.UpdateVis(false);
        men6.UpdateVis(true);
        men7.UpdateVis(false);
        men8.UpdateVis(false);
        men9.UpdateVis(false);
        men10.UpdateVis(false);
        men11.UpdateVis(false);
        men12.UpdateVis(true);
        men13.UpdateVis(false);
        mon0.burn = true;
        mon1.burn = true;
        mon2.burn = true;
        mon3.burn = true;
    }
    public static int Compute()
    {
        return mon0.speed + mon1.speed * 10 + mon2.speed * 100 + mon3.speed * 1000;
    }
}
