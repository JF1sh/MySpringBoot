package cn.lijy.demo.until.testDo;

import cn.lijy.demo.entity.MybatisPojo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;

/**
 * @program: cn.lijy.demo.until.testDo
 * @description:
 * @author: JF1sh
 * @create: 2019-11-25 19:04
 **/
public class ArrayCopy {

    public static void main(String[] args) {
    List<String> test = new ArrayList<String>();
      test.add("a");
      test.add("c");
      test.add("b");
      test.add("d");
  if(!test.contains("a")){
      System.out.println("ok");
  }else {
      System.out.println("no");
  }
    }

}
