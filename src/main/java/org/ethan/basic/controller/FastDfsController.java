package org.ethan.basic.controller;

import io.swagger.annotations.Api;
import org.ethan.basic.util.AjaxResult;
import org.ethan.basic.util.FastDfsUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/dfs")
@Api(tags = "文件接口",description = "文件接口详细描述")
public class FastDfsController {

    /**
     * 上传方法
     * @param file
     * @return
     */
    @PostMapping
    public AjaxResult upload(@RequestPart(required = true, value = "file") MultipartFile file){

        try {
            // 获取图片的全名
            String filename = file.getOriginalFilename();
            // 获取图片的后缀

            String extName = filename.substring(filename.lastIndexOf(".") + 1);
            // 调用fastDFS工具类方法，上传文件
            String path = FastDfsUtil.upload(file.getBytes(), extName);

            // 向后台返回图片的路径，用于保存在数据中
            return AjaxResult.me().setResultObj(path);


        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("System Failure");
        }
    }


    @DeleteMapping
    public AjaxResult delete(@RequestParam String path){

        try {
            String pathTmp = path.substring(1);
            // 截取组名
            String groupName = pathTmp.substring(0, pathTmp.indexOf("/"));
            // 截取文件名
            String remotePath = pathTmp.substring(pathTmp.indexOf("/") + 1);//
            // 调用fastDFS工具类方法，删除文件
            FastDfsUtil.delete(groupName, remotePath);

            return AjaxResult.me();

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("System Failure");
        }
    }



}
