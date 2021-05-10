package com.example.demo.data;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;
import java.util.UUID;

import org.hibernate.annotations.Entity;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Entity
@Table(value = "message")
//@AllArgsConstructor
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
    
    public UUID getId() {
    	return id;
    }
    
    public void setId(UUID id) {
    	this.id = id;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getTitle() {
    	return title;
    }
    
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public String getContent() {
    	return content;
    }
    
    public void setContent(String content) {
    	this.content = content;
    }
    
    
   public int getMagicNumber() {
	   return magicNumber;
   }
   
   public void setMagicNumber(int number) {
	   this.magicNumber = number;
   }
}
