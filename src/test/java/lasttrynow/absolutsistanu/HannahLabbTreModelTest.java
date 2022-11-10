package lasttrynow.absolutsistanu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class HannahLabbTreModelTest {
    HannahLabbTreModel hannah = new HannahLabbTreModel();
    @Test
    void isListLargerAfterNewShapeWasDrawn (){
        hannah.createRectangleShape(20, 20);

        assertThat(hannah.myShapesList).hasSize(1);
    }

    @Test
    void isLastDrawnShapeReallyRemoved () {

        hannah.createSquareShape(10, 10);

        hannah.removeLastShapeFromCanvas();
        assertThat(hannah.myShapesList).hasSize(0);
    }

    @Test
    void isCreatedSquareActuallyInTheList() {

        Square mySquare = hannah.createSquareShape(20, 20);
        assertThat(hannah.myShapesList).contains(mySquare);
    }


}
