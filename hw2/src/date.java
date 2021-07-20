import java.util.Scanner;
public class date
{
    public String datename;                                                                   
    public boolean exit01=false,star,timeerror;                                                //star¬°trueªº¸Ü¤é´Á´N¥[*
    public String events[]=new String[1440];                                                   //events[]¥Nªí¤@¤Ñ¤¤ªº1440¤ÀÄÁ
    public void calendar()
    {
        boolean month=false;
        Scanner scanner = new Scanner(System.in);
        
        do                                                                                     //¥i­«½Æ°õ¦æ
        {
            int y=1;                                                                                                          //y¥Nªí¬¡°Ê¦¸§Ç
            System.out.println("\n"+"2018¦~10¤ë"+datename+"¤é"+"\n"+"¬¡°Ê:");
            for(int x=0;x<1440;x++)                                                                                           //x¥Nªí®É¶¡
            {
                if (events[x] !=null)
                {                                                                                                             //«Dnullªº®æ¤l¥Nªí¦³¦s¬¡°Ê
                    System.out.println(y+". "+events[x]);
                    star=true;                                                                                                //­Y¦³®æ¤l¦s¬¡°Ê«h¥[¤W¬P¸¹
                    y++;
                }
            }
            System.out.println("\n"+"½Ð¿é¤J±ý°õ¦æªº«ü¥O"+"\n"+"(1.·s¼W¬¡°Ê:add-[¬¡°Ê®É¶¡]-[·s¼W¬¡°Ê], 2.§R°£¬¡°Ê:del-[¬¡°Ê½s¸¹], 3.§R°£©Ò¦³¬¡°Ê:del-all, 4.­×§ï¬¡°Ê®É¶¡:edit-[¬¡°Ê½s¸¹]-[¬¡°Ê®É¶¡], 5.¤Á´«¦Ü¤ë¦æ¨Æ¾ä¼Ò¦¡:month, 6.µ²§ô¨t²Î:exit)");                                                                                                    
            String input01=scanner.nextLine();
            if(input01.equals("month"))                                                                 //¦^¨ì¤ë¾ä
            {
                month=true;
            }
            else if(input01.equals("exit"))                                                             //µ²§ôµ{¦¡
            {
                exit01=true;
            }
            else if (input01.length()<5)                                                                //°»´ú¿é¤J¿ù»~ªº¨ä¤¤¤@³¡¤À
            {
                System.out.println("\n"+"¿ù»~ªº«ü¥O,½Ð¦A¦¸¿é¤J");
            }
            else if (input01.substring(0,4).equals("add-") && input01.substring(6,7).equals(":") && input01.substring(12,13).equals(":")     //·s¼W¬¡°Êªº³¡¤À
             && input01.substring(9,10).equals("~") && input01.substring(15,16).equals("-") && input01.length()>=17 && Integer.parseInt(input01.substring(4,6))<=23
             && Integer.parseInt(input01.substring(10,12))<=23 && Integer.parseInt(input01.substring(7,9))<=59 && Integer.parseInt(input01.substring(13,15))<=59)
            {
                timeerror=false;
                int a=Integer.parseInt(input01.substring(4,6))*60+Integer.parseInt(input01.substring(7,9));                        //a¬°¿é¤Jªº¬¡°Êªº¶}©l®É¶¡
                int b=Integer.parseInt(input01.substring(10,12))*60+Integer.parseInt(input01.substring(13,15));                    //b¬°¿é¤Jªº¬¡°Êªºµ²§ô®É¶¡
                
                for(int x=0;x<1440;x++)                                                                                            //x¥Nªí®É¶¡
                {
                    if(b<a)
                    {
                        System.out.println("\n"+"¿ù»~ªº®É¶¡ªí¥Üªk,½Ð­«·s¿é¤J");                                                       //§PÂ_®É¶¡¦³µL¿ù»~
                        timeerror=true;
                        break;
                    }
                    if (events[x] !=null)
                    {
                        int c=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));            //c¬°­ì¦³ªº¬¡°Êªº¶}©l®É¶¡
                        int d=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));           //d¬°­ì¦³ªº¬¡°Êªºµ²§ô®É¶¡
                        
                        if ((c<=a && a<=d) || (c<=b && b<=d))
                        {
                            System.out.println("\n"+"®É¶¡»P¤w¦s¦b¬¡°Ê¦³©Ò­«Å|,½Ð­«·s¿é¤J");                                           //§PÂ_®É¶¡¬O§_­«Å|
                            timeerror=true;
                            break;
                        }
                    }
                }
                if(timeerror==false)
                {
                    events[a]=input01.substring(4,15)+" "+input01.substring(16);                                 //¦pªG¨S¦³®É¶¡¤Wªº¿ù»~«h±N¦¹¬¡°ÊÀx¦s¦b¬¡°Ê¶}©l®É¶¡¸Ó®æ
                }
            }
            else if (input01.substring(0,5).equals("edit-") && input01.substring(6,7).equals("-") && input01.substring(9,10).equals(":")     //­×§ïªº³¡¤À
             && input01.substring(12,13).equals("~") && input01.substring(15,16).equals(":") && input01.length()==18 && Integer.parseInt(input01.substring(7,9))<=23
             && Integer.parseInt(input01.substring(13,15))<=23 && Integer.parseInt(input01.substring(10,12))<=59 && Integer.parseInt(input01.substring(16,18))<=59)
            {
                timeerror=false;
                int e=Integer.parseInt(input01.substring(7,9))*60 + Integer.parseInt(input01.substring(10,12));                          //e¬°±ý­×§ïªº¬¡°Êªº¶}©l®É¶¡
                int f=Integer.parseInt(input01.substring(13,15))*60 + Integer.parseInt(input01.substring(16,18));                        //f¬°±ý­×§ïªº¬¡°Êªºµ²§ô®É¶¡
                int w=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {   
                        int g=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));                  //g¬°­ì¦³ªº¬¡°Êªº¶}©l®É¶¡
                        int h=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));                 //h¬°­ì¦³ªº¬¡°Êªºµ²§ô®É¶¡
                        
                        if (!(Integer.toString(w)).equals(input01.substring(5,6)))
                        {
                            if((g<=e && e<=h) || (g<=f && f<=h))
                            {
                                //System.out.println("\n"+"®É¶¡»P¤w¦s¦b¬¡°Ê¦³©Ò­«Å|,½Ð­«·s¿é¤J");                                           //§PÂ_®É¶¡¬O§_­«Å|
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
                            if((Integer.toString(w)).equals(input01.substring(5,6)))                        //§ä¨ì±ý­×§ïªº¶µ¥Ø
                            {
                                edit=true;                                                                  //¦³§ä¨ì±ý­×§ï¶µ¥Øªº¸Üedit=true
                                break;  
                            }  
                            w++;
                        }
                    }
                    if (edit==false)                                                                        //¨S¦³­×§ï¬¡°Ê®É¶¡¥Nªí±ý­×§ïªº¬¡°Ê½s¸¹¤£¦s¦b
                    {
                        System.out.println("\n"+"µL¦¹¬¡°Ê,½Ð­«·s¿é¤J");
                    }
                    else if (f<e)
                    {
                        System.out.println("\n"+"¿ù»~ªº®É¶¡ªí¥Üªk,½Ð­«·s¿é¤J");   
                    }
                    else if(timeerror==true)
                    {
                        System.out.println("\n"+"®É¶¡»P¤w¦s¦b¬¡°Ê¦³©Ò­«Å|,½Ð­«·s¿é¤J");
                    }
                    else 
                    {
                        events[e]=input01.substring(7,18)+" "+events[x].substring(12);              //¦b·sªº®É¶¡®æ¤W·s¼W¬¡°Ê
                        if(e!=x) 
                        {
                            events[x]=null;                                                         //±N­ì®É¶¡®æªº¬¡°Ê§R°£
                        } 
                    }
                
            }
            else if (input01.equals("del-all"))                                            //§R°£¥þ³¡ªº³¡¤À
            {
                star=false;                                                         
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                            events[x]=null;                                                 //§â¨C¤@®æm§ï¦¨null
                    }
                }
            }
            else if (input01.substring(0,4).equals("del-"))                                                 //§R°£ªº³¡¤À
            {
                star=false;
                boolean del=false;
                int z=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                        if(("del-"+Integer.toString(z)).equals(input01))                                    //±ý§R°£ªº¶µ¥ØÅÜ¦¨null
                        {
                            events[x]=null;
                            del=true;
                            break;                                                                 
                        }
                        z++;
                    }
                }
                if (del==false)                                                                             //¨S¦³§R°£¬¡°Ê¥Nªí±ý§R°£ªº¬¡°Ê½s¸¹¤£¦s¦b
                    {
                        System.out.println("\n"+"µL¦¹¬¡°Ê,½Ð­«·s¿é¤J");
                    }
            }
            else
            {
                System.out.println("\n"+"¿ù»~ªº«ü¥O,½Ð¦A¦¸¿é¤J");
            }
        }while(month==false && exit01==false);                                                              //­Y¿é¤Jmonth©Îexit´Nµ²§ô¤é¾ä¨t²Î
    }
}