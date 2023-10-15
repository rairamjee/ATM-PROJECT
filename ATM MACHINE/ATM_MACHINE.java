import java.util.*;

class ATM_PROCESS{

    Scanner sc=new Scanner(System.in);

    int Accounts[]=new int[]{123456,456789,654321};    // Accounts that are predefined 
    int Pin[]=new int[]{1234,4567,6543};               // Pins that are predefined against 
    String name[]=new String[]{"Ramjee","Tannu","Shubham"};   // Names of  that are predefined Account Holders  
    double Balance[]=new double[]{1000.0,2000.0,5000.0};      //Balnce of the Respective Person
    String Bank[]=new String[]{"Vijaya Bank","HDFC Bank","SBI Bank"};
    int acc_no,pin_no,p=0;       //Variables Used

    void acc_details()            // Checking for a Valid Account 
    {
        System.out.println("\t ENTER THE ACCOUNT NUMBER  ::   ");    // Accept the Account Number 
        acc_no=sc.nextInt();

        for(int i=0;i<Accounts.length;i++)
        {
            if(acc_no==Accounts[i])
            {
                p=1;
                pin_details(i);        // Function Invoked for checking the pin details of the Users 
            }
        }
        if(p==0){
        System.out.println("-- Please Enter A Valid Account Number --\n");

        System.out.println("Press 1 to Re-Enter the Account Number");
        System.out.println("Press 2 to Exit");

        System.out.println("Enter Your Choice :: ");
        int ch = sc.nextInt();

        switch(ch)                        // Switch Case for Different Options Available 
        {
            case 1:
            acc_details();
            break;

            case 2:
            System.exit(0);

            default:
            System.out.println("Wrong Choice.");
            break;
        }
    }
    }

    void pin_details(int x)               // Check the Pin Details of the Entered Account 
    {
        System.out.println("\t ENTER THE PIN NUMBER  ::   ");          // Accept the Pin from the user
        pin_no=sc.nextInt();

        if(pin_no==Pin[x])
        {
            System.out.println("\n Hii "+name[x]+",\nThis are the services which we provide :: \n");   //Welcome Message 
            Menu(x);
        }
        else{                                   // Incase the Entered Pin Is Incorrect
            System.out.println("\t Oops, Your Entered pin is Invalid\n");

            System.out.println("Press 1 to Re-Enter the password ");
            System.out.println("Press 2 to Exit");

            System.out.println("Enter Your Choice :: ");
            int ch = sc.nextInt();

            switch(ch)                                   // Switch Case for Different Options Available 
            {
                case 1:
                pin_details(x);
                break;

                case 2:
                System.exit(0);

                default:
                System.out.println("Wrong Choice.");
                break;
            }
        }
    }

    void Menu(int x)
    {
        //--  The Menu List /  The Availale Services  ---- 

        System.out.println("\n\t --Press 1 for Checking Account Details-- ");
        System.out.println("\t --Press 2 for Adding Money-- ");
        System.out.println("\t --Press 3 for Withdrawing Money-- ");
        System.out.println("\t --Press 4 for Exiting-- ");

        System.out.println("Enter Your Choice :: ");
        int ch = sc.nextInt();

        switch(ch)
        {
            case 1:                              // Case for Checking the Account Balance
            check_balance(x);
            break;

            case 2:                              // Case for Adding the Balance Into Account 
            add_money(x);
            break;

            case 3:                              // Case for Removing the Balance From Account 
            withdraw_money(x);
            break;

            case 4:                              // Exiting All the process
            System.exit(0);

            default:
            System.out.println("You Entered A Wrong Option :");
            Menu(x);
            break;
        }
    }

    void check_balance(int x)     // Function Which Displays the Detail of the Account Holder
    {
        System.out.println("Bank Account Holder ::  "+name[x]);
        System.out.println("Bank Name :: "+Bank[x]);
        System.out.println("Account Number :: "+Accounts[x]);
        System.out.println("Balance ::  "+Balance[x]);
        System.out.println("Follow the Menu For Further Process");
        Menu(x);
    }


    void add_money(int x)        // Function Which Adds the Money of the Account Holder
    {
        System.out.println("Enter the Amount Of the Money You Want To Add :: ");
        Double  n=sc.nextDouble();
        
        Balance[x]+=n;
        System.out.println("Your Amount Is Successfully Added \n\n Follow the Menu List for More Option\n");
        Menu(x);
    }

    void withdraw_money(int x)               // Function Which Withdraw the Money of the Account Holder
    {
        System.out.println("Enter the Amount Of the Money You Want To Withdraw :: ");
        Double  n=sc.nextDouble();

        if(Balance[x]>=n){
             Balance[x]-=n;
             System.out.println("Your Amount Is Successfully Withrawn \n Please Collect Your Cash \n\n Follow the Menu List for More Option\n");
             Menu(x);
        }
        else
        {
            System.out.println("Sorry,Your Account Balance Is Low \n Please Refer Menu For Further Process\n");
            Menu(x);
        }
    }
}
public class ATM_MACHINE{
    public static void main(String[] args) {

        ATM_PROCESS obj=new ATM_PROCESS();   // Creating the Object of the Class 
        obj.acc_details();     // Invoking the first Function
    }
}