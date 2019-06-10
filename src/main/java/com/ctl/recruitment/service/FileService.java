package com.ctl.recruitment.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String Upload(MultipartFile file);
    String UploadBase64Image(String image);
}
