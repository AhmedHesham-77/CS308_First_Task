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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Departments", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "dep_gen", sequenceName = "departments_seq", allocationSize = 1)
public class Departments implements Serializable {

    private static final long serialVersionUID = -915428707036605461L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dep_gen")
    @Column(name = "DEPARTMENT_ID")
    private Integer DEPARTMENT_ID;
    @Column(name = "DEPARTMENT_NAME")
    private String DEPARTMENT_NAME;
    @Column(name = "MANAGER_ID")
    private Integer MANAGER_ID;
    @Column(name = "LOCATION_ID")
    private Integer LOCATION_ID;
}
