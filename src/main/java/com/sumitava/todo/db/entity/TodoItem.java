package com.sumitava.todo.db.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @NotNull
    @JsonFormat(pattern="yyyy-MM-dd") // Used for entering date from UI. Act with @Valid in Controller.
    private Date startDate;
    private Date endDate;
    private Long parentId;

}
