package movies.spring.data.neo4j.domain;


import org.neo4j.ogm.annotation.*;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class User {
    @GraphId Long id;

    private String name;
    private date born;

    @Relationship(type = "isMember")
    List<Game> games;

    public User() { }

    public String getName() {
        return name;
    }

    public int getBorn() {
        return born;
    }

    public List<Game> getGames() {
        return games;
    }
}
