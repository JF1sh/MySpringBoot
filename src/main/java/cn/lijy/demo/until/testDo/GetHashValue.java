package cn.lijy.demo.until.testDo;


public class GetHashValue {

    /**
     *  将hash分为100个 拿到当前所属的个数
     *
     */


    public static int getHashValue(String key){
        int h= (h= key.hashCode()) ^ (h>>16);
        System.out.println(">>>>>>>>>>"+h);
        int i= (100 -1) & h;
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getHashValue(""));

    }


}
