package main.java.leetcode.algorithms.easy.problems_401_500;

import java.util.HashMap;

public class ConvertNumberToHexadecimal {
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }

        HashMap<Integer,Character> map = buildHashMap();
        StringBuilder sb = new StringBuilder();

        if(num > 0) {

            while(num > 0) {
                sb.append(map.get(num%16));
                num = (num - (num%16)) /16;
            }
        } else {
            //TODO for negative numbers
        }

        return sb.reverse().toString();
    }

    private HashMap<Integer,Character> buildHashMap() {
        HashMap<Integer,Character> map = new HashMap<>();

        map.put(0,'0');
        map.put(1,'1');
        map.put(2,'2');
        map.put(3,'3');
        map.put(4,'4');
        map.put(5,'5');
        map.put(6,'6');
        map.put(7,'7');
        map.put(8,'8');
        map.put(9,'9');
        map.put(10,'a');
        map.put(11,'b');
        map.put(12,'c');
        map.put(13,'d');
        map.put(14,'e');
        map.put(15,'f');

        return map;
    }
}
