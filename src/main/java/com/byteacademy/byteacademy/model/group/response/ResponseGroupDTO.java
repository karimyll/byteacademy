package com.byteacademy.byteacademy.model.group.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseGroupDTO {
    private Long id;
    private Long number;
    private String name;
    private LocalDate createdDate;
}
