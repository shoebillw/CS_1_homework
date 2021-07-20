public class Electric extends Card
{
    public Electric(String ID)
    {
        super(ID);
    }
    public int attack(Card enemy)
    {
        if(enemy instanceof Rock)
        {
            enemy.minusHp(atk+1);
        }
        else if(enemy instanceof Wind)
        {
            enemy.minusHp(atk-1);
        }
        else
        {
            enemy.minusHp(atk);
        }
        return enemy.getHp();
    }
}