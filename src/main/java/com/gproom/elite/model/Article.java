package com.gproom.elite.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by weixeushan
 * at 2018/1/10- 11:18
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    @Id
    @Column
    private Long id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Date createdTime;
    @Column
    private Date lastModifyTime;
}
