public class PlayingCat {
    public static boolean isCatPlaying(boolean summer, int temperature) {
        if (summer == false) {
            if (temperature >= 25) {
                if (temperature <= 35) {
                    summer = true;
                }
            }
            return summer;
        }
        if (temperature >= 25) {
            if (temperature > 45) {
                summer = false;
            }
        } else {
            summer = false;
        }
        return summer;
    }
}
