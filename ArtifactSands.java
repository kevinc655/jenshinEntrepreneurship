public class ArtifactSands
{
    private String artifactSet;
    private int artifactLevel;
    private String artifactMainStatName;
    private double artifactMainStatNumber;

    private int artifactStat1RollCount;
    private String artifactStat1Name;
    private double artifactStat1Number = 0;
    private int artifactStat2RollCount;
    private String artifactStat2Name;
    private double artifactStat2Number = 0;
    private int artifactStat3RollCount;
    private String artifactStat3Name;
    private double artifactStat3Number = 0;
    private int artifactStat4RollCount;
    private String artifactStat4Name;
    private double artifactStat4Number = 0;

        public ArtifactSands(String artifactSet, int artifactLevel, String artifactMainStatName, String artifactStat1Name, double artifactStat1Number, String artifactStat2Name, double artifactStat2Number, String artifactStat3Name, double artifactStat3Number, String artifactStat4Name, double artifactStat4Number, int artifactStat1RollCount, int artifactStat2RollCount, int artifactStat3RollCount, int artifactStat4RollCount)
        {
            this.artifactSet = artifactSet;
            this.artifactLevel = artifactLevel;

            this.artifactMainStatName = artifactMainStatName;
            this.artifactMainStatNumber = GetMainStatNumber(artifactMainStatName, artifactLevel);

            this.artifactStat1RollCount = artifactStat1RollCount;
            this.artifactStat1Name = artifactStat1Name;
            this.artifactStat1Number = artifactStat1Number;

            this.artifactStat2RollCount = artifactStat2RollCount;
            this.artifactStat2Name = artifactStat2Name;
            this.artifactStat2Number = artifactStat2Number;

            this.artifactStat3RollCount = artifactStat3RollCount;
            this.artifactStat3Name = artifactStat3Name;
            this.artifactStat3Number = artifactStat3Number;

            this.artifactStat4RollCount = artifactStat4RollCount;
            this.artifactStat4Name = artifactStat4Name;
            this.artifactStat4Number = artifactStat4Number;
    }    

    public void PrintArtifact()
    {
        System.out.println("Sands");
        System.out.println();
        System.out.println("Main Stat: " + artifactMainStatName);
        System.out.println("Main Stat Number: " + artifactMainStatNumber);
        System.out.println();
        System.out.println("(" + artifactStat1RollCount + ") " + artifactStat1Name + " - " + artifactStat1Number);
        System.out.println("(" + artifactStat2RollCount + ") " + artifactStat2Name + " - " + artifactStat2Number);
        System.out.println("(" + artifactStat3RollCount + ") " + artifactStat3Name + " - " + artifactStat3Number);
        System.out.println("(" + artifactStat4RollCount + ") " + artifactStat4Name + " - " + artifactStat4Number);
        System.out.println("");
    }

    //https://docs.google.com/spreadsheets/d/1sYQrV5Yp_QTVEKMLWquMu0mDgHhOO_Rh2LfcWdS_Eno/edit?gid=0#gid=0
    public double GetMainStatNumber(String artifactMainStatName, double artifactLevel)
    {
        double returnStat = 0;
        for (int i = 0; i <= artifactLevel; i++)
        {
            if (artifactMainStatName.equals("PercentHP") || artifactMainStatName.equals("PercentATK"))
            {
                if (i == 0)
                {returnStat += 7.00;}
                else
                {
                    returnStat += 2.00;
                    if (i == 3 || i == 8 || i == 14 || i == 19)
                    {returnStat -= 0.10;}
                } 
            }
            else if (artifactMainStatName.equals("PercentDEF"))
            {
                if (i == 0)
                {returnStat += 8.70;}
                else
                {
                    returnStat += 2.50;
                    if (i == 4 || i == 9 || i == 13 || i == 17)
                    {returnStat -= 0.10;}
                }            
            } 
            else if (artifactMainStatName.equals("EM"))
            {
                if (i == 0)
                {returnStat += 28.0;}
                else
                {
                    returnStat += 7.9;
                    if (i == 3 || i == 7 || i == 11 || i == 15 || i == 19)
                    {returnStat += 0.1;}
                }
            }
            else if (artifactMainStatName.equals("ER"))
            {
                if (i == 0)
                {returnStat += 7.80;}
                else
                {returnStat += 2.20;}
            }
        }
        return returnStat;
    }

    public String Set()
    {return artifactSet;}

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