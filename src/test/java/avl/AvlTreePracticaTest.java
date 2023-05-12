package avl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AvlTreePracticaTest {


    @Nested
    @DisplayName("Valores introducibles en el constructor si el ")
    public class PruebaConstructor{
        @Test
        @DisplayName("Si num Nodos = 1")
        public void ConstructorCon1Nodo(){
            AvlTree<Object> avlTreeActual = new AvlTree<>(null);
            avlTreeActual.insert(1);
            Object itemExpected = 1;
            Object itemActual = avlTreeActual.getTop().getItem();


            assertEquals(itemExpected,itemActual);
        }

        @Test
        @DisplayName("Si num Nodos >1")
        public void ConstructoMasDe1Nodo(){
            AvlTree<Object> avlTreeActual = new AvlTree<>(null);
            avlTreeActual.insert(1);
            Object itemExpected = 1;
            Object itemActual = avlTreeActual.getTop().getItem();

            assertThrows(NullPointerException.class, () -> {avlTreeActual.insert(2);});

        }
    }

    @Nested
    @DisplayName("Valores introducibles en el InsertarNodo")
    public class InsertarNodo{
        @Test
        @DisplayName("Si Nodo != null")
        public void InsertarNodoNoNull(){
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
        public void InsertarNodoNullLanzarIllegalArgumentException(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = null;
            assertEquals(-1, avlTree.height(node));
            assertThrows(IllegalArgumentException.class, () -> {avlTree.insertAvlNode(node);});
        }
    }

    @Nested
    @DisplayName("Valores introducibles en el BuscarNodo")
    public class BuscarNodo{
        @Test
        @DisplayName("Si Nodo != null")
        public void BuscarNodoNoNull(){
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
            avlTree.insert(4);
            assertEquals(null,avlTree.search(5));
            avlTree.insert(2);
            assertEquals(null,avlTree.search(1));
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
        public void BuscarNodoNullLanzarIllegalArgumentException(){
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
        public void BorrarNodoNoNull(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            avlTree.insertAvlNode(node);

            avlTree.delete(4);
            assertEquals(null,avlTree.searchNode(node));
        }

        @Test
        @DisplayName("Si Nodo == null")
        public void BorrarNodoNull(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = null;

            assertThrows(IllegalArgumentException.class, () -> {avlTree.deleteNode(node);});
        }

        @Test
        @DisplayName("Si Nodo != null y tiene hijo derecho")
        public void BorrarNodoNoNullConHijoDrcho(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);

            avlTree.insertTop(node);
            node.setRight(new AvlNode<>(5));

            avlTree.deleteNode(node);
            assertEquals(5,avlTree.searchNode(node).getItem());
        }

        @Test
        @DisplayName("Si Nodo != null y tiene hijo izquierdo")
        public void BorrarNodoNoNullConHijoIzq(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);

            avlTree.insertTop(node);
            node.setLeft(new AvlNode<>(3));

            avlTree.deleteNode(node);
            assertEquals(3,avlTree.searchNode(node).getItem());
        }

        @Test
        @DisplayName("Si Nodo != null y tiene hijo izquierdo y derecho")
        public void BorrarNodoNoNullConHijoIzqYDrcho(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);

            avlTree.insertTop(node);
            node.setLeft(new AvlNode<>(3));
            node.setRight(new AvlNode<>(5));

            avlTree.deleteNode(node);
            assertEquals(null,avlTree.searchNode(node));
        }

        @Test
        @DisplayName("Si Nodo != null y tiene hijo izquierdo y derecho y el cual tiene hijo derecho")
        public void BorrarNodoNoNullConHijoIzqYDrchoYElCualTieneHijoDrcho(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(3);
            AvlNode<Integer> node2 = new AvlNode(5);

            avlTree.insertTop(node);
            node.setLeft(node1);
            node.setRight(node2);


            node2.setRight(new AvlNode<>(4));


            avlTree.deleteNode(node);
            assertEquals(null,avlTree.searchNode(node));
        }
        @Test
        @DisplayName("Si Nodo != null y tiene hijo izquierdo y derecho y el cual tiene hijo izquierdo")
        public void BorrarNodoNoNullConHijoIzqYDrchoYElCualTieneHijoIzq(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(50);
            AvlNode<Integer> node1 = new AvlNode(17);
            AvlNode<Integer> node2 = new AvlNode(76);

            node1.setLeft(new AvlNode<>(9));
            node2.setLeft(new AvlNode<>(54));

            avlTree.insertAvlNode(node);
            avlTree.insertAvlNode(node1);
            avlTree.insertAvlNode(node2);

            avlTree.deleteNode(node);
            avlTree.deleteLeafNode(node2);
            assertEquals(null,avlTree.searchNode(node2));
        }

    }


    @Nested
    @DisplayName("Valores introducibles en el BorrarHijoIzquiero")
    public class BorrarHijoIzq{
        @Test
        @DisplayName("Si Nodo != null")
        public void BorrarHijoIzqNoNull(){
            Comparator comparator = Comparator.comparingInt((Integer o)-> o);
            AvlTree<Object> avlTree = new AvlTree<>(comparator);
            avlTree.insert(1);
            avlTree.insert(2);
            AvlNode<Object> nodeActual = avlTree.getTop();

            assertThrows(NullPointerException.class, () -> {avlTree.deleteNodeWithALeftChild(avlTree.top.getLeft());});

        }

        @Test
        @DisplayName("Si Nodo == null")
        public void BorrarHijoIzqNull(){
            Comparator comparator = Comparator.comparingInt((Integer o)-> o);
            AvlTree<Object> avlTree = new AvlTree<>(comparator);
            avlTree.insert(1);
            AvlNode<Object> nodeActual = avlTree.getTop();

            assertThrows(NullPointerException.class, () -> {avlTree.deleteNodeWithALeftChild(avlTree.top.getLeft());});
        }
    }


    @Nested
    @DisplayName("Valores introducibles en el BorrarHijoDerecho")
    public class BorrarHijoDrcho{
        @Test
        @DisplayName("Si Nodo != null")
        public void BorrarHijoDrchoNoNull(){
            Comparator comparator = Comparator.comparingInt((Integer o)-> o);
            AvlTree<Object> avlTree = new AvlTree<>(comparator);
            avlTree.insert(5);
            avlTree.insert(3);
            avlTree.insert(6);
            AvlNode<Object> nodeActual = avlTree.getTop();
            avlTree.deleteNodeWithARightChild(avlTree.top);

            assertThrows(NullPointerException.class, () -> {avlTree.deleteNodeWithARightChild(avlTree.top);});
        }

        @Test
        @DisplayName("Si Nodo == null")
        public void BorrarHijoDrchoNull(){
            Comparator comparator = Comparator.comparingInt((Integer o)-> o);
            AvlTree<Object> avlTree = new AvlTree<>(comparator);
            avlTree.insert(5);
            avlTree.insert(3);
            avlTree.insert(6);
            AvlNode<Object> nodeActual = avlTree.getTop();
            assertThrows(NullPointerException.class, () -> {avlTree.deleteNodeWithARightChild(avlTree.top.getRight());});
        }
    }



    @Nested
    @DisplayName("Valores introducibles en el EntrarSucesor")
    public class EncontrarSucesor{
        @Test
        @DisplayName("Si Nodo tiene algún hijo")
        public void ComprobarNodoHijo(){
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
        public void ComprobarNodoNoTieneHijo(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);

            avlTree.insertAvlNode(node);

            assertThrows(IllegalArgumentException.class, () -> {avlTree.findSuccessor(node);});
        }


    }

    @Nested
    @DisplayName("Método Rotar a la Izquierda")
    public class RotarAIzquierdaElAvlTree{
        @Test
        @DisplayName("Rotar a la izquierda sin tener nodo padre")
        public void ComprobarRotarAIzquierdaSinPadre(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.leftRotation(avlTree.getTop());
        }

        @Test
        @DisplayName("Rotar a la izquierda teniendo nodo padre")
        public void ComprobarRotarAIzquierdaConPadre(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node3 = new AvlNode(6);


            node1.setParent(node3);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.leftRotation(avlTree.getTop());
        }

        @Test
        @DisplayName("Rotar a la izquierda teniendo nodo padre, el cual tiene sus dos hijos iguales")
        public void ComprobarRotarAIzquierdaConPadreTeniendoSuHijoIzqIguaAlDrcho(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node3 = new AvlNode(6);

            node3.setLeft(node1);

            node1.setParent(node3);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.leftRotation(avlTree.getTop());
        }

    }


    @Nested
    @DisplayName("Método Rotar a la derecha")
    public class RotarADerechaElAvlTree{
        @Test
        @DisplayName("Rotar a la derecha sin tener nodo padre")
        public void ComprobarRotarADerechaSinPadre(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.rightRotation(avlTree.getTop());
        }

        @Test
        @DisplayName("Rotar a la derecha teniendo nodo padre")
        public void ComprobarRotarADerechaConPadre(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node3 = new AvlNode(6);


            node1.setParent(node3);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.rightRotation(avlTree.getTop());
        }

        @Test
        @DisplayName("Rotar a la derecha teniendo nodo padre, el cual tiene sus dos hijos iguales")
        public void ComprobarRotarADerechaConPadreTeniendoSuHijoIzqIguaAlDrcho(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node3 = new AvlNode(6);

            node3.setRight(node1);

            node1.setParent(node3);

            node1.setLeft(node);
            node1.setRight(node2);
            avlTree.insertTop(node1);

            avlTree.rightRotation(avlTree.getTop());
        }

    }

    @Nested
    @DisplayName("Metodo Rotar dos veces")
    public class RotarDosVecesADerechaElAvlTree {
        @Test
        @DisplayName("Rotar a la derecha sin tener nodo padre dos veces")
        public void ComprobarRotarADerechaSinPadreDosVeces() {
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node3 = new AvlNode(7);


            node1.setLeft(node);
            node1.setRight(node2);
            node2.setLeft(node1);
            node2.setRight(node3);
            avlTree.insertTop(node1);

            avlTree.doubleRightRotation(avlTree.getTop());
        }
        @Test
        @DisplayName("Rotar a la izquierda sin tener nodo padre dos veces")
        public void ComprobarRotarAIzquierdaSinPadreDosVeces() {
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);
            AvlNode<Integer> node = new AvlNode(4);
            AvlNode<Integer> node1 = new AvlNode(5);
            AvlNode<Integer> node2 = new AvlNode(6);
            AvlNode<Integer> node0 = new AvlNode(3);


            node1.setLeft(node);
            node1.setRight(node2);
            node.setLeft(node0);
            node.setRight(node1);
            avlTree.insertTop(node1);

            avlTree.doubleLeftRotation(avlTree.getTop());
        }
    }

    @Nested
    @DisplayName("Devolver Arbol String")
    public class DevolverArbolString{
        @Test
        @DisplayName("Devolver el arbol que se ha creado vacio")
        public void DevolverArbolVacio(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);

            assertEquals("", avlTree.toString());
        }

        @Test
        @DisplayName("Devolver el arbol que se ha creado no vacio")
        public void DevolverArbolNoVacio(){
            Comparator comparator = Comparator.comparingInt((Integer o) -> o);
            AvlTree<Integer> avlTree = new AvlTree<>(comparator);

            AvlNode<Integer> node = new AvlNode(5);
            node.setRight(new AvlNode<>(2));
            node.setLeft(new AvlNode(7));

            avlTree.insertAvlNode(node);

            assertEquals(" | 5 | 7 | 2", avlTree.toString());
        }
    }


    @Test
    @DisplayName("SearchClosestNode el cual top=null")
    public void SearchClosestNodeTopNull(){
        Comparator comparator = Comparator.comparingInt((Integer o) -> o);
        AvlTree avlTree = new AvlTree<Object>(comparator);
        AvlNode top = null;
        avlTree.insertTop(null);
        assertEquals(0,avlTree.searchClosestNode(top));
    }

    @Test
    @DisplayName("SearchClosestNode ")
    public void SearchClosestNode(){
        Comparator comparator = Comparator.comparingInt((Integer o) -> o);
        AvlTree avlTree = new AvlTree<Object>(comparator);
        AvlNode<Integer> node = new AvlNode(4);
        AvlNode<Integer> node1 = new AvlNode(5);
        AvlNode<Integer> node2 = new AvlNode(6);
        AvlNode<Integer> node3 = new AvlNode(7);

        avlTree.insertAvlNode(node);
        avlTree.insertAvlNode(node1);
        avlTree.insertAvlNode(node2);
        avlTree.insertAvlNode(node3);

        assertEquals(0,avlTree.searchClosestNode(node));
        assertEquals(0,avlTree.searchClosestNode(node1));
        assertEquals(0,avlTree.searchClosestNode(node2));
        assertEquals(0,avlTree.searchClosestNode(node3));
        assertEquals(1,avlTree.searchClosestNode(new AvlNode<>(8)));
    }
    @Test
    @DisplayName("Buscar en árbol vacio")
    public void BuscarNodoEnArbolVacio(){
        Comparator comparator = Comparator.comparingInt((Integer o) -> o);
        AvlTree avlTree = new AvlTree(comparator);
        AvlNode<Integer> node1;
        node1 = new AvlNode<Integer>(7);
        assertNull(   avlTree.searchNode(node1));
    }

    @Test
    @DisplayName("Eliminar Nodo hoja")
    public void EliminarNodoHoja() {
        Comparator comparator = Comparator.comparingInt((Integer o) -> o);
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.delete(3);
        assertEquals(5, (int) tree.top.getItem());
        assertNull(tree.top.getLeft());
        assertEquals(7, (int) tree.top.getRight().getItem());
    }


    @Test
    @DisplayName("La busqueda a sido exitosa")
    public void BusquedaExitosa() {
        Comparator comparator = Comparator.comparingInt((Integer o) -> o);
        AvlTree<Integer> tree = new AvlTree<>(comparator);
        tree.insert(5);
        AvlNode<Integer> node = tree.search(5);
        assertNotNull(node);
        assertEquals(5, (int) node.getItem());
    }



}
