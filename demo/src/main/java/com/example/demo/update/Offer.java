package com.example.demo.update;

/** Interface with discount and increasePrice methods */
public interface Offer {
    void discount(); //reduce pretul la toate masinile care au numele dat ca parametru
    void increasePrice(); //creste pretul la masina cu id-ul dat ca parametru
}
