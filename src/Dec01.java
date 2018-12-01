
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Dec01 {


    public static void main(String[] args) {

        /******************* PART 2 *********************/
        List<Integer> frequencyList = new ArrayList<>();
        frequencyList.add(0);
        int freq;
        int result;
        int firstDuplicate;
        boolean foundDuplicate = false;
        while (!foundDuplicate) {
            try (BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"))) {

                String line = br.readLine();
                while (line != null) {
                    freq = Integer.parseInt(line);
                    result = frequencyList.get(frequencyList.size()-1) + freq;

                    if (frequencyList.contains(result)) {
                        foundDuplicate = true;
                        System.out.println(result);
                        break;
                    } else {
                        frequencyList.add(result);
                        line = br.readLine();
                    }
                }

            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }

        /******************* PART 1 *********************
         try(BufferedReader br = new BufferedReader(new FileReader("inputFile.txt"))) {

         String line = br.readLine();
         int sum = 0;
         while (line != null) {
         sum += Integer.parseInt(line);
         line = br.readLine();
         }

         System.out.println(sum);
         } catch (IOException ioe) {
         System.out.println(ioe);
         }
         **************** END OF PART 1********************/

    }
}
