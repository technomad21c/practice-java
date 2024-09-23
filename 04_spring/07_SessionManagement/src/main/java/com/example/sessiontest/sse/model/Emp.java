package com.example.sessiontest.sse.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Table(name="employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;
    @Column(name = "gender")
    String gender;
    @Column(name = "email", nullable = false)
    String email;
    @Column(name = "phone_number", unique = true)
    String phoneNumber;
    @Column(name = "home_address")
    String homeAddress;

}
