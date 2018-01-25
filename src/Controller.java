import Search.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mandy Cho :) on 1/23/18.
 */
public class Controller {
    private static char[] input;

    public static void main(String...args) throws IOException {
        String filePath = args[args.length - 1], userSelection = args[args.length - 2].toLowerCase();

        fillInputArray(filePath);
        SearchController searchController = SearchFactory.getSearchController(input, userSelection);
    }

    private static void fillInputArray(String filePath) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            input = bufferedReader.readLine()
                    .trim()
                    .toCharArray();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
