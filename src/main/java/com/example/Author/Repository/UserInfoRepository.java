package com.example.Author.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Author.Model.UserInfo;



@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
		public Optional<UserInfo> findByUsername(String username);
}
