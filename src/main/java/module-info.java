
module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    opens edu.fiuba.algo3.vista to javafx.graphics;
    requires org.json;
    exports edu.fiuba.algo3;
}