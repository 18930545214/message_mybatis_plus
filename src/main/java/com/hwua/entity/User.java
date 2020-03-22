package com.hwua.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (User)表实体类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@SuppressWarnings("serial")
@Data
public class User extends Model<User> {

    @TableId(type = IdType.AUTO)
    private Long id = 0L;
    
    private String name;
    
    private String pwd;
    
    private String email;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
    }