package com.koreait.dbms_study.dto;

import com.koreait.dbms_study.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditPostReqDto {
    private Integer postId;
    private String title;
    private String content;

    public Post toEntity(){
        return Post.builder()
                .postId(this.postId)
                .title(this.title)
                .content(this.content)
                .build();
    }




}
