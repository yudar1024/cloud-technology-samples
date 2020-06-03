package com.mycompany.alicloudapp.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("storage_tbl")
@ApiModel(value="StorageTbl对象", description="")
public class StorageTbl implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty
    @TableId
    private long id;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;


    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StorageTbl{" +
                "id=" + id +
                ", commodityCode='" + commodityCode + '\'' +
                ", count=" + count +
                '}';
    }
}
