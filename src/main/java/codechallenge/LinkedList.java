/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechallenge;

/**
 *
 * @author ranjeet
 */
public class LinkedList {

    private int data;
    private LinkedList next;

    public LinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public int data() {
        return data;
    }

    public LinkedList next() {
        return next;
    }

}
