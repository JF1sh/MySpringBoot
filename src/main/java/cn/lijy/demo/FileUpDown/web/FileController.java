package cn.lijy.demo.FileUpDown.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * @program: cn.lijy.demo.FileUpDown.web
 * @description:
 * @author: JF1sh
 * @create: 2019-12-26 16:33
 **/

@Controller
public class FileController {

   private static Logger log = Logger.getLogger(FileController.class);

    @Autowired
    Environment environment;

    final String uri="/Users/jf1sh/temp/Downlaod-test";

    @RequestMapping("fileUp")
    @ResponseBody
    public String fileUp(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()){
            return "上传失败";
        }
        String originalFilename = file.getOriginalFilename();
        String filePath =uri;
        File file1 =new File(filePath + originalFilename);
        try {
            file.transferTo(file1);
            return "上传成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }


    @RequestMapping("fileDown")
    public void fileDown(String path, HttpServletResponse response){
        path = uri+path;
        try{
            File file = new File(path);
            String fileName =file.getName();
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(path));
            /* 获取文件大小*/
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();

            response.reset();

            response.addHeader("Content-Disposition","attachment;filename="+new String(fileName.getBytes()));
            response.addHeader("Content-Length",""+file.length());
            BufferedOutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();

        }catch (Exception e){
            e.printStackTrace();
            log.error("ERROR at fileDown:"+path);
        }
    }

    @RequestMapping("list")
    @ResponseBody
    public String list(){
        log.info(">>>> COME TO LIST ");
        ArrayList<String> list = new ArrayList<>();
        File file = new File(uri);
        File[] files = file.listFiles();
        for (File file2 :files){
            list.add(file2.getName());
        }
        return list.toString();
    }

    @RequestMapping("index")
    public ModelAndView index(Map<String,Object> paramMap){
        log.info(">>>>> COME TO INDEX");
        ArrayList<String> list =new ArrayList<>();
        File file =new File(uri);
        File[] files=file.listFiles();
        for (File file2:files){
            list.add(file2.getName());
        }
        paramMap.put("list",list);
        return new ModelAndView("index");
    }


}
