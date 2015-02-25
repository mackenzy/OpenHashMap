import hashmap.Map;
import hashmap.impl.OpenHashMap;

/**
 * Created by MatveyI on 23.02.2015.
 */
public class MainClass {

    public static void main(String[] args) {

        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        map.put(10,100L);
        map.put(11,100L);
        map.put(26,126L);
        map.put(12,112L);
        map.put(42,142L);
        map.put(28,128L);
        map.put(58,158L);
        map.put(74,174L);
        map.put(90,190L);
        map.put(60,160L);
        map.put(80,180L);
        map.put(15,115L);
        map.put(3,103L);

        System.out.println(map);

        map.remove(3);
        map.remove(12);

        System.out.println(map);

        map.remove(42);
        map.remove(58);
        map.remove(74);
        map.remove(90);

        System.out.println(map);
    }
}
