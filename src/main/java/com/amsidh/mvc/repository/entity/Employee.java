package com.amsidh.mvc.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
