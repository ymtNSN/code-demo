package com.example.demo.design.iterator;

/**
 * Created by @author ymtNSN on 2020/10/24
 */
public interface SocialNetwork {

    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
