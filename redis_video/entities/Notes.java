package com.spring_video_stream.redis_video.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="stream_notes")
public class Notes implements Serializable{

    @Id
    private String id;

    private String title;

    private String content;

    private Date addedDate;
    
    private boolean live =false;




}
