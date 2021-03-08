package cn.lijy.demo.until.demo;

/**
 * 使用可配置参数
 */
public class demo1 {

    public static String getStr(String str,String def){
        String value = str;
        if(value == null || value.length() ==0 ){
            value = def;
        }
        return value;
    }


    public static String SelectStr(String key){
        String value = key;

        return value;
    }


    public static void main(String[] args) {
        System.out.println(getStr("qwe", "123"));
        System.out.println(getStr("", "qwe"));
    }
}
