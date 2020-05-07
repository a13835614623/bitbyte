package com.zzk.bitbyte.controller;

import com.zzk.bitbyte.PathConfig;
import com.zzk.bitbyte.util.ResponseState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * @Author: zzk
 * @Date: 2020-05-07 13:52
 */
@RestController
@RequestMapping("/article/pic")
public class ArticleImageController {

    @Autowired
    private PathConfig pathConfig;

    @RequestMapping("/upload")
    public ResponseState upload(@RequestParam("file") MultipartFile imgFile) throws Exception {
        // 原图片名称
        String oldFileName = null;

        if (imgFile == null || (oldFileName = imgFile.getOriginalFilename()) == null
                || oldFileName.length() > 3 << 20) {
            throw new Exception("图片上传失败");
        }
        // 新图片名称
        String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));

        File file = new File(newFileName);
        // 将内存中的图片写入磁盘
        imgFile.transferTo(file);
        return ResponseState.success("上传成功!").setData(newFileName);
    }

    @RequestMapping(value = "/get")
    public void getPic(@RequestParam("name") String article_pic, HttpServletResponse response)
            throws Exception {
        if (article_pic == null || article_pic.equals("undefined") || article_pic.equals("")) {
            throw new Exception("此图片不存在");
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(pathConfig.getPicPath() + article_pic));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte bys[] = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }}
