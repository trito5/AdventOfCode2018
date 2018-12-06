import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Dec05 {
    public static void main(String[] args) {
        String input = "";
        String fileName = "inputFile5.txt";
        List<Character> charList = new ArrayList<>();

        try {
            input = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        for (int i = 0; i < input.length(); i++) {
            charList.add(input.charAt(i));
        }

        boolean change;
        do {
            change = false;
            for(int i = charList.size() - 1; i >0; i--) {
                if (Character.isLowerCase(charList.get(i))) {
                    char temp = Character.toUpperCase(charList.get(i));
                    if (temp == charList.get(i - 1)) {
                        charList.remove(i);
                        charList.remove(i-1);
                        change = true;
                        break;
                    }
                } else {
                    char temp = Character.toLowerCase(charList.get(i));
                    if (temp == charList.get(i - 1)) {
                        charList.remove(i);
                        charList.remove(i-1);
                        change = true;
                        break;
                    }
                }

            }


        } while (change);

        System.out.println("\nSum of chars: " + charList.size());
    }


    private static String readFile(String fileName) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String line = br.readLine();
       /* while (line != null) {

            line = br.readLine();
        }*/

        return line;
    }

}
