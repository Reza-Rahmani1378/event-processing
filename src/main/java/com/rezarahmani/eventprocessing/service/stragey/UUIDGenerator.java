package com.rezarahmani.eventprocessing.service.stragey;

import uk.co.jemos.podam.common.AttributeStrategy;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.UUID;

/**
 * This Class Generate UUID That PodamFactory use this class for Generating UUID value
 */
public class UUIDGenerator implements AttributeStrategy<String> {
    @Override
    public String getValue(Class<?> aClass, List<Annotation> list) {
        return UUID.randomUUID().toString();
    }
}
