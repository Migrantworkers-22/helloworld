package socket;

import java.util.ArrayList;
import java.util.Collections;

public class aaaa {
    public void print(int n){
        int t=0;
        for (int i=1;i<=n;i++){
            t=n-i;
            while (t>0){
                System.out.print(" ");
                t--;
            }
            for (int j=1;j<=i;j++){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
        for (int k=n-1;k>0;k--){
            t=n-k;
            while (t>0){
                System.out.print(" ");
                t--;
            }
            for (int p=1;p<=k;p++){
                System.out.print(k);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        aaaa a=new aaaa();
        a.print(9);
    }
}
