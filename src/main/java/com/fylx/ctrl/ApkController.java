package com.fylx.ctrl;

import com.fylx.Result;
import com.fylx.entity.Apk;
import com.fylx.mapper.ApkMapper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;

@Controller
public class ApkController {
    @Autowired
    private ApkMapper apkMapper;

    @Value("${filepath}")
    private String filepath;

    @ResponseBody
    @GetMapping("/api/apks/latest")
    public Result<Apk> getLatest() {
        Result<Apk> result = new Result<>();
        try {
            Apk apk = apkMapper.selectLatest();
            result.setCode(200);
            result.setData(apk);
            result.setDesc("success");
        } catch (Exception ex) {
            result.setCode(201);
            result.setDesc(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/files/apks/friend.apk")
    public ResponseEntity<byte[]> downloadLatestApk() {
        try {
            Apk apk = apkMapper.selectLatest();
            File file = new File(filepath, apk.getPath());
            HttpHeaders headers = new HttpHeaders();
            //告诉浏览器执行下载的操作，“attachment”告诉了浏览器进行下载,下载的文件 文件名为 downloadFileName
            headers.setContentDispositionFormData("attachment", "friend.apk");
            //设置响应方式为二进制，以二进制流传输
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            byte[] bytes = FileUtils.readFileToByteArray(file);
            return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
        } catch (Exception ex) {
            return null;
        }
    }
}
