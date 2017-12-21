package com.sudo_code.friendswithdeficits.model;

import java.util.*;

public class FWD {
    private List<Friend> friendList;

    public FWD() {
        friendList = new ArrayList<Friend>();
    }

    public void addFriend(String name) {
        friendList.add(new Friend(name));
    }

    public void removeFriend(Friend friend) {
        friendList.remove(friend);
    }

    public double getFriendOwing(Friend friend) {
        return friend.getOwing();
    }

    public String getFriendName(int num) {
        return friendList.get(num).getName();
    }

    public List<Friend> getFriends() {
        return friendList;
    }
}