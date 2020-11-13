package top.itweek.wavefile.persistence.beans;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.itweek.wavefile.entity.AbstractDO;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_config")
public class SysConfig extends AbstractDO {
    private String configKey;
    private String configValue;
}
