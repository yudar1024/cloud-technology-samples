package com.mycompany.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@TableName("my_date_time_wrapper")
@ApiModel(value="MyDateTimeWrapper对象", description="")
public class MyDateTimeWrapper implements Serializable {

    private static final long serialVersionUID=1L;

    private LocalDateTime instant;

    private LocalDateTime localDateTime;

    private LocalDateTime offsetDateTime;

    private LocalDateTime zonedDateTime;

    private LocalTime localTime;

    private LocalTime offsetTime;

    private LocalDate localDate;


}
