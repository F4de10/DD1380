// Author: Nils Olivier
// Date: 2024-02-05

import java.util.*;

public class VegetableRecord implements Comparable<VegetableRecord> {
    String vegetable;
    String country;
    int size;
    String unit;

    public VegetableRecord(String vegetable, String country, int size, String unit) {
        this.vegetable = vegetable;
        this.country = country;
        this.size = size;
        this.unit = unit;
    }

    @Override
    public int compareTo(VegetableRecord other) {
        // Compare vegetable type alphabetically
        int typeComparison = this.vegetable.compareTo(other.vegetable);
        if (typeComparison != 0) {
            return typeComparison;
        }

        // If the vegetables are the same, compare the size
        int sizeComparison = Integer.compare(other.size, this.size);
        if (sizeComparison != 0) {
            return sizeComparison;
        }

        // If the sizes are the same, compare the countries
        return this.country.compareTo(other.country);
    }

    @Override
    public String toString() {
        return vegetable + " " + country + " " + size + " " + unit;
    }

    public static void main(String[] args) {
        List<VegetableRecord> records = new ArrayList<>();
        Map<String, Integer> maxSizes = new HashMap<>();

        Scanner sc = new Scanner(System.in);

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

            // Remove duplicate records of the same vegetable and country
            String key = vegetable + country.toString();
            if (!maxSizes.containsKey(key) || size > maxSizes.get(key)) {
                maxSizes.remove(key); // Remove the old record
                maxSizes.put(key, size);
                records.removeIf(r -> r.vegetable.equals(vegetable) && r.country.equals(country.toString())); // Remove
                                                                                                              // the old
                                                                                                              // record
                                                                                                              // from
                                                                                                              // the
                                                                                                              // record
                                                                                                              // list
                records.add(record);
            }
        }
        sc.close();

        // Sort the records
        Collections.sort(records);

        // Print the records
        for (VegetableRecord record : records) {
            System.out.println(record);
        }
    }
}
