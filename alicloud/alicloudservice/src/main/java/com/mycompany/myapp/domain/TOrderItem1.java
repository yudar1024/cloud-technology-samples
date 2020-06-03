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
 * @since 2020-06-03
 */
@TableName("t_order_item_1")
@ApiModel(value="TOrderItem1对象", description="")
public class TOrderItem1 implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("order_item_id")
    private Long orderItemId;

    @TableField("order_id")
    private Long orderId;

    @TableField("user_id")
    private Integer userId;

    @TableField("status")
    private String status;


    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TOrderItem1{" +
        "orderItemId=" + orderItemId +
        ", orderId=" + orderId +
        ", userId=" + userId +
        ", status=" + status +
        "}";
    }
}
