import java.util.Scanner;

public class hw1
{
    public static void main(String args[])
    {
        float candidate1 = 0,candidate2 = 0,candidate3 = 0;
        String again;
        int voters = 0;
        do
        {
             System.out.println("歡迎使用選票計算系統");
             System.out.println("請根據選票上的學生年級輸入年級編號(1~6)");     //提示使用�芨擗J年級
             float grade = ConsoleIn.readLineInt();
                while (grade != 1 && grade != 2 && grade != 3 &&
                       grade != 4 && grade != 5 && grade != 6)               //若輸入錯誤要求重新輸入
                {            
                    System.out.println("年級編號僅可為1~6");
                    System.out.println("請再次輸入年級編號");
                    grade = ConsoleIn.readLineInt();
                }



            System.out.println("請根據選票上的支持對象輸入候選人編號(1~3)");    //提示使用�芨擗J支持對象
            int candidate = ConsoleIn.readLineInt();
                while (candidate != 1 && candidate != 2 && candidate != 3)   //若輸入錯誤要求重新輸入
                {
                    System.out.println("候選人編號僅可為1~3");
                    System.out.println("請再次輸入候選人編號");
                    candidate = ConsoleIn.readLineInt();
                }



                if (grade<=4)                                                //計算候選人得票數
                {
                    switch (candidate) 
                    {
                        case 1:
                            candidate1 = candidate1 + grade;
                            break;
                        case 2:
                            candidate2 = candidate2 + grade;
                            break;
                        case 3:
                            candidate3 = candidate3 + grade;
                            break; 
                    }
                }
                else 
                {   
                    switch (candidate)    
                    {
                        case 1:
                            candidate1 = candidate1 + 0.5F ;
                            break;
                        case 2:
                            candidate2 = candidate2 + 0.5F ;
                            break;
                        case 3:
                            candidate3 = candidate3 + 0.5F ;
                            break; 
                    }
                }

            

            System.out.println("繼續輸入請輸入Y,顯示結果請輸入N");              //詢問使用�肮O否繼續輸入
            Scanner scanner = new Scanner(System.in);
            again=scanner.nextLine();
                while (!(again.equals("Y") || again.equals("N")))            //若輸入錯誤要求重新輸入
                {            
                    System.out.println("請根據系統提示再次輸入Y或N");
                    again=scanner.nextLine();
                }
            
            voters=voters+1;                                                 //計算總投票人數

        } 
        while (again.equals("Y"));                                           //再次輸入的條件





        if (voters < 5)                                                      //計算票選結果
            {System.out.println("因投票人數小於5人");
             System.out.println("本屆學生會長無人當選");}
        else if((candidate1*2)>candidate1+candidate2+candidate3)
            {System.out.println("本屆學生會長當選人為1號柯同學");}
        else if((candidate2*2)>candidate1+candidate2+candidate3)
            {System.out.println("本屆學生會長當選人為2號丁同學");}    
        else if((candidate3*2)>candidate1+candidate2+candidate3)
            {System.out.println("本屆學生會長當選人為3號姚同學");}
        else 
            {System.out.println("因無候選人總票值過半數");
             System.out.println("本屆學生會長無人當選");}
    }   
}













