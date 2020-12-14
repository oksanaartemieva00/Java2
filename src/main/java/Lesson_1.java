import java.util.Random;

public class Lesson_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Actions[] action = new Actions[3];

        int distance = rand.nextInt(9);
        int height = rand.nextInt(5);
        action[0] = new Person("Ваня", distance, height);

        distance = rand.nextInt(100);
        height = rand.nextInt(20);
        action[1] = new Robot("Робот", distance, height);

        distance = rand.nextInt(7);
        height = rand.nextInt(1);
        action[2] = new Cat("Мурзик", distance, height);

        Obstacles[] obstacles = new Obstacles[1];

        boolean isRoad;
        for (int i = 0; i < obstacles.length; i++) {
            distance = rand.nextInt(10);
            isRoad = rand.nextBoolean();
            if (isRoad) {
                obstacles[i] = new RunningTrack("Беговая дорожка " + i,distance);
            } else {
                obstacles[i] = new Wall("Стена " +i,distance);
            }
        }

        for (int i = 0; i < action.length; i++) {
            boolean result = true;
            for (int j = 0; j < obstacles.length; j++) {
                result = obstacles[j].moving(action[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Прошел испытание");
            } else {
                System.out.println("Не прошел испытание");
            }

        }

    }
}