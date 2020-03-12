package com.online.edu.controller;




import com.online.edu.entity.Teacher;
import com.online.edu.service.TeacherService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Helen
 * @since 2020-03-12
 */
@RestController
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有讲师的功能
    @GetMapping("/list")
    public List<Teacher> getAllTeacherList(){

        //调用teacherService里面的方法
        val list = teacherService.list(null);

        return list;
    }

}

