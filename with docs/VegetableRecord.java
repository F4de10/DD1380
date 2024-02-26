
/**
 * Author: Nils Olivier
 * Date: 2024-02-26
 * Course: DD1380
 */

import java.util.*;

/**
 * Represents a record for a vegetable.
 */
public class VegetableRecord implements Comparable<VegetableRecord> {
    private String vegetable;
    private String country;
    private int size;
    private String unit;

    /**
     * Represents a record for a vegetable.
     */
    public VegetableRecord(String vegetable, String country, int size, String unit) {
        this.vegetable = vegetable;
        this.country = country;
        this.size = size;
        this.unit = unit;
    }

    /**
     * Compares this VegetableRecord with the specified VegetableRecord for order.
     * The comparison is based on the vegetable name, size, and country.
     * 
     * @param other the VegetableRecord to be compared
     * @return a negative integer, zero, or a positive integer as this
     *         VegetableRecord is less than, equal to, or greater than the specified
     *         VegetableRecord
     */
    @Override
    public int compareTo(VegetableRecord other) {
        int typeComparison = this.vegetable.compareTo(other.vegetable);
        if (typeComparison != 0) {
            return typeComparison;
        }

        int sizeComparison = Integer.compare(other.size, this.size);
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        return this.country.compareTo(other.country);
    }

    /**
     * Returns a string representation of the VegetableRecord object.
     *
     * @return a string containing the vegetable, country, size, and unit of the
     *         VegetableRecord.
     */
    @Override
    public String toString() {
        return vegetable + " " + country + " " + size + " " + unit;
    }

    /**
     * The main method is the entry point of the program.
     * It reads vegetable records from the user input, stores them in a list,
     * and then sorts and prints the records.
     *
     * @param args The command-line arguments passed to the program.
     */
    public static void main(String[] args) {
        List<VegetableRecord> records = new ArrayList<>();
        Map<String, Integer> maxSizes = new HashMap<>();

        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String vegetable = sc.next();
                StringBuilder country = new StringBuilder();

                while (sc.hasNext() && !sc.hasNextInt()) {
                    String countryWord = sc.next();
                    country.append(countryWord);
                    if (sc.hasNext() && !sc.hasNextInt()) {
                        country.append(" ");
                    }
                }
                int size = sc.nextInt();
                String unit = sc.next();

                VegetableRecord record = new VegetableRecord(vegetable, country.toString(), size, unit);

                String key = vegetable + country.toString();
                if (!maxSizes.containsKey(key) || size > maxSizes.get(key)) {
                    maxSizes.remove(key);
                    maxSizes.put(key, size);
                    records.removeIf(r -> r.vegetable.equals(vegetable) && r.country.equals(country.toString()));
                    records.add(record);
                }
            }
            sc.close();

            Collections.sort(records);

            for (VegetableRecord record : records) {
                System.out.println(record);
            }
        }

    }
}
