
package util;

/**
 *
 * @author felip
 */
public class Produto {
       
    private int codigo;
    private String descricao;
    private double valorCusto;
    private double lucro;
    private double icms;
    private double ipi;
    private double outrosImpostos;
    private double estoque;
    private double estoqueMinimo;
    private double estoqueMaximo;

    public Produto(int codigo, String descricao, double valorCusto, double lucro, double icms, double ipi, double outrosImpostos, double estoque, double estoqueMinimo, double estoqueMaximo) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorCusto = valorCusto;
        this.lucro = lucro;
        this.icms = icms;
        this.ipi = ipi;
        this.outrosImpostos = outrosImpostos;
        this.estoque = estoque;
        this.estoqueMinimo = estoqueMinimo;
        this.estoqueMaximo = estoqueMaximo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getIpi() {
        return ipi;
    }

    public void setIpi(double ipi) {
        this.ipi = ipi;
    }

    public double getOutrosImpostos() {
        return outrosImpostos;
    }

    public void setOutrosImpostos(double outrosImpostos) {
        this.outrosImpostos = outrosImpostos;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public double getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(double estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }
    
    
    
}
