import java.util.Scanner;
import java.util.ArrayList;
public class Table
{
    private int eattime=0;
    private int tablenumber;
    public void setTablenumber(int newTablenumber)                              //修改private的tablenumber
    {
        tablenumber=newTablenumber;
    }
    public int getTablenumber()                                                 //取得private的tablenumber
    {
        return tablenumber;
    }

    ArrayList<Integer> eattime2=new ArrayList<Integer>();                                  //餐點做好後還剩多久可以吃
    ArrayList<Integer> waiting=new ArrayList<Integer>();                                   //未上菜
    ArrayList<Integer> eating=new ArrayList<Integer>();                                    //正在吃
    Scanner scanner=new Scanner(System.in);
    private boolean sequence;                                                              //上菜的順序
    private boolean uperson =false;                                              //座位有沒有人
    private int eatmin[]={0,10,8,2,5,3};                                         //餐點食用時間
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
            System.out.println("座位使用中,請重新輸入");
        }
        else
        {
            do
            {
                System.out.println("\n"+"點餐 ");
                System.out.println("(點選新餐點:add [餐點編號] [廚師編號] , 點餐結束 end)");
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
                        chef[c].order(b);                                                           //告訴廚師該做什麼
                        chef[c].food[b].whoorder(tablenumber);                                              //知道是誰點的
                        waiting.add(b);                                           //正在等餐點
                    }
                    else 
                    {
                        System.out.println("錯誤的指令");
                    }
                }
                catch (Exception e)
                {
                    System.out.println("錯誤的指令");
                }
            }while(true);
        }
    }
    public void eat(int time)
    {
        do
        {
            do                                                                      //排序上菜的順序
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
                    eattime=eatmin[eating.get(0)];        //要開始吃的餐點
                    if(eattime2.get(0)<time)
                    {
                        time=eattime2.get(0);
                    }
                }
            }   
            if (eattime==1)
            {
                eating.remove(0);                                      //吃完了        
                eattime2.remove(0);                                         
            }
            eattime--;
            time--;
        } while (time!=0 && time!=-1);                //如果餐點剛做好eattime=0 time就會變-1
    }
}