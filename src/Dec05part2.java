import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dec05part2 {
    public static void main(String[] args) {
        String input = "";
        String fileName = "inputFile5.txt";
        List<Character> charList = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        int lowestCount = 1000000;

        try {
            input = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        for (int i = 0; i < input.length(); i++) {
            charList.add(input.charAt(i));
            charSet.add(input.charAt(i));
        }
        for (Character ch : charSet) {
            List<Character> newList = new ArrayList<>(charList);
            for (int i = 0; i < newList.size(); i++){
               newList.removeAll(Arrays.asList(Character.toLowerCase(ch)));
               newList.removeAll(Arrays.asList(Character.toUpperCase(ch)));
            }

            boolean change;
            do {
                change = false;
                for (int i = newList.size() - 1; i > 0; i--) {
                    if (Character.isLowerCase(newList.get(i))) {
                        char temp = Character.toUpperCase(newList.get(i));
                        if (temp == newList.get(i - 1)) {
                            newList.remove(i);
                            newList.remove(i - 1);
                            change = true;

                            break;
                        }
                    } else {
                        char temp = Character.toLowerCase(newList.get(i));
                        if (temp == newList.get(i - 1)) {
                            newList.remove(i);
                            newList.remove(i - 1);
                            change = true;
                            break;
                        }
                    }

                }


            } while (change);
           if (newList.size() < lowestCount){
               lowestCount = newList.size();
           }
        }

        System.out.println("lowest count: " + lowestCount);
    }


    private static String readFile(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();


        return line;
    }

}
