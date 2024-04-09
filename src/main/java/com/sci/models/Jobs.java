package com.sci.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Jobs", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class Jobs implements Serializable{
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "JOB_ID")
    private String JOB_ID;
    @Column(name = "JOB_TITLE")
    private String JOB_TITLE;
    @Column(name = "MIN_SALARY")
    private Integer MIN_SALARY;
    @Column(name = "MAX_SALARY")
    private Integer MAX_SALARY;
}
