import java.util.Arrays;

public class Card implements Comparable<Card> {

    private final String name;
    private final static int NORMALMONSTER = 0;
    private final static int EFFECTMONSTER = 1;
    private final static int SPELL = 2;
    private final static int TRAP = 3;
    private final int typeCode;
    private final int year;

    // constructor
    public Card(String name, String type, int year) {
        this.name = name;
        if (type.equals("SPELL")) {
            this.typeCode = SPELL;
        } else if (type.equals("TRAP")) {
            this.typeCode = TRAP;
        } else if (type.equals("EFFECTMONSTER")) {
            this.typeCode = EFFECTMONSTER;
        } else if (type.equals("NORMALMONSTER")) {
            this.typeCode = NORMALMONSTER;
        } else {
            this.typeCode = -1;
        }
        this.year = year;
    }

    // getter methods
    public String getName() {
        return this.name;
    }
    public int getTypeCode() {
        return this.typeCode;
    }
    public int getYear() {
        return this.year;
    }

    @Override
    public int compareTo(Card o) {
        Card compareCard = (Card) o;
        if (this.getYear() < compareCard.getYear()) {
            return -1;
        } else if (this.getYear() > compareCard.getYear()) {
            return 1;
        } else if (this.getTypeCode() < compareCard.getTypeCode()) {
            return -1;
        } else if (this.getTypeCode() > compareCard.getTypeCode()) {
            return 1;
        } else if (this.getName().equals(compareCard.getName())) {
            return 0;
        } else {
            String[] arr = {this.getName(), compareCard.getName()};
            Arrays.sort(arr);
            if (this.getName().equals(arr[0])) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
