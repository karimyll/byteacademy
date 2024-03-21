package com.byteacademy.byteacademy.model.group.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterGroupDTO {
    private Long number;
    private String name;
}
