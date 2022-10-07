package racingcar.domain;

public class Car implements Comparable<Car> {
    private final CarName name;
    private final Forward forward;

    public Car(String name) {
        this.name = new CarName(name);
        this.forward = new Forward();
    }

    @Override
    public int compareTo(Car o) {
        return o.forward.getCount() - this.forward.getCount();
    }

    public void move(int number , CarForwardCondition strategy) {
        if (strategy.isMoveable(number)) {
            moveForward();
        }
    }

    public String toStringIfWinner(int maxScore) {
        if (this.forward.getCount() >= maxScore) {
            return print();
        }
        return "";
    }

    private String print() {
        return String.format("%s : %s", this.name.getName(), this.forward.moveToDash());
    }

    private void moveForward() {
        this.forward.move();
    }

    public String getName() {
        return this.name.getName();
    }

    public int getForwardCount() {
        return this.forward.getCount();
    }
}
