package com.wizz.sentencelib.beans;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author seenline
 * @data 2021/8/2 14:41
 * @description
 */
@Data
@Accessors(chain = true)
@TableName(value = "tbl_user")
@NoArgsConstructor
public class User {
    @TableId
    private Integer id;
    private String avatar;
    private String username;
    private String uid;
}
