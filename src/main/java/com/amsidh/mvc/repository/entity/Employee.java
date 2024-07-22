package com.amsidh.mvc.repository.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
@RedisHash("Employee")
public class Employee implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
