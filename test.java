public class test 
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

        Character1 testcharacter = new Character1("Cryo", 10000, 1200, 700, "Bow", "Hunter's Bow", 100, "ATKPercent", 0, "CD", 20, CharFlower, CharFeather, CharSands, CharGoblet, CharCirclet);    


        testcharacter.PrintCharStats();

        testcharacter.PrintCharFlower();
        testcharacter.PrintCharFeather();
        testcharacter.PrintCharSands();
        testcharacter.PrintCharGoblet();
        testcharacter.PrintCharCirclet();
    }
}
