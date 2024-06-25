package com.ritik.vo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer animalId;

  private String animalImage;

  @Column(name = "type", length = 100, nullable = false)
  private String animalType;

  private String gender;

  private Boolean isMicrochip;

  @Column(length = 1000000000)
  private String additionalInfo;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
    name = "animal_location",
    joinColumns = @JoinColumn(name = "animal", referencedColumnName = "animalId"),
    inverseJoinColumns = @JoinColumn(name = "location", referencedColumnName = "id")
  )
  private Set<Location> locations = new HashSet<>();
}

