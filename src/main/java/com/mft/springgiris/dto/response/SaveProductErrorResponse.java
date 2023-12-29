package com.mft.springgiris.dto.response;

import lombok.*;
@Builder

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SaveProductErrorResponse {
    String errorMesage;
}
