package com.ahao.java.music.controller;


import com.ahao.java.music.config.BaseControllerStringToDate;
import com.ahao.java.music.pojo.Singer;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.ISingerService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@RestController
@RequestMapping("/singer")
public class SingerController extends BaseControllerStringToDate {
    @Autowired
    private ISingerService iSingerService;

    public final static String imgPath=System.getProperty("user.dir")+"/src/main/resources/static/singerImg";
    public final static String imgPathToMysql="/singerImg";

    @RequestMapping(value = "/fuzzyQuery",method = RequestMethod.GET)
    public Object fuzzyQuerySingerByName(@RequestParam("Singer_name") String Singer_name){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSingerService.fuzzyQuerySingerByName(Singer_name)));
        return jsonObject;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public Object selectAllSinger(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSingerService.selectAllSinger()));
        return jsonObject;
    }

    @RequestMapping(value = "/selectAllBySex",method = RequestMethod.GET)
    public Object selectAllSingerBySex(Byte Singer_sex){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSingerService.selectAllSingerBySex(Singer_sex)));
        return jsonObject;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insertSinger(Singer singer){
        boolean result = iSingerService.insertSinger(singer);
        JSONObject jsonObject = new JSONObject();
        if (result){
            jsonObject.put("data",new Status(200,"添加成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(200,"添加失败",null));
        return jsonObject;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleteSinger(@RequestParam("Singer_id") Integer Singer_id){
        JSONObject jsonObject=new JSONObject();
        String temp=iSingerService.selectSingerById(Singer_id).getSinger_img().replaceAll("/singerImg", "");
        boolean result=iSingerService.deleteSinger(Singer_id);
        if (result){
            if (!temp.equals("/init.png")){
                File delFile = new File(imgPath + temp);
                delFile.delete();
            }
            jsonObject.put("data",new Status(200,"删除成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(200,"删除失败",null));
        return jsonObject;
    }
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Object updateSinger(Singer singer){
        JSONObject jsonObject=new JSONObject();
        boolean result=iSingerService.updateSinger(singer);
        if (result){
            jsonObject.put("data",new Status(200,"修改成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(200,"修改失败",null));
        return jsonObject;
    }


    @RequestMapping(value = "/updateSingerImg",method = RequestMethod.POST)
    public Object updateSingerImg(@RequestParam("file")MultipartFile multipartFile, @RequestParam("Singer_id")Integer Singer_id){
        JSONObject jsonObject=new JSONObject();
        if (multipartFile.isEmpty()){
            jsonObject.put("data",new Status(204,"上传失败",null));
            return jsonObject;
        }
        //获取文件名，为了避免图像文件名重复
        String singerImgName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        //获取存放歌手头像的文件路径，不存在则创建
        File file=new File(imgPath);
        if (!file.exists()){
            file.mkdir();
        }
        //存放文件的绝对地址
        File newSingerImgPath = new File(imgPath + "/" + singerImgName);
        //存放到数据库的相对地址
        String newSingerImgPathToMysql=imgPathToMysql+"/"+singerImgName;
        try {
            Singer singer = new Singer();
            singer.setSinger_id(Singer_id);
            singer.setSinger_img(newSingerImgPathToMysql);
            multipartFile.transferTo(newSingerImgPath);
            String oldSingerImgToMysql=iSingerService.selectSingerById(Singer_id).getSinger_img();
            oldSingerImgToMysql=oldSingerImgToMysql.replaceAll("/singerImg", "");
            boolean updateResult = iSingerService.updateSinger(singer);
            if (updateResult){
                jsonObject.put("data",new Status(200,"上传成功",null));
            }
            if (!oldSingerImgToMysql.equals("/init.png")){
                File oldSingerImgFile = new File(imgPath + oldSingerImgToMysql);
                oldSingerImgFile.delete();
            }
        } catch (Exception e) {
            jsonObject.put("data",new Status(204,"服务器错误，上传失败",null));
            e.printStackTrace();
        } finally {
            return jsonObject;
        }
    }
}
