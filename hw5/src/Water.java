public class Water extends Card
{
    public void attack(Card enemy)
    {
        if(enemy instanceof Fire)
        {
            enemy.minusHp(atk+1);
        }
        else if(enemy instanceof Rock)
        {
            if(atk==0)
            {
                enemy.minusHp(atk);
            }
            else
            {
                enemy.minusHp(atk-1);
            }
        }
        else
        {
            enemy.minusHp(atk);
        }
    }
}