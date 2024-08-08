import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner user = new Scanner(System.in);
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        while(true)
        {
            System.out.print("Principal: ");
            principal = user.nextInt();
            if(principal >= 1000 && principal <= 1000000)
            {
                break;
            }
            System.out.println("Enter a value between 1000 and 1000000");
        }
        while(true)
        {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = user.nextFloat();
            if(annualInterest >= 1 && annualInterest <= 30)
            {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        while(true)
        {
            System.out.print("Period (Years): ");
            byte years = user.nextByte();
            if(years >= 1 && years <= 30)
            {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = principal * (monthlyInterest * (Math.pow(1 + monthlyInterest, numberOfPayments)))
                / ((Math.pow(1 + monthlyInterest, numberOfPayments)) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}