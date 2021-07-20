import java.util.Scanner;
public class hw2
{
    public static void main (String args[])
    {
        
        System.out.println("歡迎來到個人單月行事曆系統");
        date day[]=new date[32];                                                            
        String input;                                                                     
        Scanner scanner = new Scanner(System.in);
        boolean exit=false;
        int i=0;                                                                            //i代表日期
        for(i=0;i<=31;i++)                                                                  //把每一天�mnew成一個變數類型為date的物件 
        {
            day[i]=new date();
            day[i].datename=String.valueOf(i);
            day[0].datename=" ";
        }
        do
        {

            System.out.println("\n"+"                     2018年10月");
            System.out.println("Sun.    Mon.    Tue.    Wed.    Thu.    Fri.    Sat.");
            for(i=0;i<=31;i++)
            {
                if (day[i].star==true)
                {
                    System.out.print(day[i].datename+"*\t");  
                }
                else
                {
                    System.out.print(day[i].datename+"\t");                                       //print出月曆
                }
                if(i%7==6)
                {
                    System.out.print("\n");
                }
            }
            System.out.println("\n");
            System.out.println("請輸入欲執行的指令"+"\n"+"(1.進入單日行事曆模式:day-[日期], 2.結束系統:exit)");
            i=0;
            input=scanner.nextLine();
            if (input.equals("exit"))  
            {
                exit=true;
            }
            else if(input.length() !=9)                                                           //指令錯誤,重新輸入 
            {
                System.out.println("\n"+"錯誤的指令,請再次輸入");
            }
            else if (input.substring(0,7).equals("day-10/") && (input.substring(7,9).equals("01") ||input.substring(7,9).equals("02") ||input.substring(7,9).equals("03") ||
            input.substring(7,9).equals("04") ||input.substring(7,9).equals("05") ||input.substring(7,9).equals("06") ||input.substring(7,9).equals("07") ||
            input.substring(7,9).equals("08") ||input.substring(7,9).equals("09") ||input.substring(7,9).equals("10") ||input.substring(7,9).equals("11") ||
            input.substring(7,9).equals("12") ||input.substring(7,9).equals("13") ||input.substring(7,9).equals("14") ||input.substring(7,9).equals("15") ||
            input.substring(7,9).equals("16") ||input.substring(7,9).equals("17") ||input.substring(7,9).equals("18") ||input.substring(7,9).equals("19") ||
            input.substring(7,9).equals("20") ||input.substring(7,9).equals("21") ||input.substring(7,9).equals("22") ||input.substring(7,9).equals("23") ||
            input.substring(7,9).equals("24") ||input.substring(7,9).equals("25") ||input.substring(7,9).equals("26") ||input.substring(7,9).equals("27") ||
            input.substring(7,9).equals("28") ||input.substring(7,9).equals("29") ||input.substring(7,9).equals("30") ||input.substring(7,9).equals("31")))
            {
                for(i=0;i<=31;i++)                                                                //進到指定的日期
                {
                    if (Integer.parseInt(input.substring(7,9))==i)
                    {
                        day[i].calendar();
                        break;
                    }
                }
            }
            else                                                                                  //指令錯誤,重新輸入
            {
                System.out.println("\n"+"錯誤的指令,請再次輸入");
            }
        }while(exit==false && day[i].exit01==false);                                              //若輸入exit則系統結束
    }
}