public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    private Season nextSeason;
    private Season previousSeason;

    static {
        WINTER.nextSeason = SPRING;
        SPRING.nextSeason = SUMMER;
        SUMMER.nextSeason = AUTUMN;
        AUTUMN.nextSeason = WINTER;

        WINTER.previousSeason = AUTUMN;
        SPRING.previousSeason = WINTER;
        SUMMER.previousSeason = SPRING;
        AUTUMN.previousSeason = SUMMER;
    }

    public Season getNextSeason() {
        return nextSeason;
    }

    public Season getPreviousSeason() {
        return previousSeason;
    }
}
