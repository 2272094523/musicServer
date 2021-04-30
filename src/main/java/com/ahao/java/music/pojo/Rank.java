package com.ahao.java.music.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.ldap.PagedResultsControl;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Rank implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer rankId;
    private Integer rankSongListId;
    private Integer rankConsumerId;
    private Double rankScore;
}
