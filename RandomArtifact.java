import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
public class RandomArtifact 
{
    String artifactSet;
    String artifactType;

    int artifactLevel;

    String artifactMainStatName;
    double artifactMainStatNumber;

    int artifactStat1RollCount;
    String artifactStat1Name;
    double artifactStat1Number = 0;

    int artifactStat2RollCount;
    String artifactStat2Name;
    double artifactStat2Number = 0;

    int artifactStat3RollCount;
    String artifactStat3Name;
    double artifactStat3Number = 0;

    int artifactStat4RollCount;
    String artifactStat4Name;
    double artifactStat4Number = 0;

    String[] artifactTypeList = {"Flower", "Feather", "Sands", "Goblet", "Circlet"};
    // Make Main Stat Lists, occurrence of Strings represent probability (will randomly choose from this list)
    String[] SandsMainStatList = {
    "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", 
    "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", 
    "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", 
    "EM", "EM", "EM", 
    "ER", "ER", "ER"};
    String[] GobletMainStatList = CreateGobletMainStatList(); // probabilities are specific, manual list creation would be extremely long
    String[] CircletMainStatList = {
    "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", "PercentHP", 
    "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", 
    "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", "PercentATK", 
    "EM", "EM", 
    "CR", "CR", "CR", "CR", "CR", 
    "CD", "CD", "CD", "CD", "CD"};
    String[] StatList = {
    "FlatHP", "FlatHP", "FlatHP", "FlatHP", "FlatHP", "FlatHP", 
    "PercentHP", "PercentHP", "PercentHP", "PercentHP", 
    "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF", "FlatDEF",
    "PercentDEF", "PercentDEF", "PercentDEF", "PercentDEF", 
    "FlatATK", "FlatATK", "FlatATK", "FlatATK", "FlatATK", "FlatATK", 
    "PercentATK", "PercentATK", "PercentATK", "PercentATK", 
    "EM", "EM", "EM", "EM", 
    "ER", "ER", "ER", "ER", 
    "CR", "CR", "CR", 
    "CD", "CD", "CD"
    };

    // All numbers gotten from wiki. Needs to be rounded when displayed (or not) (double check in game), computing decimal addition with computers may result in long "inaccurate" decimals
    double[] FlatHPList = {209.13, 239.00, 269.88, 298.75};
    double[] PercentHPList = {4.08, 4.66, 5.25, 5.83};
    double[] FlatDEFList = {16.20, 18.52, 20.83, 23.15};
    double[] PercentDEFList = {5.10, 5.83, 6.56, 7.29};
    double[] FlatATKList = {13.62, 15.56, 17.51, 19.45};
    double[] PercentATKList = {4.08, 4.66, 5.25, 5.83};
    double[] EMList = {16.32, 18.65, 20.98, 23.31};
    double[] ERList = {4.53, 5.18, 5.83, 6.48};
    double[] CRList = {2.72, 3.11, 3.50, 3.89};
    double[] CDList = {5.44, 6.22, 6.99, 7.77};

    public RandomArtifact()
    {
        artifactLevel = 0;
        Random random = new Random();

        // Will determine whether this is a four liner artifact. 20% chance to be a 4 liner
        if (Math.random() >= 0.2)
        {artifactStat4RollCount--;}

        // Set artifact type by random 
        int randomIndex = random.nextInt(artifactTypeList.length);
        artifactType = artifactTypeList[randomIndex];

        ArrayList<String> StatChoose = new ArrayList<String>(Arrays.asList(StatList));

        // Set Main Stat according to type of artifact (can be randomly selcted from lists above if sands, goblet, or circlet)
        if (artifactType == "Flower")
        {
            artifactMainStatName = "FlatHP";            
        }

        else if (artifactType == "Feather")
        {
            artifactMainStatName = "FlatATK";
        }

        else if (artifactType == "Sands")
        {
            artifactMainStatName = SandsMainStatList[random.nextInt(SandsMainStatList.length)];
        }

        else if (artifactType == "Goblet")
        {
            artifactMainStatName = GobletMainStatList[random.nextInt(GobletMainStatList.length)];
        }
        else
        {
            artifactMainStatName = CircletMainStatList[random.nextInt(CircletMainStatList.length)];
        }
        
        // Remove main stat from list so it cannot be a substat
        StatChoose = RemoveStatFromArray(artifactMainStatName, StatChoose);

        // Select substats (even if it's a three liner)
        RandomChooseStats(StatChoose);

        // Determine first roll value for each stat
        artifactStat1Number = RandomChooseNumberStat(artifactStat1Name);
        artifactStat2Number = RandomChooseNumberStat(artifactStat2Name);
        artifactStat3Number = RandomChooseNumberStat(artifactStat3Name);
        artifactStat4Number = RandomChooseNumberStat(artifactStat4Name);

        //PrintArtifact();

        //
        //System.out.println("Rolling Artifact");
        ArtifactRoll();
        //PrintArtifact();
    }


