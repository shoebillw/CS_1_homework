import java.util.Scanner;
import java.util.ArrayList;
public class Table
{
    private int eattime=0;
    private int tablenumber;
    public void setTablenumber(int newTablenumber)                              //�ק�private��tablenumber
    {
        tablenumber=newTablenumber;
    }
    public int getTablenumber()                                                 //���oprivate��tablenumber
    {
        return tablenumber;
    }

    ArrayList<Integer> eattime2=new ArrayList<Integer>();                                  //�\�I���n���ٳѦh�[�i�H�Y
    ArrayList<Integer> waiting=new ArrayList<Integer>();                                   //���W��
    ArrayList<Integer> eating=new ArrayList<Integer>();                                    //���b�Y
    Scanner scanner=new Scanner(System.in);
    private boolean sequence;                                                              //�W�檺����
    private boolean uperson =false;                                              //�y�즳�S���H
    private int eatmin[]={0,10,8,2,5,3};                                         //�\�I���ήɶ�
    public boolean getUperson()                                            
    {
        return uperson;
    }
    public void setUperson(boolean newUperson)
    {
        uperson=newUperson;
    }
    public void seat(Chef chef[])
    {
        
        if (uperson==true)
        {
            System.out.println("�y��ϥΤ�,�Э��s��J");
        }
        else
        {
            do
            {
                System.out.println("\n"+"�I�\ ");
                System.out.println("(�I��s�\�I:add [�\�I�s��] [�p�v�s��] , �I�\���� end)");
                String input01=scanner.nextLine();
                try
                {
                    if(input01.substring(0,3).equals("end"))
                    {
                        break;
                    }
                    else if (input01.substring(0,5).equals("add M") && input01.substring(6,8).equals(" S") && Integer.parseInt(input01.substring(5,6))>=1 && 
                             Integer.parseInt(input01.substring(5,6))<=5 && Integer.parseInt(input01.substring(8,9))>=1 && Integer.parseInt(input01.substring(8,9))<=2)
                    {
                        int b=Integer.parseInt(input01.substring(5,6)),c=Integer.parseInt(input01.substring(8,9));
                        chef[c].order(b);                                                           //�i�D�p�v�Ӱ�����
                        chef[c].food[b].whoorder(tablenumber);                                              //���D�O���I��
                        waiting.add(b);                                           //���b���\�I
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
            }while(true);
        }
    }
    public void eat(int time)
    {
        do
        {
            do                                                                      //�ƧǤW�檺����
            {
                sequence=true;
                for(int i=1,tempstorage;i<eattime2.size();i++)
                {
                    if(eattime2.get(i)>eattime2.get(i-1))
                    {
                        tempstorage=eattime2.get(i-1);
                        eattime2.set(i-1,eattime2.get(i));
                        eattime2.set(i,tempstorage);
                        tempstorage=eating.get(i-1);
                        eating.set(i-1,eating.get(i));
                        eating.set(i,tempstorage);
                        sequence=false;
                    }
                }
            }while(sequence==false);

            if (eattime==0)
            {
                if(eating.isEmpty()==true)
                {
                    break;
                }
                else
                {
                    eattime=eatmin[eating.get(0)];        //�n�}�l�Y���\�I
                    if(eattime2.get(0)<time)
                    {
                        time=eattime2.get(0);
                    }
                }
            }   
            if (eattime==1)
            {
                eating.remove(0);                                      //�Y���F        
                eattime2.remove(0);                                         
            }
            eattime--;
            time--;
        } while (time!=0 && time!=-1);                //�p�G�\�I�谵�neattime=0 time�N�|��-1
    }
}