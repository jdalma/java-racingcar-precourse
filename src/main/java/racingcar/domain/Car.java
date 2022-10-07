package racingcar.domain;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Forward forward;

    public Car(String name) {
        this.name = new CarName(name);
        this.forward = new Forward();
    }

    public String print() {
        return String.format("%s : %s", this.name.getName(), this.forward.moveToDash());
    }

    public void move(int number , CarForwardCondition strategy) {
        if (strategy.isMoveable(number)) {
            moveForward();
        }
    }

    private void moveForward() {
        this.forward.move();
    }

    @Override
    public int compareTo(Car o) {
        return o.forward.getCount() - this.forward.getCount();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getForwardCount() {
        return this.forward.getCount();
    }

    public String toStringIfWinner(int maxScore) {
        if (this.forward.getCount() >= maxScore) {
            return print();
        }
        return "";
    }
}
