package com.ahao.java.music.controller;

import com.ahao.java.music.config.BaseControllerStringToDate;
import com.ahao.java.music.pojo.Song;
import com.ahao.java.music.pojo.Status;
import com.ahao.java.music.service.ISongService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;

    public final static String songPath=System.getProperty("user.dir")+"/src/main/resources/static/songFile";
    public final static String songPathToMysql="/songFile";
    public final static String songImgPath=System.getProperty("user.dir")+"/src/main/resources/static/songImg";
    private final static String songImgPathToMysql="/songImg";

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insertSong(Song song, @RequestParam("file")MultipartFile multipartFile){
        JSONObject jsonObject = new JSONObject();
        if (multipartFile.isEmpty()){
            jsonObject.put("data",new Status(204,"添加歌曲失败,缺少mp3文件",null));
            return jsonObject;
        }
        //获取mp3文件名,可重复
        String songName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        //确认存放mp3的文件夹存在
        File songFolder=new File(songPath);
        if (songFolder.exists()){
            songFolder.mkdir();
        }
        //存放歌曲的绝对路径
        File songFile=new File(songPath+"/"+songName);
        try {
            //复制文件
            multipartFile.transferTo(songFile);
            song.setSong_createTime(new Date());
            String songRelativePath=songPathToMysql+"/"+songName;
            song.setSong_url(songRelativePath);
            song.setSong_img(songImgPathToMysql+"/"+"init.jpg");
            System.out.println(song);
            boolean result=iSongService.insertSong(song);
            System.out.println("result = " + result);
            if (result){
                jsonObject.put("data",new Status(200,"添加歌曲成功",songRelativePath));
            }
        } catch (Exception e) {
            jsonObject.put("data",new Status(204,"添加歌曲失败",null));
            e.printStackTrace();
        }finally {
            return jsonObject;
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateSong(Song song){
        JSONObject jsonObject = new JSONObject();
        song.setSong_updateTime(new Date());
        boolean result=iSongService.updateSong(song);
        if (result){
            jsonObject.put("data",new Status(200,"修改歌曲信息成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"修改歌曲信息失败",null));
        return jsonObject;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleteSong(Integer Song_id){
        JSONObject jsonObject = new JSONObject();
        Song delSong = iSongService.selectSongById(Song_id);
        System.out.println(delSong);
        String delSongFile=songPath+delSong.getSong_url().replaceAll("/songFile","");
        File delFile = new File(delSongFile);
        boolean result=iSongService.deleteSong(Song_id);
        if (result){
            delFile.delete();
            if (!delSong.getSong_img().equals("/songImg/init.jpg")){
                File delImg = new File(songImgPath + delSong.getSong_img().replaceAll("/songImg", ""));
                delImg.delete();
            }
            jsonObject.put("data",new Status(200,"删除歌曲成功",null));
            return jsonObject;
        }
        jsonObject.put("data",new Status(204,"删除歌曲失败",null));
        return jsonObject;
    }

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public Object selectAllSong(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSongService.selectAllSong()));
        return jsonObject;

    }

    @RequestMapping(value = "/fuzzySelect",method = RequestMethod.GET)
    public Object fuzzySelectSongByName(String Song_name){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSongService.fuzzySelectSongByName(Song_name)));
        return jsonObject;
    }

    @RequestMapping(value = "/selectById",method = RequestMethod.GET)
    public Object selectSongById(Integer Song_id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSongService.selectSongById(Song_id)));
        return jsonObject;
    }

    @RequestMapping(value="/selectAllBySingerId",method = RequestMethod.GET)
    public Object selectAllBySingerId(Integer Song_singerId){
        System.out.println(Song_singerId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",new Status(200,"查询成功",iSongService.selectAllBySingerId(Song_singerId)));
        return jsonObject;
    }

    @RequestMapping(value="/updateSongImg",method = RequestMethod.POST)
    public Object updateSongImg(@RequestParam("file")MultipartFile multipartFile,@RequestParam("Song_id") Integer Song_id){
        JSONObject jsonObject = new JSONObject();
        File folder = new File(songImgPath);
        if (folder.exists()){
            folder.mkdir();
        }
        String songImgName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        //获取存放文件的绝对路径
        String newSongImgPath=songImgPath+"/"+songImgName;
        //获取文件的相对地址存到数据库
        String newSongImgPathToMysql=songImgPathToMysql+"/"+songImgName;
        File newSongFile = new File(newSongImgPath);
        try {
            Song song = new Song();
            song.setSong_img(newSongImgPathToMysql);
            song.setSong_id(Song_id);
            //在服务器生产新文件
            multipartFile.transferTo(newSongFile);
            //获取旧文件
            String oldSongImgPath=songImgPath+iSongService.selectSongById(Song_id).getSong_img().replaceAll("/songImg","");
            boolean result = iSongService.updateSong(song);
            if (result) {
                jsonObject.put("data", new Status(200, "更新歌曲图片成功", null));
            }
            //最后删除旧文件
            if (!oldSongImgPath.equals("init.jpg")){
                File oldFile = new File(oldSongImgPath);
                oldFile.delete();
            }
        } catch (IOException e) {
            jsonObject.put("data",new Status(204,"更新歌曲图片失败", null));
            e.printStackTrace();
        }finally {
            return jsonObject;
        }
    }

    @RequestMapping(value="/updateSongFile",method = RequestMethod.POST)
    public Object updateSongFile(@RequestParam("file")MultipartFile multipartFile,@RequestParam("Song_id") Integer Song_id){
        JSONObject jsonObject = new JSONObject();
        File folder = new File(songPath);
        if (folder.exists()){
            folder.mkdir();
        }
        String songPathName=System.currentTimeMillis()+multipartFile.getOriginalFilename();
        //获取存放文件的绝对路径
        String newSongFilePath=songPath+"/"+songPathName;
        //获取文件的相对地址存到数据库
        String newSongImgPathToMysql=songPathToMysql+"/"+songPathName;
        File newSongFile = new File(newSongFilePath);
        try {
            Song song = new Song();
            song.setSong_url(newSongImgPathToMysql);
            song.setSong_id(Song_id);
            //在服务器生产新文件
            multipartFile.transferTo(newSongFile);
            //获取旧文件
            String oldSongFilePath=songPath+iSongService.selectSongById(Song_id).getSong_url().replaceAll("/songFile","");
            System.out.println(oldSongFilePath);
            boolean result = iSongService.updateSong(song);
            if (result) {
                jsonObject.put("data", new Status(200, "更新歌曲文件成功", null));
            }
            File oldSongFile = new File(oldSongFilePath);
            oldSongFile.delete();
        } catch (IOException e) {
            jsonObject.put("data",new Status(204,"更新歌曲文件失败", null));
            e.printStackTrace();
        }finally {
            return jsonObject;
        }
    }


}
