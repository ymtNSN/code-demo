package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by @author ymtNSN on 2020/4/15
 */
@Slf4j
public class ExceptionUtil {

    public static String getMessage(Exception e) {
        String swStr = null;
        try {
            try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
                e.printStackTrace(pw);
                pw.flush();
                sw.flush();
                swStr = sw.toString();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            log.error(e.getMessage());
        }
        return swStr;
    }

    public static void main(String[] args) {
        List<Person> list = Arrays.asList(new Person(1,4), new Person(8,5), new Person(8,4), new Person(6,9));
        System.out.println(list);
       list =  list.stream().sorted(Comparator.comparing(Person::getId,Comparator.naturalOrder()).thenComparing(Person::getAge, Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(list);
    }

}
