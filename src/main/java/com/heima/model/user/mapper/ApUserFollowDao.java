package com.heima.model.user.mapper;

import com.heima.model.user.pojos.ApUserFollow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * APP用户关注信息表 Mapper 接口
 * </p>
 *
 * @author SaddyFire
 * @since 2022-01-23
 */
@Mapper
public interface ApUserFollowDao extends BaseMapper<ApUserFollow> {

}
