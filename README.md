# spring

<h1><a href="https://spring.io/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="20" height="20"/> </a>Développement web avec Spring et Thymeleaf</h1>


<img src="https://www.vincenzoracca.com/images/spring.png" alt="Spring picture">
<h3>Bonjour !</h3>
<h3>Table de matiere :</h3>
<ul>
<li><strong><a href="https://github.com/TmaneChouaib/spring01">Implementation du CRUD partie 1 </a></strong></li>
<li><strong><a href="https://github.com/TmaneChouaib/spring02">Implementation du CRUD partie 2</a></strong></li>
<li><strong><a href="https://github.com/TmaneChouaib/spring03">Implementation de la securité partie 3</a></strong></li>
</ul>
<p>Ce tutoriel permet de créer une application web de gestion de patients en utilisant Spring, Spring Boot, Spring Security, Spring Data JPA, Thymeleaf et MySQL.
En suivant ces étapes vous pouvez créer une application simple ! ,Ce Tp a pour but d'apprendre Spring .</p>
<h3>Objectif :</h3>
<p>Dans 
<strong><a href="https://github.com/TmaneChouaib/spring01">la 1ère partie</a></strong>
Et
<strong><a href="https://github.com/TmaneChouaib/spring02">la 2ème partie</a></strong> 
on vas Implementer notre CRUD "les methode classique". Apres dans 
on vas Implementer notre logique de Securité dans <strong><a href="https://github.com/TmaneChouaib/spring02">la 3ème partie</a></strong> pour finire l application en beauté.</p>
 
 <h3>Note:</h3>
<p>Ce tutoriel est déstiné au débutans de Spring comme moi<strong> "plus ou moin" 😄</strong></p>
<p>Pret?<strong> on y vas!</strong></p>

<h1>Première partie</h1>
<h2>1.Structure du Code :</h2>
<ul>
  <li><strong>le package entities</strong>: vas contenire nos entités</li>
  <li><strong>le package repositories</strong>: vas contenire la couche DAO</li>
  <li><strong>le package web</strong>: vas contenire la couche web</li>
</ul>
<img src="pictureDocumentation/structureDuCode.png" alt="structure du code">


<h2>2.Le fichier<code>pom.xml</code> :</h2>
<a href="https://gist.github.com/TmaneChouaib/03434519fee77e7a28c4cd00ff0624ba">Code Source</a>

```Bash
    <dependency>
        <groupId>org.webjars</groupId>
        <artifactId>bootstrap</artifactId>
        <version>5.2.3</version>
    </dependency>

    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.32</version>
    </dependency>
 ```

<ul>
  <li>On a ajouter la dépendance de <strong>Bootstrap</strong> à notre projet.</li>
  <li>Aussi la dépendance du driver <strong>MySQL</strong>, pour permettre à notre application de s'interagir avec la base de données MySQL.</li>
</ul>
<h3>note:</h3>
<p>le fichier <code>pom.xml</code> est un fichier de configuration maven qui permet de déclarer les dependances nécessaires à notre application et de gérer les différentes versions de ces dépendances.</p>

<h2>3.<code>PatientsMvcApplication</code> la classe principale de l'application Spring Boot :</h2>
<a href="https://gist.github.com/TmaneChouaib/97b75be7b154215b6c7af3d3b0205453">Code Source</a>

```Bash
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
            patientRepository.save(new Patient(null,"toto",new Date(),false,12));
            patientRepository.save(new Patient(null,"toto",new Date(),false,14));
            patientRepository.save(new Patient(null,"tata",new Date(),true,8));
            patientRepository.save(new Patient(null,"tata",new Date(),true,17));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getNom());
            });
        };
}
}
 ```
<h3>Description des annotation utilisé dans cette <code>Classe</code> :</h3>
<ul>
<li><code>@SpringBootApplication </code> : est une annotation qui est utilisée pour définire que la classe principale de l'application est une application Spring Boot.</li>
<li><code>@Bean </code> : indique à Spring que la méthode dans notre classe retourne un object qui doit être enregistré en tant que bean Spring.</li>
<li><code>CommandLineRunner </code> : est une interface fonctionnelle de Spring Boot. Elle permet d'exécuter une méthode lors du démarrage de l'application.</li>
</ul>

<h2>4.<strong>application.properties</strong> :</h2> 
<a href="https://gist.github.com/TmaneChouaib/33fdfe3b81afd6aaac2026460f6d201d">Code Source</a>

```Bash
server.port=8082
spring.datasource.url=jdbc:mysql://localhost:3306/DB_Patients?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.influx.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
 ```
