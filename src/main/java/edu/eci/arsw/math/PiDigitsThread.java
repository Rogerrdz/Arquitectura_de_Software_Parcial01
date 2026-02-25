package edu.eci.arsw.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PiDigitsThread extends Thread {

    private int start;
    private int count;
    private byte[] result;

    public PiDigitsThread(int start, int count) {
        this.start = start;
        this.count = count;
    }

    @Override
    public void run() {
        long last = System.currentTimeMillis();
        int processed = 0;
        result = new byte[count];

        for (int i = 0; i < count; i++) {
            result[i] = PiDigits.getDigits(start + i, 1)[0];
            processed++;

            if (System.currentTimeMillis() - last >= 5000) {
                System.out.println(
                    "Hilo " + this.getId() + " procesó " + processed + " dígitos. Presione ENTER para continuar."
                );
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    br.readLine();
                } catch (Exception e) {
                }
                last = System.currentTimeMillis();
            }
        }
    }
    

    public byte[] getResult() {
        return result;
    }
}