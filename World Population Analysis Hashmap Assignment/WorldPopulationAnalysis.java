import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WorldPopulationAnalysis {
    public static HashMap<String, Long> countryPop = new HashMap<String, Long>();
    public static HashMap<String, Long> countrySize = new HashMap<String, Long>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File inputFile = new File("World Populations.txt");

        Scanner in = new Scanner(System.in);

        

        try {
            Scanner reader = new Scanner(inputFile);
            while (reader.hasNext()) {
                String input = reader.nextLine();
                String parts[] = input.split("###");
                
                String output = parts[0] + " Has a population of " + parts[1] + " With a size of "+parts[2] + " Square Kilometers";
                if(Double.parseDouble(parts[2]) > 1) {

                }
                parts[2] = Double.parseDouble(parts[2]) > 1 ? parts[2] : "1"; //Long data type does not use decimals, so in order to avoid error any nations with under 1 sqaure kilometer is rounded to 1.
                countryPop.put(parts[0], Long.parseLong(parts[1]));
                countrySize.put(parts[0], Long.parseLong(parts[2]));

                System.out.println(output);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File cannot be found....");
        }

        findMostPopulousCountries();
        findDensestCountries();
    }

    public static void findMostPopulousCountries() {
        ArrayList<Long> pops = new ArrayList<Long>(countryPop.values());

        Collections.sort(pops);  
        Collections.reverse(pops);

        System.out.println(pops);

        for(int i = 0; i < 5; i++) {
            for(String country : countryPop.keySet()) {
                if(countryPop.get(country).equals(pops.get(i))) {
                    System.out.println("Country name is: " + country);
                }
            }
        }
    }

    public static void findDensestCountries() {
        HashMap<String, Double> countryDensities = new HashMap<String, Double>();

        for(String country : countryPop.keySet()) {
            double density = (double) countryPop.get(country)/countrySize.get(country);
            countryDensities.put(country, density);
        }

        ArrayList<Double> densities = new ArrayList<Double>(countryDensities.values());


        Collections.sort(densities);  
        Collections.reverse(densities);

        System.out.println(densities);

        for(int i = 0; i < 5; i++) {
            for(String country : countryDensities.keySet()) {
                if(countryDensities.get(country).equals(densities.get(i))) {
                    System.out.println("Country name is: " + country);
                }
            }
        }
    }
}