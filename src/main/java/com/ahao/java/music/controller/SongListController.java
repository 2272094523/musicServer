package com.ahao.java.music.controller;


import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.SongList;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.ISongListService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/songlist")
public class SongListController {

    @Autowired
    private ISongListService iSongListService;

    private final static String songListImgFolderPath=System.getProperty("user.dir")+"/src/main/resources/static/songListImg";
    private final static String songListImgFolderPathToMysql="/songListImg";

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    public Object insertSongList(SongList songList){
        JSONObject jsonObject = new JSONObject();
        boolean result=iSongListService.insertSongList(songList);
        if (result==true){
            jsonObject.put("data",new Status(200,"新增歌单成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"新增歌单失败",null));
        return jsonObject;
    }
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Object updateSongList(SongList songList){
        JSONObject jsonObject = new JSONObject();
        boolean result=iSongListService.updateSongList(songList);
        if (result){
            jsonObject.put("data",new Status(200,"修改歌单成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"修改歌单失败",null));
        return jsonObject;
    }
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public Object deleteSongList(Integer songListId){
        JSONObject jsonObject = new JSONObject();
        boolean result=iSongListService.deleteSongList(songListId);
        if (result){
            jsonObject.put("data",new Status(200,"删除歌单成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"删除歌单失败",null));
        return jsonObject;
    }
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public Object selectAllSongList(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSongListService.selectAllSongList()));
        return jsonObject;
    }
    @RequestMapping(value = "/updateSongListImg",method = RequestMethod.POST)
    public Object updateSongListImg(@RequestParam("file")MultipartFile multipartFile,@RequestParam("songListId") Integer songListId){
        JSONObject jsonObject = new JSONObject();
        File path = new File(songListImgFolderPath);
        if (!path.exists()){
            path.mkdir();
        }
        //设置歌单图片名字
        String songListImgName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        //设置到数据库新路径名
        String newSongListImgPathToMysql=songListImgFolderPathToMysql+"/"+songListImgName;
        //设置到服务器的新路径名
        String newSongListImgPath=songListImgFolderPath+"/"+songListImgName;
        System.out.println(newSongListImgPath);
        SongList songList = new SongList();
        songList.setSongListId(songListId);
        songList.setSongListImg(newSongListImgPathToMysql);
        File newSongListImgFile = new File(newSongListImgPath);
        try {
            multipartFile.transferTo(newSongListImgFile);
            boolean result = iSongListService.updateSongList(songList);
            if (result){
                jsonObject.put("data",new Status(200,"更新歌单图片成功",null));
                songList = iSongListService.selectSongListById(songListId);
                String path1=songListImgFolderPath+songList.getSongListImg().replaceAll("/songFile","");
                System.out.println(path1);
                File oldSongListImgFile=new File(path1);
                oldSongListImgFile.delete();
                System.out.println("删除成功");
            }
        } catch (Exception e) {
            jsonObject.put("data",new Status(204,"更新歌单图片失败",null));
            e.printStackTrace();
        }finally {
            return jsonObject;
        }

    }



}
