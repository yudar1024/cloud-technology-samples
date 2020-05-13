package com.mycompany.myapp.domain;

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
 * @since 2020-05-13
 */
@TableName("order_tbl")
@ApiModel(value="OrderTbl对象", description="")
public class OrderTbl implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("user_id")
    @ApiModelProperty(notes = "用户ID")
    private String userId;

    @TableField("commodity_code")
    @ApiModelProperty(notes = "商品代码")
    private String commodityCode;

    @TableField("count")
    @ApiModelProperty(notes = "商品数量")
    private Integer count;

    @ApiModelProperty(notes = "商品价格")
    @TableField("money")
    private Integer money;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "OrderTbl{" +
        "userId=" + userId +
        ", commodityCode=" + commodityCode +
        ", count=" + count +
        ", money=" + money +
        "}";
    }
}
