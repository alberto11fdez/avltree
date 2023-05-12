package avl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.Node;

import static org.junit.jupiter.api.Assertions.*;

public class AvlNodePracticaTest {
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
        assertThrows(IllegalArgumentException.class, () -> {AvlNode<Object> nodoNull = new AvlNode<>(null);});

    }

    @Test
    @DisplayName("Test para comprobar que un nodo completo, con padre, hijoDrcho, HijoIzq, NodoCercano y con peso devuelve el item del nodo")
    public void test3(){
        AvlNode<Object>Node1 = new AvlNode<>(1);

        Node1.setHeight(1);
        Node1.setLeft(new AvlNode<>(2));
        Node1.setRight(new AvlNode<>(3));
        Node1.setParent(new AvlNode<>(0));
        Node1.setClosestNode(new AvlNode<>(4));
        Node1.updateHeight();
        Node1.setItem(1);

        assertEquals(1, Node1.getItem());
        assertTrue(Node1.hasParent());
        assertTrue(Node1.hasRight());
        assertTrue(Node1.hasLeft());
    }

    @Test
    @DisplayName("Test para comprobar que un nodo solo tiene hijo izquierdo")
    public void test4(){
        AvlNode<Object>Node1 = new AvlNode<>(1);

        Node1.setLeft(new AvlNode<>(2));

        Node1.updateHeight();
        assertFalse(Node1.isLeaf());
        assertFalse(Node1.hasOnlyARightChild());
        assertTrue(Node1.hasOnlyALeftChild());
    }


    @Test
    @DisplayName("Test para comprobar que un nodo solo tiene hijo derecho")
    public void test5(){
        AvlNode<Object>Node1 = new AvlNode<>(1);

        Node1.setRight(new AvlNode<>(2));

        Node1.updateHeight();


        assertFalse(Node1.isLeaf());
        assertFalse(Node1.hasOnlyALeftChild());
        assertTrue(Node1.hasOnlyARightChild());
    }

    @Test
    @DisplayName("Test para comprobar que un nodo es una hoja")
    public void test6(){
        AvlNode<Object>Node1 = new AvlNode<>(1);
        Node1.updateHeight();

        assertTrue(Node1.isLeaf());
        assertFalse(Node1.hasParent());
        assertFalse(Node1.hasOnlyALeftChild());
        assertFalse(Node1.hasOnlyARightChild());
    }




}
