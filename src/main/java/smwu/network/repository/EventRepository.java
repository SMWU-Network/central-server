package smwu.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smwu.network.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
