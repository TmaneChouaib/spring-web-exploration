
<h1 style="color:LightGreen"><a href="https://spring.io/" target="_blank" rel="noreferrer" > <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="spring" width="20" height="20"/> </a >Développement web avec Spring et Thymeleaf</h1>

<p align="center"><img src="https://www.vincenzoracca.com/images/spring.png" width="200px" alt="Spring picture"></p>
<h5 style="float: right">👋  Bonjour</h5>
<h5>Comment vous pouvez Utiliser l'application ?</h5>      
<ul>
<li>👉 Pour cloner le projet, ouvrez le terminale et exécuter les comandes suivantes:</li>
<ul>

```Bash
        git clone https://github.com/TmaneChouaib/spring-mvc-app-patient-part-01
```

<li>👉 Pour se rendre sur le project</li>

```Bash
        cd spring-mvc-app-patient-part-01
``` 

<li>👉 Pour nottoyer le project</li>

```Bash
        mvn clean
```

<li>👉 Pour recharger le project</li>

```Bash
        mvn clean install
```
        
</ul>
<li>Ouvrer IntelliJ IDEA et cliquer sur <strong>"Open"</strong> ou <strong>"File"</strong> puis sur <strong>"Open"</strong></li>
<li>Naviguer jusqu'au répertoire où vous avez cloné le project et sélectionnez le, cliquer sur <strong>"Open"</strong> pour ouvrir le project dans IntelliJ IDEA.</li>
<p>Une fois ces étapes terminées, vous pouvez exécuter l'application.</p>
<ul>
<li>👉 Ouvrer votre navigateur et rendez-vous sur l'URL:</li>

```Bash
http://localhost:8085/index
```

</ul>
</ul>

<h3 style="color:#FFC0CB">Note :</h3>
<p>N'oubliez pas de démarrer Apache et MySQL avant d'executer l'application.</p>

<h1>📋Prérequis :</h1>
<ul>
    <li>✅ Avoir installé un JDK (Java Development Kit)</li>
    <li>✅ IntelliJ IDEA ,un environnement de développement intégré pour Java</li>
    <li>✅ Avoir installé XAMPP ou un serveur MySQL intallé sure votre ordinateur</li>
        <ul>
            <li>demarer Apache et MySQL.</li>
        </ul>
</ul>

<h1>🔍 Le Guide :</h1>
<ul>
<li><strong><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-01">Implémentation du CRUD - Partie 1 </a></strong></li>
<li><strong><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-02">Implémentation du CRUD - Partie 2</a></strong></li>
<li><strong><a href="https://github.com/TmaneChouaib/spring-sec-app-patient-part-03">Implémentation de la sécurité - Partie 3</a></strong></li>
</ul>
<p>Ce Tp à pour but de vous guider dans la création d'une application web de gestion de patients en utilisant Spring, Spring Boot, Spring Security, Spring Data JPA, Lombok, Thymeleaf et MySQL. En suivant les étapes décrites, vous serez capable de créer une application simple et d'apprendre les bases de Spring.</p>
<h5>👉La Structure :</h5>
<p>La
<strong><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-01"> première partie </a></strong>
et
<strong><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-02"> deuxième partie </a></strong> 
vous permettront d'implémenter les focntionnalités CRUD.
<br>Dans la <strong><a href="https://github.com/TmaneChouaib/spring-sec-app-patient-part-03"> troisième partie  </a></strong>vous apprendrez à mettre en place la logique de la sécurité de l'application.</p>
 
 <h3 style="color:#FFC0CB">👉Note:</h3>
<p>Ce Tp guidé est concu pour aider les débutans en Spring qui souhaitent découvrir ce framework de manière amusante et ludique. J'ai adoré travailler avec ce framework. C'est pourquoi j'ai crée cette documentation pour partager mon expérience et aider les futurs développeurs débutants à s'initier à Spring<strong> Et je souligne que c'etait ma premiére application que j'ai réaliser en suivant une vidéo YouTube quand j'etait débutant en Spring et j'ai été téllement impréssionné par ce que j'ai appris que j'ai décider de créer cette documentation 😃</strong></p>
<p>Êtes-vous prêt ? <strong> C'est parti!</strong>✈️</p>


#### 📑 Bonne lecture !
----------------------------------------------------------------------------------------------------------


