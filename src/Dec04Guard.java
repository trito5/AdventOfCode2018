import java.util.*;

public class Dec04Guard {
    private int id;
    private List<Integer> sleepList = new ArrayList<>(Collections.nCopies(60, 0));
    private Map<String, Integer> SleepPerMinute = new HashMap<>();

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

    public Map<String, Integer> getSleepPerMinute() {
        return SleepPerMinute;
    }

    public void setSleepPerMinute(Map<String, Integer> sleepPerMinute) {
        SleepPerMinute = sleepPerMinute;
    }
}

