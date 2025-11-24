package smwu.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smwu.network.entity.HeartRate;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
}