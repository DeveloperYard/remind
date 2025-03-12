package com.remind.backend.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberJPARepo extends JpaRepository<Member, Long> {
    Member findByEmail(String email);
}
