package com.wizz.sentencelib.beans;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName(value = "tbl_collection_relation")
public class CollectionRelation {
    private Integer id;
    private String uid;
    @TableField(value = "otherId")
    private Integer otherId;
}
