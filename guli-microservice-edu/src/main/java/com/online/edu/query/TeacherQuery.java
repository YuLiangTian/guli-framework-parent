package com.online.edu.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName TeacherQuery
 * @Description TODO
 * @Author User
 * @Date 2020/3/13 16:19
 * @Version 1.0
 * @Desc
 */
@ApiModel(value = "Teacher查询对象", description = "讲师查询对象封装")
@Data
public class TeacherQuery implements Serializable {

    private static final long serialVersionUID = 1l;

    @ApiModelProperty(value = "讲师名称,模糊查询",example = "张三")
    private String name;

    @ApiModelProperty(value = "讲师等级,头衔 1.高级讲师  2首席讲师",example = "0")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间",example = "2019-01-01 10:10:10")
    private String begin;   //注意,这里使用的是String类型，前端传过来的数据无需进行类型转换

    @ApiModelProperty(value = "查询结束时间",example = "2019-12-01 10:10:10")
    private String end;
}
