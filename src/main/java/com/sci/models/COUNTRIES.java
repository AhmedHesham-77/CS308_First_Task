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
@Table(name = "COUNTRIES", schema = "hr")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
public class COUNTRIES implements Serializable {
    private static final long serialVersionUID = -915428707036605461L;
    @Id
    @Column(name = "COUNTRY_ID")
    private String COUNTRY_ID;
    @Column(name = "COUNTRY_NAME")
    private String COUNTRY_NAME;
    @Column(name = "REGION_ID")
    private Integer REGION_ID;
}
