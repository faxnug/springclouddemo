package com.why.microserviceprovider.dao;

import com.why.microserviceprovider.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author WHY
 * @Date 2020-12-17
 * @Version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
