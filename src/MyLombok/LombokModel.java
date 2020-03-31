package MyLombok;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class LombokModel {
    private @NonNull String name;
    private @NonNull String age;
    private @NonNull String address;
}
