import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dec03 {

    public static void main(String[] args) {
        List<String> inputList = new ArrayList<>();
        String fileName = "inputFile3.txt";

        try {
            inputList = readFile(fileName);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        List<List<Integer>> xList = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            List<Integer> yList = new ArrayList<>();
            for (int j = 0; j < 2000; j++) {
                yList.add(0);
            }
            xList.add(yList);
        }

        //loopa över varje rad
        for (String w : inputList) {
            String[] tempArray = w.split(" ");

            String xPadding;
            String yPadding = "";
            String width;
            String height;

            String[] paddings = tempArray[2].split(",");
            xPadding = paddings[0];
            for (int i = 0; i < paddings[1].length() - 1; i++) {
                yPadding += paddings[1].charAt(i);
            }

            String[] area = tempArray[3].split("x");
            width = area[0];
            height = area[1];

            for (int i = Integer.parseInt(xPadding); i <= Integer.parseInt(xPadding) + Integer.parseInt(width)-1; i++) {
                //för varje x, loopa igeom ylistan
                for (int j = Integer.parseInt(yPadding); j <= Integer.parseInt(yPadding) + Integer.parseInt(height)-1; j++) {

                    xList.get(i).set(j, xList.get(i).get(j) + 1);
                }
            }
        }

        int doubleCounter = 0;

        for (List<Integer> list : xList){
            for (int number : list){
                if (number > 1) {
                    doubleCounter++;
                }
            }
        }

        System.out.println("Överlappande: " + doubleCounter);
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
