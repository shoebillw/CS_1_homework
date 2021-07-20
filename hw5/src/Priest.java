public class Priest extends Player
{
    public Priest(int HP,String name)
    {
        super(HP,name);
    }
    public void skill(Card card)
    {
        card.addhp(2);
    }
    public void skill(Player player)
    {
        player.addHP(2);
    }
    public String getCareer()
    {
        return "Priest";
    }
}