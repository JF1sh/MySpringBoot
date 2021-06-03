package cn.lijy.demo.until.testDo;

import java.util.Arrays;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description: 使用冒泡排序
 * @author: JF1sh
 * @create: 2020-04-27 19:51
 **/
public class BubbleSort {
    final static int [] num = {19,11,23,4,33,5,1,2,3,88,99,34};

    public static void main(String[] args) {

        quickSort(num);
        System.out.println(Arrays.toString(num));
    }

    /**
     * 冒泡排序
     * 从数组第一位置开始，与每一位进行比较，如果比[0]小 则交换位置，与剩下的继续比较
     */
    public static void Bubble(){
        for (int i = 0; i <num.length ; i++) {
            for (int j = i; j < num.length ; j++) {
                if(num[i] > num [j]){
                    int temp;
                    temp =num[i] ;
                    num[i] =num[j];
                    num[j]=temp;
                    System.out.println("当前："+ Arrays.toString(num));
                }
            }
        }
        System.out.println(Arrays.toString(num));
    }


    /**
     * 快速排序
     * @param a
     * @param low
     * @param height
     */
    public static void sort(int a[], int low, int height) {
        int i, j, index;
        if (low > height) {
            return;
        }
        i = low;
        j = height;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
            System.out.println("当前："+ Arrays.toString(num));
            System.out.println("当前："+ index);

        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, height); // 对高子表进行递归排序

    }

    public static void quickSort(int a[]) {
        sort(a, 0, a.length - 1);
    }


}
