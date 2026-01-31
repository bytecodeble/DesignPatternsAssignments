import java.util.Random;

public abstract class Map {
    protected int width = 10;
    protected int height = 5;

    public abstract Tile createTile();

    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + " ");
            }
            System.out.println();
        }
    }
}

class CityMap extends Map {
    private Random random = new Random();
    @Override
    public Tile createTile() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new RoadTile();
            case 1:
                return new ForestTile();
            case 2:
                return new BuildingTile();
            default:
                return new BuildingTile(); // Always need a default for safety!
        }
    }
}

class WildernessMap extends Map {
    private Random random = new Random();
    @Override
    public Tile createTile() {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return new SwampTile();
            case 1:
                return new WaterTile();
            case 2:
                return new ForestTile();
            default:
                return new ForestTile();
        }
    }
}