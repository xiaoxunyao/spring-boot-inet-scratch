package com.inet.code.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 上传的项目的管理模块
 * </p>
 *
 * @author HCY
 * @since 2020-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_production")
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作品uuid
     */
    @TableId(value = "production_uuid",type = IdType.UUID)
    private String productionUuid;

    /**
     * 项目的名字
     */
    @TableField(value = "production_name")
    private String productionName;

    /**
     * 封面的URL地址
     */
    @TableField(value = "production_cover")
    private String productionCover;

    /**
     * 项目的地址
     */
    @TableField(value = "production_url")
    private String productionUrl;

    /**
     * 作品的说明(备注)
     */
    @TableField(value = "production_remark")
    private String productionRemark;

    /**
     * 作品操作说明
     */
    @TableField(value = "production_oi")
    private String productionOi;

    /**
     * 作品的类型
     */
    @TableField(value = "production_type")
    private String productionType;

    /**
     * 作品是否允许改编
     */
    @TableField(value = "production_recompose")
    private Boolean productionRecompose;

    /**
     * 作品是发布还是草稿
     */
    @TableField(value = "production_issue")
    private Boolean productionIssue;

    /**
     * 创建时间
     */
    @TableField(value = "production_creation")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date productionCreation;

    /**
     * 修改时间
     */
    @TableField(value = "production_modification",update = "NOW()",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date productionModification;


}
