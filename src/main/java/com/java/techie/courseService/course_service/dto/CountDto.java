package com.java.techie.courseService.course_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountDto {
    String courseType;
    Integer count;
}
