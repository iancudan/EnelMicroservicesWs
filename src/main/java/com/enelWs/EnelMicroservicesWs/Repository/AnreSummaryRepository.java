package com.enelWs.EnelMicroservicesWs.Repository;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnreSummaryRepository extends JpaRepository<AnreSummary,Long> {

}
