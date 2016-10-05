/**
 * Created by jakereisner on 10/1/16.
 */
import javax.swing.*;
import java.util.*;

public class CubicZeroSolver {

    public static double[] cubic(double a, double b, double c, double d) {
        int n = (int) a;
        int m = (int) d;


        double[] lead = new double[n];
        double[] end = new double[m];

        int i, j = 0; //create an array for lead coefficient
        for (i = 1; i <= n; i++) {
            if (n % i == 0) {
                lead[j] = i;
                j++;
            }
        }

        //erase all values in the lead array equal to 0 (extra array values)
        j = 0;
        for(i=0;  i<lead.length;  i++ ) {
            if (lead[i] != 0)
                lead[j++] = lead[i];
        }
        double [] newLead = new double[j];
        System.arraycopy( lead, 0, newLead, 0, j );


         //create an array for the end term
        j = 0;
        for (i = 1; i <= m; i++) {
            if (m % i == 0) {
                end[j] = i;
                j++;
            }
        }
        //erase all values in the end array equal to 0 (extra array values)
        j = 0;
        for(i=0;  i<end.length;  i++ )
        {
            if (end[i] != 0)
                end[j++] = end[i];
        }
        double [] newEnd = new double[j];
        System.arraycopy( end, 0, newEnd, 0, j );
        //return newEnd;
        return newLead;

    }

    //old method, deprecated:
    //double p = (-1*b)/(3*a);
    //double q = Math.pow(p,3) + (b*c-3*a*d)/(6*a*a);
    //double r = c/(3*a);
    //return Math.pow(q + Math.pow(q*q + Math.pow(r-p*p,3.0),.5),(1/3)) +
    //Math.pow(q - Math.pow(q*q + Math.pow(r-p*p,3),.5),(1/3)) + p;


//    public static int[] synth(double a, double b, double c, double d){
//        int root1 = cubic(a,b,c,d);
//        //double remainder = d-(root*(c-(root*(b-root*a))));
//        int[] syn = {a,b-root1*a,c-(b-(root1*a))};
//        return syn;
//    }

//    public static boolean syntest(double a,double b,double c,double d){
//        double[] synresult = synth(a,b,c,d);
//        double discriminant = Math.pow((synresult[1])*(synresult[1]) - 4*synresult[0]*synresult[2],.5);
//        if (discriminant == (int)discriminant)
//            return true;
//        else
//            return false;
//    }

//    public static double[] quad(double a, double b, double c, double d){
//        double[] sy = synth(a,b,c,d);
//        double[] roots = {((-1*b)+Math.pow(sy[1]*sy[1]-4*sy[0]*sy[2],.5))/(2*a),((-1*b)-Math.pow(sy[1]*sy[1]-4*sy[0]*sy[2],.5))/(2*a)};
//        return roots;
//    }

    public static void main(String[] args) {

        double a = Double.parseDouble(JOptionPane.showInputDialog("enter a"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("enter b"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("enter c"));
        double d = Double.parseDouble(JOptionPane.showInputDialog("enter d"));

//        double result = cubic(a, b, c, d);
//        double[] synresult = synth(a,b,c,d);
//        double[] roots = quad(a,b,c,d);
//        if (!syntest(a,b,c,d))
//            System.out.println("Your solution is: (x-" + result + ")(" + synresult[0] + "x^2  + " + synresult[1] + "x + " + synresult[2] + ")");
//        else
//            System.out.println("Your solution is: (x-" + result + ")"+"(x- " + roots[0]+ ")(x-" +roots[1]+")");
        double[] result = cubic(a, b, c, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(" " + result[i]+ " ");
        }
    }
}