package ph.gov.bsp.bcvs.downloader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import ph.gov.bsp.bcvs.dao.TblExtractionTrackerDao;
import ph.gov.bsp.bcvs.entity.TblExtractionTracker;

@Component
public class DownloaderExtractionTracker {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final Logger logger = Logger.getLogger(DownloaderExtractionTracker.class.getName());

    @Autowired
    private TblExtractionTrackerDao trackerDao;


    @PostConstruct
    public void init() {
        logger.info("====================================================");
        logger.info("Downloader ExtractionTracker initialized successfully at " + LocalDateTime.now().format(fmt));
        logger.info("====================================================");
    }

    @Scheduled(fixedDelay = 10000)
    public void runScheduledTask() {
        String currentTime = LocalDateTime.now().format(fmt);
        logger.info("----------------------------------------------------");
        logger.info("[TIME] Scheduled Task Triggered @ " + currentTime);

        try {
            if (trackerDao == null) {
                logger.severe("[ERROR] trackerDao is NULL — cannot continue!");
                return;
            }

            // Claim first pending record
            Optional<TblExtractionTracker> optTracker = trackerDao.claimFirstPending("Ongoing");

            if (!optTracker.isPresent()) {
                logger.info("[INFO] No pending tracker record found.");
                return;
            }

            TblExtractionTracker tracker = optTracker.get();
            logger.info("[INFO] Claimed record ID " + tracker.getRecId() + " as Ongoing");

            // Print date range as example
            String dateFrom = tracker.getDateFrom() != null ? tracker.getDateFrom().toString() : "";
            String dateTo = tracker.getDateTo() != null ? tracker.getDateTo().toString() : "";
            logger.info("[INFO] Date range: " + dateFrom + " to " + dateTo);

        } catch (Exception e) {
            logger.severe("[ERROR] Exception in scheduled task: " + e.getMessage());
            e.printStackTrace();
        }

        logger.info("----------------------------------------------------");
    }
}
