public class Wind extends Card
{
    public Wind(String ID)
    {
        super(ID);
    }
    public int attack(Card enemy)
    {
        if(enemy instanceof Electric)
        {
            enemy.minusHp(atk+1);
        }
        else if(enemy instanceof Fire)
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