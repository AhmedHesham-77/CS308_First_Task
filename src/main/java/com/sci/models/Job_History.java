package com.sci.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Columns;

@Entity
@Table(name = "Job_History", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Job_History implements Serializable {
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer EMPLOYEE_ID;

    @Id
    @Column(name = "START_DATE")
    private String START_DATE;

    @Column(name = "END_DATE")
    private String END_DATE;

    @Column(name = "JOB_ID")
    private String JOB_ID;

    @Column(name = "DEPARTMENT_ID")
    private Integer DEPARTMENT_ID;
}
