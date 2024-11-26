package kems.popspot.board.service;

import java.util.List;
import kems.popspot.board.domain.Image;
import kems.popspot.board.domain.Post;
import kems.popspot.board.repository.ImageRepository;
import kems.popspot.board.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class PostService {

  private final PostRepository postRepository;
  private final ImageRepository imageRepository;

  public PostService(PostRepository postRepository, ImageRepository imageRepository) {
    this.postRepository = postRepository;
    this.imageRepository = imageRepository;
  }

  @Transactional
  public void createPostWithImage(Post post, Image image) {
    //1. Img 테이블에 데이터 삽입
    imageRepository.addImage(image);
    //2. 생성된 Img의 imgNo를 Post 객체에 설정
    post.setImgNo(image.getImgNo());
    //3. Post 테이블에 데이터 삽입
    postRepository.createPost(post);
  }

  // Update an existing post
  public void updatePost(Post post) {
    // Update the post
    postRepository.updatePost(post);

    // Update associated images
    updateImages(post);
  }

  // Delete a post and its associated images
  public void deletePost(Long postId) {
    // Delete associated images
    imageRepository.deleteImagesByPostId(postId);

    // Delete the post
    postRepository.deletePost(postId);
  }

  // Retrieve all posts
  public List<Post> findAll() {
    List<Post> posts = postRepository.findAll();
    if (!CollectionUtils.isEmpty(posts)) {
      posts.forEach(post -> {
        List<Image> images = imageRepository.findImagesByPostId(post.getPostId());
        post.setImages(images);
      });
    }
    return posts;
  }

  // Retrieve a post by ID
  public Post findById(Long postId) {
    Post post = postRepository.findById(postId);

    if (post != null) {
      List<Image> images = imageRepository.findImagesByPostId(postId);
      post.setImages(images);
    }
    return post;
  }

  // Save images for a post
  private void saveImages(Post post) {
    if (!CollectionUtils.isEmpty(post.getImages())) {
      for (Image image : post.getImages()) {
        image.setPostingNum(post.getPostId()); // Set the foreign key
        imageRepository.addImage(image); // Add image
      }
    }
  }

  // Update images for a post
  private void updateImages(Post post) {
    if (!CollectionUtils.isEmpty(post.getImages())) {
      // Delete old images
      imageRepository.deleteImagesByPostId(post.getPostId());

      // Save new images
      saveImages(post);
    }
  }
}
