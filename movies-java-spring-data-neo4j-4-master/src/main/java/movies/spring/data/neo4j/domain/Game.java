
import org.neo4j.graphdb.Direction;
import org.neo4j.ogm.annotation.*;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;


@JsonIdentityInfo(generator=JSOGGenerator.class)

@NodeEntity
public class Game {
    @GraphId Long id;

    String name;
    String state;


    @Relationship(type="isMember", direction = Relationship.INCOMING) List<Nickname> nicknames;


    public Game() { }

    public String getName() {
        return name;
    }

    public int getState() {
        return state;
    }


    public Collection<Nickname> getNicknames() {
        return nicknames;
    }
}

