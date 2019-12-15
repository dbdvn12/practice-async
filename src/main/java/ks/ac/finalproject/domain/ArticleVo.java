package ks.ac.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class ArticleVo {
    private String title;
    private String description;
    private String body;
    private List<Tag> tags;
}
