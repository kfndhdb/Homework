package app;
import dto.ApiError;
import dto.DataC;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tgBotClasses.TgBotMethods;

@RequestMapping("/updates")
@RestController
public class BotController {

    public static TgBotMethods bot;
    @ApiResponse(responseCode = "200", description = "Обработано")
    @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса")


    @PostMapping(consumes = "application/json", produces = "application/json")
    public DataC update(@Valid @RequestBody DataC dataClass) {
        for (int i = 0; i < dataClass.getTgChatIds().length; i++){
            bot.sendMessage(dataClass.getTgChatIds()[i], dataClass.getDescription());
        }
        return new DataC(dataClass.getId(), dataClass.getUrl(), dataClass.getDescription(), dataClass.getTgChatIds());
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

}