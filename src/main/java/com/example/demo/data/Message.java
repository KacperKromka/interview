package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Entity
@Table(value = "message")
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Message {
		
	@PrimaryKey
	@Column("id")
	UUID id = UUID.randomUUID();

    @Column("email")
    private  String email;

    @Column("title")
    private  String title;

    @Column("content")
    private  String content;

    @JsonProperty("magic_number")
    @Column("magic_number")
    private int magicNumber;
    
    @Column("createdAt")
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    
	
}
