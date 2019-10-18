
package conta;

/**
 * @author diego
 */
public abstract class Conta {
    protected int agencia;
    protected int numero;
    protected int digito;
    protected double saldo;

    @Override
    public String toString() {
        return "Agencia: " + agencia + "\nNumero: " + numero +
                "\nDigito: " + digito + "\nSaldo: " + saldo+"\n";
    }
    
    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getDigito() {
        return digito;
    }
    
    public void setDigito (int digito) {
        this.digito = digito;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo (double saldo) {
        this.saldo = saldo;
    } 

    public void saldo() {
        System.out.println(this.toString());
    }
    
    public void saque(double val){
        if (val <= saldo){
            this.setSaldo(saldo - val);
            System.out.println("Saque de " +val+" reais realizado! ");
        }else{
            System.out.println("Saldo indisponivel para saque!");
        }
    }
    public void deposito(double val) {
        this.setSaldo(saldo+val);

    }
    public void transferencia(double val,Conta ct) {
        if(val<=saldo) {
            this.setSaldo(saldo - val);
            ct.setSaldo(ct.getSaldo()+val);
            System.out.println("Transferências de " +val+" reais realizado! ");
        } else {
            System.out.println("Saldo indisponivel para transferências!");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        ContaPoupanca poupanca1 = new ContaPoupanca(122,134,5,1000); 
        ContaPoupanca poupanca2 = new ContaPoupanca(233,245,6,2000);
        ContaCorrente corrente1 = new ContaCorrente(144,156,7,3000,4000);
        ContaCorrente corrente2 = new ContaCorrente(255,267,8,4000,5000);
        
        //saque corrente 1
        System.out.println("Conta corrente 1, com " +
                corrente1.saldo + " reais.");
        corrente1.saque(500);
        corrente1.saldo();
        
        //saque poupanca 2
        System.out.println("Conta Poupanca 2, com " + poupanca2.saldo +
                " reais.");
        poupanca2.saque(100);  
        poupanca2.saldo();
        
        //transferencia corrente 1 , para poupanca 1
        System.out.println("Conta poupanca 1, com " +
                            poupanca1.saldo + " reais.");
        corrente1.transferencia(100, poupanca1);
        poupanca1.saldo();
        
        //transferencia poupanca 2, para corrente 2
        System.out.println("Conta corrente 2, com " +
                            corrente2.saldo + " reais.");
        poupanca2.transferencia(200, corrente2);
        corrente2.saldo();
        
        System.out.println("\nTentativa de um saque e uma "
                + "transferência para uma conta corrente");
        corrente1.saque(6401);
        corrente1.transferencia(6401, corrente2);
        
        System.out.println("\nTentativa de um saque e uma "
                + "transferência para uma conta poupança\n");
        poupanca1.saque(1101);
        poupanca1.transferencia(1101, poupanca2);
    }
} 
