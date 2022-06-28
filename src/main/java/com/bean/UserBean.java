package com.bean;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
public class UserBean {
	@Id
	@GeneratedValue
	UUID userId;
	int role,userStatus;
	@Column(name="user_name")
	String userName;
	
	

}
