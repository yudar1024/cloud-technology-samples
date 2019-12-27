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
 * @since 2019-12-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_tbl")
@ApiModel(value="OrderTbl对象", description="")
public class OrderTbl implements Serializable {

    private static final long serialVersionUID=1L;

    private String userId;

    private String commodityCode;

    private Integer count;

    private Integer money;


}
