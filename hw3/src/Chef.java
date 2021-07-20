import java.util.ArrayList;
public class Chef
{
    private int cookmin[]=new int[6];                           //餐點準備時間
    public void setCookmin(int newcookmin[])
    {
        cookmin=newcookmin;
    }
    ArrayList<Integer> prepare =new ArrayList<Integer>();
    Table table[]=new Table[5];                                 
    Food food[]=new Food[6];                                //兩個廚師做好的餐點不能搞混,所以要分開判斷
    {
        for (int i=1;i<=5;i++)
        {
            food[i]=new Food();
        }
    }
    private int cooktime=0;                                    //正在準備的餐點還需要多久
    public void getTable(Table table[])
    {
        this.table=table;
    }
    public void order(int food)                                             //點餐
    {
        prepare.add(food);                                //廚師要準備的餐點
    }   
    public void cook(int time)                                              //煮菜
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
                cooktime=cookmin[prepare.get(0)];        //要開始煮的餐點
                }
            }   
            if (cooktime==1)
            {
                if (prepare.get(0)==2 || prepare.get(0)==4)
                {
                    table[food[prepare.get(0)].who.get(0)].eattime2.add(time-1);
                    table[food[prepare.get(0)].who.get(0)].waiting.remove(prepare.get(0));
                    table[food[prepare.get(0)].who.get(0)].eating.add(prepare.get(0));  //餐點上桌
                    food[prepare.get(0)].who.remove(0);                   //知道下一個餐點是誰點的
                    prepare.remove(0);                                      //廚師準備完成
                }
                else
                {
                    for(int i=prepare.size()-1;i>=0;i--)
                    {
                        if(prepare.get(i).equals(prepare.get(0)))
                        {   
                            table[food[prepare.get(0)].who.get(0)].eattime2.add(time-1);
                            table[food[prepare.get(0)].who.get(0)].waiting.remove(prepare.get(0));
                            table[food[prepare.get(0)].who.get(0)].eating.add(prepare.get(0));  //餐點上桌
                            food[prepare.get(0)].who.remove(0);                   //知道下一個餐點是誰點的
                            prepare.remove(i);                                      //廚師準備完成
                        }
                    } 
                }                                                                      
            }
            cooktime--;
            time--;
        } while (time!=0);
    }
}