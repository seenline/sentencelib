package com.wizz.sentencelib.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author seenline
 * @date 2021/8/11 12:18
 * @description
 */
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tbl_askinformation")
@Data
public class AskInformation {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "uid")
    private String uid;
    @TableField(value = "content")
    private String content;
    @TableField(value = "createtime")
    private String createTime;

}
