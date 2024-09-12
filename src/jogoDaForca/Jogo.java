package jogoDaForca;

import java.util.Scanner;

public class Jogo {

	public static void main(String[] args) {

		char[] palavra = sortearPalavra();
		char[] tabuleiro = montarTabuleiro(palavra);
		int erros = 0;
		char[] letrasErradas = new char[7];
		int letrasCertas = 0;

		apresentarJogo();

		exibirTabuleiro(tabuleiro);

		while (erros < 7 && letrasCertas < tabuleiro.length) {

			System.out.println();
			System.out.println();
			Scanner scan = new Scanner(System.in);
			System.out.print("Escolha uma letra: ");
			char letra = scan.next().toUpperCase().charAt(0);
			System.out.println();
			System.out.println();

			boolean validador = validarLetra(letra);
			while (validador != true) {
				System.out.println("Caractere inválido!");
				System.out.print("Escolha uma letra: ");
				letra = scan.next().toUpperCase().charAt(0);
				validador = validarLetra(letra);
			}

			if (checarAcerto(palavra, letra) == true) {
				atualizarTabuleiro(tabuleiro, palavra, letra);
				exibirTabuleiro(tabuleiro);
				letrasCertas++;
			} else {
				exibirTabuleiro(tabuleiro);
				letrasErradas[erros] = letra;
				erros++;
			}

			System.out.println();
			exibirLetrasErradas(letrasErradas);
			System.out.print("Erros cometidos: " + erros);
			System.out.println();

		}

		if (erros == 7) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("          F O R C A           ");
			System.out.println("    V O C Ê  P E R D E U !    ");
			System.out.println("==============================");
			System.out.println();
		}

		if (letrasCertas == tabuleiro.length) {
			System.out.println();
			System.out.println("==============================");
			System.out.println("       P A R A B É N S        ");
			System.out.println("    V O C Ê  V E N C E U !");
			System.out.println("==============================");
		}

	}
 
	// Methods
	static char[] sortearPalavra() {

		int sorteio = (int) (Math.random() * 10) + 1;

		switch (sorteio) {
		case 1:
			return new char[] { 'B', 'E', 'G', 'O', 'N', 'I', 'A' };
		case 2:
			return new char[] { 'G', 'I', 'R', 'A', 'S', 'S', 'O', 'L' };
		case 3:
			return new char[] { 'L', 'I', 'R', 'I', 'O' };
		case 4:
			return new char[] { 'B', 'R', 'O', 'M','E','L','I','A' };
		case 5:
			return new char[] { 'M', 'A', 'R', 'G', 'A', 'R', 'I', 'D', 'A' };
		case 6:
			return new char[] { 'V', 'I', 'O', 'L', 'E', 'T', 'A' };
		case 7:
			return new char[] { 'O', 'R', 'Q', 'U', 'I', 'D', 'E', 'A' };
		case 8:
			return new char[] { 'C', 'A', 'M', 'E', 'L', 'I', 'A' };
		case 9:
			return new char[] { 'P', 'E', 'T', 'U', 'N', 'I', 'A' };
		case 10:
			return new char[] { 'C', 'R', 'A', 'V', 'O' };
		default:
			return new char[0];
		}

	}

	static void apresentarJogo() {
		System.out.println();
		System.out.println();
		System.out.println("============>  J O G O  D A  F O R C A  <============");
		System.out.println();
		System.out.println();
	}

	static char[] montarTabuleiro(char[] palavra) {
		char[] tabuleiro = new char[palavra.length];
		for (int i = 0; i < tabuleiro.length; i++) {
			tabuleiro[i] = '_';
		}
		return tabuleiro;
	}

	static void exibirTabuleiro(char[] tabuleiro) {
		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.print(tabuleiro[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

	static boolean validarLetra(char letra) {
		char[] alfabeto = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
				'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		for (int i = 0; i < alfabeto.length; i++) {
			if (letra == alfabeto[i])
				return true;
		}
		return false;
	}

	static boolean checarAcerto(char[] palavra, char letra) {
		for (int i = 0; i < palavra.length; i++) {
			if (palavra[i] == letra) 
				return true;
		}
		return false;
	}

	static void atualizarTabuleiro(char[] tabuleiro, char[] palavra, char letra) {
		for (int i = 0; i < palavra.length; i++) {
			if (palavra[i] == letra)
				tabuleiro[i] = letra;
		}
	}

	static void exibirLetrasErradas(char[] letrasErradas) {
		for (int i = 0; i < 7; i++) {
			System.out.print(letrasErradas[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

}
