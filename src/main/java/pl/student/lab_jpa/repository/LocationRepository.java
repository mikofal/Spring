package pl.student.lab_jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.student.lab_jpa.model.Location;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {

    Page<Location> findByCountry(@Param("country") String country, Pageable pageable);

    Location findByCity(@Param("city") String city);
}