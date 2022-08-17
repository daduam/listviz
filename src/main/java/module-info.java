module io.github.daduam {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens io.github.daduam to javafx.fxml;

    exports io.github.daduam;
}
