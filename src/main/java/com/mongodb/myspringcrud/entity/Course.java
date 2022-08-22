package com.mongodb.myspringcrud.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "Course")
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    private Student students;
    private String ratings;
}
