public class Main
{
    public static void main(String[] args) 
    {
        System.out.println("BEGIN SIMULATION");

        int iterations = 0;
        int totaliterations = 0;
        boolean found = false;
        int samplesize = 0;
        int satisfiedsamplesize = 2500;
        while (samplesize != satisfiedsamplesize)
            {
            while (!found)
            {
                iterations++;
                if (iterations % 1000000 == 0)
                {
                    System.out.println("Current iterations (for artifact # + " + samplesize + "): " + iterations);
                }

                boolean doublecrit = false;
                double critvalue = 0;

                RandomArtifact test = new RandomArtifact();


                if ((test.Stat1Name() == "CR") || (test.Stat2Name() == "CR") || (test.Stat3Name() == "CR") || (test.Stat4Name() == "CR"))
                {
                    if ((test.Stat1Name() == "CD") || (test.Stat2Name() == "CD") || (test.Stat3Name() == "CD") || (test.Stat4Name() == "CD"))
                    {
                        if (test.Stat1Name() == "CR")
                        {critvalue += test.Stat1Number() * 2;}
                        else if (test.Stat1Name() == "CD")
                        {critvalue += test.Stat1Number();}
                        if (test.Stat2Name() == "CR")
                        {critvalue += test.Stat2Number() * 2;}
                        else if (test.Stat2Name() == "CD")
                        {critvalue += test.Stat2Number();}
                        if (test.Stat3Name() == "CR")
                        {critvalue += test.Stat3Number() * 2;}
                        else if (test.Stat3Name() == "CD")
                        {critvalue += test.Stat3Number();}
                        if (test.Stat4Name() == "CR")
                        {critvalue += test.Stat4Number() * 2;}
                        else if (test.Stat4Name() == "CD")
                        {critvalue += test.Stat4Number();}
                        doublecrit = true;
                    }

                }
                if (doublecrit)
                //if (test.MainStatName().equals("CR") || test.MainStatName().equals("CD"))
                //if (critvalue >= 54.0)
                // pyro hydro anemo electro dendro cryo geo
                //if (test.Type() == "Goblet" && ((test.MainStatName() == "PyroDMG") || (test.MainStatName() == "HydroDMG") || (test.MainStatName() == "AnemoDMG") || (test.MainStatName() == "ElectroDMG") || (test.MainStatName() == "DendroDMG") || (test.MainStatName() == "CryoDMG") || (test.MainStatName() == "GeoDMG"))) // 50cv element dmg goblet 
                //if (critvalue >= 50.0 && test.Type() == "Goblet" && ((test.MainStatName() == "PyroDMG") || (test.MainStatName() == "HydroDMG") || (test.MainStatName() == "AnemoDMG") || (test.MainStatName() == "ElectroDMG") || (test.MainStatName() == "DendroDMG") || (test.MainStatName() == "CryoDMG") || (test.MainStatName() == "GeoDMG"))) // 50cv element dmg goblet 
                //if (critvalue >= 50.0 && test.MainStatName() == "CryoDMG")
                {
                    System.out.println();
                    found = true;
                    
                    ArtifactPrint(test);

                    System.out.println("Crit Value: " + critvalue);

                    System.out.println("");

                    System.out.println("Total iterations: " + iterations);
                }
            }
            System.out.println("");

            totaliterations += iterations;
            samplesize++;
            iterations = 0;
            
            if (samplesize != satisfiedsamplesize)
            {
                found = false;
            }
            
                
            
        }
        System.out.println("");
        //System.out.println("Avg 54 cv occurrence: ");
        System.out.println("Average occurence: " + (double) totaliterations / samplesize);
        //System.out.println("Average 50 cv occurrence: " + totaliterations / samplesize);
        //System.out.println("Average 50 cv occurrence for element goblet: " + totaliterations / samplesize);
        System.out.println("Total Wanted Count: " + satisfiedsamplesize);
        System.out.println("");

        
        
        //double testdamage = ATKDamageCalculator(1000, 0, 100, 500, 1, 0, 0, null, false);
        //System.out.println(testdamage);
    
    }   

    public static void ArtifactPrint(RandomArtifact artifact)
        {
            System.out.println(artifact.Type());
            System.out.println();
            System.out.println("Main Stat: " + artifact.MainStatName());
            System.out.println();
            System.out.println("(" + artifact.Stat1RollCount() + ") " + artifact.Stat1Name() + " - " + artifact.Stat1Number());
            System.out.println("(" + artifact.Stat2RollCount() + ") " + artifact.Stat2Name() + " - " + artifact.Stat2Number());
            System.out.println("(" + artifact.Stat3RollCount() + ") " + artifact.Stat3Name() + " - " + artifact.Stat3Number());
            System.out.println("(" + artifact.Stat4RollCount() + ") " + artifact.Stat4Name() + " - " + artifact.Stat4Number());
            
            System.out.println("");

        }

    // Enemy is assumed to have 10% all elemental res, 0 DEF, 0 DMG Reduction, and x1 DEF Mltiplier as of now
    public static double ATKDamageCalculator(double CharATK, double CharEM, double CharCD, double CharAbilityScaling, double BaseDMGMultiplier, double AdditiveBaseDMGBonus, double DMGBonus, String Reaction, Boolean CritHit)
    {
        // (Sigma(BaseDMG * BaseDMGMultiplier) + AddictiveBaseDMGBonus) * DMGBonusMultiplier * DEF Multiplier(target) * ResMultiplier(Target) * AmplifyingMultiplier
        // Multiply by (1 + %CRIT DMG) if crit hit

        double AmplifyingMultiplier;
        if (Reaction == "ForwardVaporize")
        {AmplifyingMultiplier = 2 + (2.78 * (CharEM)/(CharEM + 1400));}
        else if (Reaction == "ReverseVaporize");
        {AmplifyingMultiplier = 1.5 + (2.78 * (CharEM)/(CharEM + 1400));}


        double NonCritDamage;
        NonCritDamage = ((CharATK * CharAbilityScaling * BaseDMGMultiplier) + AdditiveBaseDMGBonus) * (1 + DMGBonus) * 1 * (0.9) * (AmplifyingMultiplier);
        if (CritHit)
        {return NonCritDamage * (1 + CharCD / 100);}
        else
        {return NonCritDamage;}
    }

}