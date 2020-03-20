package cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class FileUploadController {

    @RequestMapping("/fileUpload")
    public String handler(@RequestParam("uploadfile") List<MultipartFile> uploadfile, HttpServletRequest request) throws IOException {
        System.out.println("进入servlet");
        if(!uploadfile.isEmpty()&&uploadfile.size() > 0){
            //循环输出上传文件
            for(MultipartFile file : uploadfile){
                //获取上传文件原始名称
                String filename = file.getOriginalFilename();
                //设置保存目录
                String dirPath = request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                if(filePath.exists()){
                    filePath.mkdirs();
                }
                //重新命名上传文件名称
                String newFilename="1"+filename;
                System.out.println("上传成功");
                //完成文件上传
                file.transferTo(new File(dirPath+newFilename));
            }
        }
        return "success.jsp";
    }

    @RequestMapping("/one")
    public String testspring(){
        return "success.jsp";
    }
}
