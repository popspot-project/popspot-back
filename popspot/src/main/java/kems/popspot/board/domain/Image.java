package kems.popspot.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Image {
  private Long imgNo;       // imgno (기본 키)
  private Long postingNum;  // postingnum (외래 키)
  private String img;       // 이미지 이름
  private String imgCopy;   // 이미지 이름 복사본
  private String imgSize;   // 파일 크기
  private String fileInfo;  // 파일 형식
  private String imgPath;   // 이미지 경로

  // 기본 생성자
  public Image() {}

}
