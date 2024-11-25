package kems.popspot.board.repository;

import java.util.List;
import kems.popspot.board.domain.Post;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostRepository {

  void createPost(Post post); // Insert a new post

  void updatePost(Post post); // Update an existing post

  void deletePost(Long postingNum); // Delete a post

  List<Post> findAll(); // Retrieve all posts

  Post findById(Long postingNum); // Retrieve a post by its ID
}
