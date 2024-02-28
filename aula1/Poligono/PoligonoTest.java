import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoligonoTest
{
    @Test
    public void testPerimetro (){
        Poligono quadrado= new Retangulo(new Ponto(0,0), new Ponto(2,0), new Ponto(2,2), new Ponto(0,2));
        assertEquals(8, quadrado.perimetro());
    }

    
}