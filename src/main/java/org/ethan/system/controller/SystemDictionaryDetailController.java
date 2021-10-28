package org.ethan.system.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ethan.basic.util.AjaxResult;
import org.ethan.basic.util.PageList;

import org.ethan.system.domain.SystemDictionaryDetail;
import org.ethan.system.query.SystemDictionaryDetailQuery;
import org.ethan.system.service.ISystemDictionaryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail")
@Api(tags = "部门接口", description = "部门接口详细描述")
public class SystemDictionaryDetailController {

    @Autowired
    private ISystemDictionaryDetailService service;

    /**
     * @PathVariable： 接收请求路径中占位符的值，即id的值
     */
    @ApiOperation(value = "查询一条数据",notes = "根据id查询")
    @GetMapping("/{id}") // 相当于@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public SystemDictionaryDetail findOne(@PathVariable("id") Long id){
        return service.getById(id);

    }

    /**
     * 查询所有数据
     * @return
     */
    @GetMapping
    @ApiOperation(value = "查询所有数据",notes = "不需要id")
    public List<SystemDictionaryDetail> findAll(){

        return service.getAll();
    }

    /**
     * 查询分页数据
     * @RequestBody ：主要用来接收前端传递给后端的json字符串中的数据(请求体中的数据，一般是对象)；
     * 而最常用的使用请求体传参的无疑是POST请求了，所以使用@RequestBody接收数据时，一般都用POST方式进行提交
     * @param query
     * @return
     */
    @PostMapping
    @ApiOperation(value = "分页查询",notes = "输入分页条件进行查询")
    public PageList<SystemDictionaryDetail> queryPage(@RequestBody SystemDictionaryDetailQuery query){

        return service.queryData(query);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除",notes = "根据id删除")
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            service.del(id);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("删除失败，请稍后再试！！！");

        }

    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PatchMapping()
    @ApiOperation(value = "批量删除",notes = "传入id数组")
    public AjaxResult patchDel(@RequestBody List<Long> ids){
        try {
            service.patchDel(ids);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("System Failure ,Please try again later!!!");
        }

    }


    /**
     * 添加和删除
     * @param dept
     * @return
     */
    @PutMapping()
    @ApiOperation(value = "部门添加或修改",notes = "如果有id就是修改否则就是添加")
    public AjaxResult AddOrUpdate(@RequestBody SystemDictionaryDetail dept){
        try {
            if (dept.getId() == null) {
                // id为空执行添加操作
                service.add(dept);
            } else {
                // id不为空执行修改操作
                service.update(dept);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return  AjaxResult.me().setMessage("系统繁忙，try again later！！！");
        }

    }


    @PostMapping("/{id}")
    public List<SystemDictionaryDetail> loadByTypeId(@PathVariable("id") Long id){
        return service.loadByTypeId(id);

    }



}
