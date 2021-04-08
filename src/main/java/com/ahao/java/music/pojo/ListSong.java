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
    private Integer ListSong_id;
    private Integer Song_id;
    private Integer SongList_id;
}
