public class Fire extends Card
{
    public void attack(Card enemy)
    {
        if(enemy instanceof Wind)
        {
            enemy.minusHp(atk+1);
        }
        else if(enemy instanceof Water)
        {
            enemy.minusHp(atk-1);
        }
        else
        {
            enemy.minusHp(atk);
        }
    }
}