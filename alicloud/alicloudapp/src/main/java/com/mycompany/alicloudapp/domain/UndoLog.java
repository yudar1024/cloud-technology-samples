package com.mycompany.alicloudapp.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.sql.Blob;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author roger
 * @since 2020-05-15
 */
@TableName("undo_log")
@ApiModel(value="UndoLog对象", description="")
public class UndoLog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("branch_id")
    private Long branchId;

    @TableField("xid")
    private String xid;

    @TableField("context")
    private String context;

    @TableField("rollback_info")
    private Blob rollbackInfo;

    @TableField("log_status")
    private Integer logStatus;

    @TableField("log_created")
    private LocalDateTime logCreated;

    @TableField("log_modified")
    private LocalDateTime logModified;

    @TableField("ext")
    private String ext;


    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Blob getRollbackInfo() {
        return rollbackInfo;
    }

    public void setRollbackInfo(Blob rollbackInfo) {
        this.rollbackInfo = rollbackInfo;
    }

    public Integer getLogStatus() {
        return logStatus;
    }

    public void setLogStatus(Integer logStatus) {
        this.logStatus = logStatus;
    }

    public LocalDateTime getLogCreated() {
        return logCreated;
    }

    public void setLogCreated(LocalDateTime logCreated) {
        this.logCreated = logCreated;
    }

    public LocalDateTime getLogModified() {
        return logModified;
    }

    public void setLogModified(LocalDateTime logModified) {
        this.logModified = logModified;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "UndoLog{" +
        "branchId=" + branchId +
        ", xid=" + xid +
        ", context=" + context +
        ", rollbackInfo=" + rollbackInfo +
        ", logStatus=" + logStatus +
        ", logCreated=" + logCreated +
        ", logModified=" + logModified +
        ", ext=" + ext +
        "}";
    }
}
