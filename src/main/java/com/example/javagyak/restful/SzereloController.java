package com.example.javagyak.restful;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.javagyak.lekerdezes.Szerelo;
import org.springframework.web.bind.annotation.*;
@RestController
public class SzereloController {
    private final SzereloRepository repo;
    SzereloController(SzereloRepository repo) { // Dependency injection
        this.repo = repo;
    }
    @GetMapping("/Szerelok")
    Iterable<Szerelo> olvasMind() {
        return repo.findAll();
    }
    @GetMapping("/Szerelok/{id}")
    Szerelo olvasEgy(@PathVariable Long id) {
        return repo.findById((long)id)
                .orElseThrow(() -> new SzereloNotFoundException(id));
    }
    @PostMapping("/Szerelok")
    Szerelo SzereloFeltolt(@RequestBody Szerelo ujSzerelo) {
        return repo.save(ujSzerelo);
    }
    @PutMapping("/Szerelok/{id}")
    Szerelo SzereloModosit(@RequestBody Szerelo adatSzerelo, @PathVariable int id) {
        return repo.findById((long) id)
                .map(a -> { // Lambda kifejezés
                    a.setNev(adatSzerelo.getNev());
                    a.setKezdev(adatSzerelo.getKezdev());

                    return repo.save(a);
                })
                .orElseGet(() -> { // ha nincs ilyen id-jű személy, akkor vegye fel új rekordnak
                    adatSzerelo.setId(id);
                    return repo.save(adatSzerelo);
                });
    }
    @DeleteMapping("/Szerelok/{id}")
    void torolSzerelo(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
