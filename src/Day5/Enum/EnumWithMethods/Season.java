package Day5.Enum.EnumWithMethods;

/*
    Create an enum Season with values WINTER, SPRING, SUMMER, and FALL. Add a method
    getAverageTemperature() to return an average temperature for each season.
*/

public enum Season {
    WINTER(20),
    SPRING(30),
    SUMMER(35),
    FALL(25);

    private int averageTemperature;

    Season(int averageTemperature){
        this.averageTemperature = averageTemperature;
    }

    public int getAverageTemperature(){
        return this.averageTemperature;
    }
}
