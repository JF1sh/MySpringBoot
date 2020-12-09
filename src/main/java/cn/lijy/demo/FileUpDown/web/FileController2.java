package cn.lijy.demo.FileUpDown.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
@RequestMapping("file")
@Slf4j
public class FileController2 {

    final String uri = "/Users/jf1sh/temp/Downlaod-test/";

    @RequestMapping("/index1")
    public String index1() {
        return "file";
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public String uploading(@RequestParam("file") MultipartFile file) {
        File targetFile = new File(uri);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        String filename= file.getOriginalFilename();
        try (FileOutputStream out = new FileOutputStream(uri + filename); // try块退出时会默认调用out.close()方法
        ) {
//            File file1 =new File(uri+filename);  //设置文件路径
//            file.transferTo(file1);//将file保存到file1
            System.out.println(file.getBytes());
            out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件上传失败!");
            return "uploading failure";
        }
        log.info("文件上传成功!");
        return "uploading success";
    }

    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename = "1.txt";
        String filePath = "/Users/jf1sh/temp/Downlaod-test";
        File file = new File(filePath + "/" + filename);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename, "utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try (
                    FileInputStream fis = new FileInputStream(file);
                    BufferedInputStream bis = new BufferedInputStream(fis);
            ) { //在try块退出时，会默认调用close()方法
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
