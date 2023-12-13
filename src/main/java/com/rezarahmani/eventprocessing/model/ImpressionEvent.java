package com.rezarahmani.eventprocessing.model;


import com.rezarahmani.eventprocessing.service.stragey.UUIDGenerator;
import lombok.Data;
import uk.co.jemos.podam.common.PodamLongValue;
import uk.co.jemos.podam.common.PodamStrategyValue;

@Data
public class ImpressionEvent {

    @PodamStrategyValue(value = UUIDGenerator.class)
    private String requestId;

    private String adId;

    private String addTitle;

    private Double advertiserCost;

    private String appId;

    private String appTitle;

    // impressionTime according to day.
    @PodamLongValue(minValue = 1 , maxValue = 7)
    private Long impressionTime;
}
