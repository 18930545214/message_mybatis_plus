package com.hwua.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@RestController
@RequestMapping("user")
public class UserController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过实体对象查询单条数据
     *
     * @param user 实体对象
     * @return 单条数据
     */
    @GetMapping()
    public R selectOne(User user) {
        return success(this.userService.login(user));
    }

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("selectAll")
    public R selectAll() {
        return success(this.userService.list());
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody User user) {
        return success(this.userService.save(user));
    }
}