    public RandomArtifact(String artifactType)
    {
        artifactLevel = 0;
        Random random = new Random();

        if (Math.random() >= 0.2)
        {artifactStat4RollCount--;}

        this.artifactType = artifactType;

        ArrayList<String> StatChoose = new ArrayList<String>(Arrays.asList(StatList));

        if (artifactType == "Flower")
        {
            artifactMainStatName = "FlatHP";
        }

        else if (artifactType == "Feather")
        {
            artifactMainStatName = "FlatATK";
        }
        else if (artifactType == "Sands")
        {
            artifactMainStatName = SandsMainStatList[random.nextInt(SandsMainStatList.length)];
        }

        else if (artifactType == "Goblet")
        {
            artifactMainStatName = GobletMainStatList[random.nextInt(GobletMainStatList.length)];
        }
        else
        {
            artifactMainStatName = CircletMainStatList[random.nextInt(CircletMainStatList.length)];
        }
        
        StatChoose = RemoveStatFromArray(artifactMainStatName, StatChoose);

        RandomChooseStats(StatChoose);

        artifactStat1Number = RandomChooseNumberStat(artifactStat1Name);
        artifactStat2Number = RandomChooseNumberStat(artifactStat2Name);
        artifactStat3Number = RandomChooseNumberStat(artifactStat3Name);
        artifactStat4Number = RandomChooseNumberStat(artifactStat4Name);

        //PrintArtifact();

        //System.out.println("Rolling Artifact");
        ArtifactRoll();
        
        //PrintArtifact();
    }
    
    public void ArtifactRoll()
    {
        // Randomly add 5 preset values (values determined by name) to 5 random stats. If it's a three liner, only 4 will be added.
        Random random = new Random();
        for (int i = 0; i < 5; i++)
        {
            if (artifactStat4RollCount == -1)
            {artifactStat4RollCount++;}
            else
            {
                // Select a random stat 1-4 to roll
                int StatSelect = random.nextInt(4) + 1;
                
                // Adds a random predetermined value from 4 choices
                if (StatSelect == 1)
                {
                    double increment = RandomChooseNumberStat(artifactStat1Name);
                    artifactStat1Number += increment;
                    artifactStat1RollCount++;
                }
                else if (StatSelect == 2)
                {
                    double increment = RandomChooseNumberStat(artifactStat2Name);
                    artifactStat2Number += increment;
                    artifactStat2RollCount++;
                }
                else if (StatSelect == 3)
                {
                    double increment = RandomChooseNumberStat(artifactStat3Name);
                    artifactStat3Number += increment;
                    artifactStat3RollCount++;
                }
                else if (StatSelect == 4)
                {
                    double increment = RandomChooseNumberStat(artifactStat4Name);
                    artifactStat4Number += increment;
                    artifactStat4RollCount++;
                }   
            }
        }
    }

    public void RandomChooseStats(ArrayList<String> StatChoose)
    {
        // Select the 4 substats
        Random random = new Random();
        
        artifactStat1Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(artifactStat1Name, StatChoose);

        artifactStat2Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(artifactStat2Name, StatChoose);

        artifactStat3Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(artifactStat3Name, StatChoose);

        artifactStat4Name = StatChoose.get(random.nextInt(StatChoose.size()));
        StatChoose = RemoveStatFromArray(artifactStat4Name, StatChoose);
    }

