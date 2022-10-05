package racingcar.domain;

public class Forward {
    private int count;

    public Forward() {
        this.count = 0;
    }

    public void move() {
        this.count++;
    }

    public String moveToDash() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.count ; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public int getCount() {
        return this.count;
    }
}
