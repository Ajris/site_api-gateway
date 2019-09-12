package com.ajris.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogInformation {

    private Long id;

    private String title;
    private String shortText;

    public BlogInformation(String title, String shortText) {
        this.title = title;
        this.shortText = shortText;
    }
}
