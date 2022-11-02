package lasttrynow.absolutsistanu;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HannahLabbTreModelTest {

    //behövs objektet från Model eller räcker listan?
    HannahLabbTreModel hannah = new HannahLabbTreModel();
    List<HannahsShape> hannahMyShapesList = new ArrayList<>();

    //testa om listan ökade när nytt shape-objekt skapaades
    @Test
    void isListLargerAfterNewShapeWasDrawn (){

        //tänker att jag vill kolla om listans size blivit större
        //men måste innan nytt objekt läggs till i listan, veta hur stor den är
        //för att se om size blivit större

        hannahMyShapesList.size();
        //vad assertas?

    }


    //testa om listan faktiskt är uppdaterad när senaste shapen togs bort
    //ev lägga till att rätt objekt togs bort
    @Test
    void isLastDrawnShapeReallyRemoved () {

        List<HannahsShape> expectedArrayList = hannahMyShapesList;

        hannahMyShapesList.remove(true);
       //vad ska  assert?

    }

}

/*     var expected = new XXX();
        var actual=hannahMyShapesList.XXX();
        //måste ha en overridad equal för att kunna köra test med equal
        //objekten behöver overridad hashcode och equal

        assertEquals(expected, actual);*/