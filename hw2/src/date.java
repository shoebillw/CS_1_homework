import java.util.Scanner;
public class date
{
    public String datename;                                                                   
    public boolean exit01=false,star,timeerror;                                                //star��true���ܤ���N�[*
    public String events[]=new String[1440];                                                   //events[]�N��@�Ѥ���1440����
    public void calendar()
    {
        boolean month=false;
        Scanner scanner = new Scanner(System.in);
        
        do                                                                                     //�i���ư���
        {
            int y=1;                                                                                                          //y�N���ʦ���
            System.out.println("\n"+"2018�~10��"+datename+"��"+"\n"+"����:");
            for(int x=0;x<1440;x++)                                                                                           //x�N��ɶ�
            {
                if (events[x] !=null)
                {                                                                                                             //�Dnull����l�N���s����
                    System.out.println(y+". "+events[x]);
                    star=true;                                                                                                //�Y����l�s���ʫh�[�W�P��
                    y++;
                }
            }
            System.out.println("\n"+"�п�J�����檺���O"+"\n"+"(1.�s�W����:add-[���ʮɶ�]-[�s�W����], 2.�R������:del-[���ʽs��], 3.�R���Ҧ�����:del-all, 4.�קﬡ�ʮɶ�:edit-[���ʽs��]-[���ʮɶ�], 5.�����ܤ��ƾ�Ҧ�:month, 6.�����t��:exit)");                                                                                                    
            String input01=scanner.nextLine();
            if(input01.equals("month"))                                                                 //�^����
            {
                month=true;
            }
            else if(input01.equals("exit"))                                                             //�����{��
            {
                exit01=true;
            }
            else if (input01.length()<5)                                                                //������J���~���䤤�@����
            {
                System.out.println("\n"+"���~�����O,�ЦA����J");
            }
            else if (input01.substring(0,4).equals("add-") && input01.substring(6,7).equals(":") && input01.substring(12,13).equals(":")     //�s�W���ʪ�����
             && input01.substring(9,10).equals("~") && input01.substring(15,16).equals("-") && input01.length()>=17 && Integer.parseInt(input01.substring(4,6))<=23
             && Integer.parseInt(input01.substring(10,12))<=23 && Integer.parseInt(input01.substring(7,9))<=59 && Integer.parseInt(input01.substring(13,15))<=59)
            {
                timeerror=false;
                int a=Integer.parseInt(input01.substring(4,6))*60+Integer.parseInt(input01.substring(7,9));                        //a����J�����ʪ��}�l�ɶ�
                int b=Integer.parseInt(input01.substring(10,12))*60+Integer.parseInt(input01.substring(13,15));                    //b����J�����ʪ������ɶ�
                
                for(int x=0;x<1440;x++)                                                                                            //x�N��ɶ�
                {
                    if(b<a)
                    {
                        System.out.println("\n"+"���~���ɶ���ܪk,�Э��s��J");                                                       //�P�_�ɶ����L���~
                        timeerror=true;
                        break;
                    }
                    if (events[x] !=null)
                    {
                        int c=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));            //c���즳�����ʪ��}�l�ɶ�
                        int d=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));           //d���즳�����ʪ������ɶ�
                        
                        if ((c<=a && a<=d) || (c<=b && b<=d))
                        {
                            System.out.println("\n"+"�ɶ��P�w�s�b���ʦ��ҭ��|,�Э��s��J");                                           //�P�_�ɶ��O�_���|
                            timeerror=true;
                            break;
                        }
                    }
                }
                if(timeerror==false)
                {
                    events[a]=input01.substring(4,15)+" "+input01.substring(16);                                 //�p�G�S���ɶ��W�����~�h�N�������x�s�b���ʶ}�l�ɶ��Ӯ�
                }
            }
            else if (input01.substring(0,5).equals("edit-") && input01.substring(6,7).equals("-") && input01.substring(9,10).equals(":")     //�ק諸����
             && input01.substring(12,13).equals("~") && input01.substring(15,16).equals(":") && input01.length()==18 && Integer.parseInt(input01.substring(7,9))<=23
             && Integer.parseInt(input01.substring(13,15))<=23 && Integer.parseInt(input01.substring(10,12))<=59 && Integer.parseInt(input01.substring(16,18))<=59)
            {
                timeerror=false;
                int e=Integer.parseInt(input01.substring(7,9))*60 + Integer.parseInt(input01.substring(10,12));                          //e�����ק諸���ʪ��}�l�ɶ�
                int f=Integer.parseInt(input01.substring(13,15))*60 + Integer.parseInt(input01.substring(16,18));                        //f�����ק諸���ʪ������ɶ�
                int w=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {   
                        int g=Integer.parseInt(events[x].substring(0,2))*60+Integer.parseInt(events[x].substring(3,5));                  //g���즳�����ʪ��}�l�ɶ�
                        int h=Integer.parseInt(events[x].substring(6,8))*60+Integer.parseInt(events[x].substring(9,11));                 //h���즳�����ʪ������ɶ�
                        
                        if (!(Integer.toString(w)).equals(input01.substring(5,6)))
                        {
                            if((g<=e && e<=h) || (g<=f && f<=h))
                            {
                                //System.out.println("\n"+"�ɶ��P�w�s�b���ʦ��ҭ��|,�Э��s��J");                                           //�P�_�ɶ��O�_���|
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
                            if((Integer.toString(w)).equals(input01.substring(5,6)))                        //�����ק諸����
                            {
                                edit=true;                                                                  //�������קﶵ�ت���edit=true
                                break;  
                            }  
                            w++;
                        }
                    }
                    if (edit==false)                                                                        //�S���קﬡ�ʮɶ��N����ק諸���ʽs�����s�b
                    {
                        System.out.println("\n"+"�L������,�Э��s��J");
                    }
                    else if (f<e)
                    {
                        System.out.println("\n"+"���~���ɶ���ܪk,�Э��s��J");   
                    }
                    else if(timeerror==true)
                    {
                        System.out.println("\n"+"�ɶ��P�w�s�b���ʦ��ҭ��|,�Э��s��J");
                    }
                    else 
                    {
                        events[e]=input01.substring(7,18)+" "+events[x].substring(12);              //�b�s���ɶ���W�s�W����
                        if(e!=x) 
                        {
                            events[x]=null;                                                         //�N��ɶ��檺���ʧR��
                        } 
                    }
                
            }
            else if (input01.equals("del-all"))                                            //�R������������
            {
                star=false;                                                         
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                            events[x]=null;                                                 //��C�@��m�令null
                    }
                }
            }
            else if (input01.substring(0,4).equals("del-"))                                                 //�R��������
            {
                star=false;
                boolean del=false;
                int z=1;
                for(int x=0;x<1440;x++)                   
                {
                    if (events[x] !=null)
                    {                                                                                                            
                        if(("del-"+Integer.toString(z)).equals(input01))                                    //���R���������ܦ�null
                        {
                            events[x]=null;
                            del=true;
                            break;                                                                 
                        }
                        z++;
                    }
                }
                if (del==false)                                                                             //�S���R�����ʥN����R�������ʽs�����s�b
                    {
                        System.out.println("\n"+"�L������,�Э��s��J");
                    }
            }
            else
            {
                System.out.println("\n"+"���~�����O,�ЦA����J");
            }
        }while(month==false && exit01==false);                                                              //�Y��Jmonth��exit�N�������t��
    }
}