package com.ctl.recruitment.controller;

import com.ctl.recruitment.pojo.result.ResultType;
import com.ctl.recruitment.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private final
    FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @RequestMapping("/upload")
    public ResultType upload(MultipartFile file){
        System.out.println("FileControllerCalled");
        try{
            return ResultType.Success(fileService.Upload(file));
        }catch (Exception e){
            e.printStackTrace();
            return ResultType.Error("Server: 文件上传失败");
        }
    }
}
