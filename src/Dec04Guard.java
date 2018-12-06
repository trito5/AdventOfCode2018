import java.util.*;

public class Dec04Guard {
    private int id;
    private int mostMinuteAsleep;
    private List<Integer> sleepList = new ArrayList<>();


    public Dec04Guard(int id) {
        this.id = id;
    }

    public List<Integer> getSleepList() {
        return sleepList;
    }

    public void setSleepList(List<Integer> sleepList) {
        this.sleepList = sleepList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMostMinuteAsleep() {
        return mostMinuteAsleep;
    }

    public void setMostMinuteAsleep(int mostMinuteAsleep) {
        this.mostMinuteAsleep = mostMinuteAsleep;
    }

    public int getMostSleepMinute(){

        Collections.sort(getSleepList());
        int minuteCounterA = 0;
        int minuteCounterStore = 0;
        int inMinute = 0;
        int smallCounter = 0;
        for (int i = 0; i <getSleepList().size()-1; i++ ){
            if (getSleepList().get(i) == getSleepList().get(i + 1)) {
                smallCounter++;
                minuteCounterA = smallCounter;
            } else {
                smallCounter = 0;
            }

            if (minuteCounterA > minuteCounterStore) {
                inMinute = getSleepList().get(i);
                minuteCounterStore = minuteCounterA;
                setMostMinuteAsleep(getSleepList().get(i));
            }
        }

        return minuteCounterStore;
    }
}

