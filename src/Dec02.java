import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dec02 {

    public static void main(String[] args) {
        List<String> idList = new ArrayList<>();
        String fileName = "inputFile2.txt";
        int twoCharCounter = 0;
        int threeCharCounter = 0;


        try {
            idList = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        for (String word : idList) {

            List<Character> checkedChar = new ArrayList<>();
            boolean foundTwos = false;
            boolean foundThrees = false;

            for (int i = 0; i < word.length(); i++) {
                int charCounter = 1;
                if (!checkedChar.contains(word.charAt(i))){
                    checkedChar.add(word.charAt(i));
                    for(int j = 1 + i; j < word.length(); j++){
                        if (word.charAt(i) == word.charAt(j)){
                            charCounter++;
                        }
                    }
                    if (!foundTwos && charCounter == 2){
                        foundTwos = true;
                        twoCharCounter++;

                    }
                    if (!foundThrees && charCounter == 3) {
                        foundThrees = true;
                        threeCharCounter++;

                    }
                }

            }

        }

        System.out.println("Sum: " + twoCharCounter * threeCharCounter);
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
