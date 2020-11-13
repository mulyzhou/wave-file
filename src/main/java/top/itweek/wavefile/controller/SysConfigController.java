package top.itweek.wavefile.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RestController;
import top.itweek.wavefile.service.SysConfigService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhoubo
 * @since 2020-11-12
 */
@RestController
@RequestMapping("/sysConfig")
public class SysConfigController {

    @Autowired
    private SysConfigService sysConfigService;

    @GetMapping("/list")
    public Object list(){
        return sysConfigService.list(new QueryWrapper<>());
    }

}

