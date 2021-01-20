package com.example.demo.service;

//import com.user.sdk.getway.UserFeignClient;
//import com.user.sdk.response.AppUserVO;
//import com.user.sdk.response.BaseResponse;
//import com.user.sdk.service.UserService;

import com.example.demo.demo.MyFunction;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.Key;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * Created by @author ymtNSN on 2020/4/9
 */
@Service
public class DemoService {

//    @Autowired
//    private UserFeignClient userFeignClient;
    @Autowired
    private ObjectFactory<DestService> objectFactory;

//    public BaseResponse<AppUserVO> demo(Long userId) {
//        return userFeignClient.getUserByUid(userId);
//    }

    public void testDest(){
        DestService object = objectFactory.getObject();
        System.out.println(object);
    }

    public static void main(String[] args) {
//        System.out.println(System.currentTimeMillis());
//        Map<String, Integer> map = new HashMap<>();
//        map.put("1", 1);
//        map.put("2", 1);
//        map.merge("1", 1, Integer::sum);
//        System.out.println(map);
//        Function<Integer,Integer> d = Integer::sum;
//        d.apply(d);

        MyFunction myFunction = System.out::println;
        myFunction.sayHello("msg");

        Consumer<String> consumer = System.out::println;
        consumer.accept("dg ");
        Supplier<String> supplier = () -> "我";
        supplier.get();
        Function<Integer, Integer> function = e -> e * 5;
        System.out.println(function.apply(2));

        List<String> list = Arrays.asList("d", "h", "a", "z", "b");
        Comparator<String> comparable = String::compareTo;

        list.sort(comparable);

        Aaa aaa = new Aaa();
        Timer timer = new Timer(1000, aaa);
        timer.start();

        Timer bbb1 = new Timer(100, bbb -> System.out.println("bbb"));

        Ww.repeat(6, () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("count:" + i);
            }
        });


    }

    static class Aaa implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("hello");
        }
    }

    static class Ww {
        public static void repeat(int n, Runnable ac) {
            for (int i = 0; i < n; i++) {
                ac.run();
            }
        }
    }
}
