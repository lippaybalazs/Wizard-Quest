import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
public class Level extends World
{
    int i;
    public static int Points;
    public static int Goal;
    public static boolean boss = false;
    public static double BossHP;
    public static double BossMaxHP;
    static double diff;
    static double difficulty;
    public static boolean impossible;
    public Level(double d, double df, boolean imp)
    {
        // d determines fifficulty setting, df determines level
        super(1280, 720, 1, false);
        addObject(new BeamSpell(0), 600, 300);
        diff = d;
        impossible = imp;
        difficulty = df;
        i = 2500;
        setPaintOrder(explosion.class,WizDead.class,Shrapnel.class,BeamSpell.class,Power1.class, Power2.class, Power3.class,Bufftype.class,WizLeft.class,WizHead.class,Cloud.class,WizAnim.class,ProjSpell.class,WizRight.class,Wizard.class,HPVal.class,HPBar.class,Projectile.class,spellshadow.class);
        addObject(new Counter(),0,0);
        addObject(new CheckMonsters(), 640, 360);
        switch ((int)(d * 10))
        {
            case 10 :
                setBackground("Levels/stage0.png");
                break;
            case 11 :
                setBackground("Levels/stage1.png");
                break;
            case 12 :
                setBackground("Levels/stage3.png");
                break;
            case 13 :
                setBackground("Levels/stage2.png");
                break;
            case 14 :
                setBackground("Levels/stage5.png");
                break;
            case 15 :
                setBackground("Levels/stage6.png");
                break;
            case 16 :
                setBackground("Levels/stage7.png");
                break;
            default :
                setBackground("Levels/stage0.png");
                break;
        }
        addObject(new Wizard(), Wizard.posX, Wizard.posY);
        addObject(new WizAnim(), Wizard.posX, Wizard.posY);
        addObject(new WizHead(), Wizard.posX, Wizard.posY);
        addObject(new WizLeft(), Wizard.posX, Wizard.posY);
        addObject(new WizRight(), Wizard.posX, Wizard.posY);
        addObject(new Cloud(), Wizard.posX, Wizard.posY + 45);
        addObject(new Power1(), 0, 0);
        addObject(new Power2(), 0, 0);
        addObject(new Power3(), 0, 0);
        if (!impossible)
        {
            addObject(new HPBar(0),236,35);
            addObject(new HPBar(1),644,35);
            for (int j = 0; j < 100; j++)
            {
                addObject(new HPVal(j+1,0), 38 + j * 4, 35);
            }
            for (int j = 0; j < 100; j++)
            {
                addObject(new HPVal(j+1,1), 446 + j * 4, 35);
            }
        }
        else
        {
            Wizard.HP = 1;
            Wizard.Shield = 0;
            addObject(new HPBar(5),236,35);
            addObject(new HPBar(5),644,35);
        }
        addObject(new HPBar(2),1052,35);
        addObject(new HPBar(3),236,70);
        addObject(new HPBar(3),644,70);
        addObject(new HPBar(3),1052,70);
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,2), 853 + j * 2, 22);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,3), 1053 + j * 2, 22);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,4), 853 + j * 2, 47);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,5), 1053 + j * 2, 47);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,6), 38 + j * 4, 70);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,7), 446 + j * 4, 70);
        }
        for (int j = 0; j < 100; j++)
        {
            addObject(new HPVal(j+1,8), 854 + j * 4, 70);
        }
        BossHP = 0;
        Points = 0;
        Goal = (int)(d * df * 50);
        boss = false;
        Wizard.diff = d * df;
    }
    public void act()
    {
        switch ((int)(diff * 10))
        {
            case 10 :
                Level0();
                break;
            case 11 :
                Level1();
                break;
            case 12 :
                Level2();
                break;
            case 13 :
                Level3();
                break;
            case 14 :
                Level4();
                break;
            case 15 :
                Level5();
                break;
            case 16 : 
                Level6();
                break;
        }
    }
    void Level0()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(3) % 3 == 1)
                {
                    addObject(new Monster(1,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(3); j >= 0; j--)
                {
                    addObject(new Monster(0, 0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(3,0);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level1()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(4) % 4 == 0)
                {
                    addObject(new Monster(2,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                if (Greenfoot.getRandomNumber(3) % 3 <= 1)
                {
                    addObject(new Monster(1,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(2); j >= 0; j--)
                {
                    addObject(new Monster(0,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(4,0);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level2()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(4) % 4 == 0)
                {
                    addObject(new Monster(2,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                if (Greenfoot.getRandomNumber(3) % 3 <= 1)
                {
                    addObject(new Monster(1,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(2); j >= 0; j--)
                {
                    addObject(new Monster(0, Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(5,0);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level3()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(4) % 4 <= 1)
                {
                    addObject(new Monster(2,0), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                if (Greenfoot.getRandomNumber(3) % 3 <= 2)
                {
                    addObject(new Monster(1,Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(2); j >= 0; j--)
                {
                    addObject(new Monster(0, Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(3,5);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level4()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(3) % 3 <= 2)
                {
                    addObject(new Monster(2,Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(2); j >= 0; j--)
                {
                    addObject(new Monster(1, Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(4,5);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level5()
    {
        if (Points < Goal)
        {
            if (Greenfoot.getRandomNumber(i)/1000 > 2)
            {
                i = 2500;
                if (Greenfoot.getRandomNumber(10) % 10 == 2)
                {
                    addObject(new Monster(2,Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
                for (int j = Greenfoot.getRandomNumber(5); j >= 0; j--)
                {
                    addObject(new Monster(0, Greenfoot.getRandomNumber(10) % 5), 1350, Greenfoot.getRandomNumber(500) + 110);
                }
            }   
            else
            {
                i++;
            }
        }
        else
        {
            if(!boss)
            {
                if (CheckMonsters.MonsterCount == 0)
                {
                    Monster moni = new Monster(5,5);
                    addObject(moni, 1650, 360);
                    boss = true;
                    addObject(new HPBar(4),640,710);
                    for (int j = 0; j < 500; j++)
                    {
                        addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                    }
                }
            }
        }
    }
    void Level6()
    {
        if(!boss)
        {
            if (CheckMonsters.MonsterCount == 0)
            {
                Monster moni = new Monster(6,5);
                addObject(moni, 1650, 360);
                boss = true;
                addObject(new HPBar(4),640,710);
                for (int j = 0; j < 500; j++)
                {
                    addObject(new HPVal(j+1,9), 141 + j * 2, 710);
                }
            }
        }
    }
}
