package com.hiranwj.excel_export.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "course_dtls")
public class Course {
    @Id
    private Integer cid;
    private String name;
    private Integer price;
}
