package com.hwua.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hwua.entity.Message;
import com.hwua.service.MessageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (Message)表控制层
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@RestController
@RequestMapping("message")
public class MessageController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MessageService messageService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Message> page,Message message) {
        return success(this.messageService.page(page,new QueryWrapper<>(message).orderByDesc("MSG_CREATE_DATE")));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 数据模型
     */
    @GetMapping("{id}")
    public ModelAndView selectOne(@PathVariable Serializable id) {
        Message message = messageService.getById(id);
        return new ModelAndView("/pages/readMsg").addObject("message",message);
    }

    /**
     * 新增数据
     *
     * @param message 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Message message) {
        System.out.println(message);
        return success(this.messageService.save(message));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(String id) {
        return success(this.messageService.removeById(id));
    }
}