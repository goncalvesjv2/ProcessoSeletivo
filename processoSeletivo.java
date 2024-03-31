package project;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class processoSeletivo {
    
    public static void main(String[] args) {
        
    }

    static void entrandoEmContato(String candidato) {
        int tentativaRealizada = 1;
        boolean tentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            tentando = !atendeu;
            if (tentando) 
                tentativaRealizada++;
            else 
                System.out.println("Contato realizado");
        } while(tentando && tentativaRealizada<3);
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"Paulo", "Ana", "Danielle"};
        System.out.println("Imprimindo a lista de candidatos");
        for (int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de n" + (indice+1) + "é o" +  candidatos[indice]);
        }

        for(String candidato:candidatos){
            System.out.println("O candidato selecionado foi" + candidato);
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"Paulo", "João", "Maria", "Nelson", "Ana", "Danielle"};
        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salario = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioEscolhido = valorEscolhido();
            System.out.println("O candidato" + candidato + "Solicitou o salário"  + salarioEscolhido);
            if (salario >= salarioEscolhido) {
                System.out.println("O candidato" + candidato + "Foi selecionado para a vaga");
                candidatosSelecionados ++;
            }
            candidatosAtual++;
        }
    }

    static double valorEscolhido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioEscolhido) {
        double salario = 2000.0;
        if (salario > salarioEscolhido) {
            System.out.println("Entrar em contato com o candidato");
        } else if(salario  == salarioEscolhido)
            System.out.println("Ligar para o candidato contra proposta");
        else {
            System.out.println("Aguardar os outros candidatos");
        }
    }

}
