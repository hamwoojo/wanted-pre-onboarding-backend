package com.wanted.hirenotice.repository;

import com.wanted.hirenotice.domain.HireNotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HireNoticeRepository extends JpaRepository<HireNotice,Long> {

}
