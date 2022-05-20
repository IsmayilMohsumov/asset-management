package com.asset.collabera.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="First name is compulsory")
    @NotBlank(message = "Name can not be empty")
    private String name;

    @NotNull(message="Mobile is compulsory")
    @NotBlank(message = "Mobile can not be empty")
    private String mobile;

    @Email(message = "Email is invalid")
    private String email;

    @Length(min=5, message="Password should be at least 5 characters")
    private String password;

    private String staffID;

}
