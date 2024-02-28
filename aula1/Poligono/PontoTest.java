import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoTest {
    @Test
    public void incrementaPonto() {
        Ponto p = new Ponto(0, 0);
        p.incCoord(5, 5);
        assertEquals(5, p.getX());
        assertEquals(5, p.getY());
    }
}