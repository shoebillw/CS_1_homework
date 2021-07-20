public class Card implements Cloneable
{
	protected String ID,cardName,state;
	protected int atk,maxhp,hp,crystal,enemyhp;
	protected boolean canMove=false;
	public void setAbility(String ID,String cardName,int atk,int hp,int crystal)
	{
		this.ID=ID;
		this.cardName=cardName;
		this.atk=atk;
		this.maxhp=hp;
		this.hp=hp;
		this.crystal=crystal;
	}
	public void sethp(int hp)
	{
		this.hp=hp;
	}
	public void setState(String state)
	{
		this.state=state;
	}
	public void setCanMove()
	{
		canMove=true;
	}
	public void setCantMove()
	{
		canMove=false;
	}
	public boolean getCanMove()
	{
		return canMove;
	}
	public String getCardName()
	{
		return cardName;
	}
	public String toString()
	{
		return ID;
	}
	public String getID()
	{
		return ID;
	}
	public int getAtk()
	{
		return atk;
	}
	public int getHp()
	{
		return hp;
	}
	public int getmaxhp()
	{
		return maxhp;
	}
	public int getCrystal()
	{
		return crystal;
	}
	public String getState()
	{
		return state;
	}
	public void addAtk()
	{
		atk++;
	}
	public void addhp(int cure)
	{
		hp+=cure;
		if(hp>maxhp)
		hp=maxhp;
	}
	public void minusHp(int damage)
	{
		hp-=damage;
	}
	public void attack(Card enemy)
	{

	}
	public Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}