<h1><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-01"><code>Première partie</code></a></h1>
<h2 style="color:LightGreen">1.Structure du Projet :</h2>
<p>◆ Étape NUM 1: Pour créer votre propre project, suivez ces trois étapes simples:</p>
<ul>
<li>1. Ouvrez IntelliJ et sélectionnez "Créer un nouveau projet".</li>
<li>2. Sur la gauche, choisissez <strong>"Spring Initialzr"</strong>.</li>
<li>3. Donnez un nom à votre projet, et un nom de groupe. Je vous recommande de choisir les mêmes noms de projet et de groupe que ceux que j'ai données dans mon exemple,
c'est à-dire <strong>"patients-mvc"</strong> et <strong>"ma.emsi"</strong>, respectivement, cela vous permettra de maintenir une bonne cohérence avec mon code source et évitera les erreurs en relation au namespace... 😉 Si vous rencontrez des problèmes avec votre code source, je pourrais vous aider plus facilement si nous utilisons les mêmes nom de projet de groupe, de classe ... 👍 </li>
<li>4. Sélectionnez le langage <strong>Java</strong>, le type <strong>Maven</strong> et la version <strong>java 8</strong>.</li>
<li>5. cliquez sur suivant et suivez l'etapes suivante pour ajouter les dépendances nécessaires à votre projet.</li>
</ul>
<p align="center"><img src="pictureDocumentation/createNewProject.png"  alt="Spring picture"></p>

<p>◆ Étape NUM 2: Pour ajouter les dependances à votre projet:</p>
<p>Veillez choisir les suivantes: <strong>Spring Data JPA</strong>, <strong>Spring Web</strong>, <strong>Spring Security</strong> et <strong>Lombok</strong>. N'oubliez pas d'ajoutez <strong>Thymeleaf</strong> pour la gestion des vues 👍.</p>
<p align="center"><img src="pictureDocumentation/dependencies.png"  alt="Spring picture"></p>


<p>◆ Étape NUM 3: Maintenant on vas créer trois packages :</p>
<ul>
  <li><strong>1.</strong> le package <strong>"entities"</strong> : contiendra nos entités,</li>
  <li><strong>2.</strong> le package <strong>"repositories"</strong> : contiendra la couche DAO,</li>
  <li><strong>3.</strong> le package <strong>"web"</strong> : contiendra la couche web.</li>
</ul>
<img src="pictureDocumentation/structureDuCode.png" alt="structure du code">


<h2 style="color:LightGreen">2.Le fichier<code>pom.xml</code> :</h2>

```Bash
        <!-- https://mvnrepository.com/artifact/org.webjars/bootstrap -->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>5.2.3</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.32</version>
        </dependency>
 ```

<ul>
  <li>Nous avons ajouté la dépendance de <strong>Bootstrap</strong> à notre projet.</li>
  <li>Aussi la dépendance du driver <strong>MySQL</strong>, pour permettre à notre application de communiquer avec la base de données MySQL.</li>
</ul>
<h3 style="color:#FFC0CB">note:</h3>
<p>le fichier <code>pom.xml</code> est un fichier de configuration <strong>Maven</strong> qui permet de déclarer les dependances 
nécessaires à notre application et de gérer les différentes versions de ces dépendances. Après avoir effectué un changement dans le fichier <code>pom.xml</code>, vous devez cliquer avec le button droit de la souris 🖱️👆 et selectionner "Maven" dans IntelliJ, puis choisir "Reload Project". Cela permettra de recharger les dependances et de mettre à jour le project avec les modifications apportées a votre fichier <code>pom.xml</code></p>


<h2 style="color:LightGreen">3.<code>application.properties</code> :</h2> 

```Bash
server.port=8085
spring.datasource.url=jdbc:mysql://localhost:3306/DB_Patients?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.influx.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
 ```
<p>Les propriétés de configuration pour <code>Spring Boot</code> et <code>Hibernate</code> utilisé sont :</p>
<ul>
<li><code>spring.jpa.hibernate.ddl-auto</code> : Spésifie la stratégie de mise a jour de la base de données par Hibernate.</li>
<li><code>spring.jpa.properties.hibernate.dialect</code> : Spécifie le dialect de la base de données pour Hibernate.</li>
<li><code>spring.jpa.show-sql</code> : Active l'affichage des requêtes SQL exécutées par Hibernate. Les requêtes seront affichées dans la console de log de notre application</li>
<li><code>spring.thymeleaf.cache</code> : Spécifie si le cache de Thymeleaf doit être activé ou non. Dans notre exemple  il est désactivé.</li>
</ul>

