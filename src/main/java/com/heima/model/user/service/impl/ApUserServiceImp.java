package com.heima.model.user.service.impl;

import com.heima.model.user.pojos.ApUser;
import com.heima.model.user.mapper.ApUserDao;
import com.heima.model.user.service.ApUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * APP用户信息表 服务实现类
 * </p>
 *
 * @author SaddyFire
 * @since 2022-01-23
 */
@Service
public class ApUserServiceImp extends ServiceImpl<ApUserDao, ApUser> implements ApUserService {

}
