package cn.lijy.demo.until.demo;

import java.io.FileNotFoundException;

public class demo2 {

    public static void getException() throws FileNotFoundException {


            throw new FileNotFoundException();

    }


    public static void doSomething(){
        System.out.println("ok");
    }


    public static void main(String[] args) {
        try {
            getException();
            doSomething();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("------");
    }

}
