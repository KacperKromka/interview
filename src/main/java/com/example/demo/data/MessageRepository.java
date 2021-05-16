package com.example.demo.data;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


@Repository
public interface MessageRepository extends CassandraRepository<Message, UUID> {

	@AllowFiltering
    List<Message> findMessageByMagicNumber(int magicNumber);
	@AllowFiltering
    Slice<Message> findMessagesByEmail(String emailValue, Pageable pageable);
	@AllowFiltering
    List<Message> findMessageByCreatedAtBefore(Timestamp expiryTime);   
}
