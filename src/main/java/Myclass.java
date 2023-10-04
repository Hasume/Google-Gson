public class Myclass {
    public enum StudyProfile { MEDICINE("Медицина"),
        ENGINEERING("Инженерия"),
        COMPUTER_SCIENCE("Информатика"),
        BUSINESS("Бизнес");

        private final String profileName;


        StudyProfile(String profileName) {
            this.profileName = profileName;
        }


        public String getProfileName() {
            return profileName;
        }
    }
}