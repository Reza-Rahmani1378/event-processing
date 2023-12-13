package com.rezarahmani.eventprocessing.model;

import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamLongValue;

@Data
public class ClickEvent {

    @PodamExclude
    private String requestId;

    @PodamLongValue(minValue = 1 , maxValue = 1000)
    private Long clickTime;
}
