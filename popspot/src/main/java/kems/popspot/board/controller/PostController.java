package kems.popspot.board.controller;

import java.util.List;
import kems.popspot.board.domain.Image;
import kems.popspot.board.domain.Post;
import kems.popspot.board.dto.request.PostWithImageRequest;
import kems.popspot.board.service.PostService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/popspot")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping("/create")
  public String createPostWithImage(@RequestBody PostWithImageRequest request) {
    // 요청 데이터를 Post 및 Image 객체로 변환
    Post post = request.toPost();
    Image image = request.toImage();

    // Service를 통해 트랜잭션 처리
    postService.createPostWithImage(post, image);

    return "Post and Image created successfully";
  }

  @PutMapping("/update/{postingId}")
  public String updatePost(@PathVariable Long postingId, @RequestBody Post post) {
    post.setPostId(postingId);
    postService.updatePost(post);
    return "Post updated successfully";
  }

  @DeleteMapping("/{postingId}")
  public String deletePost(@PathVariable Long postingId) {
    postService.deletePost(postingId);
    return "Post deleted successfully";
  }

  @GetMapping("/list")
  public List<Post> getAllPosts() {
    return postService.findAll();
  }

  @GetMapping("/list/{postingId}")
  public Post getPostById(@PathVariable Long postingId) {
    return postService.findById(postingId);
  }
}
