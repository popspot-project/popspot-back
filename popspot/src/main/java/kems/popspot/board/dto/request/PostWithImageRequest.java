package kems.popspot.board.dto.request;

import java.time.LocalDateTime;
import kems.popspot.board.domain.Image;
import kems.popspot.board.domain.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWithImageRequest {
  private String title;
  private String address;
  private String description;
  private String publicUrl;
  private String startDate;
  private String endDate;
  private String startTime;
  private String endTime;

  private String img;
  private String imgCopy;
  private String imgSize;
  private String fileInfo;
  private String imgPath;

  public Post toPost() {
    Post post = new Post();
    post.setTitle(title);
    post.setAddress(address);
    post.setDescription(description);
    post.setPublicUrl(publicUrl);
    post.setStartDate(LocalDateTime.parse(startDate));
    post.setEndDate(LocalDateTime.parse(endDate));
    post.setStartTime(LocalDateTime.parse(startTime));
    post.setEndTime(LocalDateTime.parse(endTime));
    return post;
  }

  public Image toImage() {
    Image image = new Image();
    image.setImg(img);
    image.setImgCopy(imgCopy);
    image.setImgSize(imgSize);
    image.setFileInfo(fileInfo);
    image.setImgPath(imgPath);
    return image;
  }
}

