
module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    opens edu.fiuba.algo3.vista to javafx.graphics;
    requires org.json;
    requires java.desktop;
    requires javafx.media;
    requires java.scripting;
    exports edu.fiuba.algo3;

    opens edu.fiuba.algo3.testEntregaFinal.CriterioTest to org.junit.platform.commons;
}