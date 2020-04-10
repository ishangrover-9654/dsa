package com.project.practice.javaconcepts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class HashMapConcepts {
    public static void main(String[] args) {
        List<Entity> list = new ArrayList<>();
        list.add(new Entity(4, "name4", "value2"));
        list.add(new Entity(3, "name3", "value2"));
        list.add(new Entity(5, "name5", "value2"));
        list.add(new Entity(1, "name1", "name2"));
        list.add(new Entity(1, "name1new", "name2new"));
        list.add(new Entity(2, "name2", "value2"));

        listToMapJava8ops(list);
    }

    public static void listToMapJava8ops(List<Entity> list){

        /*
        //Key - Id, value - entity
        Map<Integer, Entity> map = list.stream().collect(Collectors.toMap(Entity::getId, entity -> entity));

        //or
        Map<Integer, Entity> map1 = list.stream().collect(Collectors.toMap(Entity::getId, Function.identity()));

        // Key - id, Value - name
        Map<Integer, String> map3 = list.stream().collect(Collectors.toMap(Entity::getId, Entity::getName));

        //Same as above Using Lambda Expression
        Map<Integer, String> map4 = list.stream().
                collect(Collectors.toMap(entity -> entity.getId(), entity -> entity.getName()));
*/
        //Manage Duplicates with preserve order
        Map<Integer, String> map5 =  list.stream().collect(Collectors.toMap(Entity::getId, Entity::getName,
                (oldValue, newValue) -> newValue , LinkedHashMap::new));

        //Sort Map by key
        Map<Integer, String> sortedKeyMap = map5.entrySet().stream().sorted(Map.Entry.comparingByKey()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldKey, newKey) -> newKey,
                        LinkedHashMap::new));
        //Sort Map by value
        Map<Integer, String> sortedValueMap = map5.entrySet().stream().sorted(Map.Entry.comparingByValue()).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldKey, newKey) -> newKey,
                        LinkedHashMap::new));

        log.info("Duplicate keys removed and preserved order {}", map5);
        log.info("Sorted Map by Key {}", sortedKeyMap);
        log.info("Sorted Map by value {}", sortedValueMap);
    }

    
}

@Getter @Setter @AllArgsConstructor
class Entity{
    int id;
    String name;
    String value;
}