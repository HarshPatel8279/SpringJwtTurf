package com.SpringJwtTurf.models;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class AllSlot {
    private LocalDateTime shopOpenTime;
    private LocalDateTime shopCloseTime;



}
