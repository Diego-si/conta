
package conta;

/**
 * @author diego
 */
public class ContaPoupanca extends Conta{
    
   public double perc = 0.02;
    
    public ContaPoupanca() {
        this(0,0,0,0.0);
    }
    
    public ContaPoupanca(int agencia, int numero, int digito, double saldo) {
        this.setAgencia(agencia);
        this.setNumero(numero);
        this.setDigito(digito);
        super.setSaldo(saldo);
    }
    
    public ContaPoupanca (ContaPoupanca c) {
        this(c.getAgencia(), c.getNumero(), c.getDigito() , c.getSaldo());
    }
    
    public void rendimento(double perc){
        super.setSaldo( saldo + (saldo * perc));
        System.out.println("Conta poupanca, rendimento de 2%, saldo: " + getSaldo());
    }

}
