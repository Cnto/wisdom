package com.wisdom.core.service;


import com.wisdom.common.dto.core.Page;
import com.wisdom.common.dto.core.entity.RemindTemplateEntity;
import com.wisdom.common.dto.core.notification.NotificationMessageDTO;
import com.wisdom.core.mapper.RemindMapper;
import com.wisdom.core.mapper.RemindTemplateMapper;
import com.wisdom.core.mapper.RemindUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/8/17.
 */
@Service
@Transactional(readOnly = false)
public class RemindService {

    @Autowired
    private RemindMapper remindMapper;

    @Autowired
    private RemindUserMapper remindUserMapper;

    @Autowired
    private RemindTemplateMapper remindTemplateMapper;

    public List<NotificationMessageDTO> getRemindListBySysElderUserID(String sysElderUserID, Integer limit) {
        return remindMapper.getRemindListBySysElderUserID(sysElderUserID,limit);
    }

    public Integer getRemindByUnread(String sysElderUserID) {
        return remindUserMapper.getRemindByUnread(sysElderUserID);
    }

    public NotificationMessageDTO getRemindByID(String remindID) {
        return remindMapper.getRemindByID(remindID);
    }

    public void updateRemindStatus(String remindID) {
        remindUserMapper.updateRemindUser(remindID);
    }

    //********机构版接口
    public Integer addRemindTemplate(RemindTemplateEntity remindTemplateEntity) {
        return remindTemplateMapper.addRemindTemplate(remindTemplateEntity);
    }

    public RemindTemplateEntity getRemindTemplateEntityByID(String remindTemplateID) {
        return remindTemplateMapper.getRemindTemplateEntityByID(remindTemplateID);
    }

    public Page getRemindTemplateEntityList(String title, String sartUpdateDate, String endUpdateDate, Page page) {
        return remindTemplateMapper.getRemindTemplateEntityList(title,sartUpdateDate,endUpdateDate,page);
    }

    public Integer updateRemindTemplate(RemindTemplateEntity remindTemplateEntity) {
        return remindTemplateMapper.updateRemindTemplate(remindTemplateEntity);
    }

    public Integer deleteRemindTemplate(String id) {
        return remindTemplateMapper.deleteRemindTemplate(id);
    }
}
