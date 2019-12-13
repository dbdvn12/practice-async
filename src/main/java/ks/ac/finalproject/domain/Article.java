package ks.ac.finalproject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @Id
    private String id;

    private String slug;
    private String title;
    private String description;
    private String body;
    private List<Tag> tags;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean favorited;
    private Long favoritesCount;

}
