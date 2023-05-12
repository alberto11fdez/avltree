package avl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AvlTreePracticaTest {


    @Nested
    @DisplayName("Valores introducibles en el constructor si el ")
    public class PruebaConstructor{
        @Test
        @DisplayName("Si num Nodos = 1")
        public void test3(){

        }

        @Test
        @DisplayName("Si num Nodos >1")
        public void test4(){

        }
    }

    @Nested
    @DisplayName("Valores introducibles en el InsertarNodo")
    public class InsertarNodo{
        @Test
        @DisplayName("Si Nodo != null")
        public void test5(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node2 = new AvlNode(3);
            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node2);

            assertEquals(0,avlTree.height(node2));
            assertEquals(node,avlTree.getTop());
        }

        @Test
        @DisplayName("Si Nodo == null")
        public void test6(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = null;

            assertThrows(IllegalArgumentException.class, () -> {avlTree.insertAvlNode(node);});
        }
    }

    @Nested
    @DisplayName("Valores introducibles en el BuscarNodo")
    public class BuscarNodo{
        @Test
        @DisplayName("Si Nodo != null")
        public void test7(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node2 = new AvlNode(3);
            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node2);

            assertEquals(node,avlTree.search(4));
        }

        @Test
        @DisplayName("Si top es null")
        public void testTopNull(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);

            assertEquals(null,avlTree.search(4));
        }

        @Test
        @DisplayName("Si no existe el item")
        public void testNoItem(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            avlTree.insert(3);

            assertEquals(null,avlTree.search(4));
        }
        @Test
        @DisplayName("Búsqueda por la derecha")
        public void testRightSearch(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node2 = new AvlNode(3);
            AvlNode<Integer> node3 = new AvlNode(5);
            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node2);
            avlTree.insertAvlNode(node3);

            assertEquals(node3,avlTree.search(5));
        }
        @Test
        @DisplayName("Si Nodo == null")
        public void test8(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = null;

            assertThrows(IllegalArgumentException.class, () -> {avlTree.searchNode(node);});
        }
    }



    @Nested
    @DisplayName("Valores introducibles en el BorrarNodo")
    public class BorrarNodo{
        @Test
        @DisplayName("Si Nodo != null")
        public void test9(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node2 = new AvlNode(3);
            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node2);

            avlTree.delete(3);
            assertEquals(null,avlTree.searchNode(node2));
        }

        @Test
        @DisplayName("Si Nodo == null")
        public void test10(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = null;

            assertThrows(IllegalArgumentException.class, () -> {avlTree.deleteNode(node);});
        }
    }


    @Nested
    @DisplayName("Valores introducibles en el BorrarHijoIzquiero")
    public class BorrarHijoIzq{
        @Test
        @DisplayName("Si Nodo != null")
        public void test11(){

        }

        @Test
        @DisplayName("Si Nodo == null")
        public void test12(){

        }
    }


    @Nested
    @DisplayName("Valores introducibles en el BorrarHijoDerecho")
    public class BorrarHijoDrcho{
        @Test
        @DisplayName("Si Nodo != null")
        public void test13(){

        }

        @Test
        @DisplayName("Si Nodo == null")
        public void test14(){

        }
    }



    @Nested
    @DisplayName("Valores introducibles en el EntrarSucesor")
    public class EncontrarSucesor{
        @Test
        @DisplayName("Si Nodo tiene algún hijo")
        public void test15(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node2 = new AvlNode(3);
            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node2);

            assertEquals(node,avlTree.findSuccessor(node2));
        }

        @Test
        @DisplayName("Si Nodo no tiene hijos")
        public void test16(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);

            avlTree.insertAvlNode(node);

            assertThrows(IllegalArgumentException.class, () -> {avlTree.findSuccessor(node);});
        }
    }



}
