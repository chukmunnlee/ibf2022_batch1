package day05;

public class CalcInterest {

    public static void main(String[] args) {
        Account acct = new Account();
        acct.setBalance(10f);
        calculateInterest(acct);

        FixedDeposit fixed = new FixedDeposit();
        fixed.setBalance(20f);

        CarLoan carLoan = new CarLoan();

        calculateInterest(acct);
        calculateInterest(fixed);
        calculateInterest(carLoan);

        display(fixed);
        display(carLoan);
    }

    public static void calculateInterest(Interest intf) {
        System.out.printf(">>> interest: %f\n", intf.interest());
    }

    public static void display(Information info) {
        System.out.printf(">>> %s\n", info.getInformation());
    }
    
}
