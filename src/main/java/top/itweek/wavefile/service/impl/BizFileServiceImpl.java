package top.itweek.wavefile.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.itweek.wavefile.entity.File;
import top.itweek.wavefile.persistence.beans.BizFile;
import top.itweek.wavefile.persistence.mapper.IBizFileMapper;
import top.itweek.wavefile.service.BizFileService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubo
 * @since 2020-11-12
 */
@Service
public class BizFileServiceImpl extends ServiceImpl<IBizFileMapper, BizFile> implements BizFileService {

    @Override
    public File selectFileByPathAndUploadType(String filePath, String uploadType) {
        return null;
    }
}
