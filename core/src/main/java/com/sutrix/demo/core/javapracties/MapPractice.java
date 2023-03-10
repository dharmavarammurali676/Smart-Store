package com.sutrix.demo.core.javapracties;


import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        ///// Creation of Map
        Map<Integer, String> map = new Hashtable<>();
        ///// Add Values in Map
        map.put(1, "dharmavaram Murali");
        map.put(2, "Krishna");
        map.put(3, "Vinitha");
        map.put(4, "Hari");
        map.put(5, "sameera");

        // Retrieve the keys
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(key);
        }
        System.out.println();
        //// Retrieve yhe values
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
        System.out.println();
        ///// Get Values using key
        System.out.println(map.get(4));
        ///// Get all Data
        for (Integer key : keys) {
            System.out.println(key + "--->" + map.get(key));
            System.out.println(map);
            ////// Deletion of the map
            map.remove(3);
            System.out.println(map);
            ////// Verification of values and Keys
            // Keys
            System.out.println(map.containsKey(2));
            System.out.println(map.containsKey(2));
            // Values
            System.out.println(map.containsValue("sameera"));
            System.out.println(map.containsValue("vinitha"));

        }
    }
}

