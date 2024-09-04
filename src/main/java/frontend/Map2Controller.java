package frontend;

import dto.classes.Movie;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static client.brain.ClientCode.this_client;
import static frontend.LoginController.lang;
import static frontend.MainController.list;

public class Map2Controller {

    @FXML
    private Canvas canvas;

    @FXML
    public void initialize() {
        drawGrid();
        placePoints();
    }

    private void drawGrid() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Отступы для осей и меток
        double padding = 30;
        double axisOffset = 20; // Смещение оси X вверх

        // Рисование фона
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Рисование сетки
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        double width = canvas.getWidth();
        double height = canvas.getHeight();
        double gap = 50; // Расстояние между линиями сетки

        // Рисование сетки
        for (double i = padding; i <= width - padding; i += gap) {
            gc.strokeLine(i, padding, i, height - padding - axisOffset); // Вертикальные линии
        }
        for (double i = padding; i <= height - padding - axisOffset; i += gap) {
            gc.strokeLine(padding, i, width - padding, i); // Горизонтальные линии
        }

        // Рисование осей
        gc.setLineWidth(2);
        gc.strokeLine(padding, height - padding - axisOffset, width - padding, height - padding - axisOffset); // Ось X
        gc.strokeLine(padding, padding, padding, height - padding - axisOffset); // Ось Y

        // Рисование меток на осях
        gc.setLineWidth(1);
        for (double i = padding; i <= width - padding; i += gap) {
            gc.strokeLine(i, height - padding - axisOffset - 5, i, height - padding - axisOffset + 5); // Отметки на оси X
            gc.fillText(String.valueOf((int) (i - padding)), i - 10, height - padding - axisOffset + 20); // Подписи на оси X
        }
        for (double i = padding; i <= height - padding - axisOffset; i += gap) {
            gc.strokeLine(padding - 5, height - i - padding + height - 2 * padding + axisOffset, padding + 5, height - i - padding + height - 2 * padding + axisOffset); // Отметки на оси Y
            gc.fillText(String.valueOf((int) (height - i - padding)), padding - 25, height - i - padding + height - 2 * padding + axisOffset + 5); // Подписи на оси Y
        }

        // Рисование стрелок на осях
        gc.setLineWidth(2);
        // Стрелка на оси X
        gc.strokeLine(width - padding - 10, height - padding - axisOffset - 10, width - padding, height - padding - axisOffset);
        gc.strokeLine(width - padding - 10, height - padding - axisOffset + 10, width - padding, height - padding - axisOffset);
        gc.fillText("X", width - padding + 10, height - padding - axisOffset);

        // Стрелка на оси Y
        gc.strokeLine(padding - 10, padding + 10, padding, padding);
        gc.strokeLine(padding + 10, padding + 10, padding, padding);
        gc.fillText("Y", padding - 10, padding - 10);
    }

    private void placePoints() {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Отступы для осей и меток
        double padding = 30;
        double axisOffset = 20; // Смещение оси X вверх

        // Радиус точек
        double radius = 15;

        // Список для хранения точек и соответствующих фильмов
        List<Point2D> points = new ArrayList<>();
        List<Movie> movies = new ArrayList<>();

        // Рисование точек
        for (Movie m : list) {
            double x = padding + m.coordinate.getX() - radius / 2;
            double y = canvas.getHeight() - padding - axisOffset - m.coordinate.getY() - radius / 2;

            if (m.client.getLogin().equals(this_client.getLogin())) {
                gc.setFill(Color.GREEN); // Зеленый цвет
            } else {
                gc.setFill(Color.RED); // Красный цвет
            }

            gc.fillOval(x, y, radius, radius);

            // Добавление точки и соответствующего фильма в списки
            points.add(new Point2D(x, y));
            movies.add(m);
        }

        // Добавление обработчика события для клика мыши на канвасе
        canvas.setOnMouseClicked(event -> {
            double clickX = event.getX();
            double clickY = event.getY();

            // Проверка, находится ли клик в пределах одной из точек
            for (int i = 0; i < points.size(); i++) {
                Point2D point = points.get(i);
                if (clickX >= point.getX() && clickX <= point.getX() + radius &&
                        clickY >= point.getY() && clickY <= point.getY() + radius) {
                    showMovieInfo(movies.get(i)); // Отображение информации о фильме
                    break;
                }
            }
        });
    }

    // Метод для отображения информации о фильме
    private void showMovieInfo(Movie m) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        switch (lang) {
            case "LIETUVIŠKAS" -> {;
                alert.setTitle("Informācija par filmu");
                alert.setHeaderText("Filmas: " + m.getName());
                alert.setContentText("Savininkas: " + m.client.getLogin());
                lang = "LIETUVIŠKAS";
            }
            case "ENGLISH" -> {
                alert.setTitle("Movie information");
                alert.setHeaderText("Movie: " + m.getName());
                alert.setContentText("Holder: " + m.client.getLogin());
                lang = "ENGLISH";
            }
            case "Islandų" -> {
                alert.setTitle("Upplýsingar um kvikmyndir");
                alert.setHeaderText("Kvikmynd: " + m.getName());
                alert.setContentText("Eigandi: " + m.client.getLogin());
            }
            case "RUSSIAN" -> {
                alert.setTitle("Информация о фильме");
                alert.setHeaderText("Фильм: " + m.getName());
                alert.setContentText("Владелец: " + m.client.getLogin());
                lang = "RUSSIAN";
            }
        }





        alert.showAndWait();
    }




}
