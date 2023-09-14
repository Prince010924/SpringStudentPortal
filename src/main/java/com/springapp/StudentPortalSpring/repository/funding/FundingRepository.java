package com.springapp.StudentPortalSpring.repository.funding;

import com.springapp.StudentPortalSpring.model.Funding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FundingRepository extends JpaRepository<Funding, Long> {
}