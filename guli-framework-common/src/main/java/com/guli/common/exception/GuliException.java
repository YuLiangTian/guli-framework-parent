package com.guli.common.exception;

import com.guli.common.constants.ResultCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @ClassName GuliException
 * @Description TODO
 * @Author User
 * @Date 2020/3/14 8:22
 * @Version 1.0
 * @Desc    自定义异常  -- 参数错误
 */
@ApiModel("全局异常")
@Data
public class GuliException extends RuntimeException {

    //状态码
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:28 2020/3/14
     * @Param [message, code]
     * @Desc 接受信息和状态码
     * @return
     **/
    public GuliException(String message,Integer code){
        super(message);
        this.code = code;
    }

    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:30 2020/3/14
     * @Param [resultCodeEnum]
     * @Desc    接受枚举类型
     * @return
     **/
    public GuliException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

}
