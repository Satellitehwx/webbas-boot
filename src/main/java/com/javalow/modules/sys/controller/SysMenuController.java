package com.javalow.modules.sys.controller;


import com.javalow.common.utils.Result;
import com.javalow.modules.sys.domain.SysMenu;
import com.javalow.modules.sys.service.ShiroService;
import com.javalow.modules.sys.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author Satellite
 * @since 2018-11-21
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private ShiroService shiroService;

    /**
     * 导航菜单
     *
     * @return Result
     */
    @GetMapping("/nav")
    public Result nav() {
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        return Result.ok().put("menuList", menuList).put("permissions", permissions);
    }


    /**
     * 所有菜单列表
     *
     * @return
     */
    public List<SysMenu> list() {
        List<SysMenu> menuList = sysMenuService.list(null);
        for (SysMenu menu : menuList) {
            SysMenu parentMenu = sysMenuService.getById(menu.getParentId());
            if (parentMenu != null) {
                menu.setParentName(parentMenu.getName());
            }
        }
        return menuList;
    }

}

