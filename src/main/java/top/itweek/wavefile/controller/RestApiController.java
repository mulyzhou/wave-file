package top.itweek.wavefile.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.itweek.wavefile.entity.ResponseVO;
import top.itweek.wavefile.entity.VirtualFile;
import top.itweek.wavefile.enums.FileUploadType;
import top.itweek.wavefile.uploader.FileUploader;
import top.itweek.wavefile.uploader.GlobalFileUploader;
import top.itweek.wavefile.util.ResultUtil;


@RestController
@RequestMapping("/api")
public class RestApiController {


    @PostMapping("/uploadFile")
    public ResponseVO uploadFile(@RequestParam("file") MultipartFile file) {
        FileUploader uploader = new GlobalFileUploader();
        VirtualFile virtualFile = uploader.upload(file, FileUploadType.SIMPLE.getPath(), true);
        return ResultUtil.success("图片上传成功", virtualFile.getFullFilePath());
    }


}
