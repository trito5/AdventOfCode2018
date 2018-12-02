import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dec02part2 {
    public static void main(String[] args) {
        List<String> idList = new ArrayList<>();
        String fileName = "inputFile2.txt";
        String outputString = "";

        try {
            idList = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        // loop through the list of words
        for (int i = 0; i < idList.size(); i++) {
            int matchCounter = 0;
            //loop through the list of words
            for (int j = i + 1; j < idList.size(); j++) {
                matchCounter = 0;
                outputString = "";

                //loop through the chars

                for (int ii = 0; ii < idList.get(i).length(); ii++) {
                    //loop through the chars in the words and compare
                    if (idList.get(i).charAt(ii) == idList.get(j).charAt(ii)) {
                        matchCounter++;
                        outputString = outputString + idList.get(i).charAt(ii);
                        if (matchCounter == idList.get(i).length() - 1) {
                            break;
                        }
                    }
                }
                if (matchCounter == idList.get(i).length() - 1) {
                    break;
                }
            }

            if (matchCounter == idList.get(i).length() - 1) {
                break;
            }
        }

        System.out.println("Answer is: " + outputString);
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




