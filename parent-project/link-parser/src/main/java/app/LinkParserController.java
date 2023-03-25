package app;

import com.baeldung.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class LinkParserController {
    @GetMapping("/")
    @ResponseBody
    String hello() {
        return "<html>Go to http://localhost:8080/url:?url=URL with correct URL so it starts working</html>";
    }

    @GetMapping("/url:")
    @ResponseBody
    public String getUrl(@RequestParam(required = false) String url) {
        BLParser linkParser = new BLParser(url);
        return "<html><p>URL: " + url + "</p><p>Data:"+linkParser.getData()+"</p></html>";
    }

}
