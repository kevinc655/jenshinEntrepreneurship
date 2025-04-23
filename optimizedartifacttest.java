import java.util.Random;
public class optimizedartifacttest 
{
    public static void main(String[] args) 
    {
        RandomArtifact randomflower = new RandomArtifact("Flower");
        ArtifactFlower CharFlower = new ArtifactFlower(null, 20, randomflower.Stat1Name(), randomflower.Stat1Number(), randomflower.Stat2Name(), randomflower.Stat2Number(), randomflower.Stat3Name(), randomflower.Stat3Number(), randomflower.Stat4Name(), randomflower.Stat4Number(), randomflower.Stat1RollCount(), randomflower.Stat2RollCount(), randomflower.Stat3RollCount(), randomflower.Stat4RollCount());

        RandomArtifact randomfeather = new RandomArtifact("Feather");
        ArtifactFeather CharFeather = new ArtifactFeather(null, 20, randomfeather.Stat1Name(), randomfeather.Stat1Number(), randomfeather.Stat2Name(), randomfeather.Stat2Number(), randomfeather.Stat3Name(), randomfeather.Stat3Number(), randomfeather.Stat4Name(), randomfeather.Stat4Number(), randomfeather.Stat1RollCount(), randomfeather.Stat2RollCount(), randomfeather.Stat3RollCount(), randomfeather.Stat4RollCount());

        RandomArtifact randomsands = new RandomArtifact("Sands");
        ArtifactSands CharSands = new ArtifactSands(null, 20, randomsands.MainStatName(), randomsands.Stat1Name(), randomsands.Stat1Number(), randomsands.Stat2Name(), randomsands.Stat2Number(), randomsands.Stat3Name(), randomsands.Stat3Number(), randomsands.Stat4Name(), randomsands.Stat4Number(), randomsands.Stat1RollCount(), randomsands.Stat2RollCount(), randomsands.Stat3RollCount(), randomsands.Stat4RollCount());

        RandomArtifact randomgoblet = new RandomArtifact("Goblet");
        ArtifactGoblet CharGoblet = new ArtifactGoblet(null, 20, randomgoblet.MainStatName(), randomgoblet.Stat1Name(), randomgoblet.Stat1Number(), randomgoblet.Stat2Name(), randomgoblet.Stat2Number(), randomgoblet.Stat3Name(), randomgoblet.Stat3Number(), randomgoblet.Stat4Name(), randomgoblet.Stat4Number(), randomgoblet.Stat1RollCount(), randomgoblet.Stat2RollCount(), randomgoblet.Stat3RollCount(), randomgoblet.Stat4RollCount());

        RandomArtifact randomcirclet = new RandomArtifact("Circlet");
        ArtifactCirclet CharCirclet = new ArtifactCirclet(null, 20, randomcirclet.MainStatName(), randomcirclet.Stat1Name(), randomcirclet.Stat1Number(), randomcirclet.Stat2Name(), randomcirclet.Stat2Number(), randomcirclet.Stat3Name(), randomcirclet.Stat3Number(), randomcirclet.Stat4Name(), randomcirclet.Stat4Number(), randomcirclet.Stat1RollCount(), randomcirclet.Stat2RollCount(), randomcirclet.Stat3RollCount(), randomcirclet.Stat4RollCount());

        Character1 currentcharacter = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, CharFlower, CharFeather, CharSands, CharGoblet, CharCirclet);    

        currentcharacter.PrintCharStats();

        currentcharacter.PrintCharFlower();
        currentcharacter.PrintCharFeather();
        currentcharacter.PrintCharSands();
        currentcharacter.PrintCharGoblet();
        currentcharacter.PrintCharCirclet();

        int desiredartifactruns = 100000000;
        int currentrun = 0;
        int FlowerChanges = 0;
        int FeatherChanges = 0;
        int SandsChanges = 0;
        int GobletChanges = 0;
        int CircletChanges = 0;
        int FlowerLengthChange = 0;
        int FeatherLengthChange = 0;
        int SandsLengthChange = 0;
        int GobletLengthChange = 0;
        int CircletLengthChange = 0;
        int ArtifactLengthChange = 0;

