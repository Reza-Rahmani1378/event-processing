package com.rezarahmani.eventprocessing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddEvent {


    @PrimaryKey
    @Column(value = "request_id")
    private String requestId;

    @Column(value = "ad_id")
    private String adId;

    @Column(value = "add_title")
    private String addTitle;

    @Column(value = "advertiser_cost")
    private Double advertiserCost;

    @Column(value = "app_id")
    private String appId;

    @Column(value = "app_title")
    private String appTitle;

    @Column(value = "impression_time")
    private Long impressionTime;

    @Column(value = "click_time")
    private Long clickTime;
}
