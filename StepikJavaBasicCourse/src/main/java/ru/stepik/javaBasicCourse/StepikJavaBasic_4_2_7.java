package ru.stepik.javaBasicCourse;

import java.util.Random;

public class StepikJavaBasic_4_2_7 {

    public static void main(String[] args) {
        RobotConnectManager robotConnectManager = new RobotConnectManager();
        for (int i = 1; i < 5; i++) {
            System.out.println(i);
            moveRobot(robotConnectManager, i, 3);
        }
    }




    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        final int MAX_STEP = 3;
        for (int i = 1; i <= MAX_STEP; i++) {
            try (RobotConnection rc = robotConnectionManager.getConnection()) {
                rc.moveRobotTo(toX, toY);
                i = MAX_STEP + 1;
            } catch (RobotConnectionException e) {
                if (i == MAX_STEP) throw e;
            }
        }
    }



    static class RobotConnect implements RobotConnection {
        @Override
        public void moveRobotTo(int x, int y) {
        }
        @Override
        public void close() {
        }
    }

    static class RobotConnectManager implements RobotConnectionManager {
        Random random = new Random();
        @Override
        public RobotConnect getConnection() {
            RobotConnect robotConnect = null;
            boolean isConnect = random.nextBoolean();
            if (!isConnect) {
//                System.out.println("No connection");
                throw new RobotConnectionException("Not connect");
            } else {
//                System.out.println("There is a connection");
                robotConnect = new RobotConnect();
            }
            return robotConnect;
        }
    }

    public interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);
        @Override
        void close();
    }

    public interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    public static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);
        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
