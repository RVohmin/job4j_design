package ru.job4j.test1;

import java.util.HashMap;
import java.util.Map;

/**
 * job4j_design ru.job4j.test1.FreezeStr
 *
 * @author romanvohmin
 * @since 01.05.2020 09:58
 */
public class FreezeStr {
    public static boolean eq(String left, String right) {
        char[] charLeft = left.toCharArray();
        char[] charRight = right.toCharArray();
        Map<Character, Integer> mapLeft = new HashMap<>();
        for (char item : charLeft) {
            mapLeft.merge(item, 1, (k, x) -> x += 1);
        }
        Map<Character, Integer> mapRight = new HashMap<>();
        for (char item : charRight) {
            mapRight.merge(item, 1, (k, x) -> x += 1);
        }
        return mapLeft.equals(mapRight);
    }
}
