package com.example.demo.ddd;

import javax.validation.constraints.NotNull;

/**
 * Created by @author ymtNSN on 2021/1/20
 */
public class UserService {

    private SalesRepRepo salesRepRepo;
    private UserRepo userRepo;

    public User register(@NotNull User.Name name
            , @NotNull User.PhoneNumber phone
            , @NotNull User.Address address) {
        // 找到区域内的id
        User.RepId rep = salesRepRepo.findRep(phone.getAreaCode());

        User user = User.builder()
                .address(address).name(name).phone(phone)
                .build();
        if (rep != null) {
            user.setRepId(rep);
        }
        return userRepo.saveUser(user);
    }
}
