package com.enelWs.EnelMicroservicesWs.Repository;

import com.enelWs.EnelMicroservicesWs.Entity.AnreSummary;
import com.enelWs.EnelMicroservicesWs.Entity.AnreSummaryHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnreSummaryHistoryRepository extends JpaRepository<AnreSummaryHistory,Long> {

}
