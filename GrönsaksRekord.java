import java.util.*;

public class GrönsaksRekord implements Comparable<GrönsaksRekord> {
    String grönsak;
    String land;
    int storlek;
    String enhet;

    public GrönsaksRekord(String grönsak, String land, int storlek, String enhet) {
        this.grönsak = grönsak;
        this.land = land;
        this.storlek = storlek;
        this.enhet = enhet;
    }

    @Override
    public int compareTo(GrönsaksRekord annat) {
        // grönsakstyp, alfabetiskt
        int typJämförelse = this.grönsak.compareTo(annat.grönsak);
        if (typJämförelse != 0) {
            return typJämförelse;
        }

        // Om grönsaken är samma, jämför storleken
        int storlekJämförelse = Integer.compare(annat.storlek, this.storlek);
        if (storlekJämförelse != 0) {
            return storlekJämförelse;
        }

        // Om storleken är samma, jämför länderna
        return this.land.compareTo(annat.land);
    }

    public static void main(String[] args) {
        List<GrönsaksRekord> rekorder = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String grönsak = sc.next();
            StringBuilder land = new StringBuilder();
            while (sc.hasNext() && !sc.hasNextInt()) {
                String landOrd = sc.next();
                land.append(landOrd).append(" ");
            }
            int storlek = sc.nextInt();
            String enhet = sc.next();

            GrönsaksRekord rekord = new GrönsaksRekord(grönsak, land.toString().trim(), storlek, enhet);
            rekorder.add(rekord);

        }
        sc.close();

        // sortera rekorden
        Collections.sort(rekorder);

        for (GrönsaksRekord rekord : rekorder) {
            System.out.println(rekord.grönsak + " " + rekord.land + " " + rekord.storlek + " " + rekord.enhet);
        }
    }

}
