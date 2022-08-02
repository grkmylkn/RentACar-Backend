package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarImageRepository extends JpaRepository<CarImage, Integer> {
}
