package com.online.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.online.edu.entity.Teacher;
import com.online.edu.mapper.TeacherMapper;
import com.online.edu.query.TeacherQuery;
import com.online.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.management.Query;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Helen
 * @since 2020-03-12
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public void pageQuery(Page<Teacher> page, TeacherQuery teacherQuery) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        if(teacherQuery==null){
            baseMapper.selectPage(page,queryWrapper);
            return;
        }
        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }

        if(!StringUtils.isEmpty(level)){
            queryWrapper.eq("level",level);
        }

        if(!StringUtils.isEmpty(begin)){
            queryWrapper.ge("gmt_create",begin);
        }

        if(!StringUtils.isEmpty(end)){
            queryWrapper.le("gmt_create",end);
        }
        baseMapper.selectPage(page,queryWrapper);
    }
}
