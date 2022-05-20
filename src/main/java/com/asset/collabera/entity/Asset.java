package com.asset.collabera.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    String name;

    @Temporal(TemporalType.TIMESTAMP)
    Date manufacturingId;

    @Temporal(TemporalType.TIMESTAMP)
    Date expiry_date;

    @OneToMany(fetch = FetchType.LAZY)
    List<Staff> assigned_to;


}
