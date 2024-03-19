package ma.enset.hospitalapp;

import ma.enset.hospitalapp.entities.Patient;
import ma.enset.hospitalapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class HospitalAppApplication implements CommandLineRunner  {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalAppApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"khadija", false, 70, new Date()));
            patientRepository.save(new Patient(null,"imane", false, 90, new Date()));
            patientRepository.save(new Patient(null,"zineb", false, 80, new Date()));
        };
    }


    @Override
    public void run(String... args) throws Exception {
       /* Patient patient1= new Patient();
        patient1.setId(null);
        patient1.setNom("khadija");
        patient1.setDateNaissance(new Date());
        patient1.setMalade(false);
        patient1.setScore(23);

        Patient patient2= new Patient(null,"hamza",new Date(),false,60);

        // en utilisant lombok
        Patient patient3 = Patient.builder()
                         .nom("imane")
                         .dateNaissance(new Date())
                         .malade(false)
                         .score(70)
                         .build();*/

               /* patientRepository.save(new Patient(null,"khadija", false, 70, new Date()));
                patientRepository.save(new Patient(null,"imane", false, 90, new Date()));
                patientRepository.save(new Patient(null,"zineb", false, 80, new Date()));*/

    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
