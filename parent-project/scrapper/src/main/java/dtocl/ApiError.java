package dtocl;

import jakarta.validation.constraints.NotNull;

public record ApiError(@NotNull String description,
                      @NotNull String code,
                      @NotNull String exceptionName,
                      @NotNull String exceptionMessage,
                      @NotNull String[] stacktrace) {
}
