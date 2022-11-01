package lasttrynow.absolutsistanu;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Rectangle extends HannahsShape{
    @Override
    public boolean isShapeSelected(MouseEvent mouseEvent) {
        double endPosX= positionX+width;
        double endPosY=positionY+height;

        if(mouseEvent.getX()>getPositionX()&& mouseEvent.getX()<endPosX){
            if(mouseEvent.getY()>getPositionY()&&mouseEvent.getY()<endPosY){
                return true;
            }
        }

        return false;

    }
    public Rectangle (String shape, double positionX, double positionY, Number width, Number height, Color color){
        super(shape, positionX, positionY, width.doubleValue()*1.5, height.doubleValue(), color);
    }
}
