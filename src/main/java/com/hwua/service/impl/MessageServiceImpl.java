package com.hwua.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hwua.dao.MessageDao;
import com.hwua.entity.Message;
import com.hwua.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * (Message)表服务实现类
 *
 * @author 马涛
 * @since 2020-03-21 21:52:01
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

}