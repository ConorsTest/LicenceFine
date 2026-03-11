package gov.groupb.licencefine.databasecontrollers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadFines {

    @Bean
    CommandLineRunner initDatabase(FineRepository repo) {
        return args -> {
            repo.save(new Fine("3850285629183759",
                    234.56F,
                    false,
                    "01/01/01",
                    "02/02/02",
                    "6 Funny Street",
                    "",
                    "Dumbtown",
                    "",
                    "DB6 9SH"
                    ));
            repo.save(new Fine("2073045712093845",
                    53.85F,
                    true,
                    "01/01/01",
                    "02/02/02",
                    "6 Sad Street",
                    "",
                    "Smarttown",
                    "Up",
                    "DB6 9SH"
            ));
        };
    }
}
