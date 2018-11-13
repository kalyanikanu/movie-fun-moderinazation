package org.superbiz.moviefun.moviesapi;

import org.springframework.stereotype.Component;
import java.util.List;

import static java.util.Arrays.asList;

@Component
public class MovieFixtures {

    public List<MovieInfo> load() {
        return asList(
                new MovieInfo(0, "Wedding Crashers", "David Dobkin", "Comedy", 7, 2005),
                new MovieInfo(0, "Starsky & Hutch", "Todd Phillips", "Action", 6, 2004),
                new MovieInfo(0, "Shanghai Knights", "David Dobkin", "Action", 6, 2003),
                new MovieInfo(0, "I-Spy", "Betty Thomas", "Adventure", 5, 2002),
                new MovieInfo(0, "The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001),
                new MovieInfo(0, "Zoolander", "Ben Stiller", "Comedy", 6, 2001),
                new MovieInfo(0, "Shanghai Noon", "Tom Dey", "Comedy", 7, 2000)
        );
    }
}