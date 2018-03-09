import java.awt.*;
import java.util.Scanner;

public class elipse extends Frame {

    private static int sx;
    private static int sy;
    private int lienzo = 500;

    public void paint(Graphics g) {
        int x, y;
        int mitad = lienzo / 2;
        x=0;
        float aux;
        x=0;
        double f[] = new double[2];
        y = sy;
        do {
            aux = y;
            for (int i = 0; i <= 1; i++) {
                f[i] = (Math.pow(x, 2) / Math.pow(sx, 2)) + (Math.pow(aux, 2)/Math.pow(sy, 2)) - 1;
                aux--;
            }
            y = (int) ((Math.abs(f[0]) < Math.abs(f[1])) ? aux + 2 : aux + 1);
            g.setColor(Color.RED);
            g.drawLine(x + mitad, y + mitad, x + mitad, y + mitad);
            g.drawLine(-x + mitad, y + mitad, -x + mitad, y + mitad);
            g.drawLine(x + mitad, -y + mitad, x + mitad, -y + mitad);
            g.drawLine(-x + mitad, -y + mitad, -x + mitad, -y + mitad);
            x++;
        } while (x <= (Math.pow(sx, 2) / Math.pow(sy, 2) * y));
        x=0;
        y=sx;
        do {
            aux = y;
            for (int i = 0; i <= 1; i++) {
                f[i] = (Math.pow(x, 2) / Math.pow(sy, 2)) + (Math.pow(aux, 2)/Math.pow(sx, 2)) - 1;
                aux--;
            }
            y = (int) ((Math.abs(f[0]) < Math.abs(f[1])) ? aux + 2 : aux + 1);
            g.setColor(Color.BLUE);
            System.out.println(x+","+y);
            g.drawLine(y + mitad, x + mitad, y + mitad, x + mitad);
            g.drawLine(-y + mitad, x + mitad, -y + mitad, x + mitad);
            g.drawLine(y + mitad, -x + mitad, y + mitad, -x + mitad);
            g.drawLine(-y + mitad, -x + mitad, -y + mitad, -x + mitad);
            x++;
        } while (x <= (Math.pow(sy, 2) / Math.pow(sx, 2) * y));
    }
    private elipse() {
        this.setSize(lienzo, lienzo);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Deme Sx:");
        sx = entrada.nextInt();
        System.out.println("Deme Sy:");
        sy = entrada.nextInt();
        elipse p = new elipse();
    }
}

