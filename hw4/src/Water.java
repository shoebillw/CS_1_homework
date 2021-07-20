public class Water extends Card
{
    public Water(String ID)
    {
        super(ID);
    }
    public int attack(Card enemy)
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
        return enemy.getHp();
    }
}