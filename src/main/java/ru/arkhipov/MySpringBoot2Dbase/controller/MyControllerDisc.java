package ru.arkhipov.MySpringBoot2Dbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arkhipov.MySpringBoot2Dbase.entity.Disc;
import ru.arkhipov.MySpringBoot2Dbase.service.DiscService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyControllerDisc {

    @Autowired
    private DiscService discService;

    @GetMapping("/discs")
    public ResponseEntity<List<Disc>> allDiscs() {
        List<Disc> allDiscs = discService.getAllDiscs();
        if (allDiscs.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }
        return ResponseEntity.ok(allDiscs); // HTTP 200 OK
    }

    @GetMapping("/discs/{id}")
    public ResponseEntity<?> getDisc(@PathVariable("id") int id) {
        Disc disc = discService.getDisc(id);
        if (disc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disc not found"); // HTTP 404 Not Found
        }
        return ResponseEntity.ok(disc); // HTTP 200 OK
    }

    @PostMapping("/discs")
    public ResponseEntity<Disc> saveDisc(@RequestBody Disc disc) {
        try {
            Disc savedDisc = discService.saveDisc(disc);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedDisc); // HTTP 201 Created
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // HTTP 500 Internal Server Error
        }
    }

    @PutMapping("/discs")
    public ResponseEntity<?> updateDisc(@RequestBody Disc disc) {
        Disc existingDisc = discService.getDisc(disc.getId());
        if (existingDisc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disc not found"); // HTTP 404 Not Found
        }
        discService.saveDisc(disc);
        return ResponseEntity.ok("Disc updated successfully"); // HTTP 200 OK
    }

    @DeleteMapping("/discs/{id}")
    public ResponseEntity<String> deleteDisc(@PathVariable("id") int id) {
        Disc disc = discService.getDisc(id);
        if (disc == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Disc not found"); // HTTP 404 Not Found
        }
        discService.deleteDisc(id);
        return ResponseEntity.ok("Disc deleted successfully"); // HTTP 200 OK
    }


}
