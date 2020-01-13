package com.mycompany.domain;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Databasechangeloglock对象", description="")
public class Databasechangeloglock implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID")
    private Integer id;

    @TableField("LOCKED")
    private Boolean locked;

    @TableField("LOCKGRANTED")
    private LocalDateTime lockgranted;

    @TableField("LOCKEDBY")
    private String lockedby;


}
