package kems.popspot.board.repository;

import java.util.List;
import kems.popspot.board.domain.Image;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ImageRepository {
  void addImage(Image image); // Insert an image

  List<Image> findImagesByPostId(Long postingNum); // Retrieve images by post ID

  void deleteImagesByPostId(Long postingNum); // Delete images by post ID
}

