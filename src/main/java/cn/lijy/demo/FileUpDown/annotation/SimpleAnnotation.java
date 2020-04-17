package cn.lijy.demo.FileUpDown.annotation;

import cn.lijy.demo.FileUpDown.apollo.SpringCin;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 元注解：标注注解的生命周期，作用域等等；Target,Retention,Documented,Inherited
 */
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(value = SpringCin.class)
public @interface SimpleAnnotation {
    String[] value() default {"values"};
}

/**
 * @Target
@Target 说明了Annotation所修饰的对象范围
取值(ElementType)有：

CONSTRUCTOR:用于描述构造器
FIELD:用于描述域
LOCAL_VARIABLE:用于描述局部变量
METHOD:用于描述方法
PACKAGE:用于描述包
PARAMETER:用于描述参数
TYPE:用于描述类、接口(包括注解类型) 或enum声明
---------------------------------------------
 @Retention
 @Retention定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。
 取值（RetentionPoicy）有：

 SOURCE:在源文件中有效（即源文件保留）
 CLASS:在class文件中有效（即class保留）
 RUNTIME:在运行时有效（即运行时保留）
------------------------------------------------

*/