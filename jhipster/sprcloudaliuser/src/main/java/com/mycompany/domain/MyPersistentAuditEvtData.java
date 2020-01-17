package com.mycompany.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("my_persistent_audit_evt_data")
@ApiModel(value="MyPersistentAuditEvtData对象", description="")
public class MyPersistentAuditEvtData implements Serializable {

    private static final long serialVersionUID=1L;

    private Long eventId;

    private String name;

    private String value;


}
