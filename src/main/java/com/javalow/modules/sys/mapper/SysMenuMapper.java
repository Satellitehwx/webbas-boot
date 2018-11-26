package com.javalow.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javalow.modules.sys.domain.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author Satellite
 * @since 2018-11-21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenu> queryListParentId(Long parentId);

}
