package day05;

public class FixedDeposit implements Interest, Information {

    private Float balance;

    @Override
    public Float interest() {
        return this.balance * 0.02f;
    }

    @Override
    public String getInformation() {
        return "this is a fixed deposit";
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
