public class GanyuArtifactsTest 
{
    public static void main(String[] args) 
    {
        ArtifactFlower CharFlower = new ArtifactFlower(null, 20, "CD", 26.4, "CR", 7.4, "PercentATK", 10.5, "FlatATK", 16, 3, 1, 1, 0);

        ArtifactFeather CharFeather = new ArtifactFeather(null, 20, "ER", 5.8, "CR", 7.0, "EM", 79, "CD", 13.2, 0, 1, 3, 1);

        ArtifactSands CharSands = new ArtifactSands(null, 20, "EM", "PercentDEF", 5.8, "CR", 8.6, "PercentHP", 4.1, "CD", 24.9, 0, 2, 0, 3);

        ArtifactGoblet CharGoblet = new ArtifactGoblet(null, 20, "CryoDMG", "FlatHP", 209, "FlatATK", 29, "EM", 42, "CD", 27.2, 0, 1, 1, 3);

        ArtifactCirclet CharCirclet = new ArtifactCirclet(null, 20, "CD", "PercentATK", 10.5, "CR", 7.8, "FlatATK", 31, "EM", 42, 1, 1, 1, 1);

        Character1 testcharacter = new Character1("Cryo", 9796.73, 334.85, 630.21, "Bow", "Hunter's Path", 542, "CR", 44.1, "CD", 38.4, CharFlower, CharFeather, CharSands, CharGoblet, CharCirclet);    


        testcharacter.PrintCharStats();

        testcharacter.PrintCharFlower();
        testcharacter.PrintCharFeather();
        testcharacter.PrintCharSands();
        testcharacter.PrintCharGoblet();
        testcharacter.PrintCharCirclet();
    }    
}
