import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dec04 {

    public static void main(String[] args) {
/*
        LocalDateTime ldt1 = LocalDateTime.of(2018, 12, 4, 18, 0, 0);
        LocalDateTime ldt2 = LocalDateTime.of(2018, 12, 4, 18, 15, 0);
        while(ldt1.compareTo(ldt2) < 0) {
            System.out.println(ldt1.getMinute());
            ldt1 = ldt1.plusMinutes(1);
        }

        if(1==1) return;
*/
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
            System.out.println(formatDateTime);
            //System.out.println(eachLine[3]);
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
                            System.out.println("here: " + startSleepTime.getMinute());
                            guard.getSleepList().add(startSleepTime.getMinute());
                            startSleepTime = startSleepTime.plusMinutes(1);
                        }
                    }
                }
            }

            //idList.add(new Dec04id(formatDateTime, id, status));

            //System.out.println("Date : " + formatDateTime);
            // System.out.println("After : " + formatDateTime.format(formatter));


        }
        int longestSleep = 0;
        int longestSleepId = 0;
        for (Dec04Guard guard : guardList) {
            if (guard.getSleepList().size() > longestSleep) {
                longestSleep = guard.getSleepList().size();
                longestSleepId = guard.getId();
            }
        }

        System.out.println("Guard with longest sleep: " + longestSleepId);
        for (Dec04Guard guard : guardList) {
            if (guard.getId() == longestSleepId) {
                Collections.sort(guard.getSleepList());
                int minuteCounterA = 0;
                int minuteCounterStore = 0;
                int inMinute = 0;
                for (int i = 0; i < guard.getSleepList().size(); i++ ){
                    for (int j = i+1; j < guard.getSleepList().size(); j++ ){
                        if (guard.getSleepList().get(i) == guard.getSleepList().get(j)){
                            minuteCounterA ++;
                        }

                    }
                    if (minuteCounterA > minuteCounterStore) {
                        inMinute = guard.getSleepList().get(i);
                        minuteCounterStore = minuteCounterA;
                    }

                }
                System.out.println("Minute: " + inMinute);
                System.out.println("Sum: " + (longestSleepId * inMinute));


            }
        }


      /*  int counter = 0;
        for (Dec04id did : idList) {
            counter++;
            System.out.println(counter +" : " +did);

        }*/
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
