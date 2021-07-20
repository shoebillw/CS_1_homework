import java.util.Scanner;
public class hw3
{
    public static void main (String args[])
    {
        
        System.out.println("歡迎來到成大小吃店");
        int time;
        Scanner scanner=new Scanner(System.in);

        Table table[]=new Table[5];                                             //把全部物件new一遍
        for (int i=1;i<=4;i++)
        {
            table[i]=new Table();
        }
        Chef chef[]=new Chef[3];  
        for (int i=1;i<=2;i++)
        {
            chef[i]=new Chef();
        }
        String foodname[]={" ","炒飯","鍋燒意麵","炒青菜","奶油千層蛋糕","綜合果汁"};
        int chef1Cookmin[]={0,3,4,1,8,2};                                         //煮菜時間
        chef[1].setCookmin(chef1Cookmin);
        int chef2Cookmin[]={0,6,4,2,4,1};
        chef[2].setCookmin(chef2Cookmin);

        chef[1].getTable(table);                                          //讓chef抓的到food和table
        chef[2].getTable(table);
        do
        {
            for(int i=1;i<=4;i++)                                                                           //先判斷每一桌有沒有人
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
            System.out.println("\n"+"請輸入指令");
            System.out.println("(安排顧客座位:new [桌位編號] , 查看店內狀況:status table , 查看廚師狀況:status chef , 模擬經過時間:next [時間（分）] , 結束系統:exit)");
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
                    table[a].setTablenumber(a);                                                      //設定桌號
                    table[a].seat(chef);                                                       //找座位
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
                            System.out.println("廚師"+i+"沒有要準備的餐點");
                        }
                        else
                        {
                            System.out.print("S"+i+"廚師正在準備的餐點:");
                            System.out.print(foodname[chef[i].prepare.get(0)]+" ");
                            System.out.print("\n"+"S"+i+"廚師剩餘要準備的餐點:");
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
                            System.out.println(i+"號桌有人");
                            System.out.print(i+"號桌準備中:");
                            for (int j=0;j<table[i].waiting.size();j++)
                            {
                                System.out.print(foodname[table[i].waiting.get(j)]+" ");
                            }
                            System.out.println();
                            System.out.print(i+"號桌已上桌:");
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
                    System.out.println("錯誤的指令");
                }
            }
            catch (Exception e)
            {
                System.out.println("錯誤的指令");
            }
        } while (true);
    }
}
