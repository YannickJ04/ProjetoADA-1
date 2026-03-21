public enum Tile {
    NO_CONSTRAINTS('.'),
    NO_DIAGONALS('X'),
    NO_JUMPS('J'),
    NO_STEP('#');

    private final char value;

    Tile(char value) {
        this.value = value;
    }

    public static Tile fromChar(char value) {
        switch (value) {
            case '.': return NO_CONSTRAINTS;
            case 'X': return NO_DIAGONALS;
            case 'J': return NO_JUMPS;
            case '#': return NO_STEP;
            default: throw new IllegalArgumentException("Invalid tile value: " + value);
        }
    }

    public boolean canMoveTo() {
        return this != NO_STEP;
    }

    public boolean allowsDD() {
        return this != NO_JUMPS;
    }

    public boolean allowsJump() {
    }
}
