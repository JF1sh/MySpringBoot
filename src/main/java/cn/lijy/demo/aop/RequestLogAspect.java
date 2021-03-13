package cn.lijy.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect //表示该类为切面
@Component //将该类交给spring管理
public class RequestLogAspect {

    private static Logger log = Logger.getLogger(RequestLogAspect.class);

    @Pointcut("execution(public * cn.lijy.demo.controller..*.*(..))") //切入的位置 controller包下的所有类 返回值为*
    public void webLog(){ }

    @Before("webLog()") //什么时候进行切入 方法执行前
    public void doBefore(JoinPoint joinPoint){
        //接收请求 记录请求内容
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录日志内容
        log.info("URL:" + request.getRequestURL().toString());
        log.info("IP:" + request.getRemoteAddr());
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()") //方法执行完 返回之后 ret表示方法的返回值
    public void doAfterReturning(Object ret){
        //处理完请求返回之后
        log.info("RESPONSE:"+ret);
    }
}
