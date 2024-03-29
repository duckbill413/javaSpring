package com.example.rising.src.img.model;

import com.example.rising.src.post.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Image {
    private Long imgIdx;
    private String imgUrl;
    private Post post;
}