        while (currentrun != desiredartifactruns)
        {
            Random random = new Random();

            currentrun++;
            FlowerLengthChange++;
            FeatherLengthChange++;
            SandsLengthChange++;
            GobletLengthChange++;
            CircletLengthChange++;
            ArtifactLengthChange++;

            currentcharacter.RefreshStats("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, currentcharacter.CharFlower(), currentcharacter.CharFeather(), currentcharacter.CharSands(), currentcharacter.CharGoblet(), currentcharacter.CharCirclet());

            if (currentrun % 1000000 == 0)
            {
                System.out.println("Current Run: " + currentrun);

                if (currentrun % 10000000 == 0)
                {
                    currentcharacter.PrintCharStats();

                    currentcharacter.PrintCharFlower();
                    currentcharacter.PrintCharFeather();
                    currentcharacter.PrintCharSands();
                    currentcharacter.PrintCharGoblet();
                    currentcharacter.PrintCharCirclet();
                }
            }

            double CurrentCharacterDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
            
            String[] TypeList = {"Flower", "Feather", "Sands", "Goblet", "Circlet"};

            RandomArtifact randomartifact = new RandomArtifact(TypeList[random.nextInt(TypeList.length)]);

            if (randomartifact.Type().equals("Flower"))
            {
                ArtifactFlower NewCharFlower = new ArtifactFlower(null, 20, randomartifact.Stat1Name(), randomartifact.Stat1Number(), randomartifact.Stat2Name(), randomartifact.Stat2Number(), randomartifact.Stat3Name(), randomartifact.Stat3Number(), randomartifact.Stat4Name(), randomartifact.Stat4Number(), randomartifact.Stat1RollCount(), randomartifact.Stat2RollCount(), randomartifact.Stat3RollCount(), randomartifact.Stat4RollCount());

                Character1 newtest2character = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, NewCharFlower, currentcharacter.CharFeather(), currentcharacter.CharSands(), currentcharacter.CharGoblet(), currentcharacter.CharCirclet());    
                double newtest2characterDamage = ATKDamageCalculator(newtest2character.CharATK(), newtest2character.CharEM(), newtest2character.CharCR(), newtest2character.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                if (newtest2characterDamage > CurrentCharacterDamage)
                {
                    System.out.println("Replacing Flower-------------------------");
                    
                    currentcharacter.ChangeCharFlower(newtest2character.CharFlower());
                                
                    double newDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                    
                    System.out.println("New Damage: " + newDamage);
                    
                    FlowerChanges++;
                    System.out.println("Took " + FlowerLengthChange + " artifacts to improve Flower. (iteration = " + currentrun + ")");
                    System.out.println("Took " + ArtifactLengthChange + " artifacts to improve damage.");
                    FlowerLengthChange = 0;
                    ArtifactLengthChange = 0;
                }
            }
            else if (randomartifact.Type().equals("Feather"))
            {
                ArtifactFeather NewCharFeather = new ArtifactFeather(null, 20, randomartifact.Stat1Name(), randomartifact.Stat1Number(), randomartifact.Stat2Name(), randomartifact.Stat2Number(), randomartifact.Stat3Name(), randomartifact.Stat3Number(), randomartifact.Stat4Name(), randomartifact.Stat4Number(), randomartifact.Stat1RollCount(), randomartifact.Stat2RollCount(), randomartifact.Stat3RollCount(), randomartifact.Stat4RollCount());

                Character1 newtest2character = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, currentcharacter.CharFlower(), NewCharFeather, currentcharacter.CharSands(), currentcharacter.CharGoblet(), currentcharacter.CharCirclet());    
                double newtest2characterDamage = ATKDamageCalculator(newtest2character.CharATK(), newtest2character.CharEM(), newtest2character.CharCR(), newtest2character.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                if (newtest2characterDamage > CurrentCharacterDamage)
                {
                    System.out.println("Replacing Feather------------------------------");
                    
                    currentcharacter.ChangeCharFeather(newtest2character.CharFeather());
                
                    double newDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                    
                    System.out.println("New Damage: " + newDamage);

                    FeatherChanges++;
                    System.out.println("Took " + FeatherLengthChange + " artifacts to improve Feather. (iteration = " + currentrun + ")");
                    System.out.println("Took " + ArtifactLengthChange + " artifacts to improve damage.");
                    FeatherLengthChange = 0;
                    ArtifactLengthChange = 0;
                }
            }
            else if (randomartifact.Type().equals("Sands"))
            {
                ArtifactSands NewCharSands = new ArtifactSands(null, 20, randomartifact.MainStatName(), randomartifact.Stat1Name(), randomartifact.Stat1Number(), randomartifact.Stat2Name(), randomartifact.Stat2Number(), randomartifact.Stat3Name(), randomartifact.Stat3Number(), randomartifact.Stat4Name(), randomartifact.Stat4Number(), randomartifact.Stat1RollCount(), randomartifact.Stat2RollCount(), randomartifact.Stat3RollCount(), randomartifact.Stat4RollCount());

                Character1 newtest2character = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, currentcharacter.CharFlower(), currentcharacter.CharFeather(), NewCharSands, currentcharacter.CharGoblet(), currentcharacter.CharCirclet());    
                double newtest2characterDamage = ATKDamageCalculator(newtest2character.CharATK(), newtest2character.CharEM(), newtest2character.CharCR(), newtest2character.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                if (newtest2characterDamage > CurrentCharacterDamage)
                {
                    System.out.println("Replacing Sands------------------------------");
        
                    currentcharacter.ChangeCharSands(newtest2character.CharSands());

                    double newDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                    System.out.println("New Damage: " + newDamage);

                    SandsChanges++;
                    System.out.println("Took " + SandsLengthChange + " artifacts to improve Sands. (iteration = " + currentrun + ")");
                    System.out.println("Took " + ArtifactLengthChange + " artifacts to improve damage.");
                    SandsLengthChange = 0;
                    ArtifactLengthChange = 0;
                }
            }
            else if (randomartifact.Type().equals("Goblet"))
            {
                ArtifactGoblet NewCharGoblet = new ArtifactGoblet(null, 20, randomartifact.MainStatName(), randomartifact.Stat1Name(), randomartifact.Stat1Number(), randomartifact.Stat2Name(), randomartifact.Stat2Number(), randomartifact.Stat3Name(), randomartifact.Stat3Number(), randomartifact.Stat4Name(), randomartifact.Stat4Number(), randomartifact.Stat1RollCount(), randomartifact.Stat2RollCount(), randomartifact.Stat3RollCount(), randomartifact.Stat4RollCount());

                Character1 newtest2character = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, currentcharacter.CharFlower(), currentcharacter.CharFeather(), currentcharacter.CharSands(), NewCharGoblet, currentcharacter.CharCirclet());    
                double newtest2characterDamage = ATKDamageCalculator(newtest2character.CharATK(), newtest2character.CharEM(), newtest2character.CharCR(), newtest2character.CharCD(), 300, 1, 0, 0, "ForwardVaporize");

                if (newtest2characterDamage > CurrentCharacterDamage)
                {
                    System.out.println("Replacing Goblet-------------------------------");
                   
                    currentcharacter.ChangeCharGoblet(newtest2character.CharGoblet());

                    double newDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                    System.out.println("New Damage: " + newDamage);

                    GobletChanges++;
                    System.out.println("Took " + GobletLengthChange + " artifacts to improve Goblet. (iteration = " + currentrun + ")");
                    System.out.println("Took " + ArtifactLengthChange + " artifacts to improve damage.");
                    GobletLengthChange = 0;
                    ArtifactLengthChange = 0;
                }
            }
            else if (randomartifact.Type().equals("Circlet"))
            {
                ArtifactCirclet NewCharCirclet = new ArtifactCirclet(null, 20, randomartifact.MainStatName(), randomartifact.Stat1Name(), randomartifact.Stat1Number(), randomartifact.Stat2Name(), randomartifact.Stat2Number(), randomartifact.Stat3Name(), randomartifact.Stat3Number(), randomartifact.Stat4Name(), randomartifact.Stat4Number(), randomartifact.Stat1RollCount(), randomartifact.Stat2RollCount(), randomartifact.Stat3RollCount(), randomartifact.Stat4RollCount());

                Character1 newtest2character = new Character1("Hydro", 10000, 1200, 700, "Bow", "Hunter's Bow", 600, "ATKPercent", 0, "CD", 0, currentcharacter.CharFlower(), currentcharacter.CharFeather(), currentcharacter.CharSands(), currentcharacter.CharGoblet(), NewCharCirclet);    
                double newtest2characterDamage = ATKDamageCalculator(newtest2character.CharATK(), newtest2character.CharEM(), newtest2character.CharCR(), newtest2character.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                if (newtest2characterDamage > CurrentCharacterDamage)
                {
                    
                    System.out.println("Replacing Circlet------------------------------");
                    
                    currentcharacter.ChangeCharCirclet(newtest2character.CharCirclet());

                    double newDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");
                    System.out.println("New Damage: " + newDamage);

                    CircletChanges++;
                    System.out.println("Took " + CircletLengthChange + " artifacts to improve Circlet. (iteration = " + currentrun + ")");
                    System.out.println("Took " + ArtifactLengthChange + " artifacts to improve damage.");
                    CircletLengthChange = 0;
                    ArtifactLengthChange = 0;
                    
                }
            }   
        }

        System.out.println("Final Stats:");
        System.out.println();

        currentcharacter.PrintCharStats();

        currentcharacter.PrintCharFlower();
        currentcharacter.PrintCharFeather();
        currentcharacter.PrintCharSands();
        currentcharacter.PrintCharGoblet();
        currentcharacter.PrintCharCirclet();

        double CurrentCharacterDamage = ATKDamageCalculator(currentcharacter.CharATK(), currentcharacter.CharEM(), currentcharacter.CharCR(), currentcharacter.CharCD(), 300, 1, 0, 0, "ForwardVaporize");

        System.out.println(CurrentCharacterDamage);

        System.out.println("Flower Changes:  " + FlowerChanges);
        System.out.println("Feather Changes: " + FeatherChanges);
        System.out.println("Sands Changes:   " + SandsChanges);
        System.out.println("Goblet Changes:  " + GobletChanges);
        System.out.println("Circlet Changes: " + CircletChanges);

    }
   
