package com.project.practice.javaconcepts;

import com.project.practice.model.CusEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorJava8 {

    public static void main(String[] args) {
        List<CusEntity> list = new ArrayList<>();

        list.add(new CusEntity(4, "name4", "value4", 4));
        list.add(new CusEntity(3, "name3", "value3", 3));
        list.add(new CusEntity(0, "name0", "value0", 0));
        list.add(new CusEntity(1, "name1", "value1", 1));
        list.add(new CusEntity(6, "name6", "value6", 6));

        Comparator<CusEntity> comp = ( o1,  o2) -> o1.getId().compareTo(o2.getId());

        //or
        Comparator<CusEntity> comp2 = Comparator.comparing(CusEntity::getId);

        list.sort(comp);
    }
}


