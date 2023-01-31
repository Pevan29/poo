package tp3_pe.tp_3.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import tp3_pe.tp_3.Tp3Application;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


@Controller
public class MeteoController {
    @Autowired
    RestTemplate template;

    @PostMapping("/meteo")
    public String showMeteo(@RequestParam(name = "address", required = false, defaultValue = "") String
                                    address, Model model) throws ParseException, IOException {
        model.addAttribute("addr", address);
        {
            //token pour l'API meteoConcept
            String token = "ce9ed1c30a8609e230f7d4c7c75f6c2ef5c8a56a2eb31935c216987cd948f1a4";

            //recupération de la repoonse de l'API
            String url = "https://api-adresse.data.gouv.fr/search/?q=" + address;
            String result = template.getForObject(url, String.class);


            //convertion reponse pour exploitation
            byte[] res = result.getBytes();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(res);

            //recupération de l'objet "coordinates"
            JsonNode coordinatesNode = rootNode.path("features").get(0).path("geometry").path("coordinates");

            //recuperation lat/long
            double longitude = coordinatesNode.get(0).doubleValue();
            double latitude = coordinatesNode.get(1).doubleValue();

            model.addAttribute("lat", latitude);
            model.addAttribute("long", longitude);

            //gestion de l'API meteo
            String url2 = "view-source:https://api.meteo-concept.com/api/forecast/daily/0?token=" +token+ "&LatLong=" + latitude + "," + longitude;
            String result2 = template.getForObject(url, String.class);

            ObjectMapper mapper2 = new ObjectMapper();
            JsonNode rootNode2 = mapper.readTree(res);
            JsonNode forecast = rootNode.path("forecast");

            //vent
            double vent = forecast.get(3).doubleValue();

            //weather
            double weather = forecast.get(6).doubleValue();

            //sunHours
            double sunHours = forecast.get(16).doubleValue();

            model.addAttribute("vent", vent);
            model.addAttribute("weather", weather);
            model.addAttribute("sunHours", sunHours);
        }

        return "meteo";
    }
}
