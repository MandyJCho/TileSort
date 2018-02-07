import Search.*;

import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.Scanner;

/**
 * Created by Mandy Cho :) on 1/23/18.
 */
public class Controller {
    private static String startArrangement;

    public static void main(String...args) throws IOException {
        String[] cmd;
        System.out.println(args.length);
        if (args.length == 0) {
            System.out.println("Enter command");
            Scanner scan = new Scanner(System.in);
            cmd = scan.nextLine().split("\\s+");
            System.out.println();
        } else cmd = args;



        String filePath = cmd[cmd.length - 1], userSelection = cmd[cmd.length - 2].toLowerCase();
        boolean includeCost = cmd[1].equals("-cost");
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
