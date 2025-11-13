package ph.gov.bsp.bcvs.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.bsp.bcvs.entity.TblExtractionTracker;

import java.util.List;
import java.util.Optional;

@Repository
public interface TblExtractionTrackerRepository extends JpaRepository<TblExtractionTracker, Long> {
    
    @Query("SELECT t FROM TblExtractionTracker t WHERE t.status = 'Pending' ORDER BY t.recId ASC")
    List<TblExtractionTracker> findFirstPending();
}
