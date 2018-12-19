package lamda;

import java.util.Arrays;
import java.util.List;

/**
 * @author: xiaoran
 * @date: 2018-12-05 18:32
 */
public class UseLamda {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

//        players.forEach((player)-> System.out.printf(player+","));
        players.forEach(System.out::println);
    }
}
