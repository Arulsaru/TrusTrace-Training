package com.bit.teachers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class teachers {
    public static void main(String[] args) {
        int userId = 0;
        List<String> teachersNames = Arrays.asList("Arulmozhi", "Hari", "Keerti", "Gowtham");
//        teachersNames.forEach(name -> System.out.println(name));

        Stream<String> data = teachersNames.stream();
//        data.forEach(name -> System.out.println(name));
//        System.out.println(data.count());
//        Stream<String> sortedData = data.sorted();
//        sortedData.forEach(name -> System.out.println(name));

//        Stream<String> mappedData = sortedData.map(name -> name.toLowerCase()) ;
//        mappedData.forEach(name -> System.out.println(name));

        teachersNames.stream().filter(name -> name.length() % 2 == 0).sorted().map(name -> name.toUpperCase()).forEach(name -> System.out.println(name));

    }
}
