package cn.lijy.demo.until.testDo;


import java.util.Arrays;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 使用System.arraycopy()  和 arrays.copyof()
 * 用于copy 数组
 * @author: JF1sh
 * @create: 2019-11-25 19:04
 **/
public class ArrayCopy {

    /**
     * 使用System.arraycopy()
     * @param list
     * src:源数组；
     *    srcPos:源数组要复制的起始位置；
     *    dest:目的数组；
     *    destPos:目的数组放置的起始位置；
     *   length:复制的长度。
     *   注意：src and dest都必须是同类型或者可以进行转换类型的数组．
     */
    private static void SysCopy(String[] list) {
        System.out.println("源集合长度:" + list.length);

        String[] dataList = new String[]{"ma","yi","cong"};

        System.arraycopy(list, 1, dataList, 0, list.length -1);

        for (int i = 0; i < dataList.length; i++) {
            System.out.print(dataList[i]+",");
        }
    }


    /**
     *
     * @param list
     *
     * original：第一个参数为要拷贝的数组对象
     * newLength：第二个参数为拷贝的新数组长度
     */
    private static void ArrayCopy(String[] list) {

        System.out.println("");
        String[] dataList= Arrays.copyOf(list,list.length);
        for (int i = 0; i < dataList.length; i++) {
            System.out.print(dataList[i]+",");
        }
    }


    public static void main(String[] args) {
        String[] list = new String[]{"li","jing","yu"};

        SysCopy(list);
        ArrayCopy(list);
    }

}
