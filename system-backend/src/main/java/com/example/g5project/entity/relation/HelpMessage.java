package com.example.g5project.entity.relation;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author Hu Zirui
 * @version 1.0.0
 * @ClassName HelpMessage.java
 * @Description TODO
 * @createTime 2022年03月04日 09:11:00
 */

@ApiModel(value = "help_message")
@Entity(name = "咨询师和督导求助的聊天记录类")
public class HelpMessage {
    @Id
    private int help_message_id;        /*咨询内容id*/
    private Date consult_date;          /*咨询日期*/
    private String content;             /*消息内容*/
    private String message_type;        /*消息类型*/
    private int fromUserId;             /*发送者id*/
    private int toUserId;               /*接收者id*/
}
