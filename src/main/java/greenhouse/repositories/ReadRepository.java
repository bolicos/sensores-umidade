package greenhouse.repositories;

import greenhouse.models.Read;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadRepository extends JpaRepository<Read, Integer> {

}