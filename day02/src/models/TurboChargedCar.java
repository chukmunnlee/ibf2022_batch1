package models;

public class TurboChargedCar extends Car {

    private Boolean turbo = false;

    public TurboChargedCar(String registration) {
        // First line
        super(registration);
    }

    public Boolean getTurbo() { return turbo; }
    public void setTurbo(Boolean turbo) { this.turbo = turbo; }

    @Override
    public void accelerate() {
        if (this.turbo) {
            super.accelerate();
            super.accelerate();
            super.accelerate();
            super.accelerate();
            super.accelerate();
            System.out.println("Vrooooooommmmmmmmmmmm!");
        } else {
            super.accelerate();
            System.out.println("Pfttt...");
        }
    }

}
