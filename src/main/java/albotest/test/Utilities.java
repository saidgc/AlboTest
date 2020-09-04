package albotest.test;

import albotest.business.MarvelComic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import org.springframework.web.client.HttpClientErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Different utilities to obtain and connect with the api
 */
class Utilities {

    private static final String apikey = "5a22d51a6b95e7c0f6bc3293eaf82849";
    private static final String hash = "b3e1b35b1e4ff19be53dca342eb1ea26";
    private static final String marvelApiURL = "https://gateway.marvel.com:443/v1/public";

    /**
     * Get comics in marvelApi by comicId
     *
     * @param characterId id of the character to get comics
     * @return A MarvelComic object list with the comics
     */
    public static MarvelComic[] fetchComics(String characterId) {
        String urlComics = "/characters/" + characterId + "/comics";

        ObjectMapper objectMapper = new ObjectMapper();
        MarvelComic[] comics = null;

        try {
            comics = objectMapper.readValue(fetchData(urlComics).toString(), MarvelComic[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return comics;
    }

    /**
     * Query and interact with the api
     *
     * @param endpoint       Endpoint to consult in the api
     * @param characterFetch Boolean to determine the sending of data with limit,
     *                       especially to obtain the data of Captain America and Iron Man in a query
     * @return An array in json format with the data provided by the api
     */
    public static JSONArray fetchData(String endpoint, Boolean characterFetch) {
        String url = marvelApiURL + endpoint;
        JSONArray arrayCharacters = new JSONArray();

        try {
            String ts = "1599067500";
            if (characterFetch) {
                arrayCharacters = Unirest.get(url)
                        .queryString("ts", ts)
                        .queryString("apikey", apikey)
                        .queryString("hash", hash)
                        .queryString("limit", "100")
                        .queryString("offset", "1400")
                        .queryString("orderBy", "modified")
                        .asJson().getBody().getObject()
                        .getJSONObject("data").getJSONArray("results");
            } else {
                arrayCharacters = Unirest.get(url)
                        .queryString("ts", ts)
                        .queryString("apikey", apikey)
                        .queryString("hash", hash)
                        .asJson().getBody().getObject()
                        .getJSONObject("data").getJSONArray("results");
            }

        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }

        return arrayCharacters;
    }

    /**
     * Method overload to bypass the use of the boolean
     *
     * @param endpoint Endpoint to consult in the api
     * @return An array in json format with the data provided by the api
     */
    public static JSONArray fetchData(String endpoint) {
        return fetchData(endpoint, false);
    }

    /**
     * @return A string with the current date with specific format
     */
    public static String getDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
