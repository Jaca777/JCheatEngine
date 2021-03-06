package pl.jacadev.jce.agent.tree.nodes;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.jacadev.jce.agent.Agent;
import pl.jacadev.jce.agent.res.Controller;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author JacaDev
 */
public class FieldNode extends Node {
    private static final Image FIELD_ICON = new Image(Controller.class.getResourceAsStream("icons/fieldIcon.png"));
    private static final Image U_FIELD_ICON = new Image(Controller.class.getResourceAsStream("icons/unmodifiableFieldIcon.png"));

    private final Field field;
    private final Object owner;

    public FieldNode(Field field, Object owner) {
        this.field = field;
        this.owner = owner;
        if (isModifiable()) setGraphic(new ImageView(FIELD_ICON));
        else setGraphic(new ImageView(U_FIELD_ICON));
    }

    public FieldNode(Field field) {
        this(field, null);
    }

    public Field getField() {
        return field;
    }

    @Override
    public String toString() {
        return field.getName();
    }

    @Override
    public void handleClick() {
        try {
            Controller.CONTROLLER.openField(field, owner);
        } catch (ReflectiveOperationException e) {
            Agent.handleException(e);
        }
    }

    public boolean isModifiable() {
        return this.owner != null || ((field.getModifiers() & Modifier.STATIC) != 0);
    }
}
