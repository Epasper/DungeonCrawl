package sample;

public class HeroPower {

    enum expandedAction {FREE, MINOR, STANDARD}

    enum typeOfPower {AT_WILL, ENCOUNTER, DAILY}

    int powerLevel;
    int range; //for melee skills use range = 0
    String target;

}
