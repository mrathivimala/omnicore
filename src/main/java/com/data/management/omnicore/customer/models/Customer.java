package com.data.management.omnicore.customer.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "customer_data", indexes = {
        @Index(name = "idx_code_stat", columnList = "customer_code,status"),
        @Index(name = "idx_code", columnList = "customer_code")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_code", length = 30, nullable = false, unique = true)
    private String customerCode;
    @Column(name = "customer_name", length = 50, nullable = false)
    private String customerName;
    @Column(name = "customer_gender", length = 10, nullable = false)
    private String customerGender;
    @Column(columnDefinition = "DATE", nullable = false, name = "customer_dob")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;
    @Column(columnDefinition = "INT DEFAULT 0", nullable = false, name = "customer_age")
    private Integer age;
    @Column(name = "customer_address", length = 255)
    private String address;
    @Column(name = "customer_city", length = 255)
    private String city;
    @Column(name = "customer_state", length = 255)
    private String state;
    @Column(name = "customer_country", length = 255)
    private String country;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CustomerStatus status = CustomerStatus.ACTIVE;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


    public enum CustomerStatus {
        ACTIVE,
        INACTIVE,
        BLOCKED
    }


}
