package com.mycompany.domain;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author roger
 * @since 2019-11-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Databasechangelog对象", description="")
public class Databasechangelog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("ID")
    private String id;

    @TableField("AUTHOR")
    private String author;

    @TableField("FILENAME")
    private String filename;

    @TableField("DATEEXECUTED")
    private LocalDateTime dateexecuted;

    @TableField("ORDEREXECUTED")
    private Integer orderexecuted;

    @TableField("EXECTYPE")
    private String exectype;

    @TableField("MD5SUM")
    private String md5sum;

    @TableField("DESCRIPTION")
    private String description;

    @TableField("COMMENTS")
    private String comments;

    @TableField("TAG")
    private String tag;

    @TableField("LIQUIBASE")
    private String liquibase;

    @TableField("CONTEXTS")
    private String contexts;

    @TableField("LABELS")
    private String labels;

    @TableField("DEPLOYMENT_ID")
    private String deploymentId;


}
