package movies.spring.data.neo4j;

import movies.spring.data.neo4j.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.Map;

/**
 * @author psn
 * @since 05.01.2016
 */
@Configuration
@Import(MyNewNeo4jConfiguration.class)
@RestController("/")
public class MyGameApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MyGameApplication.class, args);
    }

    @Autowired
    GameService gameService;

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return gameService.graph(limit == null ? 100 : limit);
    }

}
