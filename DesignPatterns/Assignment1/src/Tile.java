public abstract class Tile {
    public abstract char getCharacter();
    public abstract String getType();
    public abstract void action(); // Placeholder 
}


class SwampTile extends Tile {
    public char getCharacter() { return 'S'; }
    public String getType() { return "swamp"; }
    public void action() { System.out.println("A wise sorceress lives here."); }
}

class WaterTile extends Tile {
    public char getCharacter() { return 'W'; }
    public String getType() { return "water"; }
    public void action() { System.out.println("Be careful of the water's depth."); }
}

class RoadTile extends Tile {
    public char getCharacter() { return 'R'; }
    public String getType() { return "road"; }
    public void action() { System.out.println("A traveler passes by quickly."); }
}

class ForestTile extends Tile {
    public char getCharacter() { return 'F'; }
    public String getType() { return "forest"; }
    public void action() { System.out.println("The dwarves live here."); }
}

class BuildingTile extends Tile {
    public char getCharacter() { return 'B'; }
    public String getType() { return "building"; }
    public void action() { System.out.println("The craftswoman is working."); }
}