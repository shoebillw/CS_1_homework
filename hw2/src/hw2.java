import java.util.Scanner;
public class hw2
{
    public static void main (String args[])
    {
        
        System.out.println("Åwªï¨Ó¨ì­Ó¤H³æ¤ë¦æ¨Æ¾ä¨t²Î");
        date day[]=new date[32];                                                            
        String input;                                                                     
        Scanner scanner = new Scanner(System.in);
        boolean exit=false;
        int i=0;                                                                            //i¥Nªí¤é´Á
        for(i=0;i<=31;i++)                                                                  //§â¨C¤@¤Ñmnew¦¨¤@­ÓÅÜ¼ÆÃþ«¬¬°dateªºª«¥ó 
        {
            day[i]=new date();
            day[i].datename=String.valueOf(i);
            day[0].datename=" ";
        }
        do
        {

            System.out.println("\n"+"                     2018¦~10¤ë");
            System.out.println("Sun.    Mon.    Tue.    Wed.    Thu.    Fri.    Sat.");
            for(i=0;i<=31;i++)
            {
                if (day[i].star==true)
                {
                    System.out.print(day[i].datename+"*\t");  
                }
                else
                {
                    System.out.print(day[i].datename+"\t");                                       //print¥X¤ë¾ä
                }
                if(i%7==6)
                {
                    System.out.print("\n");
                }
            }
            System.out.println("\n");
            System.out.println("½Ð¿é¤J±ý°õ¦æªº«ü¥O"+"\n"+"(1.¶i¤J³æ¤é¦æ¨Æ¾ä¼Ò¦¡:day-[¤é´Á], 2.µ²§ô¨t²Î:exit)");
            i=0;
            input=scanner.nextLine();
            if (input.equals("exit"))  
            {
                exit=true;
            }
            else if(input.length() !=9)                                                           //«ü¥O¿ù»~,­«·s¿é¤J 
            {
                System.out.println("\n"+"¿ù»~ªº«ü¥O,½Ð¦A¦¸¿é¤J");
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
                for(i=0;i<=31;i++)                                                                //¶i¨ì«ü©wªº¤é´Á
                {
                    if (Integer.parseInt(input.substring(7,9))==i)
                    {
                        day[i].calendar();
                        break;
                    }
                }
            }
            else                                                                                  //«ü¥O¿ù»~,­«·s¿é¤J
            {
                System.out.println("\n"+"¿ù»~ªº«ü¥O,½Ð¦A¦¸¿é¤J");
            }
        }while(exit==false && day[i].exit01==false);                                              //­Y¿é¤Jexit«h¨t²Îµ²§ô
    }
}