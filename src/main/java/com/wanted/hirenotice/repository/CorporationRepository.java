package com.wanted.hirenotice.repository;

import com.wanted.hirenotice.domain.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationRepository extends JpaRepository<Corporation,Long> {

}
