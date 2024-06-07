import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FaceAWTKogaKouki {
    public static void main(String[] args) {
        new FaceAWTKogaKouki();
    }

    FaceAWTKogaKouki() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {


        public void paint(Graphics g) {

            //FaceObj fobj=new FaceObj();
            FaceObj[] fobjs = new FaceObj[9];


            //fobj.setPosition(200,100);
            //fobj.drawFace(g);
            Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK, Color.CYAN, Color.MAGENTA, Color.GRAY};


            for (int j = 0; j < 3; j++) {

                for (int i = 0; i < 3; i++) {

                    fobjs[i + 3 * j] = new FaceObj();
                    fobjs[i].setPosition(200 * i + 50, 200 * j + 50);
                    fobjs[i].setEmotionLevel(i, j);
                    fobjs[i].setColor(colors[i + 3 * j]);
                    fobjs[i].drawFace(g);
                }
            }


        }


    }

    private class FaceObj {
        private int w;
        private int h;
        private int xStart;
        private int yStart;


        private int emo_a = 0;
        private int emo_b = 0;

        private Color c;


        FaceObj() {
            w = 200;
            h = 200;
            xStart = 150;
            yStart = 150;
        }

        public void drawFace(Graphics g) {
            drawRim(g);
            drawBrow(g, 30);
            drawEye(g, 25);
            drawNose(g, 40);
            drawMouth(g, 100);
        }

        public void drawRim(Graphics g) {
            g.setColor(c);
            g.fillOval(xStart + 5, yStart + 5, w - 10, h - 10);
            //g.drawLine(50, 50, 50+w, 50);
            //g.drawLine(50, 50, 50, 50+h);
            //g.drawLine(50, 50+h, 50+w, 50+h);
            //g.drawLine(50+w, 50, 50+w, 50+h);
            g.setColor(Color.black);
        }

        public void drawBrow(Graphics g, int bx) {

            g.drawLine(xStart + 40, yStart + 50 + emo_a * 3, xStart + 40 + 30, yStart + 50);
            g.drawLine(xStart + 40 + 90, yStart + 50, xStart + 40 + 90 + 30, yStart + 50 + emo_a * 3);
        }

        public void drawNose(Graphics g, int nx) {
            g.fillOval(xStart + 100, yStart + 80, 5, 2 * 10);

        }

        public void drawMouth(Graphics g, int mx) {
            int xMiddle = xStart + w / 2;
            int yMiddle = yStart + h - 50;
            g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle, yMiddle + emo_b * 5);
            g.drawLine(xMiddle, yMiddle + emo_b * 5, xMiddle + mx / 2, yMiddle);

        }

        public void drawEye(Graphics g, int r) {

            g.fillOval(xStart + 30 + emo_b * 10, yStart + 80, r, r);
            g.fillOval(xStart + 30 + 100 + emo_b * 10, yStart + 80, r, r);
        }
        

        public void setPosition(int px, int py) {
            this.xStart = px;
            this.yStart = py;

        }

        public void setEmotionLevel(int i, int j) {
            this.emo_a = i;
            this.emo_b = j;

        }

        public void setColor(Color c) {
            this.c = c;
        }
    }
}

