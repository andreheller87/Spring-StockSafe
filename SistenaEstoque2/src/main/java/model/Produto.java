package model;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.gson.annotations.Expose;

import model.DAO.BancoProdutoJSON;

public class Produto {

    private Long id;
    private Long CodLote;
    private String nome;
    private Float valor;
    private Date Data;
    private Date validade;
    private int quantidade;
    private String observacao;
    private String armazenamento;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static Long proximoCodLote = 1000L;

    @Expose(serialize = false, deserialize = false)
    private int serialVersionOnStream;

    public Produto() {

    }

    public Produto(Long id, Long codLote, String nome, Float valor, Date data, Date validade, int quantidade,
            String armazenamento) {
        super();
        this.id = id;
        this.CodLote = codLote;
        this.nome = nome;
        this.valor = valor;
        this.Data = data;
        this.validade = validade;
        this.armazenamento = armazenamento;
        this.quantidade = quantidade;
    }

    public Produto(Long id, String nome, Float valor, String data, String validade, int quantidade,
            String armazenamento) {
        super();
        this.id = id;
        this.CodLote = proximoCodLote++;
        this.nome = nome;
        this.valor = valor;
        try {
            this.Data = sdf.parse(data);
            this.validade = sdf.parse(validade);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        this.armazenamento = armazenamento;
        this.quantidade = quantidade;
    }

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodLote() {
		return CodLote;
	}

	public void setCodLote(Long codLote) {
		CodLote = codLote;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
	    if (nome != null) {
	        this.nome = nome;
	    } else {
	        throw new IllegalArgumentException("Nome não pode estar nulo");
	    }
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getArmazenamento() {
		return armazenamento;
	}

	public void setArmazenamento(String armazenamento) {
		this.armazenamento = armazenamento;
	}

	public SimpleDateFormat getSdf() {
		return sdf;
	}

	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}

	public static Long getProximoCodLote() {
		return proximoCodLote;
	}

	public static void setProximoCodLote(Long proximoCodLote) {
		Produto.proximoCodLote = proximoCodLote;
	}

	public int getSerialVersionOnStream() {
		return serialVersionOnStream;
	}

	public void setSerialVersionOnStream(int serialVersionOnStream) {
		this.serialVersionOnStream = serialVersionOnStream;
	}

	@Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", valor=" + valor + ", Data=" + Data + ", validade=" + validade
                + ", quantidade=" + quantidade + ", observacao=" + observacao + ", armazenamento=" + armazenamento
                + "] \n";
    }

    public int diferencaEmDiasInt() {
        Date dataAtual = new Date();

        long diferencaEmMilissegundos = this.getValidade().getTime() - dataAtual.getTime();
        long diferencaEmDias = TimeUnit.DAYS.convert(diferencaEmMilissegundos, TimeUnit.MILLISECONDS);
        int diferencaEmDiasInt = (int) diferencaEmDias;
        return diferencaEmDiasInt;
    }

    public Float getValorTotal() {
        String valorTotalString = String.format("%.2f", this.getValor() * this.quantidade);
        valorTotalString = valorTotalString.replace(',', '.');
        return Float.parseFloat(valorTotalString);
    }

    public static Long proximoCodLote() throws IOException, URISyntaxException {
        long maior = 0;
        List<Produto> prod;
       
            prod = BancoProdutoJSON.lerProdutos();
            for (Produto produto : prod) {
                if(produto.CodLote > maior) {
                maior = produto.CodLote ;
                }
            }
                return maior + 1;
            
      
    }
}
