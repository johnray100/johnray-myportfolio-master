package ph.gov.bsp.bcvs.dao;

import ph.gov.bsp.bcvs.entity.TblExtractionTracker;
import java.util.Optional;

public interface TblExtractionTrackerDao {
    
    /**
     * Claims the first pending record and updates its status.
     * @param newStatus the new status to set
     * @return Optional containing the claimed record, or empty if no pending records found
     */
    Optional<TblExtractionTracker> claimFirstPending(String newStatus);
}
