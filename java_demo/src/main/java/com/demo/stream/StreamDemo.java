package com.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 对stream一些操作的demo，以加深理解
 * @author LC
 * @date 2018/1/25
 */
public class StreamDemo {

    void testMap(){

        List<Double> doubles = new ArrayList<>();
        doubles.add(new Double(1));
        doubles.add(new Double(2));
        doubles.add(new Double(3));
        doubles.add(new Double(4));
        doubles.add(new Double(5));

        doubles.stream().map(d->{
            return  d* 10;
        }).forEach((s)->{
            System.out.println("map:"+s);
        });


        doubles.stream().flatMap(d->{
            return Stream.of( d* 10);
        }).forEach((s)->{
            System.out.println("flatMap:"+s);
        });


    }

    public static void main(String[] args) {
        StreamDemo test = new StreamDemo();
        test.testMap();
    }
}
 