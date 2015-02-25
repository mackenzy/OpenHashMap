import hashmap.Map;
import hashmap.impl.OpenHashMap;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MatveyI on 22.02.2015.
 */
public class MainTest {

    @Test
    public void testSizeAndRemove(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        assertTrue(map.size() == 0);

        map.put(1,100L);
        map.put(1,100L);
        map.put(1,100L);
        map.put(1,100L);
        map.put(1,100L);
        map.put(1,100L);

        assertTrue(map.size() == 1);

        map.put(2,102L);
        assertTrue(map.size() == 2);

        map.put(2,102L);
        assertTrue(map.size() == 2);

        map.put(10,110L);
        map.put(26,126L);
        map.put(12,112L);
        map.put(42,142L);
        map.put(58,158L);
        map.put(28,128L);
        map.put(74,174L);
        map.put(90,190L);
        map.put(60,160L);
        map.put(80,180L);
        map.put(44,144L);

        assertTrue(map.size() == 13);
        assertTrue(map.get(80) == 180L);


        assertTrue(map.remove(80) ==180L) ;

        assertTrue(map.size() == 12);

        assertTrue(map.remove(80) == null) ;

        assertTrue(map.size() == 12);

        assertTrue(map.remove(2)==102L);
        assertNull(map.get(2));

        assertTrue(map.remove(58)==158L);
        assertNull(map.get(58));

        assertTrue(map.remove(26)==126L);
        assertNull(map.get(26));

        assertTrue(map.remove(10) ==110L);
        assertNull(map.get(10));

        assertTrue(map.remove(42)==142L);
        assertNull(map.get(42));

        assertTrue(map.remove(74)==174L);
        assertNull(map.get(74));

        assertTrue(map.remove(90)==190L);
        assertNull(map.get(90));

        assertTrue(map.remove(60)==160L);
        assertNull(map.get(60));

        assertTrue(map.remove(80)==null);
        assertNull(map.get(80));

        assertTrue(map.remove(1)==100L);
        assertNull(map.get(1));


        assertTrue(map.size() == 3);

        assertTrue(map.get(12)==112L);
        assertTrue(map.get(28)==128L);
        assertTrue(map.get(44)==144L);
        //System.out.println(map);
    }

    @Test
    public void testConsistency(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        assertNull(map.get(10));

        map.put(10, 100L);
        assertTrue(map.get(10) == 100L);

        assertTrue(map.put(10,101L) == 100L);
        assertTrue(map.put(10,102L) == 101L);
        assertTrue(map.get(10) == 102L);

        map.put(26,126L);
        map.put(42,142L);

        assertTrue(map.get(10) == 102L);
        assertTrue(map.get(26) == 126L);
        assertNull(map.get(11));
        assertTrue(map.get(42) == 142L);
        assertNull(map.get(11));

        //System.out.println(map);
    }

    @Test
    public void testBorders(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        map.put(Integer.MIN_VALUE, 100L);
        assertTrue(map.get(Integer.MIN_VALUE) == 100L);

        map.put(Integer.MAX_VALUE, 101L);
        assertTrue(map.get(Integer.MAX_VALUE) == 101L);

        map.put(0, 102L);
        assertTrue(map.get(0) == 102L);

        //System.out.println(map);
    }

    @Test
    public void size() {
        Map<Integer, Long> map = new OpenHashMap<Integer, Long>();

        assertNull(map.get(10));

        map.put(Integer.MIN_VALUE, 100L);
        map.put(Integer.MAX_VALUE, 101L);
        map.put(0, 99L);
        map.put(-1, -101L);
        map.put(1, 110L);
        map.put(-2, -102L);
        map.put(2, 102L);
        map.put(-3, -103L);
        map.put(3, 103L);
        map.put(-4, -104L);
        map.put(4, 104L);
        map.put(-5, -105L);
        map.put(6, 106L);
        map.put(-6, -106L);
        map.put(7, 107L);

        assertNull(map.get(10));

        map.put(-7, -107L);

        assertTrue(map.size() == 16);

        assertNull(map.get(10));
    }

