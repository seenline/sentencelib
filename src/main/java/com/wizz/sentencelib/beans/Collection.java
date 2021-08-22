package com.wizz.sentencelib.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tbl_collection")
@Data
public class Collection {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "uid")
    private String uid;
    @TableField(value = "sid")
    private Integer sid;
    @TableField(value = "collectedTime")
    private String datetime;
}
