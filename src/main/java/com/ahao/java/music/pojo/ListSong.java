package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 22720
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSong  implements Serializable {


    private static final long serialVersionUID = 1L;
    private Integer listSongId;
    private Integer songId;
    private Integer songListId;
}
