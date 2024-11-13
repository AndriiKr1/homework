import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("name:Nick", "length:8", "name:Jack",
                "name:Ann", "length:6", "name:Johanes");
        Map<String, String> result = mapParameters(list);
        System.out.println(result);
    }


    public static Map<String, String> mapParameters(List<String> list) {
        return list.stream()
                .map(s->s.split(":"))
                .collect(Collectors.groupingBy(
                        arr->arr[0],
                        Collectors.mapping(
                                arr->arr[1],
                                Collectors.joining(",")
                        )
                ));
    }
}