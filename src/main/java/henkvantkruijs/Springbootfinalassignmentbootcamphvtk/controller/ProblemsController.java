package henkvantkruijs.Springbootfinalassignmentbootcamphvtk.controller;

import henkvantkruijs.Springbootfinalassignmentbootcamphvtk.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProblemsController {

    Map<Long, String> data = new HashMap<>();

    ProblemsController() {
        this.data.put(1L, "SelfConfedence");
        this.data.put(2L, "StressedOut");
        this.data.put(3L, "WorryAbout");
    }

    @GetMapping(value = "/problems")
    public ResponseEntity<Object> getProblems() {
        return new ResponseEntity<Object>(this.data.values(), HttpStatus.OK);
    }

    @GetMapping(value = "/problems/{id}")
    public ResponseEntity<Object> getProblem(@PathVariable("id") Long id) {
        if (!this.data.keySet().contains(id)) {
            throw new RecordNotFoundException();
        }
            return new ResponseEntity<Object>(this.data.get(id), HttpStatus.OK);
    }

    @DeleteMapping (value = "/problems/{id}")
    public ResponseEntity<Object> deleteProblem(@PathVariable("id") Long id) {
        this.data.remove(id);
        return new ResponseEntity<Object>("Record deleted", HttpStatus.NO_CONTENT);
    }

    @PostMapping (value = "/problems")
    public ResponseEntity<Object> addProblem(@RequestBody String problemName) {
        long maxID = this.data.keySet().stream().max(Comparator.comparing(Long::valueOf)).get();
        this.data.put(maxID + 1, problemName);
        return new ResponseEntity<Object>("Record created", HttpStatus.NO_CONTENT);
    }

    @PutMapping (value = "/problems/{id}")
    public ResponseEntity<Object> updateProblem(@PathVariable("id") Long id, @RequestBody String problemName) {
        this.data.put(id, problemName);
        return new ResponseEntity<Object>("Record updated", HttpStatus.OK);
    }

}
