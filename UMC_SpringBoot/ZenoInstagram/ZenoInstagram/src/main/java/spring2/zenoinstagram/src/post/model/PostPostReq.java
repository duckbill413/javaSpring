package spring2.zenoinstagram.src.post.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostPostReq {
    private int userIdx;
    private String content;
    private List<PostImgsUrlReq> postImgsUrl;
}
