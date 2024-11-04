import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Дан список Auto. У каждой машины есть номер, брэнд, цвет и т.д. Ваша задача написать следующие методы
метод, который сформирует Map, где ключом будет номер автомобиля, а значением сам автомобиль.
метод, который сформирует Map, где ключом будет брэнд автомобиля, а значением список автомобилей данного брэнда.
 */
public class Main {
    public static void main(String[] args) {

        List<Auto> autos = List.of(
                new Auto("DEDG7474", "Toyota", "Red"),
                new Auto("DEHF4374", "Mercedes", "Blue"),
                new Auto("DEDG7474", "VW", "Black"),
                new Auto("DEÖS654", "Honda", "White"),
                new Auto("DEAR5454", "BMW", "Green")
        );

        //  mapByNumber
        Map<String, Auto> mapByNumber = mapByNumber(autos);
        System.out.println("Map по номеру:");
        System.out.println(mapByNumber);

        //  mapByBrand
        Map<String, List<Auto>> mapByBrand = mapByBrand(autos);
        System.out.println("Map по бренду:");
        System.out.println(mapByBrand);
    }


    // Метод для формирования Map с ключом — бренд автомобиля, значением — список автомобилей данного бренда
    public static Map<String, List<Auto>> mapByBrand(List<Auto> autos) {
        Map<String, List<Auto>> map = new HashMap<>();
        for (Auto auto : autos) {
            map.putIfAbsent(auto.getBrand(), new ArrayList<>());
            map.get(auto.getBrand()).add(auto);
        }
        return map;
    }
    // Метод для формирования Map с ключом — номер автомобиля, значением — автомобиль
    public static Map<String, Auto> mapByNumber(List<Auto> autos) {
        Map<String, Auto> map = new HashMap<>();
        for (Auto auto : autos) {
            map.put(auto.getNumber(), auto);
        }
        return map;
    }
}