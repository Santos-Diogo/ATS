package Calculadora;

import Calculadora.Calculadora;
import org.junit.jupiter.api.Test;

import javax.management.remote.rmi._RMIConnection_Stub;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {
    @Test
    public void adiciona01() {
        Calculadora c = new Calculadora();
        int x = c.adiciona(5);
        assertEquals(5, x);
    }

    @Test
    public void adicionaNovo() {
        Calculadora c = new Calculadora();
        int x = c.adiciona(2, 1);
        assertEquals(3, x);
    }

    @Test
    public void adiciona02() {
        Calculadora c = new Calculadora();
        int x = c.adiciona(2, 2);
        assertEquals(4, x);
    }

    @Test
    public void subtrai01() {
        Calculadora c = new Calculadora();
        int x = c.subtrai(0, 0);
        assertEquals(0, x);
    }

    @Test
    public void subtrai02() {
        Calculadora c = new Calculadora();
        int x = c.subtrai(1, 2);
        assertEquals(-1, x);
    }

    @Test
    public void subtrai03() {
        Calculadora c = new Calculadora();
        int y = c.subtrai(5);
        assertEquals(-5, y);
    }

    @Test
    public void UltimoResultado()
    {
        Calculadora c= new Calculadora();
        c.adiciona(25);
        c.subtrai(5);
        int x= c.ultimoResultado();
        assertEquals(20, x);
    }

}
