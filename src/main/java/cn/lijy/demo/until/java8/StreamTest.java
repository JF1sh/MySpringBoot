package cn.lijy.demo.until.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    /**
     * list 操作
     */
    @Test
    public void execute(){
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");

        //Java8 Lambda遍历集合
        list.forEach(li -> print(li));

        System.out.println("-----------");
        //遍历时 过滤
        //forEach():迭代流中的每个数据。
        list.forEach(li ->{
            if(li.equals("11")){
                print(li);
            }
        });
        System.out.println("-----------");

        //先过滤 再遍历
        //steam():把一个源数据，可以是集合，数组，I/O channel， 产生器generator 等，转化成流。
        //filter():filter 方法用于通过设置的条件过滤出元素。
        list.stream()
                .filter(li ->!li.contains("22"))
                .forEach(c -> print(c)); //遍历出集合中不是22的其他的元素

        System.out.println("-----------");
        //map():用于映射每个元素到对应的结果。
        Stream<String> stream = list.stream()
                .map(li -> li + "--");
        stream.forEach(s -> print(s));
    }

    /**
     * list 集合 collect使用
     */
    @Test
    public void execute2(){
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("44");
        list.add("55");

        List<String> collect = list
                .stream() //将集合转换为流
                .filter(li -> !li.contains("22"))//使用过滤器筛选元素
//                .limit(2)  //方法用于获取指定数量的流
                .collect(Collectors.toList());//将筛选后的流转化为List

        System.out.println(collect.size());
        System.out.println(collect);
    }

    /**
     * list 集合 collect使用
     */
    @Test
    public void execute3(){
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        String mergedString = strings
                .stream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.joining(","));//将集合元素合并

        System.out.println("合并字符串: " + mergedString);
    }

    /**
     * list map使用
     */
    @Test
    public void execute4(){
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
       // 获取对应的平方数
        List<Integer> squaresList = numbers
                .stream() //将集合转化为流
                .map( i -> i*i) //map 用于映射每个元素到对应的结果
                .distinct() //去重重复的元素
                .collect(Collectors.toList());//将流转化为集合
        squaresList.forEach(list -> System.out.println(list));
    }

    @Test
    public void execute5(){
        List<String> strings = Arrays.asList("12", "", "9", "14", "17","", "3");
// 获取空字符串的数量
        List<String> collect = strings
                .parallelStream()
                .filter(string -> !string.isEmpty())
                .collect(Collectors.toList());

        System.out.println(collect);

    }

    /**
     * Map 的遍历
     */
    @Test
    public void execute1(){
        HashMap<String, Object> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        //遍历map的数据
        items.forEach((key,value)->print(key,value));
        System.out.println("-----------");

        //
        items.forEach((key,value)->{
            if (key.equals("A")){
                print(String.valueOf(value));
            }
        });
        System.out.println("-----------");

    }


    public void print(String code){
        System.out.println(code);
    }

    public void print(String code,Object in){
        System.out.println(code);
        System.out.println(in);
    }

    public static void main(String[] args) {


    }
}
