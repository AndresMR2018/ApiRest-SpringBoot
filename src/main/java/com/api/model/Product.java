package com.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product", catalog="dbspring")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column @Getter @Setter
private String name;

@Column @Getter @Setter
private Double price;

@Column @Getter @Setter
private String description;


}
