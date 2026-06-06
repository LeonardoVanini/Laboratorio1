package com.lab;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class LabirintoDFSSTest{

    @Test
    public void shouldReturnTrueWhenCellIsInsideAndEmpty() {
        LabirintoDFSS.size=5;
        LabirintoDFSS.labirinto = new int[][]{
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0},
            {0,0,0,0,0}
        };

        boolean result = LabirintoDFSS.èValida(2,2);

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenCellIsOnBorder() {
        LabirintoDFSS.size=5;
        LabirintoDFSS.labirinto = new int[5][5];



        assertFalse(LabirintoDFSS.èValida(0,0));
        assertFalse(LabirintoDFSS.èValida(4,4));
        assertFalse(LabirintoDFSS.èValida(10,-2));
    }

    @Test
    public void shouldReturnCorrectIdForDirections(){
        boolean[] direzioni ={true,false,true,false};
        LabirintoDFSS.direzioniImage = new ArrayList<>();
        LabirintoDFSS.direzioniImage.add(new boolean[]{true,false,true,false});

        int id = LabirintoDFSS.definisci(direzioni);

        assertEquals(0,id);
    }
}
