package br.net.lavanderia.pedido.DTO;

public class RoupaQtdDTO extends RoupaDTO{

  
  public RoupaQtdDTO(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public RoupaQtdDTO(Long id, Double preco, Integer prazo, String descricao, String imagemDescr, String imagem,
      Integer quantidade) {
    super(id, preco, prazo, descricao, imagemDescr, imagem);
    this.quantidade = quantidade;
  }

  private Integer quantidade;

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
}
