package com.hwua.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwua.dao.MessageDao;
import com.hwua.dao.UserDao;
import com.hwua.entity.Message;
import com.hwua.entity.User;
import com.hwua.service.MessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * (Message)表服务实现类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

    @Resource
    private MessageDao messageDao;
    @Resource
    private UserDao userDao;

    /**
     * 查看一条短消息
     * @param id 主键
     * @return 单条数据
     */
    @Transactional
    @Override
    public Message getById(Serializable id) {
        Message msg = new Message();
        Message message = messageDao.selectById(id);
        User user = userDao.selectById(message.getSendId());
        message.setUser(user);
        msg.setId(message.getId());
        msg.setState(0);
        int i = messageDao.updateById(msg);
        if (i>0){
            return message;
        }
        return null;
    }
}