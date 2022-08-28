package aplicacao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.Ordem;
import entidade.OrdemItem;
import entidade.Produto;
import enumeracoes.OrdemStatus;
public class Programa {

    public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Informe os dados do cliente:");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Aniversario (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Cliente client = new Cliente(name, email, birthDate);
		
		System.out.println("Insira os dados do pedido:");
		System.out.print("Situação: ");
		OrdemStatus status = OrdemStatus.valueOf(sc.next());
		
		Ordem order = new Ordem(new Date(), status, client);
		
		System.out.print("Quantos itens para este pedido? ");
		int n = sc.nextInt();
		for (int i=1; i<=n; i++) {
			System.out.println("Informe #" + i + " dados do produto:");
			System.out.print("Nome do produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço: ");
			double productPrice = sc.nextDouble();

			Produto product = new Produto(productName, productPrice);

			System.out.print("Quantidade: ");
			int quantity = sc.nextInt();

			OrdemItem orderItem = new OrdemItem(quantity, productPrice, product); 

			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDEM:");
		System.out.println(order);
		
		sc.close();
	}
    
}