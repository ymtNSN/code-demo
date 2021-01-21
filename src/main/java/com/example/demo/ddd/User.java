package com.example.demo.ddd;

import lombok.Builder;
import lombok.Data;

/**
 * Created by @author ymtNSN on 2021/1/20
 */
@Data
@Builder
public class User {

    private UserId userId;
    private Name name;
    private PhoneNumber phone;
    private Address address;
    private RepId repId;

    public static class UserId {
    }

    public static class Name {
    }

    public static class PhoneNumber {
        public String getAreaCode() {
            return "";
        }
    }

    public static class Address {
    }

    public static class RepId {
    }
}
