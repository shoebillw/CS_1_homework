import java.util.Scanner;
public class hw3
{
    public static void main (String args[])
    {
        
        System.out.println("�w��Ө즨�j�p�Y��");
        int time;
        Scanner scanner=new Scanner(System.in);

        Table table[]=new Table[5];                                             //���������new�@�M
        for (int i=1;i<=4;i++)
        {
            table[i]=new Table();
        }
        Chef chef[]=new Chef[3];  
        for (int i=1;i<=2;i++)
        {
            chef[i]=new Chef();
        }
        String foodname[]={" ","����","��N�N��","���C��","���o�d�h�J�|","��X�G��"};
        int chef1Cookmin[]={0,3,4,1,8,2};                                         //�N��ɶ�
        chef[1].setCookmin(chef1Cookmin);
        int chef2Cookmin[]={0,6,4,2,4,1};
        chef[2].setCookmin(chef2Cookmin);

        chef[1].getTable(table);                                          //��chef�쪺��food�Mtable
        chef[2].getTable(table);
        do
        {
            for(int i=1;i<=4;i++)                                                                           //���P�_�C�@�঳�S���H
            {
                if (table[i].waiting.isEmpty()==true && table[i].eating.isEmpty()==true)
                {
                    table[i].setUperson(false);
                }
                else
                {
                    table[i].setUperson(true);
                }
            }   
            System.out.println("\n"+"�п�J���O");
            System.out.println("(�w���U�Ȯy��:new [���s��] , �d�ݩ������p:status table , �d�ݼp�v���p:status chef , �����g�L�ɶ�:next [�ɶ��]���^] , �����t��:exit)");
            String input=scanner.nextLine();
            System.out.println();
            try
            {
                if (input.substring(0,4).equals("exit"))
                {
                    break;
                }
                else if (input.substring(0,4).equals("new ") && Integer.parseInt(input.substring(4))>=1 && Integer.parseInt(input.substring(4))<=4)
                {
                    int a =Integer.parseInt(input.substring(4,5));              
                    table[a].setTablenumber(a);                                                      //�]�w�ู
                    table[a].seat(chef);                                                       //��y��
                }
                else if (input.substring(0,5).equals("next ") && Integer.parseInt(input.substring(5))>0)
                {
                    for(int i=1;i<=4;i++)
                    {
                        time=Integer.parseInt(input.substring(5));
                        for (int j=0;j<table[i].eattime2.size();j++)
                        {
                            table[i].eattime2.set(j,time);
                        }
                    }
                    time=Integer.parseInt(input.substring(5)); 
                    chef[1].cook(time);  
                    time=Integer.parseInt(input.substring(5));   
                    chef[2].cook(time); 

                    for(int i=1;i<=4;i++)
                    {
                        time=Integer.parseInt(input.substring(5));  
                        table[i].eat(time);  
                    }                     
                }
                else if (input.substring(0,11).equals("status chef"))
                {
                    for (int i=1;i<=2;i++)
                    {
                        if(chef[i].prepare.isEmpty()==true)
                        {
                            System.out.println("�p�v"+i+"�S���n�ǳƪ��\�I");
                        }
                        else
                        {
                            System.out.print("S"+i+"�p�v���b�ǳƪ��\�I:");
                            System.out.print(foodname[chef[i].prepare.get(0)]+" ");
                            System.out.print("\n"+"S"+i+"�p�v�Ѿl�n�ǳƪ��\�I:");
                            for(int j=1;j<chef[i].prepare.size();j++)
                            {
                                System.out.print(foodname[chef[i].prepare.get(j)]+" ");
                            }
                            System.out.println();
                        }
                    }
                }
                else if (input.substring(0,12).equals("status table"))
                {
                    for(int i=1;i<=4;i++)
                    {
                        if (table[i].getUperson()==true)
                        {
                            System.out.println(i+"���঳�H");
                            System.out.print(i+"����ǳƤ�:");
                            for (int j=0;j<table[i].waiting.size();j++)
                            {
                                System.out.print(foodname[table[i].waiting.get(j)]+" ");
                            }
                            System.out.println();
                            System.out.print(i+"����w�W��:");
                            for (int j=0;j<table[i].eating.size();j++)
                            {
                                System.out.print(foodname[table[i].eating.get(j)]+" ");
                            }
                            System.out.println();
                        }
                    }
                }
                else 
                {
                    System.out.println("���~�����O");
                }
            }
            catch (Exception e)
            {
                System.out.println("���~�����O");
            }
        } while (true);
    }
}
