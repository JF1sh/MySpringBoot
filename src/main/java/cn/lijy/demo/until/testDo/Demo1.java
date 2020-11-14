package cn.lijy.demo.until.testDo;

public class Demo1 {

    private static String str;

    static {
        str="ok";
    }


    public static void main(String[] args) {
        String str ="111";
        char str1 ='1';

        if (str instanceof String){
            System.out.println("ok");
        }


    }
}
