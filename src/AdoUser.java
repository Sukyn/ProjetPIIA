public class AdoUser extends UserAccount {
    private String username;
    private String password;
    /* Les parents et les adolescents se loguent avec un identifiant personnel et un mot de passe. */
    public AdoUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
