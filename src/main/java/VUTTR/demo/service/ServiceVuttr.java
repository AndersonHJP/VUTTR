package VUTTR.demo.service;

import VUTTR.demo.entity.VuttrEntity;
import VUTTR.demo.repository.RepositoryVuttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceVuttr {
    @Autowired
    private RepositoryVuttr repositoryVuttr;

    public VuttrEntity createVuttr(VuttrEntity vuttr) {
        return repositoryVuttr.save(vuttr);
    }

    public List<VuttrEntity> getAllVuttr() {
        return repositoryVuttr.findAll();
    }

    public VuttrEntity getVuttrById(Long id) {
        return repositoryVuttr.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuttr not found"));
    }

    public VuttrEntity updateVuttr(Long id, VuttrEntity vuttrDetails) {
        VuttrEntity vuttr = getVuttrById(id);
        vuttr.setTitle(vuttrDetails.getTitle());
        vuttr.setDescription(vuttrDetails.getDescription());
        vuttr.setLink(vuttrDetails.getLink());
        vuttr.setTags(vuttrDetails.getTags());
        return repositoryVuttr.save(vuttr);
    }

    public void deleteVuttr(Long id) {
        repositoryVuttr.deleteById(id);
    }

    public List<VuttrEntity> getVuttrByTag(String tag) {
        return repositoryVuttr.findByTagsContaining(tag);
    }
    // Metodos para CRUD
}
