package com.online.edu.controller;




import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.constants.ResultCodeEnum;
import com.guli.common.exception.GuliException;
import com.guli.common.vo.R;
import com.online.edu.entity.Teacher;
import com.online.edu.query.TeacherQuery;
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

    @ApiOperation(value = "分页查询讲师信息")
    @GetMapping("list/{page}/{limit}")
    public R pageList(
            @ApiParam(name = "page",value = "当前页码",required = true)
            @PathVariable("page") Long page,
            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable("limit") Long limit){

        Page<Teacher> pageParm = new Page<>(page,limit);

        teacherService.page(pageParm,null);
        val records = pageParm.getRecords();
        val total = pageParm.getTotal();

        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("条件分页查询讲师信息")
    @GetMapping("page/{page}/{limit}")
    public R pageQuery(
            @ApiParam(name = "page",value = "当前页",required = true)
            @PathVariable("page") Long page,

            @ApiParam(name = "limit",value = "每页记录数",required = true)
            @PathVariable("limit") Long limit,

            @ApiParam(name = "teacherQuery", value = "查询对象", required = false)
            TeacherQuery teacherQuery){
        if(page<=0 || limit>=0){
            throw new GuliException(ResultCodeEnum.PARAM_ERROR);
        }
        Page<Teacher> pageParm = new Page<>(page,limit);

        teacherService.pageQuery(pageParm,teacherQuery);
        val records = pageParm.getRecords();
        val total = pageParm.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    @ApiOperation("添加讲师")
    @PostMapping
    public R addTeacher(
            @ApiParam(name="teacher",value = "讲师信息",required = true)
            @RequestBody Teacher teacher){
        //判断是否添加成功
        if(teacherService.save(teacher)){
            return R.ok().message("添加成功");
        }else{
            return R.error().message("添加失败");
        }
    }


    @ApiOperation("查询讲师信息")
    @GetMapping("/findteacher/{id}")
    public R findTeacherById(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable("id") String id){

        val teacher = teacherService.getById(id);
        return R.ok().data("item",teacher);
    }


    @ApiOperation("修改讲师信息")
    @PutMapping("/modify/{id}")
    public R modifyTeacher(
            @ApiParam(name = "id",value = "讲师id",required = true)
            @PathVariable("id") String id,
            @ApiParam(name = "teacher",value = "讲师对象",required = true)
            @RequestBody Teacher teacher){
        teacher.setId(id);
        if(teacherService.updateById(teacher)){
            return R.ok().message("修改成功");
        }else{
            return R.error().message("修改失败");
        }
    }

}

