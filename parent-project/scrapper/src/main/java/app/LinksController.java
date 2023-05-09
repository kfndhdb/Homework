package app;

import dtocl.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RequestMapping("/links")
@RestController
public class LinksController {
    @ApiResponse(responseCode = "200", description = "Чат зарегистрирован")
    @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса")
    @ApiResponse(responseCode = "404", description = "Ссылка не найдена")
    @GetMapping
    ListLinks getLinks(@RequestHeader int id){
        return new ListLinks(new Link[1], 12);
    }
    @PostMapping
    AddLink addLinkRequest(@RequestHeader int id) throws URISyntaxException {
        return new AddLink(new URI("add"));
    }
    @DeleteMapping
    RemoveLink deleteLink(@RequestHeader int id) throws URISyntaxException {
        return new RemoveLink(new URI("delete"));
    }
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleException(MethodArgumentNotValidException e){
        return new ApiError("Некорректные параметры запроса",
                e.getStatusCode().toString(),
                e.getObjectName(),
                e.getLocalizedMessage(),
                new String[]{String.valueOf(e.getStackTrace())});
    }
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError linkException(MethodArgumentNotValidException e){
        return new ApiError("Ссылка не найдена",
                e.getStatusCode().toString(),
                e.getObjectName(),
                e.getLocalizedMessage(),
                new String[]{String.valueOf(e.getStackTrace())});
    }

}


