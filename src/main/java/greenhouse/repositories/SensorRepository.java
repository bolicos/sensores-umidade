package greenhouse.repositories;

import greenhouse.dtos.SensorProjection;
import greenhouse.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
	List<SensorProjection> findAllByStatusTrueOrderByName();
}
