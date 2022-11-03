package lasttrynow.absolutsistanu;

import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class HannahLabbTreModelTest {

    HannahLabbTreModel hannah = new HannahLabbTreModel();


    @Test
    void isListLargerAfterNewShapeWasDrawn (){
        //testa om listan ökade när nytt shape-objekt skapaades
        //tänker att jag vill kolla om listans size blivit större
        //kolla getsize på listan
        //anropa metod att lägga till en shape
        //kolla därefter getSize på listan

        //eller anropa metod att lägga till en shape
        //sedan assert that size == 1

        hannah.myShapesList.size();
    }

    @Test
    void isLastDrawnShapeReallyRemoved () {
        //testa om listan faktiskt är uppdaterad när senaste shapen togs bort
        //ev lägga till att rätt objekt togs bort

        //anropa metod att lägga till objekt i listan
        //anropa metod att undo senast
        //assert that listan nu är 0

        hannah.removeLastShapeFromCanvas();
        assertThat(hannah.myShapesList).isNotEmpty();
    }

    @Test
    void isCreatedSquareActuallyInTheList() {
        //jag har skapat en ny Square till min lista, testet kollar att just denna square ligger i listan

        Square mySquare = hannah.createSquareShape(20, 20);
        assertThat(hannah.myShapesList).contains(mySquare);
    }


}


/*     var expected = new XXX();
        var actual=hannahMyShapesList.XXX();
        //måste ha en overridad equal för att kunna köra test med equal
        //objekten behöver overridad hashcode och equal

        assertEquals(expected, actual);*/