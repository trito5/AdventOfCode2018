import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dec04part2 {

    public static void main(String[] args) {

        List<String> inputList = new ArrayList<>();
        String fileName = "inputFile4.txt";

        try {
            inputList = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        String[] eachLine;

        List<Dec04Guard> guardList = new ArrayList<>();
        int guardId = 0;
        LocalDateTime startSleepTime = LocalDateTime.now();

        Collections.sort(inputList);
        for (String line : inputList) {

            line = line.replace("[", "");
            line = line.replace("]", "");
            eachLine = line.split(" ");
            String time = eachLine[1];
            String date = eachLine[0] + " " + eachLine[1];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime formatDateTime = LocalDateTime.parse(date, formatter);

            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(eachLine[3]);
            int id = 0;
            while (m.find()) {
                id = Integer.parseInt(m.group());
                if (id != 0) {
                    guardId = id;
                } else {
                    id = guardId;
                }
            }
            String status = (eachLine[3].replaceAll("\\d", "")).replace("#", "");
            if (eachLine.length == 5) {
                status = status + eachLine[4];
            }
            if (eachLine.length == 6) {
                status = status + eachLine[5];
            }
            boolean objectExists = false;
            for (Dec04Guard guard : guardList) {
                if (guard.getId() == guardId) {
                    objectExists = true;
                }
            }
            if (guardList.isEmpty() || !objectExists) {
                guardList.add(new Dec04Guard(guardId));
            }
            if (status.equals("asleep")) {
                startSleepTime = formatDateTime;
            } else if (status.equals("up")) {
                for (Dec04Guard guard : guardList) {
                    if (guard.getId() == guardId) {
                        while (startSleepTime.compareTo(formatDateTime) < 0) {
                            guard.getSleepList().add(startSleepTime.getMinute());
                            startSleepTime = startSleepTime.plusMinutes(1);
                        }
                    }
                }
            }

        }

        int idForMostSleep = 0;
        int highestMinuteCounter = 0;
        int sleepMinute = 0;

        for (Dec04Guard guard : guardList) {

           if (guard.getMostSleepMinute() > highestMinuteCounter) {
               highestMinuteCounter = guard.getMostSleepMinute();
               idForMostSleep = guard.getId();
               ;
               sleepMinute = guard.getMostMinuteAsleep();
           }
        }
        System.out.println("Guard id: " + idForMostSleep);
        System.out.println("Minute: " + sleepMinute);
        System.out.println("Product: " + idForMostSleep * sleepMinute);

    }


    private static List<String> readFile(String fileName) throws IOException {
        List<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        while (line != null) {
            list.add(line);
            line = br.readLine();
        }
        return list;
    }
}
