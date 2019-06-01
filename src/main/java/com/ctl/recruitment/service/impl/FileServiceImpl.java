package com.ctl.recruitment.service.impl;

import com.ctl.recruitment.service.FileService;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class FileServiceImpl implements FileService {

    @Override
    public String Upload(MultipartFile file) {
        return null;
    }
}
