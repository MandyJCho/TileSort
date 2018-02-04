import Search.*;

import java.io.*;

/**
 * Created by Mandy Cho :) on 1/23/18.
 */
public class Controller {
    private static String startArrangement;

    public static void main(String...args) throws IOException {
        String filePath = args[args.length - 1], userSelection = args[args.length - 2].toLowerCase();
        boolean includeCost = args[1].equals("-cost");
        getStartArrangement(filePath);
        Search searchController = SearchFactory.createController(startArrangement, userSelection, includeCost);

        searchController.findPath();
    }

    private static void getStartArrangement(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            startArrangement = bufferedReader.readLine()
                                             .trim()
                                             .toUpperCase();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
