# spring
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
<div class="d-flex justify-content-center">
  <div class="text-center">
    <img src="https://www.vincenzoracca.com/images/spring.png" alt="Spring picture">
  </div>
</div>
<h1>Développement web avec Spring et Thymeleaf</h1>
<p>Ce tutoriel permet de créer une application web de gestion de patients en utilisant Spring Boot, Spring Data JPA, Thymeleaf et MySQL.</p>
<p>En suivant ces étapes vous pouvez créer une application simple</p>
<p>Ce tutoriel est déstiné au débutans de Spring <strong>Comme moi 😄</strong></p>

<h3 style="color: green">Structure du Code :</h3>
<ul>
  <li><strong>entities</strong>: contient nos entités</li>
  <li><strong>repositories</strong>: contient la couche DAO</li>
  <li><strong>web</strong>: contient la couche web</li>
</ul>


<h3 style="color: green">Dans notre fichier<code>pom.xml</code> :</h3>
<ul>
  <li>On ajoute la dépendance de <strong>Bootstrap</strong> à notre projet.</li>
  <li>On ajoute aussi la dépendance du driver <strong>MySQL</strong>, pour permettre à notre application de s'interagir avec la base de données MySQL.</li>
</ul>


<h3 style="color: green">la classe principale de l'application Spring Boot <strong>PatientsMvcApplication</strong> :</h3>
<li><strong>@SpringBootApplication</strong> est une annotation qui est utilisée pour définire que la classe principale de l'application est une application Spring Boot.</li>
<li><strong>@Bean</strong> indique à Spring que la méthode dans notre classe retourne un object qui doit être enregistré en tant que bean Spring.</li>
<li><strong>CommandLineRunner</strong> est une interface fonctionnelle de Spring Boot. Elle permet d'exécuter une méthode lors du démarrage de l'application.</li>


<h3 style="color: green"><strong>application.properties</strong> :</h3> 
<ul>
<li><strong>spring.jpa.hibernate.ddl-auto</strong> : spésifie la stratégie de mise a jour de la base de données par Hibernate.</li>
<li><strong>spring.jpa.properties.hibernate.dialect</strong> : spécifie le dialect de la base de données pour Hibernate.</li>
<li><strong>spring.jpa.show-sql</strong> : active l'affichage des requêtes SQL exécutées par Hibernate.</li>
<li><strong>spring.thymeleaf.cache</strong> : spécifie si le cache de Thymeleaf doit être activé ou non. Ici il est désactivé.</li>
</ul>

<p>Ces propiétés sont utilisées pour configurer l'application Spring Boot. Par exemple la propriété <strong>spring.jpa.hibernate.ddl-auto</strong>
définit la stratégie de mise à jour de la base de données. La valeur de cette propriété peut être <code>update</code>,<code>create</code>,
<code>create-drop</code>, <code>validate</code>, en fonction de l'effet souhaité sur la base de données.</p>

<h3 style="color: green">L'entité "Patient" dans le package entities</h3> :
<p>L'entité "Patient" contient les annotations suivante:</p>
<ul>
<li><strong>@Entity</strong> : Cette annotation indique que la classe est une entité JPA et qu'elle doit être mappée a une table de la base de données.</li>
<li><strong>@Data</strong> : Cette annotation est fournie par Lombok et elle génère automatiquement les méthodes getters, setters, toString, equals et hashCode.</li>           
<li><strong>@AllArgsConstructor</strong> : Cette annotations génere un constructeur avec paramètre.</li>
<li><strong>@NoArgsConstructor</strong> : Cette annotation génere un constructeur sans paramètre.</li>
<li><strong>@Id</strong> : Cette annotation indique que le champ 'id' est la clé primaire de l'entité.</li>
<li><strong>@GeneratedValue</strong> : Cette annotation indique que la valeur de la clé primaire sera générée automatiquement par la base de données lors de l'insertion d'une nouvelle entité.</li>
<li><strong>@Temporal</strong> : cette anotation est utilisé pour spécifier le type de données d'un attribut.</li>
</ul>


<h3 style="color: green">L'interface <strong>PatientRepository</strong> dans le package repositories :</h3>
<p>L'interface <strong>PatientRepository</strong> hérite de l'interface <strong>JpaRepository</strong> fournie par Spring Data JPA.</p>
<ul>
  <li><strong>JpaRepository &lt;Patient,Long&gt;</strong>:</li>
<ul> 
<li>Patient :est le nom de l'entité sur laquelle cette interface sera appliquée</li>
<li>Long: est le type de données de l'ID de cette entité</li>
</ul>
<li><strong>findByNomContains</strong> :</li>
<ul>
<li>La méthode <code>findByNomContains</code> permet de rechercher les patients dont le nom contient une chaîne passé comme parametre</li>
<li>Cette méthode prend en paramètre <code>kw</code> et l'objet <code>Pageable</code> qui permet de paginer les resultas de la recherche</li>
<li>La méthode retourne un objet <code>Page</code> contenant le resultat de la recherche ,c'est à-dire une liste paginnee des patients correspondants à la recherche.</li>
</ul>
</ul>


<h3 style="color: green">Le controller <code>PatientController</code> dans le package web :</h3>
<ul>
<li><strong>home()</strong> : redirige vers la méthode "rechercherPatients()"</li>
<li><strong>rechercherPatients()</strong> : permet de chercher des patients par nom et les afficher paginés dans la vue "patients.html"</li>
<li><strong>delete()</strong> : permet de supprimer un patient par son id</li>
<li><strong>listePatients()</strong> :renvoie la liste de tous les patients. Cette méthode est utilisée pour renvoie une liste de patients au format JSON</li>
</ul>


<h3 style="color: green">La vue <strong>patients.html</strong> dans le dossier templates</h3> :
<p>NB: le dossier <strong>templates</strong> est le dossier de convention dans lequel Spring Boot recherche les fichiers vues.</p>
    <p>les termes utilisés:</p>
<ul>
<li><strong>th:action="@{index}"</strong> :Cela spécifie l'URL à laquelle le formulaire sera soumis lorsqu'il est envoyé. Dans notre exemple le formulaire est envoyé à la méthode rechercherPatients du contrôleur associé à l'URL '/index'.</li>
<li><strong>th:value="${keyWord}"</strong> :Cela récupère la valeur actuelle du paramètre "keyWord" qui a été envoyé avec la requête et l'attribut "value" de l'élément HTML "input".</li>
<li><strong>th:href="@{delete(id=${p.id}, keyWord={keyWord}, page=${currentPage})}"</strong> :Cela spécifie l'URL liée au lien "Delete" les paramètres "id" "keyWord" et "page" seront transmis à cette URL.</li>
<li><strong>th:class="${status.index==currentPage?"btn btn-dark me-2 ":" btn-outline-dark me-2"}"</strong> :Cela aplique un style en fonction de l'index de la page en cours de traitement par la boucle "th:each". Si la page est la page actuellement active "currentPage", la classe "btn btn-dark me-2" est ajoutée sinon la classe "btn btn-outline-dark me-2" est ajoutée.</li>
</ul>  