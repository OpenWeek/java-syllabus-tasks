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

public class Q1 {
	
	private static String str = "Le code semble comporter des erreurs : ";
	
	@Test
	public void testPos(){
		try{
			PrintStream ps = new PrintStream("fichier.out");
			System.setOut(ps);
			Q1Stu.decompte(10);
			BufferedReader br = new BufferedReader(new FileReader("fichier.out"));
			int i = 10;
			int count = 0;
			String s;
			while((s = br.readLine()) != null)
			{
				assertTrue("Votre code nous renvoie "+s+", il devrait renvoyer "+i,i == Integer.parseInt(s));
				i-=2;
				count ++;
			}
			assertTrue("Votre code nous renvoie "+count+" nombres, il devrait nous en renvoyer 6",count == 6);
			Q1Stu.decompte(100);
			ps.close();
			i = 100;
		 	count = 0;
			while((s = br.readLine()) != null)
			{
				assertTrue("Votre code ne renvoit pas la bonne réponse, se test a été effectuer pour prevenir du hard coding",i == Integer.parseInt(s));
				i-=2;
				count ++;
			}
			assertTrue("Votre code ne renvoit pas la bonne réponse, se test a été effectuer pour prevenir du hard coding",count ==  51);
			br.close();

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
		Result result = JUnitCore.runClasses(Q1.class);
		for (Failure failure: result.getFailures()) {
			System.err.println(failure.toString());
		}
		if (result.wasSuccessful()) {
			System.out.println("Tous les tests se sont passés sans encombre");
			System.exit(127);
		}
	}
}
