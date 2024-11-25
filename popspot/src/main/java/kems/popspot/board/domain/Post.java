package kems.popspot.board.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {
  private Long postId; // postId
  private String title; // 제목
  private String address; // 장소
  private String description; // 설명
  private String publicUrl; // 공식페이지 URL
  private LocalDateTime startDate; // 팝업 시작 날짜
  private LocalDateTime endDate; // 팝업 종료 날짜
  private LocalDateTime startTime; // 팝업 시작 시간
  private LocalDateTime endTime; // 팝업 종료 시간
  private Long imgNo; // 외래 키 imgno
  private List<Image> images; // Img 테이블과의 관계를 반영
}
