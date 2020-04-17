package cn.lijy.demo.entity;

import lombok.*;
import org.apache.log4j.Logger;

/**
 * @program: cn.lijy.demo.entity
 * @description: 使用 lombok 创建对象 . 需要安装 lombok插件
 * @author: JF1sh
 * @create: 2019-11-21 15:47
 **/

/**
 * @Data 注解在类上，会为类的所有属性自动生成setter/getter、equals、canEqual、hashCode、toString方法，
 * 如为final属性，则不会为该属性生成setter方法。
 * @NoArgsConstructor 自动生产无参构造
 * @AllArgsConstructor 自动生产全参构造
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityLombok {

    private static Logger log = Logger.getLogger(EntityLombok.class);
    private String name;
    private int age;
    private String sex;

    public void getEntity() {
        EntityLombok ent = new EntityLombok();
        ent.setName("lijingyu");
        ent.setAge(27);
        ent.setSex("男");

    }

    public static void main(String[] args) {
        EntityLombok el = new EntityLombok("lijingyu", 17, "男");
        EntityLombok el1 = new EntityLombok("lijinyu", 17, "男");

        if (el1.equals(el)) {
            System.out.println("ok");

        }else {
            System.out.println("no");
            System.out.println(el);
        }

    }

}
