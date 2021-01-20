package com.example.demo.design.adapter;

/**
 * Created by @author ymtNSN on 2020/11/4
 */
public class Demo {

    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg squarePeg1 = new SquarePeg(2);
        SquarePeg squarePeg2 = new SquarePeg(20);

        SquarePegAdapter squarePegAdapter1 = new SquarePegAdapter(squarePeg1);
        SquarePegAdapter squarePegAdapter2 = new SquarePegAdapter(squarePeg2);

        if (hole.fits(squarePegAdapter1)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!hole.fits(squarePegAdapter2)) {
            System.out.println("Square peg w20 fits round hole r5.");
        }
    }
}
