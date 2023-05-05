package avl;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AvlNodeTestPractica {
    @Test
    @DisplayName("Test para el constructor al pasarle cualquier objeto valido")
    public void test1(){

    }

    @Test
    @DisplayName("Test para el constructor al pasarle un objeto null")
    public void test2(){
        AvlNode<Object> nodoNull = new AvlNode<>(null);
        assertThrows(IllegalArgumentException.class, () -> {nodoNull.getItem();});

    }


}
