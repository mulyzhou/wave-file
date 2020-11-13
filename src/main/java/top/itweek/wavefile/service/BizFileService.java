package top.itweek.wavefile.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.itweek.wavefile.entity.File;
import top.itweek.wavefile.persistence.beans.BizFile;


public interface BizFileService extends IService<BizFile> {

    File selectFileByPathAndUploadType(String filePath, String uploadType);


}
