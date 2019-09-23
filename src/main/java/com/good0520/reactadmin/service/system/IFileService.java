package com.good0520.reactadmin.service.system;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Good0520
 * @date 2019/9/19
 */
public interface IFileService {

    String saveImg(MultipartFile image);


}