<h3>Les propriétés de configuration pour Spring Boot et Hibernate utilisé sont :</h3>
<ul>
<li><code>spring.jpa.hibernate.ddl-auto</code> : Spésifie la stratégie de mise a jour de la base de données par Hibernate.</li>
<li><code>spring.jpa.properties.hibernate.dialect</code> : Spécifie le dialect de la base de données pour Hibernate.</li>
<li><code>spring.jpa.show-sql</code> : Active l'affichage des requêtes SQL exécutées par Hibernate. Les requêtes seront affichées dans la console de log de notre application</li>
<li><code>spring.thymeleaf.cache</code> : Spécifie si le cache de Thymeleaf doit être activé ou non. Dans notre exemple  il est désactivé.</li>
</ul>

<h3>note:</h3>
<p>Ces propiétés sont utilisées pour configurer l'application Spring Boot. Par exemple la propriété <strong>spring.jpa.hibernate.ddl-auto</strong>
définit la stratégie de mise à jour de la base de données. La valeur de cette propriété peut être <code>update</code>, <code>create</code>,
en fonction de l'effet souhaité sur la base de données.</p>
<h3>Pour plus de détailles visite :</h3>
<ul>
<li><a href="https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html">documentation officielle de Spring Boot</a></li>
<li><a href="https://docs.jboss.org/hibernate/orm/5.5/userguide/html_single/Hibernate_User_Guide.html#configuration-optional-properties">documentation officielle de Hibernate
</a></li>
</ul>
<p></p>
<h3>Attention !</h3>
<p>Note bien que la documentation de <code>Spring Boot</code> et <code>Hibernate</code> peut causer une dépendance sévère à la caféine et à la lecture sans fin.
Prend juste <strong>le nécessaire</strong> cher lecteur :) !</p>

<h2>5.L'entité <code>Patient.java</code> dans le package entities :</h2>
<a href="https://gist.github.com/TmaneChouaib/e271b4191906c2d61277839df507a96e">Code Source</a>


 ```Bash
package ma.emsi.patientsmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean malade;
    private int score;
}
 ```

<p>Notre entité <code>Patient</code> contient les annotations suivantes:</p>
<ul>
<li><code>@Entity</code> : Cette annotation indique que la classe est une entité JPA et qu'elle doit être mappée a une table de la base de données.</li>
<li><code>@Data</code> : Cette annotation est fournie par Lombok et elle génère automatiquement les méthodes getters, setters, toString, equals et hashCode.</li>           
<li><code>@AllArgsConstructor</code> : Cette annotations génere un constructeur avec paramètre.</li>
<li><code>@NoArgsConstructor</code> : Cette annotation génere un constructeur sans paramètre.</li>
<li><code>@Id</code> : Cette annotation indique que le champ 'id' est la clé primaire de l'entité.</li>
<li><code>@GeneratedValue</code> : Cette annotation indique que la valeur de la clé primaire sera générée automatiquement par la base de données lors de l'insertion d'une nouvelle entité.</li>
<li><code>@Temporal</code> : cette anotation est utilisé pour spécifier le type de données d'un attribut.</li>
</ul>


<h2>6.L'interface <code>PatientRepository.java</code> dans le package repositories :</h2>
<a href="https://gist.github.com/TmaneChouaib/1b6c331a7d0e36b02f680355a13107ea">Code Source</a>

 ```Bash
package ma.emsi.patientsmvc.repositories;

import ma.emsi.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository <Patient,Long>{
    Page<Patient> findByNomContains(String kw , Pageable pegeable);
}
 ```

<p>L'interface <code>PatientRepository</code> hérite de l'interface <code>JpaRepository</code> fournie par <code> Spring Data JPA </code>.</p>
<ul>
  <li><strong>JpaRepository &lt;Patient,Long&gt;</strong> :</li>
    <ul> 
        <li><code>Patient</code> :est le nom de l'entité sur laquelle cette interface sera appliquée</li>
        <li><code>Long</code> : est le type de données de l'ID de cette entité</li>
    </ul>
        <br><li>La méthode <strong>findByNomContains</strong> :</li>
    <ul>
        <li>La méthode <code>findByNomContains</code> permet de rechercher les patients dont le nom contient une chaîne passé comme parametre</li>
        <li>Cette méthode prend en paramètre <code>kw</code> et l'objet <code>Pageable</code> qui permet de paginer les resultas de la recherche</li>
        <li>La méthode retourne un objet <code>Page</code> contenant le resultat de la recherche ,
        c'est à-dire une liste paginnee des patients correspondants à la recherche.</li>
    </ul>
</ul>


