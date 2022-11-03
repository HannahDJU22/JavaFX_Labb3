package lasttrynow.absolutsistanu;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class HannahLabbTreModelTest {
    HannahLabbTreModel hannah = new HannahLabbTreModel();
    @Test
    void isListLargerAfterNewShapeWasDrawn (){

        System.out.println(hannah.myShapesList.size());
        hannah.createRectangleShape(20, 20);

        assertThat(hannah.myShapesList.size()==1);
        System.out.println(hannah.myShapesList.size());
    }

    @Test
    void isLastDrawnShapeReallyRemoved () {

        System.out.println(hannah.myShapesList.size());
        hannah.createSquareShape(10, 10);
        System.out.println(hannah.myShapesList.size());

        hannah.removeLastShapeFromCanvas();
        assertThat(hannah.myShapesList.size()==0);
        System.out.println(hannah.myShapesList.size());
    }

    @Test
    void isCreatedSquareActuallyInTheList() {
        System.out.println(hannah.myShapesList);

        Square mySquare = hannah.createSquareShape(20, 20);
        assertThat(hannah.myShapesList).contains(mySquare);
        System.out.println(hannah.myShapesList);
    }


}
