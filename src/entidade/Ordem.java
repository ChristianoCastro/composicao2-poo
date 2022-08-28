package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumeracoes.OrdemStatus;
public class Ordem {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrdemStatus status;
	
	private Cliente client;
	private List<OrdemItem> items = new ArrayList<>();
	
	public Ordem(Date moment, OrdemStatus status, Cliente client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public List<OrdemItem> getItems() {
		return items;
	}
	
	public void addItem(OrdemItem item) {
		items.add(item);
	}

	public void removeItem(OrdemItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrdemItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Ordem de momento: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Ordem da siuação: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(client + "\n");
		sb.append("Ordem dos itens:\n");
		for (OrdemItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Preco Total: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
}