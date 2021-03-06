/**
 *  Copyright (c) 2017 Alexandre Fiset, Fitvoye Florian
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package student;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.Test;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import org.junit.runner.notification.Failure;

public class CH4Q5 {

    private static String str = "Le code semble comporter des erreurs : ";

    @Test
    public void testPos(){
        try{
            int sum = 1;
            for (int i = 1; i<=20; i++)
            {
                sum = sum *i;
                int res = CH4Q5Stu.fact(i);
                assertTrue("Factoriel " + i + " devrait renvoyer " + sum + ", mais votre code renvoit " + res, res == sum);
            }

        }catch (ArithmeticException e){
            fail(str + "Le code est incorrect : il est interdit de diviser par zéro.");
            e.printStackTrace();
        }catch(ClassCastException e){
            fail(str + "Attention, certaines variables ont été mal castées	!");
            e.printStackTrace();
        }catch(StringIndexOutOfBoundsException e){
            e.printStackTrace();
            fail(str + "Attention, vous tentez de lire en dehors des limites d'un String ! (StringIndexOutOfBoundsException)");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            fail(str + "Attention, vous tentez de lire en dehors des limites d'un tableau ! (ArrayIndexOutOfBoundsException)");
            e.printStackTrace();
        }catch(NullPointerException e){
            fail(str + "Attention, vous faites une opération sur un objet qui vaut null ! Veillez à bien gérer ce cas.");
            e.printStackTrace();
        }catch(NumberFormatException e){
            fail(str + "Il fallait renvoyer un entier !");
            e.printStackTrace();
        }catch(Exception e){
            fail(str + "\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    // Code verificateur
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CH4Q5.class);
        for (Failure failure: result.getFailures()) {
            System.err.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("Tous les tests se sont passés sans encombre");
            System.exit(127);
        }
    }
}
