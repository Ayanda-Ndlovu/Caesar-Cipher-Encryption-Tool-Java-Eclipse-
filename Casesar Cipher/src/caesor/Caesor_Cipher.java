package caesor;

public class Caesor_Cipher {

	private String Alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";	
	
	public Caesor_Cipher() {}
	
	public String Encrypt(String original_string, int Shift) {
		String new_string = "";
		int new_index;
		
		for(int i = 0; i < original_string.length(); i++) {
			char letter = original_string.charAt(i);
			if(Character.isUpperCase(letter)) {
				int index = Alphabets.indexOf(letter);
				new_index = (index+Shift) % 26;
				new_string += Alphabets.charAt(new_index);
				
			}
			else if(Character.isLowerCase(letter)){
				String Alphabet = Alphabets.toLowerCase();
				int index = Alphabet.indexOf(letter);
				new_index = (index+Shift) % 26;
				new_string += Alphabet.charAt(new_index);
				
			}
			else {
				new_string += letter;
			}
		}
		return new_string;
			
		
	}
	
	
	public String Decrypt(String encrypted_str, int Shift) {
		String new_string = "";
		int new_index;
		
		for(int i = 0; i < encrypted_str.length(); i++) {
			char letter = encrypted_str.charAt(i);
			if(Character.isUpperCase(letter)) {
				int index = Alphabets.indexOf(letter);
				new_index = (index-Shift+26) % 26;
				new_string += Alphabets.charAt(new_index);
				
			}
			else if(Character.isLowerCase(letter)){
				String Alphabet = Alphabets.toLowerCase();
				int index = Alphabet.indexOf(letter);
				new_index = (index-Shift+26) % 26;
				new_string += Alphabet.charAt(new_index);
				
			}
			else {
				new_string += letter;
			}
		}
		return new_string;
		
	}
	
	public static void main(String[] args) {
		String original_string = "Hello There";
        int Shift = 2;
        
        Caesor_Cipher Cipher = new Caesor_Cipher();
        
        // Encrypt
        String Encrypted = Cipher.Encrypt(original_string, Shift);
        System.out.println("Encrypted: " + Encrypted);

        // Decrypt
        String Decrypted = Cipher.Decrypt(Encrypted, Shift);
        System.out.println("Decrypted: " + Decrypted);

	}
}


