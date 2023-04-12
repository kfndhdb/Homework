package dtocl;

import jakarta.validation.constraints.NotNull;

import java.net.URI;

public record Link(@NotNull int id, @NotNull URI url) {
}
