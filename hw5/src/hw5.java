import java.util.Scanner;
import java.util.*;
import java.io.*;
public class hw5
{
	public static void main(String args[]) throws CloneNotSupportedException
	{
		boolean hasdef=true,exit=false,tableEmpty=true;
		int round=0,Crystal,place;
		String p1name,p2name,p1career,p2career;
		Water A1=new Water();
		Water A2=new Water();
		Fire B1=new Fire();
		Fire B2=new Fire();
		Wind C1=new Wind();
		Wind C2=new Wind();
		Electric D1=new Electric();
		Electric D2=new Electric();
		Rock E1=new Rock();
		Card[] cards={A1,A2,B1,B2,C1,C2,D1,D2,E1};
		A1.setAbility("A1","¤ô¦æ«L",8,8,8);
		A2.setAbility("A2","¬£¤j¬P",0,2,1);
		B1.setAbility("B1","ª¢Å]",7,7,7);
		B2.setAbility("B2","¼Q¤õÀs",6,4,5);
		C1.setAbility("C1","¼É­·¤k",5,7,6);
		C2.setAbility("C2","ÅIÃ^",6,1,4);
		D1.setAbility("D1","¹p¯«¯Áº¸",10,8,9);
		D2.setAbility("D2","¥Ö¥d¥C",3,4,3);
		E1.setAbility("E1","¤p®±¥Û",0,4,2);
		Player player1;
		Player player2;
		Scanner scanner=new Scanner(System.in);
		do
		{
			try
			{	
				System.out.println("½Ð³]©wª±®aÂ¾·~©M¦WºÙ");					                									//³]©wª±®a¦W¦r
				Scanner setname=new Scanner(scanner.nextLine());
				setname.useDelimiter(" ");
				p1name=setname.next();
				p1career=setname.next();
				p2name=setname.next();
				p2career=setname.next();
				if(p1career.equals("Warrior"))									//P1³Ð«Ø
				{
					/*Warrior */player1=new Warrior(40,p1name);
				}
				else if(p1career.equals("Priest"))
				{
					/*Priest */player1=new Priest(20,p1name);
				}
				else if(p1career.equals("Magician"))
				{
					/*Magician */player1=new Magician(20,p1name);
				}
				else if(p1career.equals("Hunter"))
				{
					/*Hunter */player1=new Hunter(16,p1name);
				}
				else
				{
					System.out.println("Â¾·~¿é¤J¿ù»~");
					continue;
				}

				if(p2career.equals("Warrior"))			                		//P2³Ð«Ø
				{
					/*Warrior*/ player2=new Warrior(40,p2name);
				}
				else if(p2career.equals("Priest"))
				{
					/*Priest*/ player2=new Priest(20,p2name);
				}
				else if(p2career.equals("Magician"))
				{
					/*Magician*/ player2=new Magician(20,p2name);
				}
				else if(p2career.equals("Hunter"))
				{
					/*Hunter*/ player2=new Hunter(16,p2name);
				}
				else
				{
					System.out.println("Â¾·~¿é¤J¿ù»~");
					continue;
				}
				break;
			}
			catch(Exception e)
			{
				System.out.println("¨Ï¥ÎŽÍ³Ð«Ø¿ù»~");
			}
		}while(true);
		player1.playerGetCard(A1,A2,B1,B2,C1,C2,D1,D2,E1);
		player2.playerGetCard(A1,A2,B1,B2,C1,C2,D1,D2,E1);
		try
		{
            Scanner reader = new Scanner(new FileInputStream("Card\\player1_cards.txt"));									//Åª¥d¤ù¶¶§Ç
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
		for(int i=0;i<5;i++)									//¥ý©â5±iµP
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
		do
		{
			round++;
			for(int i=1;i<7;i++)															//­«»s©ÇÃ~ª¬ºA
			{
				if(p1table[i]!=null)
				p1table[i].setCanMove();
				if(p2table[i]!=null)
				p2table[i].setCanMove();
			}
			player1.setCanMove();
			player2.setCanMove();
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
					if(round%3==0)														//P1©âµP
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
					System.out.println("\n"+player1.getName()+"-"+player1.getCareer());
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
					System.out.println("\n\n"+player2.getName()+"-"+player2.getCareer());
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
					input.substring(2,11).equals(" attack D") && Integer.parseInt(input.substring(11,12))>0)			//p1§ðÀ»¥d¤ù
					{
						if(p1table[Integer.parseInt(input.substring(1,2))].getCanMove())
						{
							if(p1table[Integer.parseInt(input.substring(1,2))].getState().equals("defense"))
							{
								System.out.println("¦u³Æª¬ºA¤£¥i§ðÀ»");
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
										System.out.println("½Ð§ðÀ»³B©ó¦u³Æª¬ºAªº©ÇÃ~");
									}
									else
									{
										p1table[Integer.parseInt(input.substring(1,2))].attack(p2table[Integer.parseInt(input.substring(11,12))]);
										p1table[Integer.parseInt(input.substring(1,2))].minusHp(p2table[Integer.parseInt(input.substring(11,12))].getAtk());
										p1table[Integer.parseInt(input.substring(1,2))].setCantMove();
									}
								}
								else
								{
									p1table[Integer.parseInt(input.substring(1,2))].attack(p2table[Integer.parseInt(input.substring(11,12))]);
									p1table[Integer.parseInt(input.substring(1,2))].minusHp(p2table[Integer.parseInt(input.substring(11,12))].getAtk());
									p1table[Integer.parseInt(input.substring(1,2))].setCantMove();
								}
							}	
						}	
						else
						{
							System.out.println(input.substring(0,2)+"¥»¦^¦X¤£¥i¦A¦æ°Ê");
						}
					}
					else if(input.substring(0,1).equals("U") && Integer.parseInt(input.substring(1,2))>0 && input.substring(2).equals(" attack enemy"))			//P1§ðÀ»P2
					{
						if(p1table[Integer.parseInt(input.substring(1,2))].getCanMove())
						{
							if(p1table[Integer.parseInt(input.substring(1,2))].getState().equals("defense"))
							{
								System.out.println("¦u³Æª¬ºA¤£¥i§ðÀ»");
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
									System.out.println("½Ð§ðÀ»³B©ó¦u³Æª¬ºAªº©ÇÃ~");
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
							System.out.println(input.substring(0,2)+"¥»¦^¦X¤£¥i¦A¦æ°Ê");
						}
					}
					else if(input.substring(0,7).equals("select ") && input.substring(9,11).equals(" U") && Integer.parseInt(input.substring(11,12))>0 && 	//P1¥l³ê
					input.substring(12,13).equals(" ") && (input.substring(13).equals("attack") || input.substring(13).equals("defense")))
					{
						place=Integer.parseInt(input.substring(11,12));
						for(int i=0;i<9;i++)
						{
							if(cards[i].getID().equals(input.substring(7,9)))
							{
								if(player1.cardexist(cards[i]))
								{
									if(p1table[place]==null)
									{
										if(cards[i].getCrystal()>Crystal)
										{
											System.out.println("¤ô´¹¼Æ¤£¨¬");
										}
										else
										{
											if(input.substring(7,8).equals("A"))
											{
												if(p2table[place]!=null)
												{
													p2table[place].minusHp(2);
												}
											}
											else if(input.substring(7,8).equals("B"))
											{
												for(int j=1;j<=6;j++)
												{
													if(p2table[j]!=null)
													{
														p2table[j].minusHp(1);
													}
												}
											}
											else if(input.substring(7,8).equals("C"))
											{
												player1.addHP(1);
												for(int j=1;j<=6;j++)
												{
													if(p1table[j]!=null)
													{
														p1table[j].addhp(1);
													}
												}
											}
											else if(input.substring(7,8).equals("D"))
											{
												player2.minusHP(2);
											}
											else if(input.substring(7,8).equals("E"))
											{
												if(p1table[place-1]!=null)
												{
													p1table[place-1].addAtk();
												}
												if(p1table[place+1]!=null)
												{
													p1table[place+1].addAtk();
												}
											}
											Crystal-=cards[i].getCrystal();
											p1table[Integer.parseInt(input.substring(11,12))]=(Card)cards[i].clone();
											player1.play(cards[i]);
											p1table[Integer.parseInt(input.substring(11,12))].setState(input.substring(13));
											break;
										}
									}
									else 
									{
										System.out.println("¦¹®æ¤w¦³¥d¤ù");
									}
								}
								else
								{
									System.out.println("¤â¤¤¨S¦³¦¹¥d");
								}
							}
						}
					}
					else if(input.substring(0,8).equals("change U") && Integer.parseInt(input.substring(8,9))>0)		//p1§ïÅÜ¥d¤ùª¬ºA
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
							System.out.println(input.substring(7,9)+"¥»¦^¦X¤£¥i¦A¦æ°Ê");
						}
					}
					else if(input.substring(0,13).equals("cast ability "))										//P1¨Ï¥Î§Þ¯à
					{
						if(player1.getCanMove())
						{
							if(Crystal<2)
							{
								System.out.println("¤ô´¹¼Æ¤£¨¬");
							}
							else
							{
								if(Player.isHunter(player1))
								{
									if(input.substring(13).equals("enemy"))
									{
										player1.skill(player2);
										player1.setCantMove();
										Crystal-=2;
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}
								}
								else if(Player.isMagician(player1))
								{
									if(input.substring(13).equals("enemy"))
									{
										player1.skill(player2);
										player1.setCantMove();
										Crystal-=2;
									}
									else if(input.substring(13,14).equals("D") && Integer.parseInt(input.substring(14))>=1 && Integer.parseInt(input.substring(14))<=6)
									{
										if(p2table[Integer.parseInt(input.substring(14))]!=null)
										{
											player1.skill(p2table[Integer.parseInt(input.substring(14))]);
											player1.setCantMove();
											Crystal-=2;
										}
										else
										{
											System.out.println("¦¹®æ¨S¦³¥d¤ù");
										}
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}
								}	
								else if(Player.isPriest(player1))
								{
									if(input.substring(13).equals("myself"))
									{
										player1.skill(player1);
										player1.setCantMove();
										Crystal-=2;
									}
									else if(input.substring(13,14).equals("U") && Integer.parseInt(input.substring(14))>=1 && Integer.parseInt(input.substring(14))<=6)
									{
										if(p1table[Integer.parseInt(input.substring(14))]!=null)
										{
											player1.skill(p1table[Integer.parseInt(input.substring(14))]);
											player1.setCantMove();
											Crystal-=2;
										}
										else
										{
											System.out.println("¦¹®æ¨S¦³¥d¤ù");
										}
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}	
								}
								else
								{
									System.out.println("¿ù»~ªº«ü¥O");
								}
							}
						}
						else
						{
							System.out.println("¨C¦^¦X¶È¥i¨Ï¥Î¤@¦¸§Þ¯à");
						}
					}
					else
					{
						System.out.println("¿ù»~ªº«ü¥O");
					}
					for(int i=1;i<7;i++)							//½T»{¥d¤ù¦å¶q
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
					System.out.println("¿ù»~ªº«ü¥O");
				}
			}
			if(round<=10)												//P2­«³]¤ô´¹
			{
				Crystal=round;
			}
			else
			{
				Crystal=10;
			}
			if(player2.nextcardIsEmpty()==false)
			{
				if(round%3==0)												//P2©â¥d
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
					System.out.println("\n"+player1.getName()+"-"+player1.getCareer());
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
					System.out.println("\n\n"+player2.getName()+"-"+player2.getCareer());
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
					else if(input02.substring(0,1).equals("D") && Integer.parseInt(input02.substring(1,2))>0 && 			//p2§ðÀ»¥d¤ù
					input02.substring(2,11).equals(" attack U") && Integer.parseInt(input02.substring(11,12))>0)
					{
						if(p2table[Integer.parseInt(input02.substring(1,2))].getState().equals("defense"))
						{
							System.out.println("¦u³Æª¬ºA¤£¥i§ðÀ»");
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
									System.out.println("½Ð§ðÀ»³B©ó¦u³Æª¬ºAªº©ÇÃ~");
								}
								else
								{
									p2table[Integer.parseInt(input02.substring(1,2))].attack(p1table[Integer.parseInt(input02.substring(11,12))]);
									p2table[Integer.parseInt(input02.substring(1,2))].minusHp(p1table[Integer.parseInt(input02.substring(11,12))].getAtk());
									p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
								}
							}
							else
							{
								p2table[Integer.parseInt(input02.substring(1,2))].attack(p1table[Integer.parseInt(input02.substring(11,12))]);
								p2table[Integer.parseInt(input02.substring(1,2))].minusHp(p1table[Integer.parseInt(input02.substring(11,12))].getAtk());
								p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
							}
						}
					}
					else if(input02.substring(0,1).equals("D") && Integer.parseInt(input02.substring(1,2))>0 && input02.substring(2,15).equals(" attack enemy")) //P2§ðÀ»P1
					{
						if(hasdef==true)
						{
							System.out.println("½Ð§ðÀ»³B©ó¦u³Æª¬ºAªº©ÇÃ~");
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
									System.out.println("½Ð§ðÀ»³B©ó¦u³Æª¬ºAªº©ÇÃ~");
							}
							else
							{
								player1.minusHP(p2table[Integer.parseInt(input02.substring(1,2))].getAtk());
								p2table[Integer.parseInt(input02.substring(1,2))].setCantMove();
							}
						}
					}
					else if(input02.substring(0,7).equals("select ") && input02.substring(9,11).equals(" D") & Integer.parseInt(input02.substring(11,12))>0 && 
					input02.substring(12,13).equals(" ") && (input02.substring(13).equals("attack") || input02.substring(13).equals("defense")))				//P2¥l³ê
					{
						place=Integer.parseInt(input02.substring(11,12));
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
											System.out.println("¤ô´¹¼Æ¤£¨¬");
										}
										else
										{
											if(input02.substring(7,8).equals("A"))
											{
												if(p1table[place]!=null)
												{
													p1table[place].minusHp(2);
												}
											}
											else if(input02.substring(7,8).equals("B"))
											{
												for(int j=1;j<=6;j++)
												{
													if(p1table[j]!=null)
													{
														p1table[j].minusHp(1);
													}
												}
											}
											else if(input02.substring(7,8).equals("C"))
											{
												player2.addHP(1);
												for(int j=1;j<=6;j++)
												{
													if(p2table[j]!=null)
													{
														p2table[j].addhp(1);
													}
												}
											}
											else if(input02.substring(7,8).equals("D"))
											{
												player1.minusHP(2);
											}
											else if(input02.substring(7,8).equals("E"))
											{
												if(p2table[place-1]!=null)
												{
													p2table[place-1].addAtk();
												}
												if(p2table[place+1]!=null)
												{
													p2table[place+1].addAtk();
												}
											}
											Crystal-=cards[i].getCrystal();
											p2table[Integer.parseInt(input02.substring(11,12))]=(Card)cards[i].clone();
											player2.play(cards[i]);
											p2table[Integer.parseInt(input02.substring(11,12))].setState(input02.substring(13));
										}
									}
									else 
									{
										System.out.println("¦¹®æ¤w¦³¥d¤ù");
									}
								}
								else
								{
									System.out.println("¤â¤¤¨S¦³¦¹¥d");
								}
							}
						}
					}
					else if(input02.substring(0,8).equals("change D") && Integer.parseInt(input02.substring(8,9))>0)					//P2§ïÅÜ¥d¤ùª¬ºA
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
							System.out.println(input02.substring(7,9)+"¥»¦^¦X¤£¥i¦A¦æ°Ê");
						}
					}
					else if(input02.substring(0,13).equals("cast ability "))						//P2¨Ï¥Î§Þ¯à
					{
						if(player2.getCanMove())
						{
							if(Crystal<2)
							{
								System.out.println("¤ô´¹¼Æ¤£¨¬");
							}
							else
							{
								if(Player.isHunter(player2))
								{
									if(input02.substring(13).equals("enemy"))
									{
										player2.skill(player1);
										player2.setCantMove();
										Crystal-=2;
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}
								}
								else if(Player.isMagician(player2))
								{
									if(input02.substring(13).equals("enemy"))
									{
										player2.skill(player1);
										player2.setCantMove();
										Crystal-=2;
									}
									else if(input02.substring(13,14).equals("D") && Integer.parseInt(input02.substring(14))>=1 && Integer.parseInt(input02.substring(14))<=6)
									{
										if(p1table[Integer.parseInt(input02.substring(14))]!=null)
										{
											player2.skill(p1table[Integer.parseInt(input02.substring(14))]);
											player2.setCantMove();
											Crystal-=2;
										}
										else
										{
											System.out.println("¦¹®æ¨S¦³¥d¤ù");
										}
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}
								}	
								else if(Player.isPriest(player2))
								{
									if(input02.substring(13).equals("myself"))
									{
										player2.skill(player2);
										player2.setCantMove();
										Crystal-=2;
									}
									else if(input02.substring(13,14).equals("U") && Integer.parseInt(input02.substring(14))>=1 && Integer.parseInt(input02.substring(14))<=6)
									{
										if(p2table[Integer.parseInt(input02.substring(14))]!=null)
										{
											player2.skill(p2table[Integer.parseInt(input02.substring(14))]);
											player2.setCantMove();
											Crystal-=2;
										}
										else
										{
											System.out.println("¦¹®æ¨S¦³¥d¤ù");
										}
									}
									else
									{
										System.out.println("¿ù»~ªº«ü¥O");
									}	
								}
								else
								{
									System.out.println("¿ù»~ªº«ü¥O");
								}
							}
						}
						else
						{
							System.out.println("¨C¦^¦X¶È¥i¨Ï¥Î¤@¦¸§Þ¯à");
						}
					}
					else
					{
						System.out.println("¿ù»~ªº«ü¥O");
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
					System.out.println("¿ù»~ªº«ü¥O");
				}
			}
		}while(exit==false && player1.getHP()>0 && player2.getHP()>0 && 
		(player1.nextcardIsEmpty()==false || player1.handcardIsEmpty()==false || tableEmpty(tableEmpty,p1table)==false) &&
		(player2.nextcardIsEmpty()==false || player2.handcardIsEmpty()==false || tableEmpty(tableEmpty,p2table)==false));
		
		if(player1.getHP()<=0 ||(player1.nextcardIsEmpty() && player1.handcardIsEmpty() && tableEmpty(tableEmpty,p1table)))
		{
			System.out.println(player2.getName()+"³Ó§Q");
		}
		else if(player2.getHP()<=0 ||(player2.nextcardIsEmpty() && player2.handcardIsEmpty() && tableEmpty(tableEmpty,p2table)))
		{
			System.out.println(player1.getName()+"³Ó§Q");
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