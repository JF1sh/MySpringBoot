package cn.lijy.demo.FileUpDown.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * @program: cn.lijy.demo.FileUpDown.model
 * @description:
 * @author: JF1sh
 * @create: 2019-12-26 16:29
 **/
public class FileModel {

    private String id;
    private String name;
    private String time;
    private String path;
    private MultipartFile file;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", path='" + path + '\'' +
                ", file=" + file +
                '}';
    }
}
