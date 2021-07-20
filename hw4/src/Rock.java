public class Rock extends Card
{
    public Rock(String ID)
    {
        super(ID);
    }
    public int attack(Card enemy)
    {
        if(enemy instanceof Water)
        {
            enemy.minusHp(atk+1);
        }
        else if(enemy instanceof Electric)
        {
            enemy.minusHp(atk);
        }
        else
        {
            enemy.minusHp(atk);
        }
        return enemy.getHp();
    }
}