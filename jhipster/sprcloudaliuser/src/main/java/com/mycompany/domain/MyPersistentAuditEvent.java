package com.mycompany.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("my_persistent_audit_event")
@ApiModel(value="MyPersistentAuditEvent对象", description="")
public class MyPersistentAuditEvent implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "event_id", type = IdType.AUTO)
    private Long eventId;

    private String principal;

    private LocalDateTime eventDate;

    private String eventType;


}
