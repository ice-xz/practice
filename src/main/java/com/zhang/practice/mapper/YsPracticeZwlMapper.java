package com.zhang.practice.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.api.R;
import com.zhang.practice.dto.PageDTO;
import com.zhang.practice.pojo.Result;
import com.zhang.practice.pojo.YsPracticeZwl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 实习表_张文亮 Mapper 接口
 * </p>
 *
 * @author zhangwenliang
 * @since 2022-07-13
 */
@Repository
@Mapper
@DS("master")
public interface YsPracticeZwlMapper extends BaseMapper<YsPracticeZwl> {
    /**
     * @author: 张文亮
     * @createTime: 2022/7/20 9:04
     * @description: 学生的分页查询
     * @param pageDTO
     * @return: java.util.List<com.zhang.practice.pojo.YsPracticeZwl>
     */
    List<YsPracticeZwl> PagedQuery(PageDTO pageDTO);
}
