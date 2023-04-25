package app;

import dtocl.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tg-chat")
@RestController
public class ChatController {
    @ApiResponse(responseCode = "200", description = "Чат зарегистрирован")
    @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса")
    @ApiResponse(responseCode = "404", description = "Ссылка не найдена")
    @PostMapping("/{id}")
    String registrateChat(@PathVariable int id){
        return "Chat Id: " + id;
    }
    @DeleteMapping("/{id}")
    String deleteChat(@PathVariable int id){
        return "Chat Id: " + id;
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