    public static double ATKDamageCalculator(double CharATK, double CharEM, double CharCR, double CharCD, double CharAbilityScaling, double BaseDMGMultiplier, double AdditiveBaseDMGBonus, double DMGBonus, String Reaction)
    {
        // (Sigma(BaseDMG * BaseDMGMultiplier) + AddictiveBaseDMGBonus) * DMGBonusMultiplier * DEF Multiplier(target) * ResMultiplier(Target) * AmplifyingMultiplier
        // Multiply by (1 + %CRIT DMG) if crit hit

        double AmplifyingMultiplier;
        if (Reaction == "ForwardVaporize" || Reaction == "ForwardMelt")
        {AmplifyingMultiplier = 2 + (2.78 * (CharEM)/(CharEM + 1400));}
        else if (Reaction == "ReverseVaporize" || Reaction == "ReverseMelt");
        {AmplifyingMultiplier = 1.5 + (2.78 * (CharEM)/(CharEM + 1400));}

        double NonCritDamage;
        NonCritDamage = ((CharATK * CharAbilityScaling * BaseDMGMultiplier) + AdditiveBaseDMGBonus) * (1 + DMGBonus) * 1 * (0.9) * (AmplifyingMultiplier);
        
        if (CharCR > 100)
        {CharCR = 100;}

        return (NonCritDamage * (1 + CharCD / 100) * CharCR / 100) + (NonCritDamage * (1 - CharCR / 100));
    }
}
    