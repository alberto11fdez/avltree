package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AvlNodeTestPractica {
    @Test
    @DisplayName("Test para el constructor al pasarle cualquier objeto valido")
    public void test1(){
        AvlNode<Object> nodeActual = new AvlNode<>(4);
        AvlNode<Object> leftActual=nodeActual.getLeft();
        AvlNode<Object> rightActual=nodeActual.getRight();
        AvlNode<Object> parentActual=nodeActual.getParent();
        int heightActual=nodeActual.getHeight();
        AvlNode<Object> closestNodeActual=nodeActual.getClosestNode();
        Object objectActual=nodeActual.getItem();



        AvlNode<Object> leftExpected=null;
        AvlNode<Object> rightExpected=null;
        AvlNode<Object> parentExpected=null;
        int heightExpected=0;
        AvlNode<Object> closestNodeExpected=null;
        Object objectExpected=(Object) 4;

        assertEquals(leftExpected,leftActual);
        assertEquals(rightExpected,rightActual);
        assertEquals(parentExpected,parentActual);
        assertEquals(heightExpected,heightActual);
        assertEquals(closestNodeExpected,closestNodeActual);
        assertEquals(objectExpected,objectExpected);
    }

    @Test
    @DisplayName("Test para el constructor al pasarle un objeto null")
    public void test2(){
        AvlNode<Object> nodoNull = new AvlNode<>(null);
        assertThrows(IllegalArgumentException.class, () -> {nodoNull.getItem();});

    }


}
