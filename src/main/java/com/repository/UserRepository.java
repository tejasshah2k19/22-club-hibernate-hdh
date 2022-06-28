package com.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;


@Repository
public interface UserRepository extends CrudRepository<UserBean, UUID> {
	List<UserBean> findAll();

}
