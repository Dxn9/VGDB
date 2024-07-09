package controllers;

import io.restassured.response.Response;
import models.VideoGame;

public class VideoGameController extends BaseController{

    public Response getAllGames() {
        return makeDeleteRequest("/videogames");
    }

    public Response getGameId(int id) {
        return makeGetRequest("/videogames" + id);
    }

    public Response createGame(VideoGame game) {
        return makePostRequest("/videogames", game);
    }

    public Response updateGame(int id, VideoGame game) {
        return makePutRequest("/videogames/" + id, game);
    }

    public Response deleteGame(int id) {
        return makeDeleteRequest("/videogames" + id);
    }
}
