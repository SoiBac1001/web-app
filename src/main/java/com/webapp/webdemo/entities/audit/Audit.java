package com.webapp.webdemo.entities.audit;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
public class Audit {
    @Column(name = "CREATED_BY", length = 15, nullable = false)
    private String createdBy;

    @Column(name = "CREATED_ON", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "MODIFIED_BY", length = 15, nullable = false)
    private String modifiedBy;

    @Column(name = "MODIFIED_ON", nullable = false)
    private LocalDateTime modifiedOn;
}
