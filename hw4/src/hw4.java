import java.util.Scanner;
import java.util.*;
import java.io.*;
public class hw4
{
	public static void main(String args[])
	{
		System.out.println("�w��Ө�C����")
		boolean hasdef=true,exit=false;
		int round=0,Crystal;
		boolean tableEmpty=true;
		Water A1=new Water("A1");
		Water A2=new Water("A2");
		Fire B1=new Fire("B1");
		Fire B2=new Fire("B2");
		Wind C1=new Wind("C1");
		Wind C2=new Wind("C2");
		Electric D1=new Electric("D1");
		Electric D2=new Electric("D2");
		Rock E1=new Rock("E1");
		Card[] cards={A1,A2,B1,B2,C1,C2,D1,D2,E1};
		A1.setAbility("A1","����L",8,8,8);
		A2.setAbility("A2","���j�P",0,2,1);
		B1.setAbility("B1","���]",7,7,7);
		B2.setAbility("B2","�Q���s",6,4,5);
		C1.setAbility("C1","�ɭ��k",5,7,6);
		C2.setAbility("C2","�I�^",6,1,4);
		D1.setAbility("D1","�p������",10,8,9);
		D2.setAbility("D2","�֥d�C",3,4,3);
		E1.setAbility("E1","�p����",0,4,2);
		Player player1=new Player();
		Player player2=new Player();
		player1.playerGetCard(A1,A2,B1,B2,C1,C2,D1,D2,E1);
		player2.playerGetCard(A1,A2,B1,B2,C1,C2,D1,D2,E1);
		try
		{
            Scanner reader = new Scanner(new FileInputStream("Card\\player1_cards.txt"));									//Ū�d������
            String Q;
			while(reader.hasNextLine())
			{
				Q = reader.nextLine();
                player1.inputNextcard(Q);
			}
			Scanner reader2 = new Scanner(new FileInputStream("Card\\player2_cards.txt"));
            String QQ;
			while(reader2.hasNextLine())
			{
                QQ = reader2.nextLine();
                player2.inputNextcard(QQ);
			}
        }
		catch(FileNotFoundException e)
		{
			System.out.println("IO Exception Happened");
		}
		for(int i=0;i<5;i++)									//����5�i�P
		{
		player1.draw(player1.getNextcard());
		player1.removeNextcard();
		}
		for(int i=0;i<5;i++)
		{
		player2.draw(player2.getNextcard());
		player2.removeNextcard();
		}
		Card[] p1table=new Card[7];
		Card[] p2table=new Card[7];
		Scanner scanner=new Scanner(System.in);
		do
		{
			try
			{	
				System.out.println("�г]�w���a�W��");										//�]�w���a�W�r
				String setname= scanner.nextLine();
				int a=setname.indexOf(" ");
				if(a!=0 && a==setname.lastIndexOf(" ") && a+1!=setname.length())
				{
					if(setname.substring(0,a).equals(setname.substring(a+1)))
					{
						System.out.println("2�H�W�٬ۦP");
						continue;
					}
					else
					{
						player1.setName(setname.substring(0,a));
						player2.setName(setname.substring(a+1));
					}
				}
				else
				{
					System.out.println("�W�r�]�w���~");
					continue;
				}
				break;
			}
			catch(Exception e)
			{
				System.out.println("�W�r�]�w���~");
			}
		}while(true);
		do
		{
			round++;
			for(int i=1;i<7;i++)															//���s���~���A
			{
				if(p1table[i]!=null)
				p1table[i].setCanMove();
				if(p2table[i]!=null)
				p2table[i].setCanMove();
			}
			if(round<=10)
				{
					Crystal=round;
				}
				else
				{
					Crystal=10;
				}
				if(player1.nextcardIsEmpty()==false)
				{
					if(round%3==0)														//P1��P
					{
							if(player1.getCardNm()==8)
							{
								player1.removeNextcard();
							}
							else if(player1.getCardNm()==7)
							{
								player1.draw(player1.getNextcard());
								player1.removeNextcard();
							}
							else
							{
								player1.draw(player1.getNextcard());
								player1.removeNextcard();
								player1.draw(player1.getNextcard());
							}
					}
					else if(player1.getCardNm()<8)
					{
						player1.draw(player1.getNextcard());
					}
					player1.removeNextcard();
				}
			while(exit==false && player1.getHP()>0 && player2.getHP()>0 && 
			(player1.nextcardIsEmpty()==false || player1.handcardIsEmpty()==false || tableEmpty(tableEmpty,p1table)==false) &&
			(player2.nextcardIsEmpty()==false || player2.handcardIsEmpty()==false || tableEmpty(tableEmpty,p2table)==false))
			{
				try
				{
					System.out.println("\nCrystal-"+Crystal);
					System.out.println(player1.getName()+"'s turn");
					System.out.println(player1.getName());
					System.out.println("HP:"+player1.getHP());
					System.out.print("Cards:");
					for(int i=0;i<player1.getCardNm();i++)
					{
						if(i!=0)
						{
							System.out.print(",");
						}
						System.out.print(player1.getCard(i));
					}
					System.out.println("\n\nU1\t\tU2\t\tU3\t\tU4\t\tU5\t\tU6");
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ID:"+p1table[i]+"\t\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ATK:"+p1table[i].getAtk()+"\t");
							System.out.print("HP:"+p1table[i].getHp()+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("State:"+p1table[i].getState()+"\t");
						}
					}

					System.out.println("\n\nD1\t\tD2\t\tD3\t\tD4\t\tD5\t\tD6");		
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ID:"+p2table[i]+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ATK:"+p2table[i].getAtk()+"\t");
							System.out.print("HP:"+p2table[i].getHp()+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("State:"+p2table[i].getState()+"\t");
						}
					}
					System.out.println("\n\n"+player2.getName());
					System.out.println("HP:"+player2.getHP());
					System.out.println("Cards Number:"+player2.getCardNm());
					
					String input=scanner.nextLine();	
					if(input.equals("exit"))
					{
						exit=true;
						break;
					}
					else if(input.equals("finish"))
					{
						break;
					}
					else if(input.substring(0,1).equals("U") && Integer.parseInt(input.substring(1,2))>0 && 
					input.substring(2,11).equals(" attack D") && Integer.parseInt(input.substring(11,12))>0)			//p1�����d��
					{
						if(p1table[Integer.parseInt(input.substring(1,2))].getCanMove())
						{
							if(p1table[Integer.parseInt(input.substring(1,2))].getState().equals("defense"))
							{
								System.out.println("�u�ƪ��A���i����");
							}
							else
							{
								hasdef=false;
								for(int i=1;i<7;i++)
								{
									if(p2table[i]!=null)
									{
										if(p2table[i].getState().equals("defense"))
										{
											hasdef=true;
										}
									}	
								}
								if(p2table[Integer.parseInt(input.substring(11,12))].getState().equals("attack"))
								{
									if(hasdef==true)
									{
										System.out.println("�Ч����B��u�ƪ��A�����~");
									}
									else
									{
										p2table[Integer.parseInt(input.substring(11,12))].sethp(p1table[Integer.parseInt(input.substring(1,2))].attack(p2table[Integer.parseInt(input.substring(11,12))]));
										p1table[Integer.parseInt(input.substring(1,2))].minusHp(p2table[Integer.parseInt(input.substring(11,12))].getAtk());
										p1table[Integer.parseInt(input.substring(1,2))].setCantMove();
									}
								}
								else
								{
									p2table[Integer.parseInt(input.substring(11,12))].sethp(p1table[Integer.parseInt(input.substring(1,2))].attack(p2table[Integer.parseInt(input.substring(11,12))]));
									p1table[Integer.parseInt(input.substring(1,2))].minusHp(p2table[Integer.parseInt(input.substring(11,12))].getAtk());
									p1table[Integer.parseInt(input.substring(1,2))].setCantMove();
								}
							}	
						}	
						else
						{
							System.out.println(input.substring(0,2)+"���^�X���i�A���");
						}
					}
					else if(input.substring(0,1).equals("U") && Integer.parseInt(input.substring(1,2))>0 && input.substring(2).equals(" attack enemy"))			//P1����P2
					{
						if(p1table[Integer.parseInt(input.substring(1,2))].getCanMove())
						{
							if(p1table[Integer.parseInt(input.substring(1,2))].getState().equals("defense"))
							{
								System.out.println("�u�ƪ��A���i����");
							}
							else
							{
								hasdef=false;
								for(int i=1;i<7;i++)
								{
									if(p2table[i]!=null)
									{
										if(p2table[i].getState().equals("defense"))
										{
											hasdef=true;
										}
									}	
								}
								if(hasdef==true)
								{
									System.out.println("�Ч����B��u�ƪ��A�����~");
								}
								else
								{
									player2.minusHP(p1table[Integer.parseInt(input.substring(1,2))].getAtk());
									p1table[Integer.parseInt(input.substring(1,2))].setCantMove();
								}
							}
						}
						else
						{
							System.out.println(input.substring(0,2)+"���^�X���i�A���");
						}
					}
					else if(input.substring(0,7).equals("select ") && input.substring(9,11).equals(" U") && Integer.parseInt(input.substring(11,12))>0 && 	//P1�l��
					input.substring(12,13).equals(" ") && (input.substring(13).equals("attack") || input.substring(13).equals("defense")))
					{
						for(int i=0;i<9;i++)
						{
							if(cards[i].getID().equals(input.substring(7,9)))
							{
								if(player1.cardexist(cards[i]))
								{
									if(p1table[Integer.parseInt(input.substring(11,12))]==null)
									{
										if(cards[i].getCrystal()>Crystal)
										{
											System.out.println("�����Ƥ���");
										}
										else
										{
											Crystal-=cards[i].getCrystal();
											p1table[Integer.parseInt(input.substring(11,12))]=new Card(cards[i].getID());
											player1.play(cards[i]);
											p1table[Integer.parseInt(input.substring(11,12))].setState(input.substring(13));
											break;
										}
									}
									else 
									{
										System.out.println("����w���d��");
									}
								}
								else
								{
									System.out.println("�⤤�S�����d");
								}
							}
						}
					}
					else if(input.substring(0,8).equals("change U") && Integer.parseInt(input.substring(8,9))>0)		//p1���ܥd�����A
					{
						if(p1table[Integer.parseInt(input.substring(8,9))].getCanMove())
						{
							if(p1table[Integer.parseInt(input.substring(8,9))].getState().equals("attack"))
							{
								p1table[Integer.parseInt(input.substring(8,9))].setState("defense");
							}
							else
							{
								p1table[Integer.parseInt(input.substring(8,9))].setState("attack");
							}
							p1table[Integer.parseInt(input.substring(8,9))].setCantMove();
						}
						else
						{
							System.out.println(input.substring(7,9)+"���^�X���i�A���");
						}
					}
					for(int i=1;i<7;i++)							//�T�{�d����q
					{
						if(p2table[i]!=null)
						{
							if(p2table[i].getHp()<=0)
							{
								p2table[i]=null;
							}
						}
						if(p1table[i]!=null)
						{
							if(p1table[i].getHp()<=0)
							{
								p1table[i]=null;
							}
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("���~�����O");
				}
			}
			if(round<=10)												//P2���]����
			{
				Crystal=round;
			}
			else
			{
				Crystal=10;
			}
			if(player2.nextcardIsEmpty()==false)
			{
				if(round%3==0)												//P2��d
				{
					if(player2.getCardNm()==8)
					{
						
						player2.removeNextcard();
					}
					else if(player2.getCardNm()==7)
					{
						player2.draw(player2.getNextcard());
						player2.removeNextcard();
					}
					else
					{
						player2.draw(player2.getNextcard());
						player2.removeNextcard();
						player2.draw(player2.getNextcard());
					}
				}
				else if(player2.getCardNm()<8)
				{
					player2.draw(player2.getNextcard());
				}
				player2.removeNextcard();
			}		
			while(exit==false && player1.getHP()>0 && player2.getHP()>0 && 
			(player1.nextcardIsEmpty()==false || player1.handcardIsEmpty()==false || tableEmpty(tableEmpty,p1table)==false) &&
			(player2.nextcardIsEmpty()==false || player2.handcardIsEmpty()==false || tableEmpty(tableEmpty,p2table)==false))
			{
				
				try
				{
					System.out.println("\nCrystal-"+Crystal);
					System.out.println(player2.getName()+"'s turn");
					System.out.println(player1.getName());
					System.out.println("HP:"+player1.getHP());
					System.out.println("Cards Number:"+player1.getCardNm());
					System.out.println("\nU1\t\tU2\t\tU3\t\tU4\t\tU5\t\tU6");
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ID:"+p1table[i]+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ATK:"+p1table[i].getAtk()+"\t");
							System.out.print("HP:"+p1table[i].getHp()+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p1table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("State:"+p1table[i].getState()+"\t");
						}
					}

					System.out.println("\n\nD1\t\tD2\t\tD3\t\tD4\t\tD5\t\tD6");		
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ID:"+p2table[i]+"\t\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("ATK:"+p2table[i].getAtk()+"\t");
							System.out.print("HP:"+p2table[i].getHp()+"\t");
						}
					}
					System.out.println();
					for(int i=1;i<7;i++)
					{
						if(p2table[i]==null)
						{
							System.out.print("\t\t");
						}
						else
						{
							System.out.print("State:"+p2table[i].getState()+"\t");
						}
					}
					System.out.println("\n\n"+player2.getName());
					System.out.println("HP:"+player2.getHP());
					System.out.print("Cards:");
					for(int i=0;i<player2.getCardNm();i++)
					{
						if(i!=0)
						{
							System.out.print(",");
						}
						System.out.print(player2.getCard(i));
					}
					System.out.println();

					String input02=scanner.nextLine();  
					if(input02.equals("exit"))
					{
						exit=true;
						break;
					}
					else if(input02.equals("finish"))
					{
						break;
					}
					else if(input02.substring(0,1).equals("D") && Integer.parseInt(input02.substring(1,2))>0 && 			//p2�����d��
					input02.substring(2,11).equals(" attack U") && Integer.parseInt(input02.substring(11,12))>0)
					{
						if(p2table[Integer.parseInt(input02.substring(1,2))].getState().equals("defense"))
						{
							System.out.println("�u�ƪ��A���i����");
						}
						else
						{
							hasdef=false;
							for(int i=1;i<7;i++)
							{
								if(p1table[i]!=null)
								{
									if(p1table[i].getState().equals("defense"))
									{
										hasdef=true;
									}
								}	
							}
							if(p1table[Integer.parseInt(input02.substring(11,12))].getState().equals("attack"))
							{
								if(hasdef==true)
								{
									System.out.println("�Ч����B��u�ƪ��A�����~");
								}
								else
								{
									p1table[Integer.parseInt(input02.substring(11,12))].sethp(p2table[Integer.parseInt(input02.substring(1,2))].attack(p1table[Integer.parseInt(input02.substring(11,12))]));
									p2table[Integer.parseInt(input02.substring(1,2))].minusHp(p1table[Integer.parseInt(input02.substring(11,12))].getAtk());
									p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
								}
							}
							else
							{
								p1table[Integer.parseInt(input02.substring(11,12))].sethp(p2table[Integer.parseInt(input02.substring(1,2))].attack(p1table[Integer.parseInt(input02.substring(11,12))]));
								p2table[Integer.parseInt(input02.substring(1,2))].minusHp(p1table[Integer.parseInt(input02.substring(11,12))].getAtk());
								p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
							}
						}
					}
					else if(input02.substring(0,1).equals("D") && Integer.parseInt(input02.substring(1,2))>0 && input02.substring(2,15).equals(" attack enemy")) //P2����P1
					{
						if(hasdef==true)
						{
							System.out.println("�Ч����B��u�ƪ��A�����~");
						}
						else
						{
							hasdef=false;
							for(int i=1;i<7;i++)
							{
								if(p1table[i]!=null)
								{
									if(p1table[i].getState().equals("defense"))
									{
										hasdef=true;
									}
								}	
							}
							if(hasdef==true)
							{
									System.out.println("�Ч����B��u�ƪ��A�����~");
							}
							else
							{
								player1.minusHP(p2table[Integer.parseInt(input02.substring(1,2))].getAtk());
								p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
							}
						}
					}
					else if(input02.substring(0,7).equals("select ") && input02.substring(9,11).equals(" D") & Integer.parseInt(input02.substring(11,12))>0 && 
					input02.substring(12,13).equals(" ") && (input02.substring(13).equals("attack") || input02.substring(13).equals("defense")))				//P2�l��
					{
						for(int i=0;i<9;i++)
						{
							if(cards[i].getID().equals(input02.substring(7,9)))
							{
								if(player2.cardexist(cards[i]))
								{
									if(p2table[Integer.parseInt(input02.substring(11,12))]==null)
									{
										if(cards[i].getCrystal()>Crystal)
										{
											System.out.println("�����Ƥ���");
										}
										else
										{
											Crystal-=cards[i].getCrystal();
											p2table[Integer.parseInt(input02.substring(11,12))]=new Card(cards[i].getID());
											player2.play(cards[i]);
											p2table[Integer.parseInt(input02.substring(11,12))].setState(input02.substring(13));
										}
									}
									else 
									{
										System.out.println("����w���d��");
									}
								}
								else
								{
									System.out.println("�⤤�S�����d");
								}
							}
						}
					}
					else if(input02.substring(0,8).equals("change D") && Integer.parseInt(input02.substring(8,9))>0)					//P2���ܥd�����A
					{
						if(p2table[Integer.parseInt(input02.substring(8,9))].getCanMove())
						{
							if(p2table[Integer.parseInt(input02.substring(8,9))].getState().equals("attack"))
							{
								p2table[Integer.parseInt(input02.substring(8,9))].setState("defense");
							}
							else
							{
								p2table[Integer.parseInt(input02.substring(8,9))].setState("attack");
							}
							p2table[Integer.parseInt(input02.substring(8,9))].setCantMove();
						}
						else
						{
							System.out.println(input02.substring(7,9)+"���^�X���i�A���");
						}
					}
					else
					{
						System.out.println("���~�����O");
					}
					for(int i=1;i<7;i++)
					{
						if(p2table[i]!=null)
						{
							if(p2table[i].getHp()<=0)
							{
								p2table[i]=null;
							}
						}
						if(p1table[i]!=null)
						{
							if(p1table[i].getHp()<=0)
							{
								p1table[i]=null;
							}
						}
					}
				}
				catch(Exception e)
				{
					System.out.println("���~�����O");
				}
			}
		}while(exit==false && player1.getHP()>0 && player2.getHP()>0 && 
		(player1.nextcardIsEmpty()==false || player1.handcardIsEmpty()==false || tableEmpty(tableEmpty,p1table)==false) &&
		(player2.nextcardIsEmpty()==false || player2.handcardIsEmpty()==false || tableEmpty(tableEmpty,p2table)==false));
		
		if(player1.getHP()<=0 ||(player1.nextcardIsEmpty() && player1.handcardIsEmpty() && tableEmpty(tableEmpty,p1table)))
		{
			System.out.println(player2.getName()+"�ӧQ");
		}
		else if(player2.getHP()<=0 ||(player2.nextcardIsEmpty() && player2.handcardIsEmpty() && tableEmpty(tableEmpty,p2table)))
		{
			System.out.println(player1.getName()+"�ӧQ");
		}
	}
	
		public static boolean tableEmpty(boolean tableEmpty,Card[] p0table)
		{
			for(int i=1;i<7;i++)
			{
				tableEmpty=true;
				if(p0table[i]!=null)
				tableEmpty=false;
			}
			return tableEmpty;
		}
}