package smwu.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smwu.network.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
