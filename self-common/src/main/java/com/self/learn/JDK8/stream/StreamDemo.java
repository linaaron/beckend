package com.self.learn.JDK8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {

    @Test
    public void TestOne() {
//        List<String> transactions = new ArrayList<>();
//        transactions.parallelStream().sorted((String Transaction) -> Comparator.comparing(Transaction).reversed()).
//                map(Transaction -> Transaction).collect(Collectors.toList());
    }

    @Test
    public void TestTwo() {
        List<String> outPut = new ArrayList<>();
        outPut.add("a");
//        Stream stream = Stream.of("a","b","c");

        outPut.stream().map(String::toUpperCase).collect(Collectors.toList());


        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).
                collect(Collectors.toList());


        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());


        IntStream.of(1, 2, 3);

    }

    @Test
    public void createStream() {
        //1 Individual values
        Stream stream = Stream.of("a", "b", "c", "d");
        //2  Arrays
        String[] strArray = new String[]{"a", "b"};
        Stream stream2 = Stream.of(strArray);
        Stream stream3 = Arrays.stream(strArray);
        //3 collections
        List<String> list = Arrays.asList(strArray);
        Stream stream4 = list.stream();
    }

    @Test
    public void IntStreamDemo() { //LongStream.   DoubleStream
        IntStream.of(1, 2, 3).forEach(System.out::print); //123
        System.out.println();
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::print); //123
        System.out.println();
        IntStream.range(1, 4).forEach(System.out::print);  //123
        System.out.println();
        IntStream.rangeClosed(1, 4).forEach(System.out::print);  //1234
    }

    @Test
    public void changeStream() {
        Stream stream = Stream.of("a", "b", "c", "d");
        //1. Array
//        String[] strArray = (String[]) stream.toArray(String[]::new);
        //2. Collection
//        List<String> list1 = (List<String>) stream.collect(Collectors.toList());
//        List<String> list2 = (List<String>) stream.collect(Collectors.toCollection(ArrayList::new));
//        Set set1 = stream.collect(Collectors.toSet());
//        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        //3. String
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);
    }

    @Test
    public void mapStream() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        List<Integer> squareNums = nums.stream().
                map(n -> n * n).collect(Collectors.toList());
        //////////////////////////
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
//      flatMap 把 input Stream 中的层级结构扁平化，就是将最底层元素抽出来放到一起，最终 output 的新 Stream
//      里面已经没有 List 了，都是直接的数字。
    }

    @Test
    public void filterStream() {

    }


    public void test() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        String res1 = arr.stream().map(i -> i.toString()).collect(Collectors.joining(","));  //1,2,3
        String res2 = arr.stream().map(i -> i.toString()).collect(Collectors.joining(",", "[", "]")); //[1,2,3]
        System.out.println(res1);

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred").add("test");
        String desiredString = sj.toString();
        System.out.print(desiredString); //[George:Sally:Fred:test]
    }

    @Test
    public void limitTest() {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            arr.add(i);
        }

        long begin2 = System.currentTimeMillis();
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < arr.size(); i++) {
//            stringBuffer.append(arr.get(i)).append(",");
//        }
        System.out.println(convertIdsToString2(arr));
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - begin2);

        long begin = System.currentTimeMillis();
//        String arrString = arr.stream().map(id -> id.toString()).collect(Collectors.joining(","));
        System.out.println(convertIdsToString(arr));
        long end = System.currentTimeMillis();
        System.out.println(end - begin);


//        arr.stream().limit(2).forEach(System.out::println);  //1 2
    }

    private String convertIdsToString(List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return "0";
        }

        List<Integer> newIds = new ArrayList<>();
        if (ids.size() > 10) {
            for (int i = 0; i < 10; i++) {
                newIds.add(ids.get(i));
            }
//            newIds = ids.stream().limit(10).collect(Collectors.toList());
        } else {
            newIds = ids;
        }

        StringBuffer idString = new StringBuffer();
//        newIds.forEach(id->{idString.append(id).append(",");});
        return idString.substring(0, idString.length()-1).toString();
//        return newIds.stream().map(id -> id.toString()).collect(Collectors.joining(","));
    }

    public String convertIdsToString2(List<Integer> ids) {
        if (ids == null || ids.size() == 0) {
            return "0";
        }

        List<Integer> newIds = new ArrayList<>();
        if (ids.size() > 10) {
            for (int i = 0; i < 10; i++) {
                newIds.add(ids.get(i));
            }
        } else {
            newIds = ids;
        }

        StringBuffer idString = new StringBuffer();
        for (int i = 0; i < newIds.size(); i++) {
            idString.append(newIds.get(i)).append(",");
        }

        return idString.substring(0, idString.length() - 1).toString();
    }
}
