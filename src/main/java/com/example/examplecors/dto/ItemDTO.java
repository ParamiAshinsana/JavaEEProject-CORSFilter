package com.example.examplecors.dto;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class ItemDTO implements Serializable {
    private String code;
    private String description;
    private int qty;
    private double unitPrice;
}
