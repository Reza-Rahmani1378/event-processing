package com.rezarahmani.eventprocessing.repository;

import com.rezarahmani.eventprocessing.model.AddEvent;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface AddEventRepository extends CassandraRepository<AddEvent, String> {
}
