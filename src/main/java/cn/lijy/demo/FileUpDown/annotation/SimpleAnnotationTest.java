package cn.lijy.demo.FileUpDown.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @program: cn.lijy.demo.FileUpDown.annotation
 * @description:
 * @author: JF1sh
 * @create: 2019-12-18 19:09
 **/
@SimpleAnnotation
public class SimpleAnnotationTest {

    @SimpleAnnotation
    private String value;

    @SimpleAnnotation
    public void sendMessage(@SimpleAnnotation String msg){
        System.out.println(msg);
    };

    public static void main(String[] args) throws Exception {
        Class<SimpleAnnotationTest> simpleAnnotationTestClass =SimpleAnnotationTest.class;
        SimpleAnnotation annotation= simpleAnnotationTestClass.getAnnotation(SimpleAnnotation.class);
        System.out.println(annotation.value()[0]);
        Method sendMessage =simpleAnnotationTestClass.getMethod("sendMessage", new Class[]{String.class});
        SimpleAnnotation sendMessageAnnotation =sendMessage.getAnnotation(SimpleAnnotation.class);
        System.out.println(sendMessageAnnotation.value()[0]);
        Annotation[][] parameterAnnotations=sendMessage.getParameterAnnotations();
        System.out.println(parameterAnnotations);
    }
}
