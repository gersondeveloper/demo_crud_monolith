package exe.badge.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String about;
    private String address;
    private Long age;
    private String balance;
    private String company;
    private String email;
    private String eyeColor;
    private String gender;
    private Boolean isActive;
    private Double latitude;
    private Double longitude;
    private String name;
    private String phone;
    private String picture;
    private String registered;
}