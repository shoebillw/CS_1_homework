import java.util.ArrayList;
public class Chef
{
    private int cookmin[]=new int[6];                           //�\�I�ǳƮɶ�
    public void setCookmin(int newcookmin[])
    {
        cookmin=newcookmin;
    }
    ArrayList<Integer> prepare =new ArrayList<Integer>();
    Table table[]=new Table[5];                                 
    Food food[]=new Food[6];                                //��Ӽp�v���n���\�I����d�V,�ҥH�n���}�P�_
    {
        for (int i=1;i<=5;i++)
        {
            food[i]=new Food();
        }
    }
    private int cooktime=0;                                    //���b�ǳƪ��\�I�ٻݭn�h�[
    public void getTable(Table table[])
    {
        this.table=table;
    }
    public void order(int food)                                             //�I�\
    {
        prepare.add(food);                                //�p�v�n�ǳƪ��\�I
    }   
    public void cook(int time)                                              //�N��
    {
        do
        {
            if (cooktime==0)
            {
                if(prepare.isEmpty()==true)
                {
                    break;
                }
                else
                {
                cooktime=cookmin[prepare.get(0)];        //�n�}�l�N���\�I
                }
            }   
            if (cooktime==1)
            {
                if (prepare.get(0)==2 || prepare.get(0)==4)
                {
                    table[food[prepare.get(0)].who.get(0)].eattime2.add(time-1);
                    table[food[prepare.get(0)].who.get(0)].waiting.remove(prepare.get(0));
                    table[food[prepare.get(0)].who.get(0)].eating.add(prepare.get(0));  //�\�I�W��
                    food[prepare.get(0)].who.remove(0);                   //���D�U�@���\�I�O���I��
                    prepare.remove(0);                                      //�p�v�ǳƧ���
                }
                else
                {
                    for(int i=prepare.size()-1;i>=0;i--)
                    {
                        if(prepare.get(i).equals(prepare.get(0)))
                        {   
                            table[food[prepare.get(0)].who.get(0)].eattime2.add(time-1);
                            table[food[prepare.get(0)].who.get(0)].waiting.remove(prepare.get(0));
                            table[food[prepare.get(0)].who.get(0)].eating.add(prepare.get(0));  //�\�I�W��
                            food[prepare.get(0)].who.remove(0);                   //���D�U�@���\�I�O���I��
                            prepare.remove(i);                                      //�p�v�ǳƧ���
                        }
                    } 
                }                                                                      
            }
            cooktime--;
            time--;
        } while (time!=0);
    }
}