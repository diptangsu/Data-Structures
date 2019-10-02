// Java program to illustrate 
// Java.util.HashMap 

import java.util.*;

public class Hashes {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map);
        map.put("First", 10);
        map.put("Second", 30);
        map.put("Third", 20);
        System.out.println("Size of map is:- " + map.size());
        System.out.println(map);
        if (map.containsKey("vishal")) {
            Integer a = map.get("vishal");
            System.out.println("value for key" + " \"vishal\" is:- " + a);
        }
        sortByKey(map);
        sortByValue(map);
        map.clear();
        System.out.println(map);
    }

    public static void print(Map<String, Integer> map) {
        if (map.isEmpty()) {
            System.out.println("map is empty");
        } else {
            System.out.println(map);
        }
    }

    public static void sortByKey(Map<String, Integer> map) {
        // TreeMap to store values of HashMap 
        TreeMap<String, Integer> sorted = new TreeMap<>();

        // Copy all data from hashMap into TreeMap 
        sorted.putAll(map);
        System.out.println("After sorting by key");
        // Display the TreeMap which is naturally sorted 
        for (Map.Entry<String, Integer> entry : sorted.entrySet())
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    }

    public static void sortByValue(HashMap<String, Integer> map) {
        List<String> mapKeys = new ArrayList<>(map.keySet());
        List<Integer> mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = map.get(key);
                Integer comp2 = val;
                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        System.out.println("Map Sorted By Value");
        System.out.println(sortedMap);
    }
} 