# spring




<h3>Structure du code :</h3>
<ul>
  <li><code>entities</code>: contient nos entités</li>
  <li><code>repositories</code>: contient la couche DAO</li>
  <li><code>web</code>: contient la couche web</li>
</ul>


<h3>Dans notre fichier<code>pom.xml</code> :</h3>
<ul>
  <li>On ajoute la dépendance de <strong>Bootstrap</strong> à notre projet.</li>
  <li>On ajoute aussi la dépendance du driver <strong>MySQL</strong>, pour permettre à notre application de s'interagir avec la base de données MySQL.</li>
</ul>


<h3>la Claasse principale de l'application Spring Boot <code>PatientsMvcApplication</code> :</h3>
<li><code>@SpringBootApplication</code> est une annotation qui est utilisée pour définire que la classe principale de l'application est une application Spring Boot.</li>
<li><code>@Bean</code> indique à Spring que la méthode dans notre classe retourne un object qui doit être enregistré en tant que bean Spring.</li>
<li><code>CommandLineRunner</code> est une interface fonctionnelle de Spring Boot. Elle permet d'exécuter une méthode lors du démarrage de l'application.</li>


<h3><code>application.properties</code> :</h3> 
<ul>
<li><code>spring.jpa.hibernate.ddl-auto</code> : spésifie la stratégie de mise a jour de la base de données par Hibernate.</li>
<li><code>spring.jpa.properties.hibernate.dialect</code> : spécifie le dialect de la base de données pour Hibernate.</li>
<li><code>spring.jpa.show-sql</code> : active l'affichage des requêtes SQL exécutées par Hibernate.</li>
<li><code>spring.thymeleaf.cache</code> : spécifie si le cache de Thymeleaf doit être activé ou non. Ici il est désactivé.</li>
</ul>

<p>Ces propiétés sont utilisées pour configurer l'application Spring Boot. Par exemple la propriété <code>spring.jpa.hibernate.ddl-auto</code>
définit la stratégie de mise à jour de la base de données. La valeur de cette propriété peut être <code>update</code>,<code>create</code>,
<code>create-drop</code>, <code>validate</code>, en fonction de l'effet souhaité sur la base de données.</p>

<h3>L'entité "Patient" dans le package entities</h3> :
<p>L'entité "Patient" contient les annotations suivante:</p>
<ul>
<li>@Entity : Cette annotation indique que la classe est une entité JPA et qu'elle doit être mappée a une table de la base de données.</li>
<li>@Data : Cette annotation est fournie par Lombok et elle génère automatiquement les méthodes getters, setters, toString, equals et hashCode.</li>           
<li>@AllArgsConstructor : Cette annotations génere un constructeur avec paramètre.</li>
<li>@NoArgsConstructor : Cette annotation génere un constructeur sans paramètre.</li>
<li>@Id : Cette annotation indique que le champ 'id' est la clé primaire de l'entité.</li>
<li>@GeneratedValue : Cette annotation indique que la valeur de la clé primaire sera générée automatiquement par la base de données lors de l'insertion d'une nouvelle entité.</li>
<li>@Temporal : cette anotation est utilisé pour spécifier le type de données d'un attribut.</li>
</ul>


<h3>L'interface <code>PatientRepository</code> dans le package repositories :</h3>
<p>L'interface <code>PatientRepository</code> hérite de l'interface <code>JpaRepository</code> fournie par Spring Data JPA.</p>
<ul>
  <li><code>JpaRepository &lt;Patient,Long&gt;</code>:</li>
<ul> 
<li>Patient :est le nom de l'entité sur laquelle cette interface sera appliquée</li>
<li>Long: est le type de données de l'ID de cette entité</li>
</ul>
<li><code>findByNomContains</code> :</li>
<ul>
<li>La méthode <code>findByNomContains</code> permet de rechercher les patients dont le nom contient une chaîne passé comme parametre</li>
<li>Cette méthode prend en paramètre <code>kw</code> et l'objet <code>Pageable</code> qui permet de paginer les resultas de la recherche</li>
<li>La méthode retourne un objet <code>Page</code> contenant le resultat de la recherche ,c'est à-dire une liste paginnee des patients correspondants à la recherche.</li>
</ul>
</ul>


<h3>Le controller <code>PatientController</code> dans le package web</h3> :
<ul>
<li><code>home()</code> : redirige vers la méthode "rechercherPatients()"</li>
<li><code>rechercherPatients()</code> : permet de chercher des patients par nom et les afficher paginés dans la vue "patients.html"</li>
<li><code>delete()</code> : permet de supprimer un patient par son id</li>
<li><code>listePatients()</code> :renvoie la liste de tous les patients. Cette méthode est utilisée pour renvoie une liste de patients au format JSON</li>
</ul>


<h3>La vue <code>patients.html</code> dans le dossier templates</h3> :
<p>NB: le dossier <code>templates</code> est le dossier de convention dans lequel Spring Boot recherche les fichiers vues.</p>
    <p>les termes utilisés:</p>
<ul>
<li><code>th:action="@{index}"</code> :Cela spécifie l'URL à laquelle le formulaire sera soumis lorsqu'il est envoyé. Dans notre exemple le formulaire est envoyé à la méthode rechercherPatients du contrôleur associé à l'URL '/index'.</li>
<li><code>th:value="${keyWord}"</code> :Cela récupère la valeur actuelle du paramètre "keyWord" qui a été envoyé avec la requête et l'attribut "value" de l'élément HTML "input".</li>
<li><code>th:href="@{delete(id=${p.id}, keyWord={keyWord}, page=${currentPage})}"</code> :Cela spécifie l'URL liée au lien "Delete" les paramètres "id" "keyWord" et "page" seront transmis à cette URL.</li>
<li><code>th:class="${status.index==currentPage?"btn btn-dark me-2 ":" btn-outline-dark me-2"}"</code> :Cela aplique un style en fonction de l'index de la page en cours de traitement par la boucle "th:each". Si la page est la page actuellement active "currentPage", la classe "btn btn-dark me-2" est ajoutée sinon la class "btn btn-outline-dark me-2" est ajoutée.</li>
</ul>  