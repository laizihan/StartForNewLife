package com.example.laizihan.startfornewlife.subscribe;

/**
 * Created by laizihan on 16/3/6.
 */
public interface Subject {
    void add(Poster poster);

    void remove(Poster poster);

    void notify(String s);

}

interface Poster {
    void update(String s);
}
