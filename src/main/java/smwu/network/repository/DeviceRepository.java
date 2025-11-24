package smwu.network.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smwu.network.entity.Device;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Optional<Device> findByDeviceId(String deviceId);
}
