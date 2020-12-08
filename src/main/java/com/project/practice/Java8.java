package com.project.practice;

import com.project.practice.model.CusEntity;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        //sortMapByValue();
        //sortMapByKey();
    }

    public static void sortNcomparatorExample(){
        List<CusEntity> list = new ArrayList<>();

        list.add(new CusEntity(4, "name4", "value4", 4));
        list.add(new CusEntity(3, "name3", "value3", 3));
        list.add(new CusEntity(0, "name0", "value0", 0));
        list.add(new CusEntity(1, "name1", "value1", 1));
        list.add(new CusEntity(6, "name6", "value6", 6));

        Comparator<CusEntity> comp = (o1, o2) -> o1.getId().compareTo(o2.getId());

        //or
        Comparator<CusEntity> comp2 = Comparator.comparing(CusEntity::getId);

        list.sort(comp);
    }

    public static void iterateMap (){
        Map<String, String> map = new HashMap<>();

        map.put("k1", "val1");
        map.put("k2", "val2");

        /** Ex : 1 using lambda*/
        map.forEach((k,v) -> System.out.println(k+":"+v));

        /** Ex : 2 using stream */
        map.entrySet().stream().forEach( e -> System.out.println(e.getKey()
                + ":" + e.getValue()));

    }

    public static void sortMapByKey(){
        System.out.println("sortMapByKey::");
        Map<String, String> map = new HashMap<>();

        map.put("k2", "val2");
        map.put("k1", "val1");

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> newKey, LinkedHashMap::new));

        System.out.println(map);

    }

    public static void sortMapByValue(){
        System.out.println("sortMapByValue");
        Map<String, String> map = new HashMap<>();

        map.put("k2", "val2");
        map.put("k1", "val1");

        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldKey, newKey) -> newKey, LinkedHashMap::new));

        System.out.println(map);

    }
}
