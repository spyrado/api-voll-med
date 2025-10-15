package med.voll.api_voll_med.repository;

import med.voll.api_voll_med.model.entity.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
  Page<Medico> findByAtivoTrue(Pageable pageable);
}
