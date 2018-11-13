package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;
import org.superbiz.moviefun.moviesapi.MovieInfo;

import java.util.List;

public class AlbumsClient {

    private final String albumsUrl;
    private final RestOperations restOperations;
    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }


    public void addAlbum(AlbumInfo album) {

        restOperations.postForEntity(albumsUrl,album, AlbumInfo.class);
    }

    public AlbumInfo find(long id) {
        return restOperations.getForEntity(albumsUrl+"/"+id,AlbumInfo.class).getBody();

    }

    public List<AlbumInfo> getAlbums() {
       /* CriteriaQuery<Album> cq = entityManager.getCriteriaBuilder().createQuery(Album.class);
        cq.select(cq.from(Album.class));
        return entityManager.createQuery(cq).getResultList();*/
        return restOperations.exchange(albumsUrl, HttpMethod.GET, null, albumListType).getBody();


    }


    public void deleteAlbum(AlbumInfo album) {
        restOperations.delete(albumsUrl+ "/"+ album.getId());
    }


    public void updateAlbum(AlbumInfo album) {
        restOperations.put(albumsUrl,album, AlbumInfo.class);
    }
}
