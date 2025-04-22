public class Character1 
{
    private String ElementType;

    private double CharBaseHP;
    private double CharBaseATK;
    private double CharBaseDEF;
    
    private String WeaponType;
    private String WeaponName;
    private double WeaponATKNumber;
    private String WeaponStatName;
    private double WeaponStatNumber;

    private String AscensionStatName;
    private double AscensionStatNumber;

    private ArtifactFlower Flower;
    private ArtifactFeather Feather;
    private ArtifactSands Sands;
    private ArtifactGoblet Goblet;
    private ArtifactCirclet Circlet;

    private double CharHP = 0;
    private double CharATK = 0;
    private double CharDEF = 0;
    private double CharEM = 0;
    private double CharER = 100;
    private double CharCR = 5;
    private double CharCD = 50;

    private double CharPhysicalDMG = 0;
    private double CharPyroDMG = 0;
    private double CharHydroDMG = 0;
    private double CharAnemoDMG = 0;
    private double CharElectroDMG = 0;
    private double CharDendroDMG = 0;
    private double CharCryoDMG = 0;
    private double CharGeoDMG = 0;

    // Add hidden buffs? (NA/CA damage, bonus damage, artifact set bonuses)
    // Add artifact buffs after?

    public Character1(String ElementType, double BaseHP, double BaseATK, double BaseDEF, String WeaponType, String WeaponName, double WeaponATKNumber, String WeaponStatName, double WeaponStatNumber, String AscensionStatName, double AscensionStatNumber, ArtifactFlower Flower, ArtifactFeather Feather, ArtifactSands Sands, ArtifactGoblet Goblet, ArtifactCirclet Circlet)

    {
        this.ElementType = ElementType;

        CharBaseHP = BaseHP;
        CharBaseATK = BaseATK + WeaponATKNumber;
        CharBaseDEF = BaseDEF;

        this.WeaponType = WeaponType;
        this.WeaponName = WeaponName;


        CharHP += CharBaseHP;
        CharATK += CharBaseATK;
        CharDEF += CharBaseDEF;

        AddStat(AscensionStatName, AscensionStatNumber);
        AddStat(WeaponStatName, WeaponStatNumber);

        this.Flower = Flower;
        AddStat(Flower.MainStatName(), Flower.MainStatNumber());
        AddStat(Flower.Stat1Name(), Flower.Stat1Number());
        AddStat(Flower.Stat2Name(), Flower.Stat2Number());
        AddStat(Flower.Stat3Name(), Flower.Stat3Number());
        AddStat(Flower.Stat4Name(), Flower.Stat4Number());

        this.Feather = Feather;
        AddStat(Feather.MainStatName(), Feather.MainStatNumber());
        AddStat(Feather.Stat1Name(), Feather.Stat1Number());
        AddStat(Feather.Stat2Name(), Feather.Stat2Number());
        AddStat(Feather.Stat3Name(), Feather.Stat3Number());
        AddStat(Feather.Stat4Name(), Feather.Stat4Number());

        this.Sands = Sands;
        AddStat(Sands.MainStatName(), Sands.MainStatNumber());
        AddStat(Sands.Stat1Name(), Sands.Stat1Number());
        AddStat(Sands.Stat2Name(), Sands.Stat2Number());
        AddStat(Sands.Stat3Name(), Sands.Stat3Number());
        AddStat(Sands.Stat4Name(), Sands.Stat4Number());

        this.Goblet = Goblet;
        AddStat(Goblet.MainStatName(), Goblet.MainStatNumber());
        AddStat(Goblet.Stat1Name(), Goblet.Stat1Number());
        AddStat(Goblet.Stat2Name(), Goblet.Stat2Number());
        AddStat(Goblet.Stat3Name(), Goblet.Stat3Number());
        AddStat(Goblet.Stat4Name(), Goblet.Stat4Number());

        this.Circlet = Circlet;
        AddStat(Circlet.MainStatName(), Circlet.MainStatNumber());
        AddStat(Circlet.Stat1Name(), Circlet.Stat1Number());
        AddStat(Circlet.Stat2Name(), Circlet.Stat2Number());
        AddStat(Circlet.Stat3Name(), Circlet.Stat3Number());
        AddStat(Circlet.Stat4Name(), Circlet.Stat4Number());
    }    

    public void RefreshStats(String ElementType, double BaseHP, double BaseATK, double BaseDEF, String WeaponType, String WeaponName, double WeaponATKNumber, String WeaponStatName, double WeaponStatNumber, String AscensionStatName, double AscensionStatNumber, ArtifactFlower Flower, ArtifactFeather Feather, ArtifactSands Sands, ArtifactGoblet Goblet, ArtifactCirclet Circlet)
    {
        CharHP = 0;
        CharATK = 0;
        CharDEF = 0;
        CharEM = 0;
        CharER = 100;
        CharCR = 5;
        CharCD = 50;

        CharPhysicalDMG = 0;
        CharPyroDMG = 0;
        CharHydroDMG = 0;
        CharAnemoDMG = 0;
        CharElectroDMG = 0;
        CharDendroDMG = 0;
        CharCryoDMG = 0;
        CharGeoDMG = 0;

        CharHP += CharBaseHP;
        CharATK += CharBaseATK;
        CharDEF += CharBaseDEF;

        AddStat(AscensionStatName, AscensionStatNumber);
        AddStat(WeaponStatName, WeaponStatNumber);

        AddStat(Flower.MainStatName(), Flower.MainStatNumber());
        AddStat(Flower.Stat1Name(), Flower.Stat1Number());
        AddStat(Flower.Stat2Name(), Flower.Stat2Number());
        AddStat(Flower.Stat3Name(), Flower.Stat3Number());
        AddStat(Flower.Stat4Name(), Flower.Stat4Number());

        AddStat(Feather.MainStatName(), Feather.MainStatNumber());
        AddStat(Feather.Stat1Name(), Feather.Stat1Number());
        AddStat(Feather.Stat2Name(), Feather.Stat2Number());
        AddStat(Feather.Stat3Name(), Feather.Stat3Number());
        AddStat(Feather.Stat4Name(), Feather.Stat4Number());

        AddStat(Sands.MainStatName(), Sands.MainStatNumber());
        AddStat(Sands.Stat1Name(), Sands.Stat1Number());
        AddStat(Sands.Stat2Name(), Sands.Stat2Number());
        AddStat(Sands.Stat3Name(), Sands.Stat3Number());
        AddStat(Sands.Stat4Name(), Sands.Stat4Number());

        AddStat(Goblet.MainStatName(), Goblet.MainStatNumber());
        AddStat(Goblet.Stat1Name(), Goblet.Stat1Number());
        AddStat(Goblet.Stat2Name(), Goblet.Stat2Number());
        AddStat(Goblet.Stat3Name(), Goblet.Stat3Number());
        AddStat(Goblet.Stat4Name(), Goblet.Stat4Number());

        AddStat(Circlet.MainStatName(), Circlet.MainStatNumber());
        AddStat(Circlet.Stat1Name(), Circlet.Stat1Number());
        AddStat(Circlet.Stat2Name(), Circlet.Stat2Number());
        AddStat(Circlet.Stat3Name(), Circlet.Stat3Number());
        AddStat(Circlet.Stat4Name(), Circlet.Stat4Number());
    }

    public void AddStat(String Name, Double Number)
    {
        if (Name.equals("FlatHP"))
        {CharHP += Number;}
        else if (Name.equals("PercentHP"))
        {CharHP += (CharBaseHP * Number / 100);}
        else if (Name.equals("FlatDEF"))
        {CharDEF += Number;}
        else if (Name.equals("PercentDEF"))
        {CharDEF += (CharBaseDEF * Number / 100);}
        else if (Name.equals("FlatATK"))
        {CharATK += Number;}
        else if (Name.equals("PercentATK"))
        {CharATK += (CharBaseATK * Number / 100);}
        else if (Name.equals("EM"))
        {CharEM += Number;}
        else if (Name.equals("ER"))
        {CharER += Number;}
        else if (Name.equals("CR"))
        {CharCR += Number;}
        else if (Name.equals("CD"))
        {CharCD += Number;}
        else if (Name.equals("PhysicalDMG"))
        {CharPhysicalDMG += Number;}
        else if (Name.equals("PyroDMG"))
        {CharPyroDMG += Number;}
        else if (Name.equals("HydroDMG"))
        {CharHydroDMG += Number;}
        else if (Name.equals("AnemoDMG"))
        {CharAnemoDMG += Number;}
        else if (Name.equals("ElectroDMG"))
        {CharElectroDMG += Number;}
        else if (Name.equals("DenroDMG"))
        {CharDendroDMG += Number;}
        else if (Name.equals("CryoDMG"))
        {CharCryoDMG += Number;}
        else if (Name.equals("GeoDMG"))
        {CharGeoDMG += Number;}
        
    }

    public void PrintCharStats()
    {
        System.out.println("BaseHP - " + CharBaseHP);
        System.out.println("BaseATK - " + CharBaseATK);
        System.out.println("BaseDEF - " + CharBaseDEF);

        System.out.println("All details");

        System.out.println("CharHP - " + CharBaseHP + " + " + (CharHP - CharBaseHP) + " = " + CharHP);
        System.out.println("CharATK - " + CharBaseATK + " + " + (CharATK - CharBaseATK) + " = " + CharATK);
        System.out.println("CharDEF - " + CharBaseDEF + " + " + (CharDEF - CharBaseDEF) + " = " + CharDEF);

        System.out.println("CharEM - " + CharEM);
        System.out.println("CharER - " + CharER);
        System.out.println("CharCR - " + CharCR);
        System.out.println("CharCD - " + CharCD);
        System.out.println();

        //System.out.println("Char PhysicalDMG - " + CharPhysicalDMG);
        //System.out.println("Char PyroDMG - " + CharPyroDMG);
        //System.out.println("Char HydroDMG - " + CharHydroDMG);
        //System.out.println("Char AnemoDMG - " + CharAnemoDMG);
        //System.out.println("Char ElectroDMG - " + CharElectroDMG);
        //System.out.println("Char DendroDMG - " + CharDendroDMG);
        //System.out.println("Char CryoDMG - " + CharCryoDMG);
        //System.out.println("Char GeoDMG - " + CharGeoDMG);
        //System.out.println();

    }

    public double CharHP()
    {return CharHP;}

    public double CharATK()
    {return CharATK;}

    public double CharDEF()
    {return CharDEF;}

    public double CharEM()
    {return CharEM;}

    public double CharER()
    {return CharER;}

    public double CharCR()
    {return CharCR;}

    public double CharCD()
    {return CharCD;}

    public double CharPhysicalDMG()
    {return CharPhysicalDMG;}

    public double CharPyroDMG()
    {return CharPyroDMG;}

    public double CharHydroDMG()
    {return CharHydroDMG;}

    public double CharAnemoDMG()
    {return CharAnemoDMG;}

    public double CharElectroDMG()
    {return CharElectroDMG;}

    public double CharDendroDMG()
    {return CharDendroDMG;}

    public double CharCryoDMG()
    {return CharCryoDMG;}

    public double CharGeoDMG()
    {return CharGeoDMG;}

    public ArtifactFlower CharFlower()
    {return Flower;}

    public ArtifactFeather CharFeather()
    {return Feather;}

    public ArtifactSands CharSands()
    {return Sands;}

    public ArtifactGoblet CharGoblet()
    {return Goblet;}

    public ArtifactCirclet CharCirclet()
    {return Circlet;}

    

    public void ChangeCharFlower(ArtifactFlower NewFlower)
    {Flower = NewFlower;}

    public void ChangeCharFeather(ArtifactFeather NewFeather)
    {Feather = NewFeather;}

    public void ChangeCharSands(ArtifactSands NewSands)
    {Sands = NewSands;}

    public void ChangeCharGoblet(ArtifactGoblet NewGoblet)
    {Goblet = NewGoblet;}

    public void ChangeCharCirclet(ArtifactCirclet NewCirclet)
    {Circlet = NewCirclet;}

    public void PrintCharFlower()
    {
        Flower.PrintArtifact();
    }

    public void PrintCharFeather()
    {
        Feather.PrintArtifact();
    }

    public void PrintCharSands()
    {
        Sands.PrintArtifact();
    }

    public void PrintCharGoblet()
    {
        Goblet.PrintArtifact();
    }

    public void PrintCharCirclet()
    {
        Circlet.PrintArtifact();
    }
}