<h3 style="color:#FFC0CB">note:</h3>
<p>Ces propiétés sont utilisées pour configurer l'application Spring Boot. Assurez-vous que le port spécifié dans <code>server.port</code> (par exemple : 8085) n'est pas déja utilisé par un autre programme. Si c'est le cas, vous pouvez le changer et choisir un autre port tel que "8086" ou "8087". L'important est qu'il soit un numéro de port plus grand que 8080.</p>
<h3>Pour plus de détailles:</h3>
<ul>
<li><a href="https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html">documentation officielle de Spring Boot</a></li>
<li><a href="https://docs.jboss.org/hibernate/orm/5.5/userguide/html_single/Hibernate_User_Guide.html#configuration-optional-properties">documentation officielle de Hibernate
</a></li>
</ul>
<p></p>
<h3 style="color:#FFC0CB">Attention 😅!</h3>
<p>Note bien que la documentation de <code>Spring Boot</code> et <code>Hibernate</code> peut causer une dépendance sévère à la caféine ☕️ et à la lecture 📚 sans fin.</p>

<h2 style="color:LightGreen">4.L'entité <code>Patient.java</code> dans le package entities :</h2>

 ```JAVA
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private int age;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private boolean sick;
}
 ```

<p>Notre entité <code>Patient</code> contient les annotations suivantes:</p>
<ul>
<li><code>@Entity</code> : Cette annotation indique que la classe est une entité JPA et qu'elle doit être mappée a une table de la base de données.</li>
<li><code>@Data</code> : Cette annotation est fournie par Lombok et elle génère automatiquement les méthodes getters, setters, toString, equals et hashCode.</li>           
<li><code>@AllArgsConstructor</code> : Cette annotation génere un constructeur avec paramètre.</li>
<li><code>@NoArgsConstructor</code> : Cette annotation génere un constructeur sans paramètre.</li>
<li><code>@Id</code> : Cette annotation indique que le champ 'id' est la clé primaire de l'entité.</li>
<li><code>@GeneratedValue</code> : Cette annotation indique que la valeur de la clé primaire sera générée automatiquement par la base de données lors de l'insertion d'une nouvelle entité.</li>
<li><code>@Temporal</code> : cette annotation est utilisée pour spécifier le type de données d'un attribut.</li>
</ul>

<h2 style="color:LightGreen">5.L'interface <code>PatientRepository.java</code> dans le package repositories :</h2>

 ```JAVA
public interface PatientRepository extends JpaRepository <Patient,Long>{
    Page<Patient> findByNameContains(String kw , Pageable pegeable);
}
 ```

<p>L'interface <code>PatientRepository</code> hérite de l'interface <code>JpaRepository</code> fournie par <code> Spring Data JPA </code>.</p>

<p>les termes utilisés:</p>
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


<h2 style="color:LightGreen">6.Le controller <code>PatientController.java</code> dans le package web :</h2>

 ```JAVA
@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @GetMapping("/patientsJson")
    @ResponseBody
    public List<Patient> listePatients(){
        return patientRepository.findAll();
    }

    @GetMapping(path="/index")
    public String index(Model model ,
                           @RequestParam(name="page", defaultValue = "0") int page ,
                           @RequestParam(name="size", defaultValue = "5")  int size ,
                           @RequestParam(name="keyWord", defaultValue = "") String keyWord)
    {
        Page<Patient> pagePatients=patientRepository.findByNameContains(keyWord,PageRequest.of(page,size));
        model.addAttribute("listPatients",pagePatients.getContent());
        model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyWord",keyWord);

        return "patients";
    }

    @GetMapping("/deletePatients")
    public String deletePatients(Long id, String keyWord, int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page="+page+"&keyWord="+keyWord;
    }

}
```

<ul>
<li><strong>home()</strong> : redirige vers la méthode <code>index()</code></li>
<li><strong>listePatients()</strong> : renvoie la liste de tous les patients. Cette méthode est utilisée pour renvoie une liste de patients au format JSON</li>
<li><strong>index()</strong> : permet de chercher des patients par nom et les afficher paginés dans la vue <code>patients.html</code></li>
<li><strong>deletePatients()</strong> : permet de supprimer un patient par son id</li>
</ul>

<h2 style="color:LightGreen">7.<code>PatientsMvcApplication</code> la classe principale de l'application Spring Boot :</h2>

```JAVA
@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null,"toto",30,new Date(),false));
            patientRepository.save(new Patient(null,"tata",25,new Date(),true));
            patientRepository.save(new Patient(null,"lolo",20,new Date(),false));
            patientRepository.save(new Patient(null,"lala",40,new Date(),true));

            patientRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
}
}
 ```
<p>Description des annotations utilisée dans cette <code>Classe</code> :</p>
<ul>
<li><code>@SpringBootApplication </code> : est une annotation qui est utilisée pour définire que la classe principale de l'application est une application Spring Boot.</li>
<li><code>@Bean </code> : indique à Spring que la méthode dans notre classe retourne un object qui doit être enregistré en tant que bean Spring.</li>
<li><code>CommandLineRunner </code> : est une interface fonctionnelle de Spring Boot. Elle permet d'exécuter une méthode lors du démarrage de l'application.</li>
</ul>


