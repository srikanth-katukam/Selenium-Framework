package utils;

/**
 * Created by Skatukam on 02/28/2018.
 */
public class Button extends Element {
    public void click(String button){
        getElement(getElementBy(button));
    }
}
