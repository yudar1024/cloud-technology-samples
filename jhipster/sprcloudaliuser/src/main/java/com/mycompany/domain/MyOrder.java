package com.mycompany.domain;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("my_order")
@ApiModel(value="MyOrder对象", description="")
public class MyOrder implements Serializable {

    private static final long serialVersionUID=1L;

    private Long orderId;

    private Long userId;

    private Long productId;

    private Integer orderNo;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
