package top.itweek.wavefile.service.impl;


import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.itweek.wavefile.contanst.DateConst;
import top.itweek.wavefile.enums.ConfigKeyEnum;
import top.itweek.wavefile.persistence.beans.SysConfig;
import top.itweek.wavefile.persistence.mapper.ISysConfigMapper;
import top.itweek.wavefile.service.SysConfigService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhoubo
 * @since 2020-11-12
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<ISysConfigMapper, SysConfig> implements SysConfigService {

    @Override
    public Map<String, Object> getConfigs() {
        List<SysConfig> list = this.baseMapper.selectList(new QueryWrapper<>());
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        String updateTimeKey = ConfigKeyEnum.UPDATE_TIME.getKey();
        Map<String, Object> res = new HashMap<>();
        res.put(updateTimeKey, DateUtil.parse("2019-01-01 00:00:00", DateConst.YYYY_MM_DD_HH_MM_SS_EN));
        list.forEach((sysConfig) -> {
            res.put(String.valueOf(sysConfig.getConfigKey()), sysConfig.getConfigValue());
            if (sysConfig.getUpdateTime().after(((Date) res.get(updateTimeKey)))) {
                res.put(updateTimeKey, sysConfig.getUpdateTime());
            }
        });
        String storageType = (String) res.get(ConfigKeyEnum.STORAGE_TYPE.getKey());
        if ("local".equalsIgnoreCase(storageType)) {
            res.put("fileStoragePath", res.get(ConfigKeyEnum.LOCAL_FILE_URL.getKey()));
        } else if ("qiniu".equalsIgnoreCase(storageType)) {
            res.put("fileStoragePath", res.get(ConfigKeyEnum.QINIU_BASE_PATH.getKey()));
        } else if ("aliyun".equalsIgnoreCase(storageType)) {
            res.put("fileStoragePath", res.get(ConfigKeyEnum.ALIYUN_FILE_URL.getKey()));
        }
        return res;
    }
}
