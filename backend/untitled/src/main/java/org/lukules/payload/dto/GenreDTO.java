package org.lukules.payload.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {

    private Long id;

    @NotBlank(message = "Genre code is required")
    private String code;

    @NotBlank(message = "Genre name is required")
    private String name;

    @Size(max = 500, message = "Depscription must not exceed 500 characters")
    private String description;

    @Min(value = 0, message = "Display order cannot be negative")
    private Integer displayOrder = 0;




}
