package ma.emsi.patientsmvc;

import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"toto",32,new Date(),false));
            patientRepository.save(new Patient(null,"tata",25,new Date(),false));
            patientRepository.save(new Patient(null,"titi",20,new Date(),true));
            patientRepository.save(new Patient(null,"tete",40,new Date(),true));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
}
}
