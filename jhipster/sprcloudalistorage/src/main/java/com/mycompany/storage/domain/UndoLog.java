package com.mycompany.storage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.sql.Blob;
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
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("undo_log")
@ApiModel(value="UndoLog对象", description="")
public class UndoLog implements Serializable {

    private static final long serialVersionUID=1L;

    private Long branchId;

    private String xid;

    private String context;

    private Blob rollbackInfo;

    private Integer logStatus;

    private LocalDateTime logCreated;

    private LocalDateTime logModified;

    private String ext;


}
