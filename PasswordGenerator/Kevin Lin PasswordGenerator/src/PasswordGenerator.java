//@author Kevin Lin
// 11/24/16 1:35 AM
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PasswordGenerator {
	private static char[] options;
	
	public PasswordGenerator(){
		options = new char[68];
		int i = 0;
		char ch = 'A';
		for(; ch <= 'Z'; i++, ch++)
			options[i] = ch;
		for(ch = 'a'; ch <= 'z'; i++, ch++)
			options[i] = ch;
		for(ch = '0'; ch <= '9'; i++, ch++)
			options[i] = ch;
		options[i] = '_';
		i++;
		options[i] = '-';
		i++;
		options[i] = '$';
		i++;
		options[i] = '%';
		i++;
		options[i] = '#';
		i++;
		options[i] = '@';
	}
	public String buildPassword(){
		boolean valid = false;
		int passwordLength = getRandomInteger(8,12);
		char[] cPassword = new char[passwordLength];
		while(!valid){
			cPassword[0] = options[alpha()];
			for(int i = 1; i < cPassword.length; i++)
				cPassword[i] = options[alphaNumeric()];
			int position = getRandomInteger(1, passwordLength - 2);
			cPassword[position] = options[symbol()];
			valid = isValidPassword(cPassword);
		}
		String password = "";
		for(int i = 0; i < cPassword.length; i++)
			password += cPassword[i];
		return password;
	}
	public static int alpha(){
		return getRandomInteger(0,51);		 
	}
	public static int alphaNumeric(){
		return getRandomInteger(0,61);
	}
	public static int symbol(){
		return getRandomInteger(62,67);
	}
	public static boolean isValidPassword(char[] cPass){
		return (hasUpperCase(cPass) && hasLowerCase(cPass) && hasNumeric(cPass));
	}
	public static boolean hasUpperCase(char[] cPass){
		for(int i = 0; i < cPass.length; i++)
			if("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(cPass[i]) != -1)
				return true;
		return false;
	}
	public static boolean hasLowerCase(char[] cPass){
		for(int i = 0; i < cPass.length; i++)
			if("abcdefghijklmnopqrstuvwxyz".indexOf(cPass[i]) != -1)
				return true;
		return false;
	}
	public static boolean hasNumeric(char[] cPass){
		for(int i = 0; i < cPass.length; i++)
			if("012346789".indexOf(cPass[i]) != -1)
				return true;
		return false;
	}
	public static int getRandomInteger(int min, int max){
		int result = (int)(min + Math.random() * (max - min));
		return result;
	}
	public void printOptions(){
		for(int i = 0; i < options.length; i++)
			System.out.println("options[" + i + "] = " + options[i]);
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		try{
			String file_name = "storedPasswords.txt";
			ReadFile rf = new ReadFile(file_name);
			
			PasswordGenerator pg = new PasswordGenerator();
			int numberOfTimes = getRandomInteger(1, 10);
			for (int i = 0; i < numberOfTimes; i++){
				String pwd = pg.buildPassword();
				String[] arrPwd = rf.OpenFile();
				boolean duplicate = false;
				for (int j = 0; j < arrPwd.length; j++)
					if (pwd.equals(arrPwd[j])){
						duplicate = true;
						j = arrPwd.length;
					}
				if (!duplicate){
					WriteFile wf = new WriteFile(file_name, true);
					wf.writeToFile(pwd);
					System.out.println("A password has been added to storedPasswords.txt");
				}
			}
			String[] storedPwds = rf.OpenFile();
			for (int i = 0; i < storedPwds.length; i++){
				System.out.println("Password " + (i + 1) + ": " + storedPwds[i]);
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Would you like to clear storedPasswords.txt ? Enter in 10 if yes and any other number for no.");
			int response = sc.nextInt();
			if (response == 10){
				PrintWriter end = new PrintWriter("storedPasswords.txt");
				end.close();
				System.out.println("storedPasswords.txt is now empty.");
			}
			sc.close();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		}
	}
}
