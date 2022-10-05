package racingcar.domain;

public class Car {
    private final CarName name;
    private final Forward forward;

    public Car(String name) {
        this.name = new CarName(name);
        this.forward = new Forward();
    }

    public String print() {
        return String.format("%s : %s", this.name.getName(), this.forward.moveToDash());
    }

    public int moveForward() {
        return this.forward.move();
    }

    public String getName() {
        return this.name.getName();
    }
}
