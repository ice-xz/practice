package com.zhang.practice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhang.practice.dto.PageDTO;
import com.zhang.practice.dto.YsPracticeZwlDTO;
import com.zhang.practice.dto.YsPracticeZwlUpdateDTO;
import com.zhang.practice.pojo.Result;
import com.zhang.practice.pojo.YsPracticeZwl;
import com.zhang.practice.mapper.YsPracticeZwlMapper;
import com.zhang.practice.service.IYsPracticeZwlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实习表_张文亮 服务实现类
 * </p>
 *
 * @author zhangwenliang
 * @since 2022-07-13
 */
@Slf4j
@Service
public class YsPracticeZwlServiceImpl extends ServiceImpl<YsPracticeZwlMapper, YsPracticeZwl> implements IYsPracticeZwlService {

    @Autowired
    YsPracticeZwlMapper ysPracticeZwlMapper;

    /**
     * @author: 张文亮
     * @createTime: 2022/7/18 16:44
     * @description: 插入一个实习生
     * @param ysPracticeZwlDTO
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @Override
    public Result<String> InsertUser(YsPracticeZwlDTO ysPracticeZwlDTO) {
        YsPracticeZwl ysPracticeZwl = new YsPracticeZwl();
        BeanUtils.copyProperties(ysPracticeZwlDTO,ysPracticeZwl);
        log.info(ysPracticeZwlDTO.toString());
        log.info(ysPracticeZwl.toString());
        ysPracticeZwlMapper.insert(ysPracticeZwl);
        return  Result.success("插入成功");
    }

    /**
     * @author: 张文亮
     * @createTime: 2022/7/18 16:44
     * @description: 按照编号批量删除实习生
     * @param arrayList
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @Override
    public Result<String> Deletebatch(ArrayList<Long> arrayList) {
        ysPracticeZwlMapper.deleteBatchIds(arrayList);
        return Result.success("批量删除成功");
    }

    /**
     * @author: 张文亮
     * @createTime: 2022/7/18 16:46
     * @description:  根据手机号删除实习生
     * @param tel
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @Override
    public Result<String> deletebytel(String tel) {
        YsPracticeZwl ysPracticeZwl = new YsPracticeZwl();
       // log.info("电话号码为:"+tel);
        ysPracticeZwl.setTel(tel);
        QueryWrapper<YsPracticeZwl> wrapper =new  QueryWrapper<>(ysPracticeZwl);
        int res =  ysPracticeZwlMapper.delete(wrapper);
        if(res == 0)
            return Result.err("没有匹配的数据可删除");
        return Result.success("删除成功");
    }


    /**
     * @author: 张文亮
     * @createTime: 2022/7/18 16:47
     * @description: 按照id删除实习生
     * @param id
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @Override
    public Result<String> DeletebyId(Integer id) {
        int res = ysPracticeZwlMapper.deleteById(id);
            if(res == 0) return Result.err("删除失败，不存在此人");
        return Result.success("删除成功");
    }

    /**
     * @author: 张文亮
     * @createTime: 2022/7/14 13:31
     * @description: 根据姓名进行查询实习生
     * @param name
     * @return: com.zhang.practice.pojo.Result<java.util.List<com.zhang.practice.pojo.YsPracticeZwl>>
     */
    @Override
    public Result<List<YsPracticeZwl>> QueryPractice(String name) {

        YsPracticeZwl ysPracticeZwl = new YsPracticeZwl();
        ysPracticeZwl.setSname(name);
        QueryWrapper<YsPracticeZwl> wrapper = new QueryWrapper<>(ysPracticeZwl);

        List<YsPracticeZwl> practiceZwlList = null;
        practiceZwlList = ysPracticeZwlMapper.selectList(wrapper);
        if(practiceZwlList.size() == 0)
            return Result.err("没有相关该实习生");
        return Result.success("查询成功",practiceZwlList);

    }


    /**
     * @author: 张文亮
     * @createTime: 2022/7/18 16:47
     * @description: 根据Id修改实习生信息
     * @param ysPracticeZwlUpdateDTO
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @Override
    public Result<String> UpdateInfo(YsPracticeZwlUpdateDTO ysPracticeZwlUpdateDTO) {
        YsPracticeZwl ysPracticeZwl = new YsPracticeZwl();
        BeanUtils.copyProperties(ysPracticeZwlUpdateDTO,ysPracticeZwl);
        ysPracticeZwlMapper.updateById(ysPracticeZwl);
        return Result.success("修改成功");
    }

    /**
     * @author: 张文亮
     * @createTime: 2022/7/20 9:04
     * @description: 学生的分页查询
     * @param pageDTO
     * @return: java.util.List<com.zhang.practice.pojo.YsPracticeZwl>
     */

    @Override
    public Result<List<YsPracticeZwl>> PagedQuery(PageDTO pageDTO) {

        List<YsPracticeZwl> practiceZwlList = null;
            practiceZwlList = ysPracticeZwlMapper.PagedQuery(pageDTO);
            if(practiceZwlList.size() <= 0)
                return Result.err("请检查页码与页大小是否已填写");
        return Result.success("分页查询成功",practiceZwlList);
    }






    @Override
    public Result<IPage<YsPracticeZwl>> MybatisplusQuery(Integer currentPage, Integer size,String major) {
        //开启分页
        Page page = new Page<>(currentPage,size);
        QueryWrapper<YsPracticeZwl> wrapper = new QueryWrapper<>();
        wrapper.lambda().like(YsPracticeZwl::getMajor,major);
        IPage<YsPracticeZwl> ysPracticeZwlIPage = ysPracticeZwlMapper.selectPage(page, null);
        log.info("总页数:{}",ysPracticeZwlIPage.getPages());
        log.info("记录为:{}",ysPracticeZwlIPage.getRecords());
        log.info("当前页为:"+ysPracticeZwlIPage.getCurrent()+"每页限制为:"+ysPracticeZwlIPage.getSize());
        return Result.success("查询成功",ysPracticeZwlIPage);
    }



}
