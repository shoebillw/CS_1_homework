public class Card
{
	protected String ID,cardName,state;
	protected int atk,hp,crystal,enemyhp;
	protected boolean canMove=false;
	public Card(String ID)
	{
		this.ID=ID;
		if (ID.equals("A1"))
		{
			cardName="¤ô¦æ«L";
			atk=8;
			hp=8;
			crystal=8;
		}
		if (ID.equals("A2"))
		{
			cardName="¬£¤j¬P";
			atk=0;
			hp=2;
			crystal=1;
		}
		if (ID.equals("B1"))
		{
			cardName="ª¢Å]";
			atk=7;
			hp=7;
			crystal=7;
		}
		if (ID.equals("B2"))
		{
			cardName="¼Q¤õÀs";
			atk=6;
			hp=4;
			crystal=5;
		}
		if (ID.equals("C1"))
		{
			cardName="­·¼É¤k";
			atk=5;
			hp=7;
			crystal=6;
		}
		if (ID.equals("C2"))
		{
			cardName="ÅIÃ^";
			atk=6;
			hp=7;
			crystal=4;
		}
		if (ID.equals("D1"))
		{
			cardName="¹p¯«¯Áº¸";
			atk=10;
			hp=8;
			crystal=9;
		}
		if (ID.equals("D2"))
		{
			cardName="¥Ö¥d¥C";
			atk=3;
			hp=4;
			crystal=3;
		}
		if (ID.equals("E1"))
		{
			cardName="¤p®±¥Û";
			atk=0;
			hp=4;
			crystal=2;
		}
	}
	public void setAbility(String ID,String cardName,int atk,int hp,int crystal)
	{
		this.ID=ID;
		this.cardName=cardName;
		this.atk=atk;
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
	public int getCrystal()
	{
		return crystal;
	}
	public String getState()
	{
		return state;
	}
	public void minusHp(int damage)
	{
		hp-=damage;
	}
	public int getenemyhp()
	{
		return enemyhp;
	}
	public int attack(Card enemy)
	{
		return enemy.getHp();
	}
}