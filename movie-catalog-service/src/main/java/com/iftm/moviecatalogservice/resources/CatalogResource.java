package com.iftm.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.iftm.moviecatalogservice.models.CatalogItem;
import com.iftm.moviecatalogservice.models.Movie;
import com.iftm.moviecatalogservice.models.Rating;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		
		// 1 - Obter todos os movies IDs
		List<Rating> ratings = Arrays.asList(
				new Rating("12", 15),
				new Rating("15", 20)
				);
		
		//UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId, UserRating.class);
		
		return ratings.stream().map(rating -> {
			// 2 - Para cada movie ID, chamar movie info service e get details
			Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
				return new CatalogItem(movie.getName(), "Filmão", rating.getRating());
		})
				// 3 - colocar tudo junto
				.collect(Collectors.toList());
		
		//return Collections.singletonList(new CatalogItem("Caça Fantasmas", "Filme de Gasparzinho", 8));
	}
}
