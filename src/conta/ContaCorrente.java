
package conta;

/**
 * @author diego
 */
public class ContaCorrente extends Conta{
    private double limite;
    public ContaCorrente() {
        this(0,0,0,0,0.0);
    }
    
    public ContaCorrente(int agencia, int numero, int digito, double saldo,double limite) {
        this.setAgencia(agencia);
        this.setNumero(numero);
        this.setDigito(digito);
        super.setSaldo(saldo);
        this.setLimite(limite);
    }
    
    public ContaCorrente (ContaCorrente c) {
        this(c.getAgencia(), c.getNumero(), c.getDigito() 
                , c.getSaldo(), c.getLimite());
    }
    
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
    
    @Override
    public void saque(double val) {
        if (val <= limite+saldo) {
            this.saldo = saldo-val;
            System.out.println("Saque de " +val+" reais realizado! ");
        } else {
            System.out.println("\nConta corrente, saldo Insuficiente para saque ! ");
        }
    }
    
    @Override
    public void transferencia(double val,Conta ct){
        if (val <= limite+saldo) {
            this.setSaldo(saldo - val);
            ct.setSaldo(ct.getSaldo()+val);
            System.out.println("Transferências de " +val+" reais realizado! ");
        } else {
            System.out.println("Conta corrente, saldo insuficiente para transferencia!");
        }
    }
    
}
    
