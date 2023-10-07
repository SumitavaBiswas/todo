package com.sumitava.todo.db.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Generated;

import java.util.Date;

@Entity
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @NotNull
    private Date startDate;
    private Date endDate;
    private Long parentId;

}
