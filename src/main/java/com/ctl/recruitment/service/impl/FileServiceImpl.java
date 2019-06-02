package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.MyConfig;
import com.ctl.recruitment.service.FileService;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class FileServiceImpl implements FileService {

    @Override
    public String Upload(MultipartFile file) {
        String uploadFileName=file.getOriginalFilename();
        String suffix = "";


        assert uploadFileName != null;
        /*get suffix*/
        if (uploadFileName.contains(".")) {
            suffix = uploadFileName.substring(uploadFileName.lastIndexOf("."));
        }
        /*image path for web access*/
        String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*10000)+suffix;


        /*folder that contain image file.*/
        File folder=new File(MyConfig.DISK_PATH);
        if(!folder.exists()){
            System.out.println("Create Folder:"+folder.mkdirs());
        }

        try {
            file.transferTo(new File(MyConfig.DISK_PATH+fileName));
            /*Compress image*/
            Thumbnails.of(MyConfig.DISK_PATH+fileName)
                    .scale(1f)
                    .outputQuality(0.5f)
                    .toFile(MyConfig.DISK_PATH+fileName);
            return MyConfig.HOST+MyConfig.URL_PATH+fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