<h2 style="color:LightGreen">8.La vue <code>patients.html</code> dans le dossier templates :</h2>

 ```HTML
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Index</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.2.3/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-5">
    <div class="card text-center">

        <div class="d-flex justify-content-center border border-dark">
            <div class="col-md-6">
                <div class="card-header bg-dark bg-subtle text-white h1">Patients Index</div>
            </div>
        </div>

        <div class="card-body">

            <form action="get" th:action="@{index}">
                <label class="form-label">Key word</label>
                <input type="text" name="keyWord" th:value="${keyWord}">
                <button type="submit" class="btn btn-dark border-dark mb-2">find</button>
            </form>

            <table class="table table-light">
                <thead>
                <tr class="table table-dark text-white h3">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Date</th>
                    <th>Sick</th>
                    <th>Action</th>
                </tr>
                </thead>

                <tbody>
                    <tr th:each="p:${listPatients}">
                        <td class="bg-dark text-white h3" th:text="${p.id}"></td>
                        <td th:text="${p.name}"></td>
                        <td th:text="${p.age}"></td>
                        <td th:text="${p.dateOfBirth}"></td>
                        <td th:text="${p.sick}"></td>
                        <td><a onclick="return confirm('Are you sure you want to delete this line?')"
                               class="btn btn-danger border-dark" th:href="@{delete(id=${p.id}, keyWord=${keyWord}, page=${currentPage})}">
                            Delete</a></td>
                    </tr>
                </tbody>
            </table>

            <div class="d-flex justify-content-center">
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
</div>

</body>
</html>
```
<p>Explication du comportemts des attributs personnalisés dans notre vue <code>patient.html</code></p>
<ul>
<li><code>th:action="@{index}"</code> :<br>Cela spécifie l'URL à laquelle le formulaire sera soumis lorsqu'il est envoyé. Dans notre exemple le formulaire est envoyé à la méthode rechercherPatients du contrôleur associé à l'URL '/index'.</li><br>
<li><code>th:value="${keyWord}"</code> :<br>Cela récupère la valeur actuelle du paramètre "keyWord" qui a été envoyé avec la requête et l'attribut "value" de l'élément HTML "input".</li><br>
<li><code>th:href="@{delete(id=${p.id}, keyWord={keyWord}, page=${currentPage})}"</code> :<br>Cela spécifie l'URL liée au lien "Delete" les paramètres "id" "keyWord" et "page" seront transmis à cette URL.</li><br>
<li><code>th:class="${status.index==currentPage?"btn btn-dark me-2 ":" btn-outline-dark me-2"}"</code> :<br>Cela aplique un style en fonction de l'index de la page en cours de traitement par la boucle "th:each". Si la page est la page actuellement active "currentPage", la classe "btn btn-dark me-2" est ajoutée sinon la classe "btn btn-outline-dark me-2" est ajoutée.</li>
</ul>  

<h3 style="color:#FFC0CB">Note :</h3>
<p>Le dossier <strong>templates</strong> est le dossier de convention dans lequel Spring Boot recherche les fichiers vues.</p>

<h2 style="color:LightGreen">Résultat final de la première partie :</h2>

<img src="pictureDocumentation/pageIndex.png" alt="Resultat">

<p>Notre aventure de développement web avec Spring Boot et Thymeleaf continue !</p>

<p>👉 Dans cette première partie, nous 
avons commencer l'exploration de notre CRUD [Create,Read,Update,Delete] en créant une page de recherche de patients avec l'implementation du "Read" et du "Delete".
</p>
<p>
👉 Dans <a href="https://github.com/TmaneChouaib/spring02">la deuxième partie</a>, nons allons continuer notre exploration en ajoutant la possibilité d'ajouter et de modifier des patients, implementation du "Create" et du "Update", pour terminer notre [C.R.U.D] 💪 ainsi que des fonctionnalités de validation de données. Alors, accrochez-vous bien nous allons enssemble explorer encore plus de fonctionnalités passionnantes dans <a href="https://github.com/TmaneChouaib/spring02">💻la deuxième partie 🚀</a></p>
<br>
<br>

### Fin !

----------------------------------------------------------------------------------------------------------


<p align="right">Auteur : <a href="https://www.linkedin.com/in/chouaib-tmane-a225ab235/">Chouaib Tmane</a></p>
<h1 align="right"><a href="https://github.com/TmaneChouaib/spring-mvc-app-patient-part-02">Continuer ➡️</a></h1>


