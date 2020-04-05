package com.project.practice;

import java.util.*;

public class LRUimplementation {
    public static void main(String[] args) {

        LRU lru = new LRU(3);
        lru.refer(3);
        lru.refer(5);
        lru.refer(2);
        lru.refer(1);
        lru.refer(5);

        lru.display();


    }



}

class LRU{
    private Deque<Integer> cache = new LinkedList<>();
    private int size;

    private Set<Integer> hash = new HashSet<>();

    public void addElem(Integer item){
        cache.add(item);
    }

    public void setSize(int size){
        this.size = size;
    }

    LRU(int size){
        this.size = size;
    }

    public void refer(int item){
        if(!hash.contains(item)){
            if(hash.size()==size){
                Integer remItem = cache.removeLast();
                hash.remove(remItem);
            }
        }
        else {
            cache.removeIf(elem -> elem == item);
        }
            hash.add(item);
            cache.addFirst(item);
        }

        void display(){
        System.out.println(cache);
        }
    }




