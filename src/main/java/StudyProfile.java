enum StudyProfile {
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    COMPUTER_SCIENCE("Информатика"),
    BUSINESS("Бизнес"),

    COURSE_NUMBER("По номеру курса"),  // Добавлено
    AVG_EXAM_SCORE("По среднему баллу"),  // Добавлено
    YEAR_OF_FOUNDATION("По году основания"),  // Добавлено
    MAIN_PROFILE("По основному профилю");  // Добавлено

    private final String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}