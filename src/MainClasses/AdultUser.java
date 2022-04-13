package MainClasses;

public class AdultUser extends AdoUser {

    public AdultUser(String username, String password) {
        super(username, password);
    }

    /*  Les utilisateurs adolescents ne peuvent pas créer d’autres utilisateurs. */
    private void makeNewUser(String username, String password, String role) {
        switch (role){
            case "Adult" -> new AdultUser(username, password);
            case "Ado" -> new AdoUser(username, password);
        }
    }

    /* L’application doit permettre aux parents de sélectionner des fichiers vidéos, de leurs donner
un nom (par exemple le titre d’un film) et de les catégoriser.
    Ce sont les parents qui déterminent les catégories.

    Des exemples de catégories sont : dessins animés pour enfants,
mangas adultes, comédies familiales, films d’horreur, vidéo familiale, vidéo d’un cours etc */
    private void addNewFile(String fileName, String category) {
        // Créer une classe category (ou un enum) ? Classe file ?
    }

    /* Les parents décident des vidéos que les enfants ou les adolescents ont le droit de visionner */
    /* Comme les adolescents ont des identifiants personnels, les parents peuvent donner des droits
différents aux différents adolescents. */
    private void allowUser(String fileName, UserAccount user) {

    }

    /* Par contre, tous les enfants ont les mêmes droits. */
    private void allowUser(String fileName) {

    }
}
