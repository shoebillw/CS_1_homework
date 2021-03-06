import java.util.Scanner;
public class date
{
    public String datename;                                                                   
    public boolean exit01=false,star,timeerror;                                                //star為true的話日期就加*
    public String events[]=new String[1440];                                                   //events[]代表一天中的1440分鐘
    public void calendar()
    {
        boolean month=false;
        Scanner scanner = new Scanner(System.in);
        
        do                                                                                     //可重複執行
        {
            int y=1;                                                                                                          //y代表活動次序
            System.out.println("\n"+"2018年10月"+datename+"日"+"\n"+"活動:");
            for(int x=0;x<1440;x++)                                                                                           //x代表時間
            {
                if (events[x] !=null)
                {                                                                                                             //非null的格子代表有存活動
                    System.out.println(y+". "+events[x]);
                    star=true;                                                                                                //若有格子存活動則加上星號
                    y++;
                }
            }
            System.out.println("\n"+"請輸入欲執行的指令"+"\n"+"(1.新增活動:add-[活動時間]-[新增活動], 2.刪除活動:del-[活動編號], 3.刪除所有活動:del-all, 4.修改活動時間:edit-[活動編號]-[活動時間], 5.切換至月行事曆模式:month, 6.結束系統:exit)");                                                                                                    
            String input01=scanner.nextLine();
            if(input01.equals("month"))                                                                 //回到月曆
            {
                month=true;
            }
            else if(input01.equals("exit"))                                                             //結束程式
            {
                exit01=true;
            }
            else if (input01.length()<5)                                                                //偵測輸入錯誤的其中一部分
            {
                System.out.println("\n"+"錯誤的指令,請再次輸入");
            }
            else if (input01.substring(0,4).equals("add-") && input01.substring(6,7).equals(":") && input01.substring(12,13).equals(":")     //新增活動的部分
             && input01.substring(9,10).equals("~") && input01.substring(15,16).equals("-") && input01.length()>=17 && Integer.parseInt(input01.substring(4,6))<=23
             && Integer.parseInt(input01.substring(10,12))<=23 && Integer.parseInt(input01.substring(7,9))<=59 && Integer.parseInt(input01.substring(13,15))<=59)
            {
                timeerror=false;
                int a=Integer.parseInt(input01.substring(4,6))*60+Integer.parseInt(input01.substring(7,9));                        //a為輸入的活動的開始時間
                int b=Integer.parseInt(input01.substring(10,12))*60+Integer.parseInt(input01.substring(13,15));                    //b為輸入的活動的結束時間
                
                for(int x=0;x<1440;x++)                                                                                            //x代表時間
                {
                    if(b<a)
                    {
                        System.out.println("\n"+"錯誤的時間表示法,請重新輸入");                                                       //判斷時間有無錯誤
                        timeerror=true;
                        break;
                    }
                    if (events[x] !=null)
                    {
                        int c=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));            //c為原有的活動的開始時間
                        int d=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));           //d為原有的活動的結束時間
                        
                        if ((c<=a && a<=d) || (c<=b && b<=d))
                        {
                            System.out.println("\n"+"時間與已存在活動有所重疊,請重新輸入");                                           //判斷時間是否重疊
                            timeerror=true;
                            break;
                        }
                    }
                }
                if(timeerror==false)
                {
                    events[a]=input01.substring(4,15)+" "+input01.substring(16);                                 //如果沒有時間上的錯誤則將此活動儲存在活動開始時間該格
                }
            }
            else if (input01.substring(0,5).equals("edit-") && input01.substring(6,7).equals("-") && input01.substring(9,10).equals(":")     //修改的部分
             && input01.substring(12,13).equals("~") && input01.substring(15,16).equals(":") && input01.length()==18 && Integer.parseInt(input01.substring(7,9))<=23
             && Integer.parseInt(input01.substring(13,15))<=23 && Integer.parseInt(input01.substring(10,12))<=59 && Integer.parseInt(input01.substring(16,18))<=59)
            {
                timeerror=false;
                int e=Integer.parseInt(input01.substring(7,9))*60 + Integer.parseInt(input01.substring(10,12));                          //e為欲修改的活動的開始時間
                int f=Integer.parseInt(input01.substring(13,15))*60 + Integer.parseInt(input01.substring(16,18));                        //f為欲修改的活動的結束時間
                int w=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {   
                        int g=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));                  //g為原有的活動的開始時間
                        int h=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));                 //h為原有的活動的結束時間
                        
                        if (!(Integer.toString(w)).equals(input01.substring(5,6)))
                        {
                            if((g<=e && e<=h) || (g<=f && f<=h))
                            {
                                //System.out.println("\n"+"時間與已存在活動有所重疊,請重新輸入");                                           //判斷時間是否重疊
                                timeerror=true;
                                break;
                            }
                        }
                        w++;                                                                                                             
                    }
                }
                w=1;
                boolean edit=false;
                int x;
                    for(x=0;x<1440;x++)                   
                    {
                        if (events[x] !=null)
                        {   
                            if((Integer.toString(w)).equals(input01.substring(5,6)))                        //找到欲修改的項目
                            {
                                edit=true;                                                                  //有找到欲修改項目的話edit=true
                                break;  
                            }  
                            w++;
                        }
                    }
                    if (edit==false)                                                                        //沒有修改活動時間代表欲修改的活動編號不存在
                    {
                        System.out.println("\n"+"無此活動,請重新輸入");
                    }
                    else if (f<e)
                    {
                        System.out.println("\n"+"錯誤的時間表示法,請重新輸入");   
                    }
                    else if(timeerror==true)
                    {
                        System.out.println("\n"+"時間與已存在活動有所重疊,請重新輸入");
                    }
                    else 
                    {
                        events[e]=input01.substring(7,18)+" "+events[x].substring(12);              //在新的時間格上新增活動
                        if(e!=x) 
                        {
                            events[x]=null;                                                         //將原時間格的活動刪除
                        } 
                    }
                
            }
            else if (input01.equals("del-all"))                                            //刪除全部的部分
            {
                star=false;                                                         
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                            events[x]=null;                                                 //把每一格?m改成null
                    }
                }
            }
            else if (input01.substring(0,4).equals("del-"))                                                 //刪除的部分
            {
                star=false;
                boolean del=false;
                int z=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                        if(("del-"+Integer.toString(z)).equals(input01))                                    //欲刪除的項目變成null
                        {
                            events[x]=null;
                            del=true;
                            break;                                                                 
                        }
                        z++;
                    }
                }
                if (del==false)                                                                             //沒有刪除活動代表欲刪除的活動編號不存在
                    {
                        System.out.println("\n"+"無此活動,請重新輸入");
                    }
            }
            else
            {
                System.out.println("\n"+"錯誤的指令,請再次輸入");
            }
        }while(month==false && exit01==false);                                                              //若輸入month或exit就結束日曆系統
    }
}