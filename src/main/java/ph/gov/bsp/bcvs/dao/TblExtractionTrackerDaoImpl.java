package ph.gov.bsp.bcvs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ph.gov.bsp.bcvs.entity.TblExtractionTracker;

import java.util.List;
import java.util.Optional;

@Service
public class TblExtractionTrackerDaoImpl implements TblExtractionTrackerDao {

    @Autowired
    private TblExtractionTrackerRepository repository;

    @Override
    @Transactional
    public Optional<TblExtractionTracker> claimFirstPending(String newStatus) {
        List<TblExtractionTracker> pendingRecords = repository.findFirstPending();
        
        if (pendingRecords.isEmpty()) {
            return Optional.empty();
        }
        
        TblExtractionTracker tracker = pendingRecords.get(0);
        tracker.setStatus(newStatus);
        repository.save(tracker);
        
        return Optional.of(tracker);
    }
}
