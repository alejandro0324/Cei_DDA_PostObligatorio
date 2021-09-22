package DDA.postObligatorio.common.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Action {
    NOTIFY_FUNCIONARIOS("notify_funcionarios");
    private String value;
}