    @Test
    public void testResize(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        map.put(Integer.MIN_VALUE, 100L);
        map.put(Integer.MAX_VALUE, 101L);
        map.put(0, 99L);
        map.put(-1, -101L);
        map.put(1, 110L);
        map.put(-2, -102L);
        map.put(2, 102L);
        map.put(-3, -103L);
        map.put(3, 103L);
        map.put(-4, -104L);
        map.put(4, 104L);
        map.put(-5, -105L);
        map.put(6, 106L);
        map.put(-6, -106L);
        map.put(7, 107L);
        map.put(-7, -107L);

        assertTrue(map.size() == 16);
        assertTrue(map.get(Integer.MAX_VALUE) == 101L);
        assertTrue(map.get(Integer.MIN_VALUE) == 100L);
        assertTrue(map.get(0) == 99L);
        assertTrue(map.get(-1) == -101L);
        assertTrue(map.get(1) == 110L);
        assertTrue(map.get(-2) == -102L);
        assertTrue(map.get(2) == 102L);
        assertTrue(map.get(-3) == -103L);
        assertTrue(map.get(3) == 103L);
        assertTrue(map.get(-4) == -104L);
        assertTrue(map.get(4) == 104L);
        assertTrue(map.get(-5) == -105L);
        assertTrue(map.get(6) == 106L);
        assertTrue(map.get(-6) == -106L);
        assertTrue(map.get(7) == 107L);
        assertTrue(map.get(-7) == -107L);


        map.put(8, 108L);
        map.put(-8, -108L);
        map.put(9, 109L);
        map.put(-9, -109L);


        assertTrue(map.size() == 20);
        assertTrue(map.get(Integer.MAX_VALUE) == 101L);
        assertTrue(map.get(Integer.MIN_VALUE) == 100L);
        assertTrue(map.get(0) == 99L);
        assertTrue(map.get(-1) == -101L);
        assertTrue(map.get(1) == 110L);
        assertTrue(map.get(-2) == -102L);
        assertTrue(map.get(2) == 102L);
        assertTrue(map.get(-3) == -103L);
        assertTrue(map.get(3) == 103L);
        assertTrue(map.get(-4) == -104L);
        assertTrue(map.get(4) == 104L);
        assertTrue(map.get(-5) == -105L);
        assertTrue(map.get(6) == 106L);
        assertTrue(map.get(-6) == -106L);
        assertTrue(map.get(7) == 107L);
        assertTrue(map.get(-7) == -107L);
        assertTrue(map.get(8) == 108L);
        assertTrue(map.get(-8) == -108L);
        assertTrue(map.get(9) == 109L);
        assertTrue(map.get(-9) == -109L);

        map.put(100, 1000L);
        map.put(101, 1001L);
        map.put(102, 1002L);
        map.put(103, 1003L);
        map.put(104, 1004L);
        map.put(105, 1005L);
        map.put(106, 1006L);
        map.put(107, 1007L);
        map.put(108, 1008L);
        map.put(109, 1009L);
        map.put(110, 1010L);
        map.put(111, 1011L);
        map.put(112, 1012L);

        assertTrue(map.size() == 33);
        assertTrue(map.get(Integer.MAX_VALUE) == 101L);
        assertTrue(map.get(Integer.MIN_VALUE) == 100L);
        assertTrue(map.get(0) == 99L);
        assertTrue(map.get(-1) == -101L);
        assertTrue(map.get(1) == 110L);
        assertTrue(map.get(-2) == -102L);
        assertTrue(map.get(2) == 102L);
        assertTrue(map.get(-3) == -103L);
        assertTrue(map.get(3) == 103L);
        assertTrue(map.get(-4) == -104L);
        assertTrue(map.get(4) == 104L);
        assertTrue(map.get(-5) == -105L);
        assertTrue(map.get(6) == 106L);
        assertTrue(map.get(-6) == -106L);
        assertTrue(map.get(7) == 107L);
        assertTrue(map.get(-7) == -107L);
        assertTrue(map.get(8) == 108L);
        assertTrue(map.get(-8) == -108L);
        assertTrue(map.get(9) == 109L);
        assertTrue(map.get(-9) == -109L);
        assertTrue(map.get(100) == 1000L);
        assertTrue(map.get(101) == 1001L);
        assertTrue(map.get(102) == 1002L);
        assertTrue(map.get(103) == 1003L);
        assertTrue(map.get(104) == 1004L);
        assertTrue(map.get(105) == 1005L);
        assertTrue(map.get(106) == 1006L);
        assertTrue(map.get(107) == 1007L);
        assertTrue(map.get(108) == 1008L);
        assertTrue(map.get(109) == 1009L);
        assertTrue(map.get(110) == 1010L);
        assertTrue(map.get(111) == 1011L);
        assertTrue(map.get(112) == 1012L);

        //System.out.println(map);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testException1(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        map.put(null,1L);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testException2(){
        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();

        map.get(null);
    }


