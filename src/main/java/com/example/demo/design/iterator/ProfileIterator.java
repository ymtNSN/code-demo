package com.example.demo.design.iterator;

/**
 * Created by @author ymtNSN on 2020/10/24
 */
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
