package med.voll.api_voll_med.model.dto.error;

public record ErrorResultResponse<T>(int status, T errors) {
}