package com.example.rising.src.post;

import com.example.rising.config.BaseException;
import com.example.rising.config.BaseResponse;
import com.example.rising.config.BaseResponseStatus;
import com.example.rising.config.BindingException;
import com.example.rising.src.post.model.*;
import com.example.rising.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final JwtService jwtService;
    private final PostService postService;
    private final PostProvider postProvider;

    @PostMapping("/create")
    public BaseResponse<PostCreateRes> createPost(@Valid @RequestBody PostCreateReq postCreateReq,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new BaseResponse<>(new BindingException().message(bindingResult));
        }
        try {
            try {
                Category.valueOf(postCreateReq.getCategory());
            } catch (Exception e) {
                throw new BaseException(BaseResponseStatus.POST_CATEGORY_INVALID);
            }
            long userIdxByJwt = jwtService.getUserIdx();
            Long postIdx = postService.createPost(userIdxByJwt, postCreateReq);

            return new BaseResponse<>(new PostCreateRes(postIdx));
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @GetMapping("/list/{page}")
    public BaseResponse<List<GetPostRes>> loadAllPost(@PathVariable(value = "page") Long page) {

        try {
            List<GetPostRes> posts = postProvider.getPosts(page);
            return new BaseResponse<>(posts);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
