package top.itweek.wavefile.persistence.beans;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.itweek.wavefile.entity.AbstractDO;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("biz_file")
public class BizFile extends AbstractDO {
    public Long size;
    public String suffix;
    public Integer width;
    public Integer height;
    private Long userId;
    private String originalFileName;
    private String filePath;
    private String fullFilePath;
    private String fileHash;
    private String uploadType;
    private Date uploadStartTime;
    private Date uploadEndTime;
    private String storageType;
}
