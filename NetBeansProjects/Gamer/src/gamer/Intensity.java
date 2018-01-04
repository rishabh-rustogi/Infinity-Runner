package gamer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Intensity extends Thread {
    // @Override
    public void run()
    {
        while(true)
        {
            //if(Main.cchh)
            {
            Main.line.start();
            for (int b; ((b = Main.line.read(Main.buf, 0, Main.buf.length)) > -1);) {
                for (int i = 0, s = 0; i < b;) {
                    Main.sample = 0;
                    Main.sample |= Main.buf[i++] & 0xFF;
                    Main.sample |= Main.buf[i++] << 8;
                    Main.samples[s++] = Main.sample / 32768f;
                }
                Main.rms = 0;
                float peak = 0f;
                for (float sample : Main.samples) {
                    float abs = Math.abs(sample);
                    if (abs > peak) {
                        peak = abs;
                    }
                    Main.rms += sample * sample;
                }
                Main.rms = (float) Math.sqrt(Main.rms / Main.samples.length);
                break;
            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(Intensity.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
}
