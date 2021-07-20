import java.util.ArrayList;
public class Player
{
    private int HP=20;
    public int getHP()
    {
        return HP;
    }
    public void minusHP(int damage)
    {
        HP-=damage;
    }
    private String playerName;
    public void setName(String name)
    {
        playerName=name;
    }
    public String getName()
    {
        return playerName;
    }
    private ArrayList<Card> nextcard =new ArrayList<Card>(); 
    private ArrayList<Card> handcard =new ArrayList<Card>();
    Water A1=new Water("A1");
	Water A2=new Water("A2");
	Fire B1=new Fire("B1");
	Fire B2=new Fire("B2");
	Wind C1=new Wind("C1");
	Wind C2=new Wind("C2");
	Electric D1=new Electric("D1");
	Electric D2=new Electric("D2");
	Rock E1=new Rock("E1");
    public void playerGetCard(Water A1,Water A2,Fire B1,Fire B2,Wind C1,Wind C2,Electric D1,Electric D2,Rock E1)
    {
        this.A1=A1;
        this.A2=A2;
        this.B1=B1;
        this.B2=B2;
        this.C1=C1;
        this.C2=C2;
        this.D1=D1;
        this.D2=D2;
        this.E1=E1;
    }
    public void inputNextcard(String card)
    {
        if(card.equals("A1"))
        {
            nextcard.add(A1);
        }
        else if(card.equals("A2"))
        {
            nextcard.add(A2);
        }
        else if(card.equals("B1"))
        {
            nextcard.add(B1);
        }
        else if(card.equals("B2"))
        {
            nextcard.add(B2);
        }
        else if(card.equals("C1"))
        {
            nextcard.add(C1);
        }
        else if(card.equals("C2"))
        {
            nextcard.add(C2);
        }
        else if(card.equals("D1"))
        {
            nextcard.add(D1);
        }
        else if(card.equals("D2"))
        {
            nextcard.add(D2);
        }
        else if(card.equals("E1"))
        {
            nextcard.add(E1);
        }
    }
    public boolean nextcardIsEmpty()
    {
        return nextcard.isEmpty();
    }
    public Card getNextcard()
    {
        return nextcard.get(0);
    }
    public void removeNextcard()
    {
        nextcard.remove(0);
    }
    public void draw(Card card)
    {
        handcard.add(card);
    }
    public int getCardNm()
    {
        return handcard.size();
    }
    public Card getCard(int no)
    {
        return handcard.get(no);
    }
    public boolean cardexist(Card card)
    {
        return handcard.contains(card);
    }
    public boolean handcardIsEmpty()
    {
        return handcard.isEmpty();
    }
    public void play(Card card)
    {
        handcard.remove(card);
    }
}