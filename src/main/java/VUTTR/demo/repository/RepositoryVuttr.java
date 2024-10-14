package VUTTR.demo.repository;

import VUTTR.demo.entity.VuttrEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryVuttr extends JpaRepository<VuttrEntity, Long> {
    List<VuttrEntity> findByTagsContaining(String tag);
}
