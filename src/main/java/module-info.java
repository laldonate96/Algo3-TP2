
module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    opens edu.fiuba.algo3.vista to javafx.graphics;
    requires org.json;
    requires java.desktop;
    requires javafx.media;
    exports edu.fiuba.algo3;
}