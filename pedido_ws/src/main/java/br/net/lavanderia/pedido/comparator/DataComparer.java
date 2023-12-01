package br.net.lavanderia.pedido.comparator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import br.net.lavanderia.pedido.DTO.PedidoRoupaDTO;


public class DataComparer implements Comparator<PedidoRoupaDTO>{
  @Override
  public int compare(PedidoRoupaDTO p1, PedidoRoupaDTO p2){
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
    Date d1 = new Date();
    Date d2 = new Date();
    try {
      d1 = formatter.parse(p1.getDataPedido());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    try {
      d2 = formatter.parse(p2.getDataPedido());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } 
    return d1.compareTo(d2); 
  }
}
