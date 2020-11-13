package top.itweek.wavefile.client;

import org.springframework.web.multipart.MultipartFile;
import top.itweek.wavefile.entity.VirtualFile;

import java.io.File;
import java.io.InputStream;

/**
 * Created by zhoubo on 2020/11/12.
 */
public interface ApiClient {

    VirtualFile uploadImg(MultipartFile file);

    VirtualFile uploadImg(File file);

    VirtualFile uploadImg(InputStream is, String key);

    boolean removeFile(String key);
}
