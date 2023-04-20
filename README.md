# spring<br>
#spring Data<br>
#spring MVC<br>

1. On vas creer 3 packages pour structurer notre code :<br>
    1. "entities" // contient nos entités<br>
    2. "repositories" // contient la couche DAO<br>
    3. "web" // contient la couche web<br>

2. On creer notre entité Patient dans le package entities :<br>
<script src="https://gist.github.com/TmaneChouaib/e271b4191906c2d61277839df507a96e.js"></script><br>
        ->L'entité Patient contient les annotations suivante:<br>
    1. @Entity : Cette annotation indique que la classe est une entité JPA et qu'elle doit être mappée a une table de base de données.<br>
    2. @Data : Cette annotation est fournie par Lombok et elle génère automatiquement les méthodes getters, setters, toString, equals et hashCode.<br>              
    3. @AllArgsConstructor : Cette annotations genere un constructeur avec paramètre.<br>
    4. @NoArgsConstructor : Cette annotation genere un constructeur sans paramètre.<br>
    5. @Id : Cette annotation indique que le champ 'id' est la clé primaire de l'entité.<br>
    6. @GeneratedValue : Cette annotation indique que la valeur de la clé primaire sera générée automatiquement par la base de données lors de l'insertion d'une nouvelle entité.<br>
    7. @Temporal : cette anotation est utilise pour spécifier le type de données d'un attribut.<br>
