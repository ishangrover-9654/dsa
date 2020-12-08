package com.project.practice.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LinkNode<T> {
    public T data;
    public LinkNode<T> next;

    public LinkNode(T data) {
        this.data = data;
    }
}
