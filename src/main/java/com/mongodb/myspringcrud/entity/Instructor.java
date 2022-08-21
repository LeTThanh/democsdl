package com.mongodb.myspringcrud.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "Instructor")
public class Instructor {
    @Id
    private String id;
    private String name;
    private String email;
    private Course course;
}
