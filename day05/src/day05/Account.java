package day05;

public class Account implements Interest {

    private Float balance;

    public Float interest() {
        return this.balance * 0.02f;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }


    
}
