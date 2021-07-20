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
             System.out.println("Åwªï¨Ï¥Î¿ï²¼­pºâ¨t²Î");
             System.out.println("½Ð®Ú¾Ú¿ï²¼¤Wªº¾Ç¥Í¦~¯Å¿é¤J¦~¯Å½s¸¹(1~6)");     //´£¥Ü¨Ï¥ÎŽÍ¿é¤J¦~¯Å
             float grade = ConsoleIn.readLineInt();
                while (grade != 1 && grade != 2 && grade != 3 &&
                       grade != 4 && grade != 5 && grade != 6)               //­Y¿é¤J¿ù»~­n¨D­«·s¿é¤J
                {            
                    System.out.println("¦~¯Å½s¸¹¶È¥i¬°1~6");
                    System.out.println("½Ð¦A¦¸¿é¤J¦~¯Å½s¸¹");
                    grade = ConsoleIn.readLineInt();
                }



            System.out.println("½Ð®Ú¾Ú¿ï²¼¤Wªº¤ä«ù¹ï¶H¿é¤J­Ô¿ï¤H½s¸¹(1~3)");    //´£¥Ü¨Ï¥ÎŽÍ¿é¤J¤ä«ù¹ï¶H
            int candidate = ConsoleIn.readLineInt();
                while (candidate != 1 && candidate != 2 && candidate != 3)   //­Y¿é¤J¿ù»~­n¨D­«·s¿é¤J
                {
                    System.out.println("­Ô¿ï¤H½s¸¹¶È¥i¬°1~3");
                    System.out.println("½Ð¦A¦¸¿é¤J­Ô¿ï¤H½s¸¹");
                    candidate = ConsoleIn.readLineInt();
                }



                if (grade<=4)                                                //­pºâ­Ô¿ï¤H±o²¼¼Æ
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

            

            System.out.println("Ä~Äò¿é¤J½Ð¿é¤JY,Åã¥Üµ²ªG½Ð¿é¤JN");              //¸ß°Ý¨Ï¥ÎŽÍ¬O§_Ä~Äò¿é¤J
            Scanner scanner = new Scanner(System.in);
            again=scanner.nextLine();
                while (!(again.equals("Y") || again.equals("N")))            //­Y¿é¤J¿ù»~­n¨D­«·s¿é¤J
                {            
                    System.out.println("½Ð®Ú¾Ú¨t²Î´£¥Ü¦A¦¸¿é¤JY©ÎN");
                    again=scanner.nextLine();
                }
            
            voters=voters+1;                                                 //­pºâÁ`§ë²¼¤H¼Æ

        } 
        while (again.equals("Y"));                                           //¦A¦¸¿é¤Jªº±ø¥ó





        if (voters < 5)                                                      //­pºâ²¼¿ïµ²ªG
            {System.out.println("¦]§ë²¼¤H¼Æ¤p©ó5¤H");
             System.out.println("¥»©¡¾Ç¥Í·|ªøµL¤H·í¿ï");}
        else if((candidate1*2)>candidate1+candidate2+candidate3)
            {System.out.println("¥»©¡¾Ç¥Í·|ªø·í¿ï¤H¬°1¸¹¬_¦P¾Ç");}
        else if((candidate2*2)>candidate1+candidate2+candidate3)
            {System.out.println("¥»©¡¾Ç¥Í·|ªø·í¿ï¤H¬°2¸¹¤B¦P¾Ç");}    
        else if((candidate3*2)>candidate1+candidate2+candidate3)
            {System.out.println("¥»©¡¾Ç¥Í·|ªø·í¿ï¤H¬°3¸¹«À¦P¾Ç");}
        else 
            {System.out.println("¦]µL­Ô¿ï¤HÁ`²¼­È¹L¥b¼Æ");
             System.out.println("¥»©¡¾Ç¥Í·|ªøµL¤H·í¿ï");}
    }   
}













