package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.Game;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author psn
 * @since 05.01.2016
 */
@RepositoryRestResource(collectionResourceRel = "games", path = "games")
public interface GameRepository extends GraphRepository<Game> {
    Game findByName(@Param("name") String name);

    @Query("MATCH (g:Game) WHERE g.game =~ ('(?i).*'+{name}+'.*') RETURN g")
    Collection<Game> findByNameContaining(@Param("name") String name);

    @Query("MATCH (g:Game)<-[:isMember]-(u:User) RETURN g.name as game, collect(u.name) as cast LIMIT {limit}")
    List<Map<String,Object>> graph(@Param("limit") int limit);
}


