package com.ritik.vo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String postOfficeName;
  private String pincode;
  private String city;
  private String district;
  private String state;

}

