package com.hwua.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * (Message)表实体类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@SuppressWarnings("serial")
@Data
public class Message extends Model<Message> {
    
    private Long id;

    private Long sendId;

    private String title;

    private String msgContent;
    
    private Integer state;

    private Long receiveId;

    @TableField(value = "msg_Create_Date")
    private String msgCreateDate;

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