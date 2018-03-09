package ru.stepik.javaBasicCourse;

import ru.stepik.javaBasicCourse.StepikJavaBasic_3_3_12.Robot.Direction;

public class StepikJavaBasic_3_3_12 {

    public static void main(String[] args) {
        Robot robot = new Robot(30, 10, Direction.DOWN);

        System.out.println("Начальное расположение робота");
        robot.printPosition();
        System.out.println();

        moveRobot(robot,20,20);

        System.out.println("Конечное положение робота");
        robot.printPosition();
    }


    public static void moveRobot(Robot robot, int toX, int toY) {
        int dx, dy;
        int stepCnt = 0, turnCnt = 0; // отладка

        while ( (dx = toX - robot.getX()) != 0 |
                (dy = toY - robot.getY()) != 0) {

            if ((dx < 1 && robot.getDirection().equals(Direction.LEFT)) ||
                (dx > 1 && robot.getDirection().equals(Direction.RIGHT))){

                for (int s = 0; s < Math.abs(dx); s++) {
                    robot.stepForward();
                    stepCnt++; // отладка
                }
            }

            if ((dy < 1 && robot.getDirection().equals(Direction.DOWN)) ||
                (dy > 1 && robot.getDirection().equals(Direction.UP))) {

                for (int s = 0; s < Math.abs(dy); s++) {
                    robot.stepForward();
                    stepCnt++; // отладка
                }
            }

            if (robot.getX() != toX || robot.getY() != toY) {
                robot.turnRight();
                turnCnt++; // отладка
            }
        }

        // отладка
        System.out.println("Количество действий: ");
        System.out.print("\tшаги:\t\t");
        System.out.println(stepCnt);
        System.out.print("\tповороты:\t");
        System.out.println(turnCnt);
    }


    static class Robot {

        public enum Direction {
            UP,
            DOWN,
            LEFT,
            RIGHT
        }

        private int xPrev;
        private int yPrev;
        private Direction directionPrev;
        private String directionTurn;

        private int x = 0;
        private int y = 0;
        private Direction direction = Direction.UP;

        public Robot() {
        }

        public Robot(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;

            this.setPrev("");
        }

        public Direction getDirection() {
            // текущее направление взгляда
            return direction;
        }

        public int getX() {
            // текущая координата X
            return x;
        }

        public int getY() {
            // текущая координата Y
            return  y;
        }

        // запоминаем предыдущие координаты
        private void setPrev(String turn){
            this.xPrev = this.getX();
            this.yPrev = this.getY();
            this.directionPrev = this.getDirection();
            this.directionTurn = turn;
        }

        // повернуться на 90 градусов против часовой стрелки
        public void turnLeft() {
            this.setPrev("<");

            switch (direction){
                case UP:
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    direction = Direction.DOWN;
                    break;
                case DOWN:
                    direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    direction = Direction.UP;
                    break;
            }
            this.printPosition(); // отладка
        }

        // повернуться на 90 градусов по часовой стрелке
        public void turnRight() {
            this.setPrev(">");

            switch (direction){
                case UP:
                    direction = Direction.RIGHT;
                    break;
                case RIGHT:
                    direction = Direction.DOWN;
                    break;
                case DOWN:
                    direction = Direction.LEFT;
                    break;
                case LEFT:
                    direction = Direction.UP;
                    break;
            }
            this.printPosition(); // отладка
        }

        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        public void stepForward() {
            this.setPrev("");

            switch (direction){
                case UP:
                    y++;
                    break;
                case RIGHT:
                    x++;
                    break;
                case DOWN:
                    y--;
                    break;
                case LEFT:
                    x--;
                    break;
            }
            this.printPosition(); // отладка
        }

        public void printPosition(){
            System.out.print("x(");
            System.out.print(x - xPrev);
            System.out.print(")=");
            System.out.print(x);

            System.out.print("; y(");
            System.out.print(y - yPrev);
            System.out.print(")=");
            System.out.print(y);

            System.out.print("; direction(");
            System.out.print(directionTurn);
            System.out.print(")=");
            System.out.println(direction);
        }

    }

}
