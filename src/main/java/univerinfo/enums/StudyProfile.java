package univerinfo.enums;

public enum StudyProfile {
    ECOLOGY("Экология и природопользование."),
    RADIO("Радиотехника. Радиотехнические системы."),
    INFOCOMMUNCATION("Инфокоммуникационные технологии и системы связи."),
    DESIGN("Конструирование и технология электронных средств."),
    BIOTECHNICAL("Биотехнические системы и технологии."),
    COMPUTER_SCENCE("Информатика и вычислительная техника.");

    private String name;
    StudyProfile(String name) {
        this.name = name;
    }

    public String getProfileName() {
        return this.name;
    }
}
