package Lesson_1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Competition competition = createAndPrepareCompetition();
        competition.startCompetition();

        System.out.println("Соревнование окончено! Победители:");
        for (Participant winner : competition.getLastWinners()) {
            System.out.println(winner);
        }
    }

    private static Competition createAndPrepareCompetition() {
        Participant person = new Human("Sergey", 30, 600);
        Participant cat = new Cat("Barsik", 100, 1000);
        Participant robot = new Robot("Marusya", 300, 2000);

        Random random = new Random();

        Wall wall = new Wall(random.nextInt(200));
        Track track = new Track(random.nextInt(1500));

        Competition competition = new Competition();
        competition.setParticipants(person, cat, robot);
        competition.setObstacles(wall, track);
        return competition;
    }
}
