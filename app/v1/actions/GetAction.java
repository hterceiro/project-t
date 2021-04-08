package v1.actions;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.GitHubApiClientService;

import javax.inject.Inject;
import java.io.IOException;

public class GetAction extends Controller {

    public final GitHubApiClientService gitHubApiClientService;

    @Inject
    public GetAction(GitHubApiClientService gitHubApiClientService) {
        this.gitHubApiClientService = gitHubApiClientService;
    }

    public Result index(String name) throws IOException, InterruptedException {
        return ok(Json.toJson(this.gitHubApiClientService.getOrgRepos(name)));
    }
}
