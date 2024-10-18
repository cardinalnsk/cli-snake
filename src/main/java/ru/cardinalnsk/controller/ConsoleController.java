package ru.cardinalnsk.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.cardinalnsk.model.enums.Direction;

@Getter
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConsoleController implements Runnable {

    final Terminal terminal;

    Direction direction = Direction.RIGHT;

    int selectedMenuItem;
    int maxMenuItems;
    boolean enterPressed;
    boolean isAlive;

    public void keyListener() {
        try {
            KeyStroke keyStroke = terminal.readInput();

            if (keyStroke != null) {
                KeyType keyType = keyStroke.getKeyType();
                switch (keyType) {
                    case ArrowUp -> selectedMenuItem((selectedMenuItem - 1 + maxMenuItems) % maxMenuItems);
                    case ArrowDown -> selectedMenuItem((selectedMenuItem + 1) % maxMenuItems);
                    case Enter -> enterPressed = true;
                    case Escape -> {
                        isAlive = false;
                        System.exit(0);
                    }
                    case Character -> {
                        char keyChar = Character.toLowerCase(keyStroke.getCharacter());
                        direction(switch (keyChar) {
                            case 'w' ->
                                direction == Direction.DOWN ? Direction.DOWN : Direction.UP;
                            case 'a' ->
                                direction == Direction.RIGHT ? Direction.RIGHT : Direction.LEFT;
                            case 's' ->
                                direction == Direction.UP ? Direction.UP : Direction.DOWN;
                            case 'd' ->
                                direction == Direction.LEFT ? Direction.LEFT : Direction.RIGHT;
                            default -> direction;
                        });
                    }
                }
            }
        } catch (IOException e) {
            isAlive = false;
            throw new RuntimeException(e);
        }
    }

    public void resetEnterPressed() {
        enterPressed = false;
    }

    public void stop() {
        isAlive = false;
    }

    @Override
    public void run() {
        isAlive = true;
        while (isAlive) {
            keyListener();
        }
    }


}
