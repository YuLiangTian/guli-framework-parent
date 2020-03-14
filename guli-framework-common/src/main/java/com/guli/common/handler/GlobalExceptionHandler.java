package com.guli.common.handler;


import com.fasterxml.jackson.core.JsonParseException;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.common.vo.R;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:41 2020/3/14
     * @Param [e] 
     * @Desc   全部异常处理
     * @return com.guli.common.vo.R
     **/
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        //事务回滚
        e.printStackTrace();
        return R.error();
    }

    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:40 2020/3/14
     * @Param [e] 
     * @Desc    sql语句错误异常处理
     * @return com.guli.common.vo.R
     **/
    @ExceptionHandler(BadSqlGrammarException.class)
    @ResponseBody
    public R error(BadSqlGrammarException e){
        //事务回滚
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.BAD_SQL_GRAMMAR);
    }

    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:40 2020/3/14
     * @Param
     * @Desc 请求异常 -- json解析异常
     * @return
     **/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public R error(JsonParseException e){
        //事务回滚
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.JSON_PARSE_ERROR);
    }
    
    /*
     * @Author tianyuliang
     * @Description //TODO
     * @Date 8:39 2020/3/14
     * @Param [e] 
     * @Desc    自定义异常 -- 参数异常处理
     * @return com.guli.common.vo.R
     **/
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public R error(GuliException e){
        //事务回滚
        e.printStackTrace();
        return R.setResult(ResultCodeEnum.PARAM_ERROR);
    }
}
