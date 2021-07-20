public class Electric extends Card
{
    public void attack(Card enemy)
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
    }
}