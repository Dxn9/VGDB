package tests;

import controllers.VideoGameController;
import io.restassured.response.Response;
import jdk.jfr.Description;
import models.VideoGame;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class VideoGameTest {

    private VideoGameController videoGameController;

    @BeforeClass
    public void setup() {
        videoGameController = new VideoGameController();
    }

    @Test
    @Description("Returns all the videos games in the DB")
    public void testGetAllGames(){
        Response response = videoGameController.getAllGames();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    @Description("Returns the details of a single game by ID")
    public void testGetGameById() {
        int gameId = 1;
        Response response = videoGameController.getGameId(gameId);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), gameId);
    }

    @Test
    @Description("Add a new video game to the DB")
    public void testCreateGame() {
        VideoGame game = new VideoGame();
        game.setId(10);
        game.setName("GTA 6");
        game.setReleaseDate("2026-07-08");
        game.setReviewScore("95");
        game.setCategory("Action");
        game.setRating("Universal");
        Response response = videoGameController.createGame(game);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), game.getName());
    }

    @Test
    @Description("Update an existing video game in the DB by specifying a new body")
    public void testUpdateGame() {
        VideoGame game = new VideoGame();
        game.setId(10);
        game.setName("GTA 6");
        game.setReleaseDate("2026-11-21");
        game.setReviewScore("99");
        game.setCategory("Action");
        game.setRating("Universal");
        Response response = videoGameController.updateGame(game.getId(), game);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), game.getName());
    }

    @Test
    @Description("Deletes a video game from the DB by ID")
    public void testDeleteGame() {
        int gameId = 10;
        Response response = videoGameController.deleteGame(gameId);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
