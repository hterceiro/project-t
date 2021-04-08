package enums;

public enum GitHubApiEnum {
    API_URL("https://api.github.com"),
    CLIENT_ID(System.getenv("CLIENT_ID")),
    SECRET_KEY(System.getenv("CLIENT_SECRET")),
    GH_TOKEN(System.getenv("GH_TOKEN"))
    ;

    public String propriedade;

    GitHubApiEnum(String propriedade) {
        this.propriedade = propriedade;
    }
}
