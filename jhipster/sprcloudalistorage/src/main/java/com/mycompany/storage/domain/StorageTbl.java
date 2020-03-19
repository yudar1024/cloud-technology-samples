package com.mycompany.storage.domain;

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
 * @since 2019-12-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("storage_tbl")
@ApiModel(value="StorageTbl对象", description="")
public class StorageTbl implements Serializable {

    private static final long serialVersionUID=1L;

    private String commodityCode;

    private Integer count;


}
