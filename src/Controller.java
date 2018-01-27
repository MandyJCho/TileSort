import Search.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mandy Cho :) on 1/23/18.
 */
public class Controller {
    private static String startArrangement;

    public static void main(String...args) throws IOException {
        String filePath = args[args.length - 1], userSelection = args[args.length - 2].toLowerCase();

        getStartArrangement(filePath);
        Search searchController = SearchFactory.getSearchController(startArrangement, userSelection);

        searchController.findPath();
    }

    private static void getStartArrangement(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            startArrangement = bufferedReader.readLine()
                    .trim();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
