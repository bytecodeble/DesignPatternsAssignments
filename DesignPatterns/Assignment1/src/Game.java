public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        
        System.out.println("--- Wilderness Map ---");
        Map wildMap = game.createMap("wilderness");
        wildMap.display();

        System.out.println("\n--- City Map ---");
        Map cityMap = game.createMap("city");
        cityMap.display();
    }

    public Map createMap(String type) {
        if (type.equalsIgnoreCase("city")) {
            return new CityMap();
        } else {
            return new WildernessMap();
        }
    }
}