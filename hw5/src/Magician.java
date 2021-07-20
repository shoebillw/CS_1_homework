public class Magician extends Player
{
    public Magician(int HP,String name)
    {
        super(HP,name);
    }
    public void skill(Card card)
    {
        card.minusHp(1);
    }
    public void skill(Player player)
    {
        player.minusHP(1);
    }
    public String getCareer()
    {
        return "Magician";
    }
}