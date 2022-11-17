package labb;

import static org.junit.Assert.*;
import org.junit.Test;

public class Volvo240Test{

    @Test
    public void a(){
        assertEquals(1, 1);

        Volvo240 a = new Volvo240();

        a.getNrDoors();
    }
}