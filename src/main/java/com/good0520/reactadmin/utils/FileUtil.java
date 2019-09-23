package com.good0520.reactadmin.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileUtil {

    private static Logger log = LoggerFactory.getLogger(FileUtil.class);

    public static byte[] toByteArray(String filename) {

        File f = new File(filename);
        if (!f.exists()) {
            log.error("文件未找到！" + filename);
            return null;
        }
        FileChannel channel = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(f);
            channel = fs.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());
            while ((channel.read(byteBuffer)) > 0) {
            }
            return byteBuffer.array();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                channel.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
            try {
                fs.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        return null;
    }


}