package movies.spring.data.neo4j.domain;



import org.neo4j.ogm.annotation.*;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@RelationshipEntity(type = "isMember")
public class Nickname {
    @GraphId
    Long id;
    Collection<String> nicknames;
    @StartNode User user;
    @EndNode   Game game;

    public Nickname() {
    }

    public Collection<String> getNicknames() {
        return nicknames;
    }

    public Person getUser() {
        return user;
    }

    public Movie getGame() {
        return game;
    }
}
