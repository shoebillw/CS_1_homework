public class Hunter extends Player
{
    public Hunter(int HP,String name)
    {
        super(HP,name);
    }
    public void skill(Player player)
    {
        player.minusHP(2);
    }
    public String getCareer()
    {
        return "Hunter";
    }
}