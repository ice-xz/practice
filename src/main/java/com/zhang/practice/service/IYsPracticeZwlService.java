package com.zhang.practice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhang.practice.dto.PageDTO;
import com.zhang.practice.dto.YsPracticeZwlDTO;
import com.zhang.practice.dto.YsPracticeZwlUpdateDTO;
import com.zhang.practice.pojo.Result;
import com.zhang.practice.pojo.YsPracticeZwl;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实习表_张文亮 服务类
 * </p>
 *
 * @author zhangwenliang
 * @since 2022-07-13
 */
public interface IYsPracticeZwlService extends IService<YsPracticeZwl> {
    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 9:20
     * @description:插入一个实习生
     * @param ysPracticeZwlDTO
     * @return: com.zhang.practice.pojo.Result
     */
    Result InsertUser(YsPracticeZwlDTO ysPracticeZwlDTO);

    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 9:45
     * @description: 按照编号批量删除实习生
     * @param arrayList
     * @return: com.zhang.practice.pojo.Result
     */
    Result Deletebatch(ArrayList<Long> arrayList);

    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 10:23
     * @description: 根据手机号删除实习生
     * @param tel
     * @return: com.zhang.practice.pojo.Result
     */
    Result deletebytel(String tel);

    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 11:18
     * @description: 按照id删除实习生
     * @param id
     * @return: com.zhang.practice.pojo.Result
     */
    Result DeletebyId(Integer id);

    /**
     * @author: 张文亮 
     * @createTime: 2022/7/14 13:30
     * @description: 根据姓名进行查询实习生
     * @param name
     * @return: com.zhang.practice.pojo.Result<java.util.List<com.zhang.practice.pojo.YsPracticeZwl>>
     */
    Result<List<YsPracticeZwl>> QueryPractice(String name);

    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 14:42
     * @description: 根据Id修改实习生信息
     * @param ysPracticeZwlUpdateDTO
     * @return: com.zhang.practice.pojo.Result
     */
    Result UpdateInfo(YsPracticeZwlUpdateDTO ysPracticeZwlUpdateDTO);

    /**
     * @author: 张文亮 
     * @createTime: 2022/7/20 9:03
     * @description: 学生的分页查询
     * @param pageDTO
     * @return: java.util.List<com.zhang.practice.pojo.YsPracticeZwl>
     */
    Result<List<YsPracticeZwl>> PagedQuery(PageDTO pageDTO);


    Result<IPage<YsPracticeZwl>> MybatisplusQuery(Integer currentPage, Integer size,String major);
}
