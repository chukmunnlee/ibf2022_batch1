package day05;

public class CarLoan implements Interest, Information {

    private Float balance;

    public CarLoan() {
        balance = 100000f;
    }

    @Override
    public String getInformation() {
        return "this is a car load";
    }

    @Override
    public Float interest() {
        return this.balance * 0.02f;
    }
    
}
