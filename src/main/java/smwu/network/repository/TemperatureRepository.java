package smwu.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smwu.network.entity.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
}