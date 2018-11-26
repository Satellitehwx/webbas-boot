package com.javalow.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.javalow.modules.sys.domain.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Satellite
 * @since 2018-11-21
 */
public interface SysMenuService extends IService<SysMenu> {

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    List<SysMenu> queryListParentId(Long parentId);


    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     */
    List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList);

    /**
     * 获取用户菜单列表
     *
     * @param userId 用户id
     * @return list
     */
    List<SysMenu> getUserMenuList(Long userId);


}
