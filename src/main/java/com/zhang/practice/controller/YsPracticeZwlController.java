package com.zhang.practice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhang.practice.dto.PageDTO;
import com.zhang.practice.dto.YsPracticeZwlDTO;
import com.zhang.practice.dto.YsPracticeZwlUpdateDTO;
import com.zhang.practice.pojo.Result;
import com.zhang.practice.pojo.YsPracticeZwl;
import com.zhang.practice.service.IYsPracticeZwlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 实习表_张文亮 前端控制器
 * </p>
 *
 * @author zhangwenliang
 * @since 2022-07-13
 */
@Validated
@RestController
@RequestMapping("/ys_practice_zwl")
@Api(tags = "实习生控制器")
public class YsPracticeZwlController extends BaseController{
    @Autowired
    IYsPracticeZwlService iYsPracticeZwlService;
    
    /**
     * @author: 张文亮 
     * @createTime: 2022/7/18 16:41
     * @description:  新增一个实习生
     * @param ysPracticeZwlDTO
     * @return: com.zhang.practice.pojo.Result<java.lang.String>
     */
    @PostMapping("/insert")
    @ApiOperation("新增一个实习生")
   public Result<String> InsertUser(@Validated  @RequestBody YsPracticeZwlDTO ysPracticeZwlDTO)
   {
       return  iYsPracticeZwlService.InsertUser(ysPracticeZwlDTO);
   }

   /**
    * @author: 张文亮
    * @createTime: 2022/7/18 16:37
    * @description:  按照编号批量删除实习生
    * @param arrayList
    * @return: com.zhang.practice.pojo.Result<java.lang.String>
    */
   @ApiOperation("批量删除实习生")
   @DeleteMapping("/deletebatch")
   public Result<String> DeleteUserBatch(@Validated @RequestBody ArrayList<Long> arrayList)
   {
        return  iYsPracticeZwlService.Deletebatch(arrayList);
   }

   /**
    * @author: 张文亮
    * @createTime: 2022/7/18 16:37
    * @description:  根据手机号删除实习生
    * @param tel
    * @return: com.zhang.practice.pojo.Result<java.lang.String>
    */
   @ApiOperation("根据手机号删除")
   @DeleteMapping("/deletebytel")
   public Result<String> Deletebytel(String tel)
   {
        return iYsPracticeZwlService.deletebytel(tel);
   }

   /**
    * @author: 张文亮
    * @createTime: 2022/7/18 16:41
    * @description:  按照id删除实习生
    * @param id
    * @return: com.zhang.practice.pojo.Result<java.lang.String>
    */
   @ApiOperation("根据id删除实习生")
   @DeleteMapping("/deletebyId")
   public Result<String> DeleteById(Integer id)
   {
       return iYsPracticeZwlService.DeletebyId(id);
   }

   /**
    * @author: 张文亮
    * @createTime: 2022/7/14 14:32
    * @description: 根据姓名进行查询实习生
    * @param name
    * @return: com.zhang.practice.pojo.Result<java.util.List<com.zhang.practice.pojo.YsPracticeZwl>>
    */
   @ApiOperation("根据姓名查询实习生")
   @GetMapping("/QueryPractice")
   public Result<List<YsPracticeZwl>> QueryPractice(String name)
   {
       return iYsPracticeZwlService.QueryPractice(name);
   }


   /**
    * @author: 张文亮
    * @createTime: 2022/7/18 16:42
    * @description: 根据Id修改实习生信息
    * @param ysPracticeZwlUpdateDTO
    * @return: com.zhang.practice.pojo.Result<java.lang.String>
    */
   @ApiOperation("根据id更新实习生信息")
   @PutMapping("/UpdateInfo")
   public Result<String> UpdateInfo(@Validated  @RequestBody YsPracticeZwlUpdateDTO ysPracticeZwlUpdateDTO)
   {
        return iYsPracticeZwlService.UpdateInfo(ysPracticeZwlUpdateDTO);
   }

   /**
    * @author: 张文亮
    * @createTime: 2022/7/20 10:05
    * @description: 分页查询实习生
    * @param pageDTO
    * @return: com.zhang.practice.pojo.Result<java.util.List<com.zhang.practice.pojo.YsPracticeZwl>>
    */
   @ApiOperation(("分页查询实习生"))
   @GetMapping("/PagedQuery")
   public Result<List<YsPracticeZwl>> PagedQueryPractice(@Validated PageDTO pageDTO)
   {
        return iYsPracticeZwlService.PagedQuery(pageDTO);
   }

   @ApiOperation("Mybatisplus分页查询")
   @GetMapping("/MybatisPageQuery")
   public Result<IPage<YsPracticeZwl>> MybatisplusPageQuery(Integer currentPage, Integer size,String major)
   {
       return iYsPracticeZwlService.MybatisplusQuery(currentPage,size,major);
   }
}
