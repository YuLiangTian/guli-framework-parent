package com.online.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.online.edu.entity.Teacher;
import com.online.edu.query.TeacherQuery;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author Helen
 * @since 2020-03-12
 */
@Component
public interface TeacherService extends IService<Teacher> {

    void pageQuery(Page<Teacher> page, TeacherQuery teacherQuery);

}
