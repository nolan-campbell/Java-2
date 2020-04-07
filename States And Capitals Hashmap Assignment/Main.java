import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author hueyru.strauss
 */
public class Main {

    public static HashMap<String, String> statesAndCaps = new HashMap<String, String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File inputFile = new File("States and Capitals List.txt");

        Scanner in = new Scanner(System.in);

        try {
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNext()) {
                String input = reader.nextLine();
                String parts[] = input.split("::");
                String output = parts[1] + " is the capital for " + parts[0];

                statesAndCaps.put(parts[0], parts[1]);

                System.out.println(output);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found....");
        }

        System.out.println("Enter a state to find the capital of it");
        String state = in.nextLine();
        capitalLookUp(state);

        System.out.println("Enter a character to list the States that have it(Use capital letters)");
        char x = in.next().charAt(0);
        findStateNamesWithX(x);

        System.out.println("Enter a character to list the Capitals that have it(Use capital letters)");
        x = in.next().charAt(0);
        findCapitalNamesWithX(x);

        System.out.print("The hashmap contains "+statesAndCaps.size()+" entries");
    }

    public static void capitalLookUp(String state) {
        if (statesAndCaps.containsKey(state)) {
            System.out.println("The capital of " + state + " is " + statesAndCaps.get(state));
        } else {
            System.out.println("Invalid state entered");
        }
    }

    public static void findStateNamesWithX(char x) {
        Set<String> states = statesAndCaps.keySet();
        for (String state : states) {
            if (state.charAt(0) == x) {
                System.out.println(state);
            }
        }
    }

    public static void findCapitalNamesWithX(char x) {
        for (String value : statesAndCaps.values()) {
            if(value.charAt(0) == x) {
                System.out.println(value);
            }
        }
    }

}