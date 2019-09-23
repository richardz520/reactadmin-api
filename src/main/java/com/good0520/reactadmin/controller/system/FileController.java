package com.good0520.reactadmin.controller.system;

import com.good0520.reactadmin.service.system.IFileService;
import com.good0520.reactadmin.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Good0520
 * @date 2019/9/19
 */
@RestController
@RequestMapping("/api/sys")
@Slf4j
public class FileController {

    @Value("${headImgDir}")
    private String headImgDir;

    @Autowired
    private IFileService iFileService;

    @PostMapping("/upLoadPic")
    public String savePic(MultipartFile image) {

        return iFileService.saveImg(image);
    }

    @RequestMapping("/image/{headimg}")
    public void renderPicture(@PathVariable("headimg") String headimg, HttpServletResponse response) {
        String path = headImgDir + headimg;
        try {
            byte[] bytes = FileUtil.toByteArray(path);
            if (bytes != null) {
                response.getOutputStream().write(bytes);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

}
