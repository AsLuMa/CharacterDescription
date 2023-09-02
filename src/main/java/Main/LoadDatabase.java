package Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // todo multiple args with one bean? check out CommandLineRunner?
    @Bean
    public Stats initBallisticSkill(StatsRepository stats) {
        Stats shooty = new Stats("Shooty", "Bang");
        stats.save(shooty);

        log.info(shooty.toString());
        return shooty;
    }

    @Bean
    public Stats initStrength(StatsRepository stats) {
        Stats strength = new Stats("Stronk", "STR");
        stats.save(strength);

        log.info(strength.toString());
        return strength;
    }
}