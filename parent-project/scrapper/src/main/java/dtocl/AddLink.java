package dtocl;

import jakarta.validation.constraints.NotNull;

import java.net.URI;

public record AddLink(@NotNull URI link) {
}