    public double RandomChooseNumberStat(String StatName)
    {
        // given a the substat name, will randomly select one of four preset values
        Random random = new Random();
        if (StatName == "FlatHP")
        {
            return FlatHPList[random.nextInt(FlatHPList.length)];
        }
        else if (StatName == "PercentHP")
        {
            return PercentHPList[random.nextInt(PercentHPList.length)];
        }
        else if (StatName == "FlatDEF")
        {
            return FlatDEFList[random.nextInt(FlatDEFList.length)];
        }
        else if (StatName == "PercentDEF")
        {
            return PercentDEFList[random.nextInt(PercentDEFList.length)];
        }
        else if (StatName == "FlatATK")
        {
            return FlatATKList[random.nextInt(FlatATKList.length)];
        }
        else if (StatName == "PercentATK")
        {
            return PercentATKList[random.nextInt(PercentATKList.length)];
        }
        else if (StatName == "EM")
        {
            return EMList[random.nextInt(EMList.length)];
        }
        else if (StatName == "ER")
        {
            return ERList[random.nextInt(ERList.length)];
        }
        else if (StatName == "CR")
        {
            return CRList[random.nextInt(CRList.length)];
        }
        else if (StatName == "CD")
        {
            return CDList[random.nextInt(CDList.length)];
        }
        return -1;
    }

    public ArrayList<String> RemoveStatFromArray(String Stat, ArrayList<String> StatList)
    {
        // Remove all of a certain stat in the list
        int count = 0;
        for (String stat : StatList)
        {
            if (stat.equals(Stat))
            {count++;}
        }
        for (int i = 0; i < count; i++)
            {StatList.remove(Stat);}

        return StatList;
    }

    public void PrintArtifact()
    {
        // Print stats of the artifact: Type of artifact, Main stat, each 4 substats with their name of stat, amount, and amount it got rolled into
        System.out.println(artifactType);
        System.out.println();
        System.out.println("Main Stat: " + artifactMainStatName);
        System.out.println();
        System.out.println("(" + artifactStat1RollCount + ") " + artifactStat1Name + " - " +  artifactStat1Number);
        System.out.println("(" + artifactStat2RollCount + ") " + artifactStat2Name + " - " + artifactStat2Number);
        System.out.println("(" + artifactStat3RollCount + ") " + artifactStat3Name + " - " + artifactStat3Number);
        System.out.println("(" + artifactStat4RollCount + ") " + artifactStat4Name + " - " + artifactStat4Number);
        System.out.println();
    }

    public String[] CreateGobletMainStatList()
    {
        String[] returnlist = new String[400];
        for (int i = 0; i < 77; i++)
        {returnlist[i] = "PercentHP";}
        for (int i = 77; i < 154; i++)
        {returnlist[i] = "PercentATK";}
        for (int i = 154; i < 230; i++)
        {returnlist[i] = "PercentDEF";}
        for (int i = 230; i < 250; i++)
        {returnlist[i] = "PhysicalDMG";}
        for (int i = 250; i < 270; i++)
        {returnlist[i] = "PyroDMG";}
        for (int i = 270; i < 290; i++)
        {returnlist[i] = "HydroDMG";}
        for (int i = 290; i < 310; i++)
        {returnlist[i] = "AnemoDMG";}
        for (int i = 310; i < 330; i++)
        {returnlist[i] = "ElectroDMG";}
        for (int i = 330; i < 350; i++)
        {returnlist[i] = "DendroDMG";}
        for (int i = 350; i < 370; i++)
        {returnlist[i] = "CryoDMG";}
        for (int i = 370; i < 390; i++)
        {returnlist[i] = "GeoDMG";}
        for (int i = 390; i < 400; i++)
        {returnlist[i] = "EM";}
        return returnlist;
    }
    
    public String Set()
    {return artifactSet;}

    public String Type()
    {return artifactType;}

    public int Level()
    {return artifactLevel;}

    public String MainStatName()
    {return artifactMainStatName;}

    public double MainStatNumber()
    {return artifactMainStatNumber;}

    public int Stat1RollCount()
    {return artifactStat1RollCount;}

    public String Stat1Name()
    {return artifactStat1Name;}

    public double Stat1Number()
    {return artifactStat1Number;} 

    public int Stat2RollCount()
    {return artifactStat2RollCount;}

    public String Stat2Name()
    {return artifactStat2Name;}

    public double Stat2Number()
    {return artifactStat2Number;} 

    public int Stat3RollCount()
    {return artifactStat3RollCount;}

    public String Stat3Name()
    {return artifactStat3Name;}

    public double Stat3Number()
    {return artifactStat3Number;} 

    public int Stat4RollCount()
    {return artifactStat4RollCount;}

    public String Stat4Name()
    {return artifactStat4Name;}

    public double Stat4Number()
    {return artifactStat4Number;} 
}