package com.example.rising.src.sale.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PutSoldReq {
    @NotNull
    private long postIdx;
    @NotNull
    private String status;
}
