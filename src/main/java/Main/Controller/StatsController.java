package Main.Controller;

import Main.Stats;
import Main.StatsRepository;
//import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StatsController {

    private final Logger log = LoggerFactory.getLogger(StatsController.class);
    private StatsRepository statsRepository;

    public StatsController(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

        @GetMapping("/stats")
        Collection<Stats> stats() {
            return statsRepository.findAll();
        }

        @GetMapping("/stats/{id}")
        ResponseEntity<?> getStats(@PathVariable Long id) {
            Optional<Stats> stats = statsRepository.findById(id);
            return stats.map(response -> ResponseEntity.ok().body(response))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }

        @PostMapping("/stats")
        ResponseEntity<Stats> createStatss(@RequestBody Stats stats) throws URISyntaxException {
            log.info("Post" + stats.toString());
            Stats result = statsRepository.save(stats);
            return ResponseEntity.created(new URI("/api/stats/" + result.getId()))
                    .body(result);
        }
//
//        @PutMapping("/group/{id}")
//        ResponseEntity<Group> updateGroup(@Valid @RequestBody Group group) {
//            log.info("Request to update group: {}", group);
//            Group result = groupRepository.save(group);
//            return ResponseEntity.ok().body(result);
//        }
//
//        @DeleteMapping("/group/{id}")
//        public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
//            log.info("Request to delete group: {}", id);
//            groupRepository.deleteById(id);
//            return ResponseEntity.ok().build();
//        }
//    }

}
