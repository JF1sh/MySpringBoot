package cn.lijy.demo.until.socket;


import org.dom4j.*;

import java.util.List;

/**
 * @program: cn.lijy.demo.until.socket
 * @description: 创建XML文件，以字符流的方式发给对方
 * @author: JF1sh
 * @create: 2020-02-23 15:49
 **/
public class CreateXML {


    /**
     * 创建xml文件，将xml转化为字符串 ，以流的形式进行传输
     * @return
     */
    public static String  createXML(){
        //创建dom4j文档
        Document document = DocumentHelper.createDocument();

        //设置节点
        Element element =DocumentHelper.createElement("xml");

        //给文件设置根节点
        document.setRootElement(element);

        /*遍历集合，以每个对象为节点，写入XML文件中。相当于给集合中的每一个下标赋值，将集合以XML文件格写出来*/

        for(int i=0;i<10;i++){
            /*先设置对象节点*/
            Element pojo = DocumentHelper.createElement("pojo");

            /*再设置属性节点*/
            Element id =DocumentHelper.createElement("id");
            Element name =DocumentHelper.createElement("name");

            /*根据下标所得到的对象属性赋给节点 id*/
            id.setText("li"+i);
            name.setText("ma"+i);

            /*将所有的对象元素，放入 element节点中*/
            element.add(pojo);

            /*将属性放入pojo节点中*/
            pojo.add(id);
            pojo.add(name);
        }


        /*所得到的则是一个Document文件，将其转化为一个字符串，以字符输出流的方式写出*/

        String str = document.asXML();

       return str;
    }

    /**
     * 解析xml文件中的数据
     * @param str
     * @return
     */
    public static  String getXML(String str){

        String name = "";
        try {
            /*创建Document 文件*/
            Document document =DocumentHelper.parseText(str);

            /*以pojo标签为例，提取节点，放在一个集合中*/
         //   List <MybatisPojo> list = document.selectNodes("xml/pojo");
            List<Node> list = document.selectNodes("xml/pojo");

            /*遍历集合，得到xml文件，将对象转换为element*/
            Element element=(Element)list.get(1); //1为集合的下标

            /*得到子节点中的值--
            selectSingleNode("name") 为得到name节点
             getText() 为得到节点的值*/
             name =element.selectSingleNode("name").getText();

        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return  name;
    }


    public static void main(String[] args) {
        System.out.println(getXML(createXML()));
    }
}
