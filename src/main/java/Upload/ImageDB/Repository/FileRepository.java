package Upload.ImageDB.Repository;

import java.nio.file.Files;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<Files, Long>{

	Files findByName(String name);

}
