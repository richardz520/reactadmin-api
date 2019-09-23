package com.good0520.reactadmin.service.impl.system;

import com.alibaba.druid.util.StringUtils;
import com.good0520.reactadmin.service.system.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author Good0520
 * @date 2019/9/19
 */
@Service
@Transactional
public class FileServiceImpl implements IFileService {

    @Value("${headImgDir}")
    private String headImgDir;


    @Override
    public String saveImg(MultipartFile image) {
        String fileName = "";
        try {
            File dir = Paths.get(headImgDir).toFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String ext = "";
            if (!StringUtils.isEmpty(image.getOriginalFilename())) {
                ext = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf(".") + 1);
            }
            fileName = UUID.randomUUID().toString() + "." + ext;
            File realFile = Paths.get(headImgDir, fileName).toFile();
            if (!realFile.exists()) {
                realFile.createNewFile();
            }
            image.transferTo(realFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
