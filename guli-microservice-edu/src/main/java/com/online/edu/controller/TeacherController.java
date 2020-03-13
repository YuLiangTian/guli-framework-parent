package com.online.edu.controller;




import com.guli.common.vo.R;
import com.online.edu.entity.Teacher;
import com.online.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Helen
 * @since 2020-03-12
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有讲师的功能
    @ApiOperation(value = "查询所有讲师列表")
    @GetMapping("/list")
    public R getAllTeacherList(){
        //调用teacherService里面的方法
        val list = teacherService.list(null);
        return R.ok().data("items",list);
    }

    @ApiOperation(value = "根据Id删除讲师")
    @DeleteMapping("/delete/{id}")
    public R removeByid(@ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable("id") String id){
        val b = teacherService.removeById(id);
        if(b){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("删除失败");
        }
    }
}

