package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName ConsultantMessages.java
 * @Description TODO
 * @createTime 2022年03月04日 09:10:00
 */
@ApiModel(value = "conslutatn_messages")
@Entity(name = "咨询师和咨询者聊天记录类")
public class ConsultantMessages {
    @Id
    private int consult_message_id;         /*咨询内容id*/
    private Date consult_date;              /*咨询日期*/
    private String content;                 /*消息内容*/
    private String message_type;            /*消息类型*/
    private String fromUserId;              /*发送者id*/
    private String toUserId;                /*接收者id*/
}