<h2>7.Le controller <code>PatientController.java</code> dans le package web :</h2>
<a href="https://gist.github.com/TmaneChouaib/0e99a69acceb27c996522432d372426c">Code Source</a>

 ```Bash
package ma.emsi.patientsmvc.web;

import lombok.AllArgsConstructor;
import ma.emsi.patientsmvc.entities.Patient;
import ma.emsi.patientsmvc.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping(path="/index")
    public String rechercherPatiens(Model model ,
                           @RequestParam(name="page",defaultValue = "0") int page ,
                           @RequestParam(name="size",defaultValue = "5")  int size ,
                           @RequestParam(name="keyWord", defaultValue = "") String keyWord)
    {
        Page<Patient> pagePatients=patientRepository.findByNomContains(keyWord,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyWord",keyWord);
        //retourne une vue appele patients.html
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id, String keyWord, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyWord="+keyWord;
    }

    @GetMapping("/patientsJson")
    @ResponseBody
    public List<Patient> listePatients(){
        return patientRepository.findAll();
    }
}
```

<ul>
<li><strong>home()</strong> : redirige vers la méthode "rechercherPatients()"</li>
<li><strong>listePatients()</strong> : renvoie la liste de tous les patients. Cette méthode est utilisée pour renvoie une liste de patients au format JSON <code>c'est juste pour un teste</code></li>
<li><strong>rechercherPatients()</strong> : permet de chercher des patients par nom et les afficher paginés dans la vue "patients.html"</li>
<li><strong>delete()</strong> : permet de supprimer un patient par son id</li>
</ul>


<h2>8.La vue <code>patients.html</code> dans le dossier templates :</h2>
<a href="https://gist.github.com/TmaneChouaib/0d1612e5b65d7bca38e1d34f97094792">Code Source</a>

 ```Bash
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-2">
    <div class="card text-center">
        <div class="card-header h1">Liste des patients</div>
        <div class="card-body">
            <form action="get" th:action="@{index}">
                <label>Key word</label>
                <input type="text" name="keyWord" th:value="${keyWord}">
                <button type="submit" class="btn btn-dark">chercher</button>
            </form>
            <table class="table table-light">
                <thead>
                <tr class="table table-dark text-white h3">
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Date</th>
                    <th>Malade</th>
                    <th>Score</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                <tr th:each="p:${listPatients}">
                    <td class="bg-dark text-white h3" th:text="${p.id}"></td>
                    <td th:text="${p.nom}"></td>
                    <td th:text="${p.dateNaissance}"></td>
                    <td th:text="${p.malade}"></td>
                    <td th:text="${p.score}"></td>
                    <td><a onclick="return confirm('Etes vous sure de vouloir supprimer cette ligne?')"
                           class="btn btn-danger" th:href="@{delete(id=${p.id}, keyWord=${keyWord}, page=${currentPage})}">
                        Delete</a></td>
                </tr>
                </tbody>
            </table>

            <ul class="nav nav-pills">
                <li th:each="page,status:${pages}">
                    <a th:class="${status.index==currentPage?'btn btn-dark me-2':'btn btn-outline-dark me-2'}"
                       th:text="${status.index}"
                       th:href="@{index(page=${status.index},keyWord=${keyWord})}">
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>

</body>
</html>
```
<h3>Explication du comportemts des attributs personnalisés dans notre vue <code>patient.html</code></h3>
<ul>
<li><code>th:action="@{index}"</code> :<br>Cela spécifie l'URL à laquelle le formulaire sera soumis lorsqu'il est envoyé. Dans notre exemple le formulaire est envoyé à la méthode rechercherPatients du contrôleur associé à l'URL '/index'.</li><br>
<li><code>th:value="${keyWord}"</code> :<br>Cela récupère la valeur actuelle du paramètre "keyWord" qui a été envoyé avec la requête et l'attribut "value" de l'élément HTML "input".</li><br>
<li><code>th:href="@{delete(id=${p.id}, keyWord={keyWord}, page=${currentPage})}"</code> :<br>Cela spécifie l'URL liée au lien "Delete" les paramètres "id" "keyWord" et "page" seront transmis à cette URL.</li><br>
<li><code>th:class="${status.index==currentPage?"btn btn-dark me-2 ":" btn-outline-dark me-2"}"</code> :<br>Cela aplique un style en fonction de l'index de la page en cours de traitement par la boucle "th:each". Si la page est la page actuellement active "currentPage", la classe "btn btn-dark me-2" est ajoutée sinon la classe "btn btn-outline-dark me-2" est ajoutée.</li>
</ul>  

<h3>Note :</h3>
<p>Le dossier <strong>templates</strong> est le dossier de convention dans lequel Spring Boot recherche les fichiers vues.</p>
    <p>les termes utilisés:</p>

<h2>Résultat Finale de la partie 1 :<a href="https://github.com/TmaneChouaib/spring02">suite Ici</a></h2>

<img src="pictureDocumentation/listePatients.png" alt="Resultat">

<h1><a href="https://github.com/TmaneChouaib/spring02">Partie 2</a></h1>
<p>Merci !</p>