package com.example.jpa2_app;

import com.example.jpa2_app.entities.*;
import com.example.jpa2_app.repositories.ConsultationRepository;
import com.example.jpa2_app.repositories.MedecinRepository;
import com.example.jpa2_app.repositories.PatientRepository;
import com.example.jpa2_app.repositories.RendezVousRepository;
import com.example.jpa2_app.service.IHospitalService;
import com.example.jpa2_app.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Jpa2AppApplication  {

	public static void main(String[] args) {
		SpringApplication.run(Jpa2AppApplication.class, args);
	}
@Bean
 CommandLineRunner start(UserService userService){
		return  args -> {
			User u=new User();
			u.setUserName("user1");
			u.setPassword("123456");
			userService.addNewUser(u);

			User u2=new User();
			u2.setUserName("admin");
			u2.setPassword("123456");
			userService.addNewUser(u2);

			Stream.of("STUDENT","USER","ADMIN")
			.forEach(r-> {
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);

			});
			//affecter role a user
			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","USER");
			userService.addRoleToUser("admin","ADMIN");


      //ajouter authentification

          try {
			  User user=userService.authentificate("user1","123456");
			  System.out.println(user.getUserId());
			  System.out.println(user.getUserName());
			  System.out.println("Roles=>");
			  user.getRoles().forEach(r->{
				  System.out.println("Roles"+r.toString());
			  });
		  }catch (Exception e){
			  e.printStackTrace();
		  }


		};

 }






	//quand je mets un objet on fait linjection du controle et sans pas besoin de declarer un objet et avec autowired
	//juste spring qui va faire l injection des dependance
//@Bean
	//CommandLineRunner start(IHospitalService hospitalService,
			//PatientRepository patientRepository,
			//MedecinRepository medecinRepository,
			//RendezVousRepository rendezVousRepository
            ///*ConsultationRepository consultationRepository*/)
//{
       //return args -> {
		  // Stream.of("Rim","Hassan","Najat")
				   //.forEach(name-> {
					//   Patient patient = new Patient();
					   //patient.setNom(name);
					   //patient.setDateNaissance(new Date());
					   //patient.setMalade(false);
					  // /*patientRepository*/hospitalService.savePatient(patient);
				   //});
		   //patientRepository.save(new Patient(null,"rim",new Date(),false,null)); je vais la faire avec constructeur
		   //Stream.of("Fahd","Youssra","Lina")
				  // .forEach(name-> {
					   //Medecin medecin = new Medecin();
					   //medecin.setNom(name);
					  // medecin.setEmail(name+"@gmail.com");
					  // medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
					  // /*medecinRepository*/hospitalService.saveMedecin(medecin);
				 //  });
		   //chercher le patient par son nom et id
            //Patient patient=patientRepository.findById(1l).get(); ou
		 // Patient patient=patientRepository.findById(1L).orElse(null);
	// Patient patient1=patientRepository.findByNom("Rim");

	//Medecin medecin=medecinRepository.findByNom("Lina");
		   //cree un rendez vous qui concerne un patient et un medecin qui existe deja
			//RendezVous rendezVous=new RendezVous();
			// rendezVous.setDate(new Date());
			//rendezVous.setStatus(StatusRDV.PENDING);
			//rendezVous.setMedecin(medecin);
	//rendezVous.setPatient(patient);
		   //rendezVousRepository.save(rendezVous);
			//RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
		   //enregistrer rdv et consulter rdv pour voir son id
	//System.out.println(saveDRDV.getId());
		   //chercher le rendezvous pour faire la consultation
		   //RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
	//RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
	// Consultation consultation= new Consultation();
	//consultation.setDateConsultation(new Date());
	// consultation.setRendezVous(rendezVous1);
	// consultation.setRapport("Rapport de la consultation ....");
	// /*consultationRepository*/hospitalService.saveConsultation(consultation);

//la couche presentation il va utiliser la couche metier et celui ci va utiliser couche dao
	// };
	//}
}
