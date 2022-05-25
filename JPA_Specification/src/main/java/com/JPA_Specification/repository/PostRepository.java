package com.JPA_Specification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.JPA_Specification.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {

}
