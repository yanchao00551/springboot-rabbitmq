package com.power.modules.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.power.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 */
public interface SysLogService extends IService<SysLogEntity> {
    Integer insertSysLog(SysLogEntity sysLogEntity);
}
