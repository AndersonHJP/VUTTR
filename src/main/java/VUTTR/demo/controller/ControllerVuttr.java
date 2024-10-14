package VUTTR.demo.controller;

import VUTTR.demo.entity.VuttrEntity;
import VUTTR.demo.service.ServiceVuttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuttr")
public class ControllerVuttr {
    @Autowired
    private ServiceVuttr serviceVuttr;

    @PostMapping
    public VuttrEntity createVuttr(@RequestBody VuttrEntity tuttr) {
        return serviceVuttr.createVuttr(tuttr);
    }

    @GetMapping
    public List<VuttrEntity> getAllVuttr() {
        return serviceVuttr.getAllVuttr();
    }

    @GetMapping("/{id}")
    public VuttrEntity getVuttrById(@PathVariable Long id) {
        return serviceVuttr.getVuttrById(id);
    }

    @PutMapping("/{id}")
    public VuttrEntity updateVuttr(@PathVariable Long id, @RequestBody VuttrEntity vuttrDetails) {
        return serviceVuttr.updateVuttr(id, vuttrDetails);
    }


    //TESTANDO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVuttr(@PathVariable Long id) {
        serviceVuttr.deleteVuttr(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<VuttrEntity> getVuttrByTag(@RequestParam String tag) {
        return serviceVuttr.getVuttrByTag(tag);
    }
    
}
    // Endpoints
