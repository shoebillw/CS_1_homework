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
             System.out.println("�w��ϥοﲼ�p��t��");
             System.out.println("�Юھڿﲼ�W���ǥͦ~�ſ�J�~�Žs��(1~6)");     //���ܨϥΎͿ�J�~��
             float grade = ConsoleIn.readLineInt();
                while (grade != 1 && grade != 2 && grade != 3 &&
                       grade != 4 && grade != 5 && grade != 6)               //�Y��J���~�n�D���s��J
                {            
                    System.out.println("�~�Žs���ȥi��1~6");
                    System.out.println("�ЦA����J�~�Žs��");
                    grade = ConsoleIn.readLineInt();
                }



            System.out.println("�Юھڿﲼ�W�������H��J�Կ�H�s��(1~3)");    //���ܨϥΎͿ�J�����H
            int candidate = ConsoleIn.readLineInt();
                while (candidate != 1 && candidate != 2 && candidate != 3)   //�Y��J���~�n�D���s��J
                {
                    System.out.println("�Կ�H�s���ȥi��1~3");
                    System.out.println("�ЦA����J�Կ�H�s��");
                    candidate = ConsoleIn.readLineInt();
                }



                if (grade<=4)                                                //�p��Կ�H�o����
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

            

            System.out.println("�~���J�п�JY,��ܵ��G�п�JN");              //�߰ݨϥΎͬO�_�~���J
            Scanner scanner = new Scanner(System.in);
            again=scanner.nextLine();
                while (!(again.equals("Y") || again.equals("N")))            //�Y��J���~�n�D���s��J
                {            
                    System.out.println("�Юھڨt�δ��ܦA����JY��N");
                    again=scanner.nextLine();
                }
            
            voters=voters+1;                                                 //�p���`�벼�H��

        } 
        while (again.equals("Y"));                                           //�A����J������





        if (voters < 5)                                                      //�p�Ⲽ�ﵲ�G
            {System.out.println("�]�벼�H�Ƥp��5�H");
             System.out.println("�����ǥͷ|���L�H���");}
        else if((candidate1*2)>candidate1+candidate2+candidate3)
            {System.out.println("�����ǥͷ|�����H��1���_�P��");}
        else if((candidate2*2)>candidate1+candidate2+candidate3)
            {System.out.println("�����ǥͷ|�����H��2���B�P��");}    
        else if((candidate3*2)>candidate1+candidate2+candidate3)
            {System.out.println("�����ǥͷ|�����H��3�����P��");}
        else 
            {System.out.println("�]�L�Կ�H�`���ȹL�b��");
             System.out.println("�����ǥͷ|���L�H���");}
    }   
}













