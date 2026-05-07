package com.manish.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	@Column(nullable = false)
	@NotBlank(message = "Product name is required")
	private String productName;

	@NotBlank(message = "Author name is required")
	private String authorName;

	@NotBlank(message = "Category is required")
	private String category;

	@NotNull(message = "Price is required")
	@Positive(message = "Price must be greater than 0")
	private Double price;

	@NotNull(message = "Stock is required")
	@PositiveOrZero(message = "Stock cannot be negative")
	private Integer stock;

	@Size(min = 10, max = 200, message = "Description must be between 10 and 200 characters")
	private String description;

	private LocalDate createAt = LocalDate.now();
}