    @Test
    public void testConsistency2(){

        int capacity = 100000;

        Map<Integer,Long> map = new OpenHashMap<Integer,Long>();


        for(int i=capacity; i>-capacity; i--){
            map.put(i,(long)i);
            assertTrue(map.get(i) == i);
            assertNull(map.get(capacity+1));
        }

        assertTrue(map.size() == 2*capacity);

        for(int i=capacity; i>-capacity; i--){
            assertTrue(map.get(i) == i);
        }

        for(int i=capacity; i>0; i--){
            assertTrue(map.remove(i) == i);
            assertNull(map.get(i));
        }

        assertTrue(map.size() == capacity);

        for(int i=0; i>-capacity; i--){
            assertTrue(map.get(i) == i);
        }

        for(int i=0; i>-capacity; i--){
            map.remove(i);
        }

        assertTrue(map.size() == 0);

        for(int i=capacity; i>-capacity; i--){
            map.put(i,(long)i);
        }

        assertTrue(map.size() == 2*capacity);

        for(int i=capacity; i>-capacity; i--){
            assertTrue(map.get(i) == i);
        }

        for(int i=0; i>-capacity; i--){
            map.remove(i);
        }


        assertTrue(map.size() == capacity);

        for(int i=capacity; i>0; i--){
            assertTrue(map.get(i) == i);
        }

        for(int i=capacity; i>0; i--){
            map.remove(i);
        }

        assertTrue(map.size() == 0);

    }

    @Test
    public void testCollision(){

        int capacity = 1000000;

        Map<Integer, Long> map = new OpenHashMap<Integer, Long>();


        for (int i = capacity; i > 0; i-=10) {
            map.put(i, (long) i);
            map.put(i+3, (long)(i+3));
            map.put(i-5, (long)(i-5));
            map.put(i+8, (long)(i+8));
            assertTrue(map.get(i) == i);
            assertTrue(map.get(i+3) == i+3);
            assertTrue(map.get(i-5) == i-5);
            assertTrue(map.get(i+8) == i+8);
        }

        assertTrue(map.size() == capacity/10*4);

        for (int i = capacity; i > 0; i-=10) {
            assertTrue(map.get(i) == i);
            assertTrue(map.get(i+3) == i+3);
            assertTrue(map.get(i-5) == i-5);
            assertTrue(map.get(i+8) == i+8);
        }

        for (int i = capacity; i > 0; i-=10) {
            assertTrue(map.remove(i) == i);
            assertTrue(map.remove(i + 3) == i+3);
            assertTrue(map.remove(i - 5) == i-5);
            assertTrue(map.remove(i + 8) == i+8);
            assertNull(map.get(i));
            assertNull(map.get(i + 3));
            assertNull(map.get(i - 5));
            assertNull(map.get(i + 8));
        }

        assertTrue(map.size() == 0);
    }
}
