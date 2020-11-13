package top.itweek.wavefile.service;


import com.baomidou.mybatisplus.extension.service.IService;
import top.itweek.wavefile.persistence.beans.SysConfig;

import java.util.Map;


public interface SysConfigService extends IService<SysConfig> {

    /**
     * 获取系统配置
     *
     * @return
     */
    Map<String, Object> getConfigs();


}
