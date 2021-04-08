package services;

import VO.Repos;
import VO.User;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import enums.GitHubApiEnum;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


import javax.inject.Inject;

public class GitHubApiClientService {

    @Inject
    public GitHubApiClientService() {}

    public List<Repos> getOrgRepos(String name) throws IOException, InterruptedException {
        String uriApi = "/users/" + name + "/repos";
        HttpRequest request = buildGetJson(uriApi);
        HttpResponse<String> response = this.getClient().send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Repos>>(){}.getType();
        List<Repos> repos = gson.fromJson(response.body(), listType);
        List<Repos> finalReposReturn = new ArrayList<>();

        for (Repos r: repos) {
            String UriRepos = "/repos/" + name + "/" +r.getName() + "/contributors";
            request = buildGetJson(UriRepos);
            response = this.getClient().send(request, HttpResponse.BodyHandlers.ofString());
            Type listTypeUser = new TypeToken<List<User>>(){}.getType();
            List<User> users = gson.fromJson(response.body(), listTypeUser);
            int contributionsRepo = 0;

            for (User u: users) {
                contributionsRepo += u.getContributions();
            }

            r.setContributions(contributionsRepo);
            finalReposReturn.add(r);
        }

        Collections.sort(finalReposReturn, Comparator.comparingLong(Repos::getContributions).reversed());

        return finalReposReturn;
    }

    private HttpClient getClient() {
        return HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    }

    private HttpRequest buildPostJson(String url, String json) {
        return HttpRequest.newBuilder()
                .POST( HttpRequest.BodyPublishers.ofString( json ) )
                .uri( URI.create( url ) )
                .header( "Content-Type", "application/json" )
                .header( "Accept", "application/json" )
                .header( "Authorization", "Bearer " + GitHubApiEnum.GH_TOKEN.propriedade )
                .build();
    }

    private HttpRequest buildGetJson(String uri) {
        return HttpRequest.newBuilder()
                .GET()
                .uri( URI.create(GitHubApiEnum.API_URL.propriedade + uri) )
                .header( "Content-Type", "application/json" )
                .header( "Accept", "application/json" )
                .header( "Authorization", "Bearer " + GitHubApiEnum.GH_TOKEN.propriedade ).build();
    }
}
