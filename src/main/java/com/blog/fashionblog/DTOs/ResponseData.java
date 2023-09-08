package com.blog.fashionblog.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseData {
    private List<PostDTO>response;
    private int pageSize;
    private int pageNo;
    private int totalItems;
    private int totalPages;
    private boolean isFirst;
    private boolean isLast;

}
