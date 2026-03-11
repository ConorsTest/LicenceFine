package gov.groupb.licencefine.databasecontrollers;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface FineRepository extends CrudRepository<Fine, Long> {
    Fine findByRefNum(String refNum);
}
