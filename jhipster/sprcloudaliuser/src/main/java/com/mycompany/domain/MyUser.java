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
@TableName("my_user")
@ApiModel(value="MyUser对象", description="")
public class MyUser implements Serializable {

    private static final long serialVersionUID=1L;

    private String name;

    private Integer age;

    private String email;

    private String phone;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
