package com.hwua.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

import static javax.swing.Action.DEFAULT;

/**
 * (Message)表实体类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@SuppressWarnings("serial")
@Data
public class Message extends Model<Message> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long sendId;

    private String title;

    private String msgContent;
    
    private Integer state;

    private Long receiveId;

    @TableField(value = "MSG_CREATE_DATE")
    private String msgCreateDate;

    @TableField(exist = false)
    private User user;

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